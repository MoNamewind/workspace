package com.bj58.api.eventBus;

import javax.annotation.PostConstruct;

public class TimeTaskEventListener {
	
	@PostConstruct
	public void init(){
		TimeEventBus.register(this);
	}
	
	public boolean processExpiringEvent(TimeExpiringEvent event){
		
		System.out.println("event:"+event);
		return false;
		
	}

}
