package com.flight.bean;

public class Booking {
	private int bookid;
	private String cId;
	private int flightid;
	private String date;
	private float price;
	private int seat;
	
	
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public Booking() {
		super();
	}
	
	@Override
	public String toString() {
		return "Booking [bookid=" + bookid + ", cId=" + cId + ", flightid=" + flightid + ", date=" + date + ", price="
				+ price + ", seat=" + seat + "]";
	}

	public Booking(int bookid, String cId, int flightid, String date, float price, int seat) {
		super();
		this.bookid = bookid;
		this.cId = cId;
		this.flightid = flightid;
		this.date = date;
		this.price = price;
		this.seat = seat;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
}
