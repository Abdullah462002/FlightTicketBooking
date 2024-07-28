package com.flight.bean;

public class Cancel {

	private String bookingID;
	private String bookingDate;
	private String departureDate;
	private String leavingFrom;
	private String goingTo;
	private String seatsToBook;
	private String totalPrice;
	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getLeavingFrom() {
		return leavingFrom;
	}
	public void setLeavingFrom(String leavingFrom) {
		this.leavingFrom = leavingFrom;
	}
	public String getGoingTo() {
		return goingTo;
	}
	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}
	public String getSeatsToBook() {
		return seatsToBook;
	}
	public void setSeatsToBook(String seatsToBook) {
		this.seatsToBook = seatsToBook;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Cancel(String bookingID, String bookingDate, String departureDate, String leavingFrom, String goingTo,
			String seatsToBook, String totalPrice) {
		super();
		this.bookingID = bookingID;
		this.bookingDate = bookingDate;
		this.departureDate = departureDate;
		this.leavingFrom = leavingFrom;
		this.goingTo = goingTo;
		this.seatsToBook = seatsToBook;
		this.totalPrice = totalPrice;
	}
	public Cancel() {
		super();
	}
	@Override
	public String toString() {
		return "Cancel [bookingID=" + bookingID + ", bookingDate=" + bookingDate + ", departureDate=" + departureDate
				+ ", leavingFrom=" + leavingFrom + ", goingTo=" + goingTo + ", seatsToBook=" + seatsToBook
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
}
