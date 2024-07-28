package com.flight.bean;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Flightsearch {
	private int flightid;
	@NotBlank(message = " *Leaving From is Mandatory")
	private String from;
	@NotBlank(message = " *Going To is Mandatory")
	private String to;
	@NotBlank(message = " *Depature Date is Mandatory")
	private String date;
	@NotBlank(message = " *Depature Time is Mandatory")
	private String time;
	@Min(message="Min Seat is 1", value=1)
	@Max(message="Max Seat is 20", value=20)
	private int seat;
	private String airlineName;
	
	@Override
	public String toString() {
		return "Flightsearch [flightid=" + flightid + ", from=" + from + ", to=" + to + ", date=" + date + ", time="
				+ time + ", seat=" + seat + ", airlineName=" + airlineName + "]";
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public Flightsearch(int flightid, String from, String to, String date, String time, int seat) {
		super();
		this.flightid = flightid;
		this.from = from;
		this.to = to;
		this.date = date;
		this.time = time;
		this.seat = seat;
	}
	
	public Flightsearch(int flightid, String from, String to, String date, String time, int seat, String airlineName) {
		super();
		this.flightid = flightid;
		this.from = from;
		this.to = to;
		this.date = date;
		this.time = time;
		this.seat = seat;
		this.airlineName = airlineName;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public Flightsearch() {
		super();
	}
	
}
