package com.paloit;

public class Particle {
	private boolean isLeft;
	private int location;

	public Particle(boolean isLeft, int location) {
		this.isLeft = isLeft;
		this.location = location;
	}
	public Particle() {
		// TODO Auto-generated constructor stub
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public boolean isLeft() {
		return isLeft;
	}
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}
	
	public void move(int speed) {
		location = isLeft?location-speed:location+speed;
	}

}
