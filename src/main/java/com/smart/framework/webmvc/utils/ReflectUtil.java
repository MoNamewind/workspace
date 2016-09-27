package com.smart.framework.webmvc.utils;

import java.lang.reflect.Field;

public class ReflectUtil {

	
	public static void setFiled(Object beanInstance, Field beanField, Object beanFieldInstance) {
		try {
			beanField.set(beanInstance, beanFieldInstance);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}
