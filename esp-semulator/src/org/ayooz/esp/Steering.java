package org.ayooz.esp;

import java.util.Observable;

public class Steering extends Observable{
	
	private long speed;
	private long angule;
	private char direction;
	private boolean probleme;
	
	public Steering(long speed, long angule, char direction) {
		super();
		this.speed = speed;
		this.angule = angule;
		this.direction = direction;
	}
	public long getSpeed() {
		return speed;
	}
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	public long getAngule() {
		return angule;
	}
	public void setAngule(long angule) {
		this.angule = angule;
	}
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	public boolean isProbleme() {
		return probleme;
	}
	public void setProbleme(boolean probleme) {
		this.probleme = probleme;
		setChanged();
		notifyObservers(this.probleme);
	}
	public void testProbleme(){
		if(speed>80 && angule>100){
			setProbleme(true);
		}
	}
	
}
