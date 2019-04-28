package com.eale.hrsm.controller.login;

import com.eale.carrentalsystem.bean.Role;
import com.eale.carrentalsystem.bean.User;
import com.eale.carrentalsystem.service.UserService;
import com.eale.hrsm.bean.User;
import com.eale.hrsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.Random;


@Controller
@RequestMapping("/")
public class LoginsController {


	@Autowired
	private UserService userService;

	
	public static final String CAPTCHA_KEY = "session_captcha";

	private Random rnd = new Random();
	
	/**
	 * 登录界面的显示
	 * @return
	 */
	@RequestMapping(value="logins",method= RequestMethod.GET)
	public String login(){
		return "login/login";
	}

	/**
	 * 注册界面的显示
	 * @return
	 */
	@RequestMapping(value = "goRegister",method = RequestMethod.GET)
	public String goRegister(){
		return "login/register";
	}
	
	@RequestMapping("loginout")
	public String loginout(HttpSession session){
		session.removeAttribute("userId");
		return "redirect:/logins";
	}
	
	/**
	 * 登录检查；
	 * 1、根据(用户名或电话号码)+密码进行查找
	 * 2、判断使用是否被冻结；
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value="logins",method = RequestMethod.POST)
	public String loginCheck(HttpSession session, HttpServletRequest req, Model model) throws UnknownHostException{
		String userName=req.getParameter("userName").trim();
		String password=req.getParameter("password");
		String ca=req.getParameter("code").toLowerCase();
		String sesionCode = (String) req.getSession().getAttribute(CAPTCHA_KEY);
		model.addAttribute("userName", userName);
		if(!ca.equals(sesionCode.toLowerCase())){
			model.addAttribute("errormess", "验证码输入错误!");
			req.setAttribute("errormess","验证码输入错误!");
			return "login/login";
		}
		/*
		 * 将用户名分开查找；用户名或者电话号码；
		 * */
		User user = userService.findOneUser(userName,password);
//		System.out.println(user.getIsLock());
		if(Objects.isNull(user)){
			model.addAttribute("errormess", "账号或密码错误!");
			return "login/login";
		}
		if(user.getIsLock()==1){
			model.addAttribute("errormess", "账号已被冻结!");
			return "login/login";
		}
		Object sessionId=session.getAttribute("userId");
//		if(sessionId==user.getUserId()){
//			model.addAttribute("hasmess", "当前用户已经登录了；不能重复登录");
//			session.setAttribute("thisuser", user);
//			return "login/login";
//		}else{
		session.setAttribute("userId", user.getUserId());
//		}
		return "redirect:/index";
	}
	
	@RequestMapping("handlehas")
	public String handleHas(HttpSession session){
		if(!StringUtils.isEmpty(session.getAttribute("thisuser"))){
			User user=(User) session.getAttribute("thisuser");
			session.removeAttribute("userId");
			session.setAttribute("userId", user.getUserId());
		}else{
			System.out.println("有问题！");
			return "login/login";
		}
		return "redirect:/index";
		
	}
	
	
	@RequestMapping("captcha")
	public void captcha(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException{
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		
		// 生成图片
		int w = 135, h = 40;
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

		// 将验证码存储在session以便登录时校验
		session.setAttribute(CAPTCHA_KEY, verifyCode.toLowerCase());
	}



	/**
	 * 注册
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "register",method = RequestMethod.POST)
	public String register(HttpServletRequest req, Model model){
		String userName=req.getParameter("userName").trim();
		String password=req.getParameter("password");
		String userTel=req.getParameter("userTel");
		String ca=req.getParameter("code").toLowerCase();
		String sesionCode = (String) req.getSession().getAttribute(CAPTCHA_KEY);
		model.addAttribute("userName", userName);
		if(!ca.equals(sesionCode.toLowerCase())){
			model.addAttribute("errormess", "验证码输入错误!");
			req.setAttribute("errormess","验证码输入错误!");
			return "login/register";
		}
		/*
		 * 将用户名分开查找；用户名或者电话号码；
		 * */
		User user = userService.findByUserName(userName);
//		System.out.println(user.getIsLock());
		if(Objects.isNull(user)){
			user =new User();
			user.setIsLock(0);
			user.setUserTel(userTel);
			user.setPassword(password);
			user.setUserName(userName);
			Role role =new Role();
			role.setRoleId((long)2);
			user.setRole(role);
			userService.save(user);
			return "login/login";

		}
		model.addAttribute("errormess", "该账户已存在!");
		return "login/register";
	}

	@RequestMapping(value ="customerLogins",method = RequestMethod.POST)
	public String customerLogin(HttpServletRequest req, HttpSession session, Model model){

		User user= null;
//		user = userService.findById((Long)session.getAttribute("userId"));
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		StringBuffer requestUrl= req.getRequestURL();
		System.out.println(requestUrl);
//		if (null!=user){
//			model.addAttribute("user",user);
//			return "app/home";
//		}

		String userName=req.getParameter("userName").trim();
		String password=req.getParameter("passWord");
		model.addAttribute("userName", userName);
		/*
		 * 将用户名分开查找；用户名或者电话号码；
		 * */
		user = userService.findOneUser(userName,password);
//		System.out.println(user.getIsLock());
		if(Objects.isNull(user)){
			model.addAttribute("errormess", "账号或密码错误!");
			return "login/login";
		}
		if(user.getIsLock()==1){
			model.addAttribute("errormess", "账号已被冻结!");
			return "login/login";
		}
		Object sessionId=session.getAttribute("userId");
		if(sessionId==user.getUserId()){
			model.addAttribute("hasmess", "当前用户已经登录了；不能重复登录");
			session.setAttribute("thisuser", user);
			return "app/home";
		}else{
			session.setAttribute("userId", user.getUserId());
		}


		return "app/home";
	}
	

}
