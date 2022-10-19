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
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.service.ColorGroupService;
import com.coder.service.LanguageService;
@Controller
@Transactional
public class ColorGroupRegisterController {
	@Autowired
	private ColorGroupService colorGroupService;
	@RequestMapping("/colorGroupRegisterPath")
	public String colorGroupRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		ColorGroupRegisterForm colorGroupRegisterForm=new ColorGroupRegisterForm();
		modelMap.addAttribute("colorGroupRegisterForm",colorGroupRegisterForm);
		colorGroupService.prepareColorGroupRegister(colorGroupRegisterForm);
		return "colorGroupRegister";
	}
	
	@RequestMapping("/colorGroupRegisterSubmitPath")
	public String colorGroupRegisterSubmitDispatcher(@ModelAttribute("colorGroupRegisterForm")ColorGroupRegisterForm colorGroupRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
			colorGroupService.prepareColorGroupRegister(colorGroupRegisterForm);
		 modelMap.addAttribute("colorGroupRegisterForm",colorGroupRegisterForm);
	     return "colorGroupRegister";
		}else{
			return "home";
		}
	
	}
	
}
