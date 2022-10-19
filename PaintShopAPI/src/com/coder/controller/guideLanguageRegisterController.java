package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.GuideLanguageForm;
import com.coder.form.ProductGroupForm;
import com.coder.form.ToolLanguageForm;
import com.coder.registerForm.GuideLanguageRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.registerForm.ToolLanguageRegisterForm;
import com.coder.service.GuideLanguageService;
import com.coder.service.LanguageService;
import com.coder.service.ProductGroupService;
import com.coder.service.ToolLanguageService;
@Controller
@Transactional
public class guideLanguageRegisterController {
	@Autowired
	private GuideLanguageService guideLanguageService;
	
    @RequestMapping("/guideLanguageRegisterPath")
	public String guideLanguageRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
    	GuideLanguageRegisterForm guideLanguageRegisterForm=new GuideLanguageRegisterForm();
	    this.guideLanguageService.prepareGuideLanguageRegister(guideLanguageRegisterForm);
		modelMap.addAttribute("guideLanguageRegisterForm",guideLanguageRegisterForm);
		return "GuideLanguageRegister";
	}
	
	@RequestMapping("/guideLanguageRegisterSubmitPath")
	public String guideLanguageRegisterSubmitDispatcher(@ModelAttribute("guideLanguageRegisterForm")GuideLanguageRegisterForm guideLanguageRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		
		GuideLanguageForm guideLanguageForm=guideLanguageRegisterForm.getGuideLanguageForm();
		 guideLanguageForm.setLanguageId("1");
		 guideLanguageRegisterForm.setGuideLanguageForm(guideLanguageForm);
		 guideLanguageService.prepareGuideLanguageRegister(guideLanguageRegisterForm);
		 modelMap.addAttribute("guideLanguageRegisterForm",guideLanguageRegisterForm);
		     return "GuideLanguageRegister";
		}else{
			return "home";
		}	}
	
}
