package com.flight.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.flight.bean.Booking;
import com.flight.bean.Flightsearch;
import com.flight.bean.User;
import com.flight.bean.UserDetails;
import com.flight.bo.CustomerBo;
import com.flight.bo.UserBo;
import com.flight.constants.StringConstants;
import com.flight.dao.InvalidUserException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({"name","error"})
public class AppController {
	@Autowired
	UserBo bo;
	@Autowired
	CustomerBo cBo;
	
	private Random rand = new Random();

	@GetMapping("/login")
	public String getLog(@ModelAttribute User user) {
		return StringConstants.LOGIN;
	}
	@ExceptionHandler(value= {InvalidUserException.class,Exception.class})
	public String errorHandler(Exception e,Model mod) {
		mod.addAttribute("user", new User());
		mod.addAttribute("error", e.getMessage());
		return StringConstants.LOGIN;
	}
	@GetMapping("/logout")
	public String getLogout() {
		return "logout";
	}
	
	@PostMapping("/validate")
	public ModelAndView validate(@Valid User user, BindingResult result, HttpServletRequest req,
			HttpServletResponse res,SessionStatus ss) throws InvalidUserException {
		var mv = new ModelAndView(StringConstants.LOGIN);
		if (result.hasErrors()) {
			return mv;
		}
		if (bo.validateUser(user)) {
			mv.addObject("name", user.getName());
			mv.addObject("page", "hom");
			mv.setViewName("home");
		} else {
			mv.addObject("err", "Invalid Password");
			mv.setViewName(StringConstants.LOGIN);
		}
		ss.setComplete();
		return mv;
	}

	@GetMapping("home")
	public String getHomePage(Model mod) {
		mod.addAttribute("page", "hom");
		return "home";
	}

	@GetMapping("register")
	public String getRegPage(@ModelAttribute UserDetails userDetails, Model mod) {
		mod.addAttribute("page", "regis");
		return "home";
	}

	@PostMapping("registerCus")
	public ModelAndView validate(@Valid UserDetails ud, BindingResult result, HttpServletRequest req) {
		req.getSession().setAttribute("cid", ud.getcId());
		var mv = new ModelAndView("home");
		mv.addObject("page", "regis");
		if (result.hasErrors()) {
			return mv;
		}
		if (ud.getPassword().equals(ud.getReTypePassword())) {
			if (cBo.registerCus(ud)) {
				mv.addObject("suc", "Customer Registered SuccessFully Your Customer Id is " + ud.getcId());
				mv.setViewName("home");
			} else {
				mv.addObject("fai", "Customer not Registered");
				mv.setViewName("home");
			}
		} else {
			mv.addObject("fai", "Password in two fields not match");
		}
		return mv;
	}

	@GetMapping("edit")
	public String getEditPage(@ModelAttribute UserDetails userDetails, HttpServletRequest req, Model mod) {
		if ((String) req.getSession().getAttribute("cid") != null) {
			int id = Integer.parseInt((String) req.getSession().getAttribute("cid"));
			var cus = cBo.getCust(id);
			if (cus != null) {
				mod.addAttribute("page", "edit");
				mod.addAttribute("cust", cus);
			} else {
				mod.addAttribute("fai", "First You Have To Register Before Editing Details");
				mod.addAttribute("page", "hom");
			}
		} else {
			mod.addAttribute("fai", "First You Have To Register Before Editing Details");
			mod.addAttribute("page", "editmsg");
		}
		return "home";
	}

	@PostMapping("update")
	public ModelAndView getEditPage(@Valid UserDetails userDetails, BindingResult result, Model mod) {
		var mv = new ModelAndView("home");
		mod.addAttribute("page", "edit");

		if (cBo.updateud(userDetails)) {
			mv.addObject("suc", "Saved Successfully");
		} else {
			mv.addObject("fai", "Not Saved");
		}
		return mv;
	}

	@GetMapping("searnbook")
	public String getSearchPage(@ModelAttribute Flightsearch flightsearch, Model mod) {
		mod.addAttribute("page", "snb");
		return "home";
	}

	@PostMapping("searchFli")
	public ModelAndView searchFli(@Valid Flightsearch fs, BindingResult result) {
		var mv = new ModelAndView("home");
		mv.addObject("page", "snb");
		if (result.hasErrors()) {
			return mv;
		}
		var flilist = cBo.searchFli(fs);
		if (!flilist.isEmpty()) {
			mv.addObject("flightli", flilist);
		} else {
			mv.addObject("fai", "No Matching Flights found");
		}
		return mv;
	}

	@PostMapping("bookfli")
	public ModelAndView bookFli(@ModelAttribute Flightsearch flightsearch, HttpServletRequest req) {
		var mv = new ModelAndView("home");
		String id = (String) req.getSession().getAttribute("cid");
		Date curdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(curdate);
		float p = 2000 * (float)flightsearch.getSeat();
		int n = rand.nextInt(90000);
		req.getSession().setAttribute("bid", n);
		var book = new Booking(n, id, flightsearch.getFlightid(), strDate, p, flightsearch.getSeat());
		if (cBo.booking(book)) {
			mv.addObject("suc", "Ticket Booked Succesfully, Your Invoice is:");
			var inli = cBo.bookInvoice(n);
			mv.addObject("invli", inli.get(0));
		}
		mv.setViewName("invoice");
		return mv;
	}

	@GetMapping("cancel")
	public String getCancelPage(@ModelAttribute Booking booking, Model mod) {
		mod.addAttribute("page", StringConstants.CANCEL);
		return "home";
	}

	@PostMapping("cancelfli")
	public ModelAndView cancelFli(Booking booking) {
		var mv = new ModelAndView("home");
		mv.addObject("page", "cancel");
		var bli = cBo.selectInvoice(booking.getBookid());
		if (!bli.isEmpty()) {
			try {
				mv.addObject("booli", bli);
				String bdate = bli.get(0).getDepartureDate();
				Date date2 = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date1 = sdf.parse(bdate);
				long diff = date2.getTime() - date1.getTime();
				int daydiff = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				int cancharge = 0;
				int refAmt = 0;
				float p = Float.parseFloat(bli.get(0).getTotalPrice());
				if (daydiff != 0) {
					if (daydiff >= 10) {
						cancharge += p * 0.10;
					} else if (daydiff >= 5 && daydiff < 10) {
						cancharge += p * 0.20;
					} else if (daydiff >= 1 && daydiff < 5) {
						cancharge += p * 0.50;
					}
					refAmt = (int) (p - cancharge);
					mv.addObject("charg", cancharge);
					mv.addObject("reamt", refAmt);
				} else {
					mv.addObject("fai", "Not Refaundable");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("cli", bli);

		} else {
			mv.addObject("fai", "Your Booking Id is Wrong");
		}
		mv.setViewName("home");
		return mv;
	}

	@PostMapping("delbook")
	public ModelAndView delbook(@ModelAttribute Booking booking, HttpServletRequest req) {
		var mv = new ModelAndView("home");
		mv.addObject("page", "cancel");
		if (cBo.cancelBooking(booking.getBookid())) {
			mv.addObject("suc", "Cancelled Successfully");
		} else {
			mv.addObject("fai", "Not Cancelled Successfully");
		}
		return mv;
	}
	
	
}
