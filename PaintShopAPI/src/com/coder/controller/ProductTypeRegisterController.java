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
import com.coder.form.ProductTypeForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.registerForm.ProductTypeRegisterForm;
import com.coder.service.LanguageService;
import com.coder.service.ProductGroupService;
import com.coder.service.ProductTypeService;
@Controller
@Transactional
public class ProductTypeRegisterController {
	@Autowired
	private ProductTypeService productTypeService;
	
    @RequestMapping("/productTypeRegisterPath")
	public String productTypeRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		ProductTypeRegisterForm productTypeRegisterForm=new ProductTypeRegisterForm();
		productTypeService.prepareProductTypeRegister(productTypeRegisterForm);
		modelMap.addAttribute("productTypeRegisterForm",productTypeRegisterForm);
		return "productTypeRegister";
	}
	
	@RequestMapping("/productTypeRegisterSubmitPath")
	public String languageRegisterSubmitDispatcher(@ModelAttribute("productTypeRegisterForm")ProductTypeRegisterForm productTypeRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		
		 ProductTypeForm productTypeForm=productTypeRegisterForm.getProductTypeForm();
		 productTypeForm.setLanguageId("1");
		 productTypeRegisterForm.setProductTypeForm(productTypeForm);
		 productTypeService.prepareProductTypeRegister(productTypeRegisterForm);
		 modelMap.addAttribute("productTypeRegisterForm",productTypeRegisterForm);
		     return "productTypeRegister";
		}else{
			return "home";
		}	}
	}
