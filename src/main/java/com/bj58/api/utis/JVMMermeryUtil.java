package com.bj58.api.utis;

import java.math.BigDecimal;

/**
 * 
 * @description 显示Java内存的信息
 * @author liushujin01
 * @since  2016年9月17日
 */
public class JVMMermeryUtil {
	
	public static final Long M_UNIT=1024*1024L;//1M
	
	
	public static String getJVMInfo(){
		Runtime runtime=Runtime.getRuntime();
		double max=runtime.maxMemory()/M_UNIT;
		double total=runtime.totalMemory()/M_UNIT;
		double free=runtime.freeMemory()/M_UNIT;
		double available=max-total+free; //可用的内存
		
		//保留2位小数，四色五入；
		BigDecimal bavailable=new BigDecimal(available);
		bavailable=bavailable.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bavailable.toString();
	}

}
