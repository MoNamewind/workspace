package com.bj58.api.controllers;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bj58.api.domain.User;
import com.bj58.api.services.IUserService;
import com.bj58.api.vo.LoginCommand;



/**
 * 负责处理登录请求，完成登录业务，并根据登录成功与否转向欢迎页面或失败页面
 * 
 * @author lenovo
 *
 */
@Controller //标注成为一个spring mvc 的Controller
public class LoginController {

	@Autowired
	private IUserService userService;
	/**
	 * 负责处理/index.html
	 */
	@RequestMapping(value="/index1.action")
	public String loginPage() {
		return "user/login";
	}
	/**
	 * 负责处理/loginCheck.html的请求
	 * 检查登录
	 * ModelAndView代表：模型和视图，模型使用来给视图进行渲染的数据。可以没有模型model，直接返回视图模型。
	 * 也可以直接返回字符串代表逻辑视图名
	 * 注意：在这个方法调用中如果抛出异常，该怎么处理？。
	 * 注意：modelAndView不要导错包了，或者会出现解析错误。
	 * 错误的：import org.springframework.web.portlet.ModelAndView
	 * 正确的：import org.springframework.web.servlet.ModelAndView;
	 */
	@RequestMapping(value="/loginCheck.action")
	public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand) {
		System.out.println(loginCommand.getPassword()+" "+loginCommand.getUserName());
		boolean isValidUser=
			userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
		System.out.println("isValidUser="+isValidUser);
		if (!isValidUser) {
			//视图名：login；model：error="用户名或密码错误。"，errer相当于与视图名
			//参数1：逻辑视图名，参数2;model名称，参数3：数据模型对象
			return new ModelAndView("user/login","error","用户名或密码错误。");
			//new ModelAndView(view, model) //返回多个参数
		} else {//正确
          User user=userService.findUserByUserName(loginCommand.getUserName());
          user.setLastlp(request.getRemoteAddr());
          user.setLastVisit(new Date());
          userService.loginSuccess(user);
          request.getSession().setAttribute("user", user);//放入与对象中，供返回的视图使用。
          return new ModelAndView("user/main");
		}
	}
}
