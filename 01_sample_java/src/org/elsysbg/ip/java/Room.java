package org.elsysbg.ip.java;

public class Room {
	
	private int width;
	private int height;
	
	// automatically generated - alt+shift+s -> r
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int calculateArea() {
		return width * height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Room) {
			final Room room2 = (Room) obj;
			return room2.height == this.height 
					&& room2.width == this.width;
		}
		return false;
	}
	
}
