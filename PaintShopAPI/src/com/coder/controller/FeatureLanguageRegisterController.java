package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.FeatureLanguageForm;
import com.coder.form.ProductGroupForm;
import com.coder.form.ToolLanguageForm;
import com.coder.registerForm.FeatureLanguageRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.registerForm.ToolLanguageRegisterForm;
import com.coder.service.FeatureLanguageService;
import com.coder.service.LanguageService;
import com.coder.service.ProductGroupService;
import com.coder.service.ToolLanguageService;
@Controller
@Transactional
public class FeatureLanguageRegisterController {
	@Autowired
	private FeatureLanguageService featureLanguageService;
	
    @RequestMapping("/featureLanguageRegisterPath")
	public String toolLanguageRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		FeatureLanguageRegisterForm featureLanguageRegisterForm=new FeatureLanguageRegisterForm();
	    this.featureLanguageService.prepareFeatureLanguageRegister(featureLanguageRegisterForm);
		modelMap.addAttribute("featureLanguageRegisterForm",featureLanguageRegisterForm);
		return "featureLanguageRegister";
	}
	
	@RequestMapping("/featureLanguageRegisterSubmitPath")
	public String toolLanguageRegisterSubmitDispatcher(@ModelAttribute("featureLanguageRegisterForm")FeatureLanguageRegisterForm featureLanguageRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		
		 FeatureLanguageForm featureLanguageForm=featureLanguageRegisterForm.getFeatureLanguageForm();
		 featureLanguageForm.setLanguageId("1");
		 featureLanguageRegisterForm.setFeatureLanguageForm(featureLanguageForm);
		 featureLanguageService.prepareFeatureLanguageRegister(featureLanguageRegisterForm);
		 modelMap.addAttribute("featureLanguageRegisterForm",featureLanguageRegisterForm);
		     return "featureLanguageRegister";
		}else{
			return "home";
		}	}
	
}
