package com.flight.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.bean.Booking;
import com.flight.bean.Cancel;
import com.flight.bean.Flightsearch;
import com.flight.bean.Invoice;
import com.flight.bean.UserDetails;
import com.flight.dao.CustomerDao;

@Service
public class CustomerBo {

	@Autowired
	CustomerDao cusDao;
	public boolean registerCus(UserDetails ud)  {
		return cusDao.registerCus(ud);
	}
	public UserDetails getCust(int id) {
		return cusDao.getCust(id);
	}
	public List<Flightsearch> searchFli(Flightsearch fli) {
		return cusDao.searchFli(fli);
	}
	public boolean booking(Booking bo) {
		return cusDao.booking(bo);
	}
	public List<Invoice> bookInvoice(int id) {
		return cusDao.bookInvoice(id);
	}
	public List<Cancel> selectInvoice(int id) {
		return cusDao.selectInvoice(id);
	}
	public boolean cancelBooking(int id){
		return cusDao.cancelBooking(id);
	}
	public boolean updateud(UserDetails ud) {
		return cusDao.updateud(ud);
	}
}
