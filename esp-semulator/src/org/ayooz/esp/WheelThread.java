package org.ayooz.esp;

import java.util.Random;

public class WheelThread extends Thread{

	private Wheel wheel;
	
    public WheelThread(Wheel wheel) {
		super();
		this.wheel = wheel;
	}

	public void run(){
    	Random r=new Random();
    	while(true){
    		wheel.setSpeed(r.nextInt(360)+1);
    		wheel.setOielPression(r.nextInt(100)+1);
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
	}
}
