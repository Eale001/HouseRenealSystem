package com.eale.hrsm.controller.role;


import com.eale.carrentalsystem.bean.*;
import com.eale.carrentalsystem.service.RoleService;
import com.eale.carrentalsystem.service.RolepowerlistService;
import com.eale.carrentalsystem.service.SystemMenuService;
import com.eale.carrentalsystem.service.UserService;
import com.eale.hrsm.bean.*;
import com.eale.hrsm.service.RoleService;
import com.eale.hrsm.service.RolepowerlistService;
import com.eale.hrsm.service.SystemMenuService;
import com.eale.hrsm.service.UserService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class RoleController {


	@Autowired
	private RoleService roleService;

	@Autowired
	private SystemMenuService systemMenuService;

	@Autowired
	private UserService userService;

	@Autowired
	private RolepowerlistService rolepowerlistService;
	
	/**
	 * 角色管理
	 * @return
	 */
	@RequestMapping("rolemanage")
	public ModelAndView index(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size){
		ModelAndView mav=new ModelAndView("role/rolemanage");
		Page<Role> pagerole=roleService.findAll(page,size);

		List<Role>  rolelist=pagerole.getContent();
		mav.addObject("page", pagerole);
		mav.addObject("rolelist", rolelist);
		mav.addObject("url", "roleser");
		return mav;
	}
	
	/**
	 * 条件查询
	 */
	@RequestMapping("roleser")
	public String roleser(HttpServletRequest req, Model model,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size){
		Page<Role> pagerole=null;
		List<Role>  rolelist=null;
		String val=null;
		
		
		if(!StringUtil.isEmpty(req.getParameter("val"))){
			val=req.getParameter("val").trim();
		}
		
		if(!StringUtil.isEmpty(val)){
			pagerole=roleService.findbyrolename(val,page,size);
			model.addAttribute("sort", "&val="+val);
		}else{
			 pagerole=roleService.findAll(page,size);
		}
		 rolelist=pagerole.getContent();
		 model.addAttribute("page", pagerole);
		 model.addAttribute("rolelist", rolelist);
		 model.addAttribute("url", "roleser");
		return "role/roletable";
	}
	
	/**
	 * 设定角色权限
	 * @return
	 */
	@RequestMapping("roleset")
	public String index2(HttpServletRequest req, Model model){
	
		Long roleid=Long.parseLong(req.getParameter("id"));
		
		Role role=roleService.findById(roleid);
		List<Rolemenu> oneMenuAll=rolepowerlistService.findbyparentall(0L, roleid);


		List<Rolemenu> twoMenuAll=rolepowerlistService.findbyparents(0L, roleid);

		model.addAttribute("oneMenuAll", oneMenuAll);
		model.addAttribute("twoMenuAll", twoMenuAll);
		model.addAttribute("roleid", roleid);
		model.addAttribute("rolename", role.getRoleName());
		return "role/roleset";
		
	}
	
	/**
	 * 权限设定
	 */
	@RequestMapping("powerss")
	public @ResponseBody
    Boolean power(HttpServletRequest req){
	Long roleid=Long.parseLong(req.getParameter("roleid"));
	String content=	req.getParameter("content").trim();
	Long menuid=Long.parseLong(	req.getParameter("menuid"));
	Rolepowerlist rolepower=rolepowerlistService.findbyroleidandmenuid(roleid,menuid);
	System.out.println(rolepower);
	if(content.equals("选中")){
		rolepower.setCheck(true);
	}else{
		rolepower.setCheck(false);
	}
		
		rolepowerlistService.save(rolepower);
		return true;
	}
	/**
	 * 进入新增角色
	 * @return
	 */
	@RequestMapping("addrole")
	public String index3(HttpServletRequest req, Model model){
		String id=null;
		Role role=new Role();
		
		if(!StringUtil.isEmpty(req.getParameter("id"))){
			id=req.getParameter("id");
			Long lid=Long.parseLong(id);
			role=roleService.findById(lid);

		}
		model.addAttribute("role", role);
		return "role/addrole";
	}
	
	/**
	 * 新增，修改角色确定
	 * @return
	 */
	@RequestMapping("modifyrole")
	public String index4(HttpServletRequest req, @Valid Role role, BindingResult br){
		String id=null;
		if(!StringUtil.isEmpty(req.getParameter("id"))){
			id=req.getParameter("id");
		}
		if(!StringUtil.isEmpty(id)){
			Long lid=Long.parseLong(id);
			Role roles=roleService.findById(lid);
			roles.setRoleName(role.getRoleName());
			roleService.save(roles);
			
		}else{
			Role rolep=roleService.save(role);
			List<SystemMenu> menulist=systemMenuService.findall();
			rolepowerlistService.save(menulist, rolep);
		}
		return "redirect:/rolemanage";
	}
/**
 * 删除
 */
	@RequestMapping("deshan")
	public String index5(HttpServletRequest req, Model model, HttpSession session){
		String userId = ((String) session.getAttribute("userId")).trim();
		Long userid = Long.parseLong(userId);
		User user=userService.findById(userid);
		String id=null;
		if(!StringUtil.isEmpty(req.getParameter("id"))){
			id=req.getParameter("id");
			
		}
		Long lid=Long.parseLong(id);
		if(user.getSuperman().equals(true)){
			List<User> useist=userService.findrole(lid);
			if(useist.size()>0){
				model.addAttribute("error", "此角色下还有职员，不允许删除。");
				return "common/proce";
			}else{
				Role r=roleService.findById(lid);
				roleService.delete(r);
			}
		}else{
			model.addAttribute("error", "只有超级管理员才能操作。");
			return "common/proce";
		}
		return null;
		
	}
}
