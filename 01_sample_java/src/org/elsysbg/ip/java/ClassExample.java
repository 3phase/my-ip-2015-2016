package org.elsysbg.ip.java;

public class ClassExample {
	
	public static void main(String[] args) {		
		// ctrl+2 + l - local var
		// final - unchangeable var
		final Room room = new Room();
		//		room = new Room(); = aint workin
		//		room.method = 5; = aight 
		
		room.setHeight(22);
		room.setWidth(41);
		
		System.out.println(room.getHeight() + " + " + room.getWidth() + 
				" \n " + room.calculateArea());
		
		
	}
	
}
