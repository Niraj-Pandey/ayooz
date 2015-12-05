package org.ayooz.esp;

import java.util.Observable;
import java.util.Observer;

public class ESPRegulator implements Observer{

	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof SpeedController){
			
		}
		
	}

}
