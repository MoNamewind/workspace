package com.bj58.api.services.imp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import com.bj58.api.exceptions.AccountCaptchaException;
import com.bj58.api.services.IAccountCaptchaService;
import com.bj58.api.utis.RandomGenerator;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
/**
 * 产生验证码
 * @author 58
 *
 */
@Service
public class AccountCaptchaServiceImp implements IAccountCaptchaService,InitializingBean{
	 final Logger logger = Logger.getLogger(AccountCaptchaServiceImp.class); 
	private DefaultKaptcha producer;
	private Map<String,String> captchaMap=new HashMap<String,String>();
	private List<String> preDefinedTexts;
	private int textCount=0;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		producer=new DefaultKaptcha();
		producer.setConfig(new Config(new Properties()));
		
	}
    /**
     * 建立映射：
     */
	@Override
	public String generateCaptchaKey() throws AccountCaptchaException {
		String key=RandomGenerator.getRandomString();
		String value=getCaptchaText();
		captchaMap.put(key, value);	
		return key;
	}
    /**
     * 获取验证码图片的字符串值
     * @return
     */
	private String getCaptchaText() {
		if (preDefinedTexts!=null && !preDefinedTexts.isEmpty()) {
			String text=preDefinedTexts.get(textCount);
			textCount=(textCount+1)%preDefinedTexts.size();
			return text;
		}else {
			return producer.createText();
		}
	}
    /**
     * 产生验证码图片
     */
	@Override
	public byte[] generateCaptchaImage(String captchaKey) throws AccountCaptchaException {
		String text=captchaMap.get(captchaKey);
		if (text==null) {
			throw new AccountCaptchaException("Captcha key'"+captchaKey+"'not found!");
		}
		BufferedImage image=producer.createImage(text);
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		try{
			ImageIO.write(image, "jpg", out);
		}catch (IOException e) {
			throw new AccountCaptchaException("Failed to write Captcha stream!",e);
		}
		return out.toByteArray();
	}

	@Override
	public List<String> getPreDefinedTexts() {
		return preDefinedTexts;
	}

	@Override
	public void setPreDefinedTexts(List<String> preDefinedTexts) {	
		this.preDefinedTexts=preDefinedTexts;
	}
	/**
	 * 验证验证码
	 * @param captchaKey
	 * @param captchaValue
	 * @return
	 * @throws AccountCaptchaException
	 */
	@Override
	public boolean validateCaptcha(String captchaKey,String captchaValue)throws AccountCaptchaException {
		String text=captchaMap.get(captchaKey);
		logger.info("text:"+text);
		if (text==null) {
			throw new AccountCaptchaException("Captch key'"+captchaKey+" 'not found");
		}
		if (text.equals(captchaValue)) {
			captchaMap.remove(captchaKey);
			return true;
		}
		return false;
	}

}
