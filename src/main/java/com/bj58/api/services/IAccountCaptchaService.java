package com.bj58.api.services;

import java.util.List;

import com.bj58.api.exceptions.AccountCaptchaException;

public interface IAccountCaptchaService {
   String generateCaptchaKey()throws AccountCaptchaException;
   byte[]  generateCaptchaImage(String captchaKey) throws AccountCaptchaException;
   List<String> getPreDefinedTexts();
   void setPreDefinedTexts(List<String> preDefinedTexts);
   boolean validateCaptcha(String captchaKey, String captchaValue) throws AccountCaptchaException;
}
