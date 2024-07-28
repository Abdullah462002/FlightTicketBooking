package com.flight.constants;

public class QueryConstants {
	
	public static final String LOGIN="""
			select password from user where name=:name
			""";
	public static final String USERDETAILSINS="""
			insert into userDetails values(:cId,:name,:email,:password,
			:reTypePassword,:dateOfBirth,:address,:gender,:phone,:SSNType,:SSNNumber)
			""";
	public static final String GETCUST="""
			select * from userDetails where CustomerId=:id
			""";
	public static final String UPDATEUD="""
			update userDetails set name=:name,Email =:email,Password =:password,Date_of_Birth =:dateOfBirth,
			Address=:address,Gender =:gender,Phone =:phone,SSN_Number=:SSNNumber where CustomerId=:cId
			""";
	public static final String SEARCHFLI="""
			select *  from Flights where LeavingFrom = :from and GoingTo = :to and DepartureDate = :date
			and DepartureTime = :time and AvailableSeats > :seat
			""";
	public static final String BOOKINGINSERT="""
			INSERT INTO Bookings VALUES (:bookid,:cId, :flightid, :date, :price, :seat);
			""";
	public static final String BOOKINVOICE="""
			select BookingID,name, AirlineName,LeavingFrom, GoingTo, DepartureDate, 
			DepartureTime,BookingDate,TotalPrice,SeatsToBook from userDetails u join Bookings b 
			on u.CustomerId=b.CId join Flights f on b.FlightID = f.FlightID where BookingID=:id;
			""";
	public static final String GETINVOICE="""
			select BookingID,BookingDate,DepartureDate,LeavingFrom,GoingTo,SeatsToBook,TotalPrice
			from Bookings b join Flights f on b.FlightID = f.FlightID where BookingID =:id;				
			""";
	public static final String CALCELBOOKING="""
			delete from Bookings where BookingID=:id
			""";
	
	private QueryConstants() {
		
	}
}
