package com.bj58.api.Dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/**
 * DAO的基类，其他DAO可以直接继承这个DAO
 * @author 58
 *
 * @param <T>
 */
public class BaseDao<T> {
	
	private Class<T> entityClass;
	//private hiber
	/**
	 * 通过反射获取子类确定的泛型类
	 */
	public BaseDao(){
		Type genType=getClass().getGenericSuperclass();
		Type[] params= ((ParameterizedType)genType).getActualTypeArguments();
		entityClass=(Class) params[0];
	}
	
	public T load(Serializable id){
		return null;
		//return (T) getHibernateT 
	}
	
	

}
