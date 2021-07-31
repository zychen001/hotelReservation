package service;
import model.*;
import service.CustomerService;
import java.util.*;


public class ReservationService {
	private static ReservationService reservationservice;
	private Map<IRoom,Reservation> reservations = new HashMap<>();
	public List<IRoom> rooms = new ArrayList<>();
	public List<Reservation> reserList = new ArrayList<>();
	public Collection<IRoom> availableRoom = new LinkedHashSet<>();
	
	public static ReservationService getInstance() {
		if(reservationservice == null) {
			reservationservice = new ReservationService();
		}
		return reservationservice;
	}
	
	public void addRoom(IRoom room) {
		rooms.add(room);
	}
	
	public IRoom getARoom(String roomNumber) {
		for(IRoom room : rooms) {
			if(roomNumber.equals(room.getRoomNumber())) {
				return room;
			}
		}
		System.out.println("This is not one of our room");
		return null;
	}
	
	public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
		Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
		if(availableRoom.contains(room)) {
			reservations.put(room, reservation);
			reserList.add(reservation);
			
			return reservation;
		}
		else {
			System.out.println("This room has been reserved.");
			return null;
		}	
	}
	
	public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
		System.out.println(rooms);
		
		if(reserList.size() == 0) {
			availableRoom = rooms;
			return availableRoom;
		}
		else {
			for(IRoom room : rooms) {
				for(Reservation res : reserList) {
					if((room.getRoomNumber().equals(res.room.getRoomNumber()))) {
						if((checkOutDate.before(res.getCheckInDate())) || (checkInDate.after(res.getCheckOutDate()))) {
							availableRoom.add(room);
						}
						else {							
							availableRoom.remove(room);
							}
					}
					
						
					}
				}
			}
		
		
		return availableRoom;
	}
	
	public Collection<Reservation> getCustomersReservation(Customer customer){
		Collection<Reservation> customerReserCollect = new ArrayList<>();
		for(Reservation cusReser : reserList) {
			if(cusReser.customer.equals(customer)) {
				customerReserCollect.add(cusReser);
			}
		}
		return customerReserCollect;
	}
	
	public void printAllReservation() {
		for(Reservation reser : reserList) {
			System.out.println(reser);
			
		}
	}
	
	
	

}
	
	


