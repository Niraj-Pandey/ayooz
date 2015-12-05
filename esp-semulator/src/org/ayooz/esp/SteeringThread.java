package org.ayooz.esp;

import java.util.Random;

public class SteeringThread extends Thread{
	
	Steering steering;
	
	public SteeringThread(Steering steering) {
		super();
		this.steering = steering;
	}

	public void run(){
    	Random r=new Random();
    	while(true){
    		steering.setAngule(r.nextInt(360)+1);
    		steering.setDirection('L');
    		steering.setSpeed(r.nextInt(360)+1);
    		steering.testProbleme();
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
	}
}
