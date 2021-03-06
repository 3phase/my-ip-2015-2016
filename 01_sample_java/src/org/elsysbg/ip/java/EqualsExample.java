package org.elsysbg.ip.java;

public class EqualsExample {

	public static void main(String[] args) {
		Room room = new Room();
		Room room2 = new Room();
		
		setDimensions(room);
		setDimensions(room2);
		
		// Pointing to different mem locations => false
		System.out.println("room == room2\n"
				+ (room == room2));
		System.out.println("room.equals(room2)\n" 
				+ room.equals(room2));
	}

	private static void setDimensions(Room room) {
		// TODO Auto-generated method stub
		room.setWidth(10);
		room.setHeight(12);
	}
	
}
