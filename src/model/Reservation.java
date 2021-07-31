package model;
import java.util.*;
import java.util.regex.Pattern;

public class Reservation {
	public Customer customer;
	public IRoom room;
	public Date checkInDate;
	public Date checkOutDate;
	
	
	
	public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
		
		this.customer = customer;
		this.room = room;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	
	public Date getCheckInDate() {
		return checkInDate;
	}
	
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	
	@Override
	public String toString() {
		return "Customer: " + customer + ". Room: " + room + "CheckInDate: " + checkInDate + 
				". CheckOutDate: " + checkOutDate;
	}

}
