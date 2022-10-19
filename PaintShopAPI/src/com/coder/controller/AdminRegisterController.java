package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.AdminForm;
import com.coder.model.Admin;
import com.coder.registerForm.AdminRegisterForm;
import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.service.AdminService;
import com.coder.service.ColorGroupService;
import com.coder.service.ColorService;
import com.coder.service.LanguageService;
@Controller
@Transactional
public class AdminRegisterController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/adminRegisterPath")
	public String adminRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
	    AdminRegisterForm adminRegisterForm=new AdminRegisterForm();
	    adminService.prepareAdminRegister(adminRegisterForm);
	    modelMap.addAttribute("adminForm",new AdminForm());
		modelMap.addAttribute("adminRegisterForm",adminRegisterForm);
		return "AdminRegister";
	}
	
	@RequestMapping("/adminRegisterSubmitPath")
	public String adminRegisterSubmitDispatcher(@ModelAttribute("adminForm")AdminForm adminForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		
		AdminRegisterForm adminRegisterForm=new AdminRegisterForm();
		adminRegisterForm.setAdminForm(adminForm);
		 adminService.prepareAdminRegister(adminRegisterForm);
		   modelMap.addAttribute("adminForm",new AdminForm());
			modelMap.addAttribute("adminRegisterForm",adminRegisterForm);
	     return "AdminRegister";
	
	
	}
	@RequestMapping("/admin")
	public String adminLoginDispatcher(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
	     modelMap.addAttribute("adminRegisterForm",new AdminRegisterForm());
	     return "login";
		 
		
	}
	@RequestMapping("/adminLoginSubmitPath")
	public String adminLoginSubmitDispatcher(@ModelAttribute("adminRegisterForm")AdminRegisterForm adminRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		 Admin admin=this.adminService.adminLogin(adminRegisterForm);
		 if(admin!=null){
			 HttpSession session=req.getSession(true);	
			 session.setMaxInactiveInterval(600);
			 session.setAttribute("admin",admin);
			  return "AdminDashboard";
		 }
		 adminRegisterForm.setMessage("Incorrect User Name & Password!");
		 modelMap.addAttribute("adminRegisterForm",adminRegisterForm);
	     return "login";
		 
		
	}
	
}
