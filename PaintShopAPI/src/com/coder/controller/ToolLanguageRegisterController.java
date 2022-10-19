package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.ProductGroupForm;
import com.coder.form.ToolLanguageForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.registerForm.ToolLanguageRegisterForm;
import com.coder.service.LanguageService;
import com.coder.service.ProductGroupService;
import com.coder.service.ToolLanguageService;
@Controller
@Transactional
public class ToolLanguageRegisterController {
	@Autowired
	private ToolLanguageService toolLanguageService;
	
    @RequestMapping("/toolLanguageRegisterPath")
	public String toolLanguageRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		ToolLanguageRegisterForm toolLanguageRegisterForm=new ToolLanguageRegisterForm();
	    this.toolLanguageService.prepareToolLanguageRegister(toolLanguageRegisterForm);
		modelMap.addAttribute("toolLanguageRegisterForm",toolLanguageRegisterForm);
		return "toolLanguageRegister";
	}
	
	@RequestMapping("/toolLanguageRegisterSubmitPath")
	public String toolLanguageRegisterSubmitDispatcher(@ModelAttribute("toolLanguageRegisterForm")ToolLanguageRegisterForm toolLanguageRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		
		 ToolLanguageForm toolLanguageForm=toolLanguageRegisterForm.getToolLanguageForm();
		 toolLanguageForm.setLanguageId("1");
		 toolLanguageRegisterForm.setToolLanguageForm(toolLanguageForm);
		 toolLanguageService.prepareToolLanguageRegister(toolLanguageRegisterForm);
		 modelMap.addAttribute("toolLanguageRegisterForm",toolLanguageRegisterForm);
		     return "toolLanguageRegister";
		}else{
			return "home";
		}	}
	
}
