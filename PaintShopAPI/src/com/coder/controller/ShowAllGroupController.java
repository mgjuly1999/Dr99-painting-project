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
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.service.LanguageService;
import com.coder.service.ProductGroupService;
@Controller
@Transactional
public class ShowAllGroupController {
	@Autowired
	private ProductGroupService productGroupService;
	
    @RequestMapping("/showAllProductGroupPath")
	public String showAllGroupDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		ProductGroupRegisterForm productGroupRegisterForm=new ProductGroupRegisterForm();
		productGroupService.showAllProductGroup(productGroupRegisterForm);
		modelMap.addAttribute("productGroupRegisterForm",productGroupRegisterForm);
		return "showAllProductGroup";
	}
	
   
   	
	
}
