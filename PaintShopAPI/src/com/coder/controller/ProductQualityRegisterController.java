package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.ProductQualityForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductQualityRegisterForm;
import com.coder.registerForm.ProductStatusRegisterForm;
import com.coder.service.LanguageService;
import com.coder.service.ProductQualityService;
import com.coder.service.ProductStatusService;
@Controller
@Transactional
public class ProductQualityRegisterController {
	@Autowired
	private ProductQualityService productQualityService;
	@RequestMapping("/productQualityRegisterPath")
	public String productQualityRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		ProductQualityRegisterForm productQualityRegisterForm=new ProductQualityRegisterForm();
		
		productQualityService.prepareProductQualityRegister(productQualityRegisterForm);
		modelMap.addAttribute("productQualityForm",new ProductQualityForm());
		modelMap.addAttribute("productQualityRegisterForm",productQualityRegisterForm);
		return "productQualityRegister";
	}
	
	@RequestMapping("/productQualityRegisterSubmit")
	public String productQualityRegisterSubmitDispatcher(@ModelAttribute("productQualityForm")ProductQualityForm productQualityForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		
		ProductQualityRegisterForm productQualityRegisterForm=new ProductQualityRegisterForm();
		productQualityRegisterForm.setProductQualityForm(productQualityForm);
		productQualityService.prepareProductQualityRegister(productQualityRegisterForm);
		modelMap.addAttribute("productQualityForm",new ProductQualityForm());
		modelMap.addAttribute("productQualityRegisterForm",productQualityRegisterForm);
		return "productQualityRegister";
		
	
	}
	
}
