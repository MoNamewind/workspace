package com.bj58.api.services;
/**
 * 二维码
 * @author 58
 *
 */
public interface IQrcodeService {
	
	public byte[] encode(String content) throws Exception;
	public String decode(String path);

}
