package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.MemberStatusForm;
import com.coder.form.ProductQualityForm;
import com.coder.model.MemberStatus;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.MemberStatusRegisterForm;
import com.coder.registerForm.ProductQualityRegisterForm;
import com.coder.registerForm.ProductStatusRegisterForm;
import com.coder.service.LanguageService;
import com.coder.service.MemberStatusService;
import com.coder.service.ProductQualityService;
import com.coder.service.ProductStatusService;
@Controller
@Transactional
public class MemberStatusRegisterController {
	@Autowired
	private MemberStatusService memberStatusService;
	@RequestMapping("/memberStatusRegisterPath")
	public String memberStatusRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		MemberStatusRegisterForm memberStatusRegisterForm=new MemberStatusRegisterForm();
		
		memberStatusService.prepareMemberStatusRegister(memberStatusRegisterForm);
		modelMap.addAttribute("memberStatusForm",new MemberStatusForm());
		modelMap.addAttribute("memberStatusRegisterForm",memberStatusRegisterForm);
		return "MemberStatusRegister";
	}
	
	@RequestMapping("/memberStatusRegisterSubmit")
	public String memberStatusRegisterSubmitDispatcher(@ModelAttribute("memberStatusForm")MemberStatusForm memberStatusForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		
		MemberStatusRegisterForm memberStatusRegisterForm=new MemberStatusRegisterForm();
		memberStatusRegisterForm.setMemberStatusForm(memberStatusForm);
		memberStatusService.prepareMemberStatusRegister(memberStatusRegisterForm);
		modelMap.addAttribute("memberStatusForm",new MemberStatusForm());
		modelMap.addAttribute("memberStatusRegisterForm",memberStatusRegisterForm);
		return "MemberStatusRegister";
		
	
	}
	
}
