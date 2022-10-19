package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.service.ColorGroupService;
import com.coder.service.ColorService;
import com.coder.service.LanguageService;
@Controller
@Transactional
public class ColorRegisterController {
	@Autowired
	private ColorService colorService;
	@RequestMapping("/colorRegisterPath")
	public String colorRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
	    ColorRegisterForm colorRegisterForm=new ColorRegisterForm();
	    colorService.prepareColorRegister(colorRegisterForm);
		modelMap.addAttribute("colorRegisterForm",colorRegisterForm);
		return "colorRegister";
	}
	
	@RequestMapping("/colorRegisterSubmitPath")
	public String colorRegisterSubmitDispatcher(@ModelAttribute("colorRegisterForm")ColorRegisterForm colorRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		 colorService.prepareColorRegister(colorRegisterForm);
		 modelMap.addAttribute("colorRegisterForm",colorRegisterForm);
	     return "colorRegister";
		}else{
			return "home";  
		}
	
	}
	
}
