package com.bj58.api.services;



public interface IAcountEmailService {
	
	void sendEmail(String to,String subject,String htmlText)throws Exception;

}
