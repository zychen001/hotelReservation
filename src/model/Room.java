package model;
import model.MainModel.RoomType;

public class Room implements IRoom{
	public String roomNumber;
	public Double price;
	public RoomType enumeration;
	
	
	
	public Room(String roomNumber, Double price, RoomType enumeration){
		this.roomNumber = roomNumber;
		this.price = price;
		this.enumeration = enumeration;
	}
	
	@Override
	public String getRoomNumber() {
		return roomNumber;
	}
	
	@Override
	public Double getRoomPrice() {
		return price;
	}
	
	@Override
	public RoomType getRoomType() {
		return enumeration;
	}
	
	public boolean isFree() {
		return isFree();
	}
	
	
	@Override
	public String toString() {
		
		return "RoonNumber: " + roomNumber + "; Price: " + price + "; RoomType: " + enumeration;
	}

}
