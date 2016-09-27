package com.smart.framework.webmvc.utils;

import java.util.HashMap;
import java.util.Map;

public class BeanHelper {
    public final static HashMap<Class<?>, Object> beanMap;
    static{
    	beanMap=new HashMap<Class<?>, Object>();
    }
	public static Map<Class<?>, Object> getBeanMap() {
		return beanMap;
	}

}
