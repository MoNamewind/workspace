package com.smart.framework.webmvc.utils;

import java.util.Map;

public class CollectionUtil {

	

	public static boolean isNotEmpty(Map<Class<?>, Object> beanMap) {
		
		return beanMap.isEmpty();
	}

}
