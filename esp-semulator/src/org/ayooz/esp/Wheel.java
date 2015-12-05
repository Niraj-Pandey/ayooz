package org.ayooz.esp;

import java.util.Observable;

public class Wheel extends Observable{
	
	private int id;
	private long speed;
	private long oielPression;
	
	public Wheel(int id, long speed,long oielPression) {
		super();
		this.id = id;
		this.speed = speed;
		this.oielPression=oielPression;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getSpeed() {
		return speed;
	}
	public void setSpeed(long speed) {
		this.speed = speed;
		setChanged();
		notifyObservers(this.speed);	
	}
	public long getOielPression() {
		return oielPression;
	}
	public void setOielPression(long oielPression) {
		this.oielPression = oielPression;
		setChanged();
		notifyObservers(this.oielPression);
	}
}
