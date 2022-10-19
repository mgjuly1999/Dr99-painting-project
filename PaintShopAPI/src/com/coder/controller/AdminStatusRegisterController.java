package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.AdminStatusForm;
import com.coder.form.MemberStatusForm;
import com.coder.form.ProductQualityForm;
import com.coder.model.MemberStatus;
import com.coder.registerForm.AdminStatusRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.MemberStatusRegisterForm;
import com.coder.registerForm.ProductQualityRegisterForm;
import com.coder.registerForm.ProductStatusRegisterForm;
import com.coder.service.AdminStatusService;
import com.coder.service.LanguageService;
import com.coder.service.MemberStatusService;
import com.coder.service.ProductQualityService;
import com.coder.service.ProductStatusService;
@Controller
@Transactional
public class AdminStatusRegisterController {
	@Autowired
	private AdminStatusService adminStatusService;
	@RequestMapping("adminStatusRegisterPath")
	public String memberStatusRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		AdminStatusRegisterForm adminStatusRegisterForm=new AdminStatusRegisterForm();
		
		adminStatusService.prepareAdminStatusRegister(adminStatusRegisterForm);
		modelMap.addAttribute("adminStatusForm",new AdminStatusForm());
		modelMap.addAttribute("adminStatusRegisterForm",adminStatusRegisterForm);
		return "AdminStatusRegister";
	}
	
	@RequestMapping("/adminStatusRegisterSubmit")
	public String memberStatusRegisterSubmitDispatcher(@ModelAttribute("adminStatusForm")AdminStatusForm adminStatusForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		
		AdminStatusRegisterForm adminStatusRegisterForm=new AdminStatusRegisterForm();
		adminStatusRegisterForm.setAdminStatusForm(adminStatusForm);
		adminStatusService.prepareAdminStatusRegister(adminStatusRegisterForm);
		modelMap.addAttribute("adminStatusForm",new AdminStatusForm());
		modelMap.addAttribute("adminStatusRegisterForm",adminStatusRegisterForm);
		return "AdminStatusRegister";
		
	
	}
	
}
