package com.flight.bean;

public class Invoice {
	private int bookingId;
	private String customerName;
	private String airlineName;
	private String leavingfrom;
	private String goingTo;
	private String dateOfJourney;
	private String departureTime;
	private String bookingDate;
	private String totalPrice;
	private String seatstobook;
	public Invoice(int bookingId, String customerName, String airlineName, String leavingfrom, String goingTo,
			String dateOfJourney, String departureTime, String bookingDate, String totalPrice, String seatstobook) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.airlineName = airlineName;
		this.leavingfrom = leavingfrom;
		this.goingTo = goingTo;
		this.dateOfJourney = dateOfJourney;
		this.departureTime = departureTime;
		this.bookingDate = bookingDate;
		this.totalPrice = totalPrice;
		this.seatstobook = seatstobook;
	}

	public Invoice() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getLeavingfrom() {
		return leavingfrom;
	}

	public void setLeavingfrom(String leavingfrom) {
		this.leavingfrom = leavingfrom;
	}

	public String getGoingTo() {
		return goingTo;
	}

	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getSeatstobook() {
		return seatstobook;
	}

	public void setSeatstobook(String seatstobook) {
		this.seatstobook = seatstobook;
	}
	
	
	
}
