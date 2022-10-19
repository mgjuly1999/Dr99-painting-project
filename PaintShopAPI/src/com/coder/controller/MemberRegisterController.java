package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.MemberForm;
import com.coder.registerForm.AdminRegisterForm;
import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.MemberRegisterForm;
import com.coder.service.AdminService;
import com.coder.service.ColorGroupService;
import com.coder.service.ColorService;
import com.coder.service.LanguageService;
import com.coder.service.MemberService;
@Controller
@Transactional
public class MemberRegisterController {
	@Autowired
	private MemberService memberService;
	@RequestMapping("/memberRegisterPath")
	public String adminRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		MemberRegisterForm memberRegisterForm=new MemberRegisterForm();
		memberService.prepareMemberRegister(memberRegisterForm);
		modelMap.addAttribute("memberForm",new MemberForm());
		modelMap.addAttribute("memberRegisterForm",memberRegisterForm);
		return "MemberRegister";
	}
	
	@RequestMapping("/memberRegisterSubmit")
	public String adminRegisterSubmitDispatcher(@ModelAttribute("memberForm")MemberForm memberForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		MemberRegisterForm memberRegisterForm=new MemberRegisterForm();
		memberRegisterForm.setMemberForm(memberForm);
			memberService.prepareMemberRegister(memberRegisterForm);
			
			modelMap.addAttribute("memberForm",new MemberForm());
			modelMap.addAttribute("memberRegisterForm",memberRegisterForm);
	     return "MemberRegister";
		
	
	}
	
}
