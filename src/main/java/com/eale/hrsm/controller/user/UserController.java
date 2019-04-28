package com.eale.hrsm.controller.user;


import com.eale.carrentalsystem.bean.Role;
import com.eale.carrentalsystem.bean.User;
import com.eale.carrentalsystem.service.RoleService;
import com.eale.carrentalsystem.service.UserService;
import com.github.pagehelper.util.StringUtil;
import com.github.stuxuhai.jpinyin.PinyinException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

	public static final String CAPTCHA_KEY = "session_captcha";


	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("userlogmanage")
	public String userlogmanage() {
		return "user/userlogmanage";
	}
	
	@RequestMapping("usermanage")
	public String usermanage(Model model, @RequestParam(value="page",defaultValue="0") int page,
                             @RequestParam(value="size",defaultValue="10") int size
			) {
//		Sort sort=new Sort(new Order(Direction.ASC,"dept"));
//		Pageable pa=new PageRequest(page, size,sort);
//		Page<User> userspage = udao.findByIsLock(0, pa);
		Page<User> userspage = userService.findByIsLock(0, page,size);
		List<User> users=userspage.getContent();
		model.addAttribute("users",users);
		model.addAttribute("page", userspage);
		model.addAttribute("url", "usermanagepaging");
		return "user/usermanage";
	}
	
	@RequestMapping("usermanagepaging")
	public String userPaging(Model model, @RequestParam(value="page",defaultValue="0") int page,
                             @RequestParam(value="size",defaultValue="10") int size,
                             @RequestParam(value="usersearch",required=false) String usersearch
			){
//		Sort sort=new Sort(new Order(Direction.ASC,"dept"));
//		Pageable pa=new PageRequest(page, size,sort);
		Page<User> userspage = null;
		if(StringUtil.isEmpty(usersearch)){
			userspage =  userService.findByIsLock(0, page,size);
		}else{
			userspage = userService.findnamelike(usersearch, page,size);
		}
		List<User> users=userspage.getContent();
		model.addAttribute("users",users);
		model.addAttribute("page", userspage);
		model.addAttribute("url", "usermanagepaging");
		
		return "user/usermanagepaging";
	}
	
	
	@RequestMapping(value="useredit",method = RequestMethod.GET)
	public String usereditget(@RequestParam(value = "userid",required=false) Long userid, Model model) {
		if(userid!=null){
			User user = userService.findById(userid);
			model.addAttribute("where","xg");
			model.addAttribute("user",user);
		}
		

		List<Role> roles = roleService.findAll();

		model.addAttribute("roles", roles);
		return "user/edituser";
	}

	@RequestMapping(value="usergetInfo",method = RequestMethod.GET)
	public String usergetInfo(HttpSession session, Model model) {
		Long userid =(Long) session.getAttribute("userId");
		if(userid!=null){
			User user = userService.findById(userid);
			model.addAttribute("where","xg");
			model.addAttribute("user",user);
		}


		List<Role> roles = roleService.findAll();

		model.addAttribute("roles", roles);
		return "user/edituser";
	}
	
	@RequestMapping(value="useredit",method = RequestMethod.POST)
	public String usereditpost(User user,
			@RequestParam("roleid") Long roleid,
			@RequestParam(value = "isbackpassword",required=false) boolean isbackpassword,
			Model model) throws PinyinException {
		System.out.println(user);
		System.out.println(roleid);
		Role role = roleService.findById(roleid);
		if(user.getUserId()==null){
			user.setPassword("123456");
			user.setRole(role);
			user.setIsLock(0);
			userService.save(user);
		}else{
			User user2 = userService.findById(user.getUserId());
			user2.setUserTel(user.getUserTel());
			user2.setRealName(user.getRealName());
			user2.setEamil(user.getEamil());
			user2.setAddress(user.getAddress());
			user2.setIdCard(user.getIdCard());
			user2.setBank(user.getBank());
			user2.setThemeSkin(user.getThemeSkin());
			user2.setSalary(user.getSalary());
			if(isbackpassword){
				user2.setPassword("123456");
			}
			user2.setRole(role);
			userService.save(user2);
		}
		
		model.addAttribute("success",1);
		return "/usermanage";
	}
	
	
	@RequestMapping("deleteuser")
	public String deleteuser(@RequestParam("userid") Long userid, Model model){
		User user = userService.findById(userid);
		
		user.setIsLock(1);
		
		userService.save(user);
		
		model.addAttribute("success",1);
		return "/usermanage";
		
	}
	
	@RequestMapping("useronlyname")
    public @ResponseBody
    boolean useronlyname(@RequestParam("username") String username){
		User user = userService.findByUserName(username);
		if(user==null){
			return true;
		}
		return false;
    }



}
