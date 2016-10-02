package com.bj58.ecard.utils;

import com.bj58.api.vo.ECard;

public class EcardUtils {
	
	/**
	 * 将用户信息转化为可以解析的字段；
	 * 拼凑字符串要满足联系人的格式,这样才能被手机识别.
	 * @param eCard
	 * @return
	 */
	public static String ConvertStand(ECard eCard){
		//String name,car,dept,mob,pho,fax,addr,web,email,com,ext,srt="";
		StringBuffer buffer=new StringBuffer("BEGIN:VCARD\n");
		if (!IsBlank(eCard.getName())) {
			buffer.append("FN:"+eCard.getName()+"\n");
		}
		
		if (!IsBlank(eCard.getCompany())) {
			if (!IsBlank(eCard.getDept())) {
				buffer.append("ORG:"+eCard.getCompany()+"("+eCard.getDept()+")\n");
			}else {
				buffer.append("ORG:"+eCard.getCompany()+"\n");
			}
		}
		
		if (!IsBlank(eCard.getTitle())) {
			buffer.append("TITLE:"+eCard.getTitle()+"\n");
		}
		if (!IsBlank(eCard.getAddress())) {
			buffer.append("ADR;WORK:"+eCard.getAddress()+"\n");
		}
		if (!IsBlank(eCard.getMobile())) {
			buffer.append("TEL;CALL:"+eCard.getMobile()+"\n");
		}
		if (!IsBlank(eCard.getTelphone())) {
			buffer.append("TEL;WORK:"+eCard.getTelphone()+"\n");
		}
		if (!IsBlank(eCard.getFax())) {
			buffer.append("TEL;WORK;FAX:"+eCard.getFax()+"\n");
		}
		if (!IsBlank(eCard.getEamil())) {
			buffer.append("EMAIL;WORK:"+eCard.getEamil()+"\n");
		}
		if (!IsBlank(eCard.getWeb())) {
			buffer.append("URL:"+eCard.getWeb()+"\n");
		}
		
		if (!IsBlank(eCard.getRemark())) {
			buffer.append("NOTE:"+eCard.getRemark()+"\n");
		}
		buffer.append("END:VCARD");
		
		return buffer.toString();
		
	}
	
	private static boolean IsBlank(String filed){
		
		if(filed==null ||filed.isEmpty()){
			return true;
		}
		
		return false;
		
	}

}
