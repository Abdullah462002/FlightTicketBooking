package com.flight.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flight.bean.Booking;
import com.flight.bean.Cancel;
import com.flight.bean.Flightsearch;
import com.flight.bean.Invoice;
import com.flight.bean.UserDetails;
import com.flight.constants.QueryConstants;
import java.util.Collections;

@Repository
@Transactional
public class CustomerDao {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public boolean registerCus(UserDetails ud) {
		String sql = QueryConstants.USERDETAILSINS;

		try {
			jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(ud));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public UserDetails getCust(int id) {
		String sql = QueryConstants.GETCUST;

		try {
			List<UserDetails> uli = jdbcTemplate.query(sql, new MapSqlParameterSource("id", id),
					(rs, r) -> new UserDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getInt(11)));
			return uli.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateud(UserDetails ud) {
		String sql = QueryConstants.UPDATEUD;

		try {
			int i = jdbcTemplate.update(sql,
					new MapSqlParameterSource("name", ud.getName()).addValue("email", ud.getEmail())
							.addValue("password", ud.getPassword()).addValue("dateOfBirth", ud.getDateOfBirth())
							.addValue("address", ud.getAddress()).addValue("gender", ud.getGender())
							.addValue("phone", ud.getPhone()).addValue("SSNNumber", ud.getSSNNumber())
							.addValue("cId", ud.getcId()));
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Flightsearch> searchFli(Flightsearch fli) {
		String sql = QueryConstants.SEARCHFLI;

		try {
			return jdbcTemplate.query(sql, new MapSqlParameterSource("from", fli.getFrom()).addValue("to", fli.getTo())
					.addValue("date", fli.getDate()).addValue("time", fli.getTime()).addValue("seat", fli.getSeat()),
					(rs, r) -> new Flightsearch(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getString(7)));
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public boolean booking(Booking bo) {
		String sql = QueryConstants.BOOKINGINSERT;

		try {
			int i = jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(bo));
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Invoice> bookInvoice(int id) {
		String sql = QueryConstants.BOOKINVOICE;

		try {
			return jdbcTemplate.query(sql, new MapSqlParameterSource("id", id),
					(rs, r) -> new Invoice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10)));
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public List<Cancel> selectInvoice(int id) {
		String sql = QueryConstants.GETINVOICE;

		try {
			return jdbcTemplate.query(sql, new MapSqlParameterSource("id", id),
					(rs, r) -> new Cancel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7)));
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public boolean cancelBooking(int id) {
		String sql = QueryConstants.CALCELBOOKING;

		try {
			int i = jdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
			return i > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
