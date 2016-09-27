package com.smart.framework.webmvc.utils;

import java.lang.reflect.Field;
import java.util.Map;

import com.smart.framework.webmvc.annotation.Injet;


public final class  IOCHelper{
	
	static{
		Map<Class<?>, Object> beanMap=BeanHelper.getBeanMap();
		if(CollectionUtil.isNotEmpty(beanMap)){
			//遍历Bean Map
			for(Map.Entry<Class<?>, Object> beanEntry:beanMap.entrySet()){
				Class<?> beanClass=beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				Field[] beanFields = beanClass.getDeclaredFields();
				for (Field beanField:beanFields) {
					if (beanField.isAnnotationPresent(Injet.class)) {
						   Class<?> beanFieldclass= beanField.getType();
						   Object beanFieldInstance=beanMap.get(beanFieldclass);
						   if (beanFieldInstance!=null) {
							ReflectUtil.setFiled(beanInstance,beanField,beanFieldInstance);
						}
					}
					
				}
			}
		}
	}

}
