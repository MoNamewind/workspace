package com.bj58.api.eventBus;

import com.google.common.eventbus.EventBus;

public class TimeEventBus {
	
	public static final EventBus eventbus=new EventBus();
	
	public static void post(Object event){
		eventbus.register(event);
	}
	
	public static void register(Object Handler){
		eventbus.register(Handler);
	}
	public static void unregister(Object Handler){
		eventbus.unregister(Handler);
	}
}
