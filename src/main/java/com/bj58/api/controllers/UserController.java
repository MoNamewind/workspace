package com.bj58.api.controllers;

import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bj58.api.domain.User;
import com.bj58.api.services.IAccountCaptchaService;
import com.bj58.api.services.IAcountEmailService;
import com.bj58.api.services.IQrcodeService;
import com.bj58.api.services.IUserService;
import com.bj58.api.utis.EmailUtil;
import com.bj58.api.utis.SessionUtil;
import com.bj58.api.vo.ECard;
import com.bj58.api.vo.RegisterVo;
import com.bj58.ecard.utils.EcardUtils;
/**
 * 返回值可以为空
 * @author 58
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IAccountCaptchaService accountCaptchaService;
	@Resource
	IQrcodeService qrccodeService;
	@Autowired
	IUserService userService;
	@Autowired
	IAcountEmailService acountEmailService;
	
	
	
	@RequestMapping("/registerUI.action")
	public String registerUI(Model model){//model通过ioc注入到进入的。
		model.addAttribute("liming", "黎明你好");
		return "user/register";
	}
	
	@RequestMapping("/register.action")
	public ModelAndView register(RegisterVo registerVo,Model model, HttpServletRequest request) throws Exception{//model通过ioc注入到进入的。
		System.out.println(registerVo);
		SessionUtil.registerVo(request);
		String key =(String) SessionUtil.get("vlidateCode");
		//验证校验码
		if(!accountCaptchaService.validateCaptcha(key, registerVo.getVlidateCode())){
			System.out.println("registerVo.getVlidateCode()"+registerVo.getVlidateCode()+"  "+"key="+key);
			return new ModelAndView("user/register","error","验证码错误。");
		}
		//判断是否注册过
		User user=userService.findUserByUserName(registerVo.getUserName());
		if (user.getUserName()!=null) {	
			return new ModelAndView("user/register","error","改用户已经注册过。");
		}
		
		//发送邮件
		String suffix=EmailUtil.getUUid();
		String url="//localhost:8080/user/finshRegister.action?suffix="+suffix;
		SessionUtil.add(registerVo.getUserName(), suffix);
		acountEmailService.sendEmail(registerVo.getEmail(),EmailUtil.SUBJECT, EmailUtil.getHtml(url));
		
		//添加到数据库中
		BeanUtils.copyProperties(user, registerVo);
		userService.addUser(user);
		return new ModelAndView("index", "username", user.getUserName());
		//return new ModelAndView("index");
	}
	
	/**
	 * 获取二维码图片
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getIcon.action")
	public void getIcon(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String key=accountCaptchaService.generateCaptchaKey();
		SessionUtil.registerVo(request);
		SessionUtil.add("vlidateCode", key);
		byte[] image = accountCaptchaService.generateCaptchaImage(key);
		response.setContentType("image/png");
        OutputStream stream = response.getOutputStream();
        stream.write(image);
        stream.flush();
        stream.close();
	}
	/**
	 * 获取电子图片
	 */
	@RequestMapping("/getECardUI.action")
	public String getECardUI() throws Exception {
		
		  return "ecard/index";
	}
	/**
	 * 获取电子图片
	 */
	@RequestMapping("/getECard.action")
	public void getECard(ECard eCard,HttpServletResponse response) throws Exception {
		System.out.println(eCard);
		String content = EcardUtils.ConvertStand(eCard);
		System.out.println(content);
		byte[] image = qrccodeService.encode(content);
		response.setContentType("image/png");
        OutputStream stream = response.getOutputStream();
        stream.write(image);
        stream.flush();
        stream.close();
	}
	
	
}
