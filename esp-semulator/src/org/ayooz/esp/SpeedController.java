package org.ayooz.esp;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class SpeedController extends Observable implements Observer{

	private long[] wheelsSpead;
	private boolean espProbleme;

	public SpeedController() {
		super();
		wheelsSpead=new long[4];
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof Wheel){
			Wheel wheel=(Wheel) obs;
			wheelsSpead[wheel.getId()]=wheel.getSpeed();
		}else if(obs instanceof Steering){
			Steering steering=(Steering) obs;
			espProbleme=steering.isProbleme();
			if(espProbleme){
				setChanged();
				notifyObservers(this.espProbleme);
			}
		}
	}
	
	public long[] getWheelsSpead() {
		return wheelsSpead;
	}

	public void setWheelsSpead(long[] wheelsSpead) {
		this.wheelsSpead = wheelsSpead;
	}

	public boolean isEspProbleme() {
		return espProbleme;
	}

	public void setEspProbleme(boolean espProbleme) {
		this.espProbleme = espProbleme;
	}

	@Override
	public String toString() {
		return "SpeedController [wheelsSpead=" + Arrays.toString(wheelsSpead) +"["+isEspProbleme() +"]]";
	}
	
}
