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
import com.coder.service.ProductTypeService;
@Controller
@Transactional
public class ProductGroupRegisterController {
	@Autowired
	private ProductGroupService productGroupService;
	@Autowired
	private ProductTypeService productTypeService;
    @RequestMapping("/productGroupRegisterPath")
	public String languageRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		ProductGroupRegisterForm productGroupRegisterForm=new ProductGroupRegisterForm();
		productGroupService.prepareProductGroupRegister(productGroupRegisterForm);
		modelMap.addAttribute("productGroupRegisterForm",productGroupRegisterForm);
		return "productGroupRegister";
	}
	
	@RequestMapping("/productGroupRegisterSubmitPath")
	public String languageRegisterSubmitDispatcher(@ModelAttribute("productGroupRegisterForm")ProductGroupRegisterForm productGroupRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		
		 ProductGroupForm productGroupForm=productGroupRegisterForm.getProductGroupForm();
		 productGroupForm.setLanguageId("1");
		 productGroupRegisterForm.setProductGroupForm(productGroupForm);
		 productGroupService.prepareProductGroupRegister(productGroupRegisterForm);
		 modelMap.addAttribute("productGroupRegisterForm",productGroupRegisterForm);
		     return "productGroupRegister";
		}else{
			return "home";
		}	}
	
	@RequestMapping("/selectProductGroupPath")
	public String selectPaintGroupDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		ProductGroupRegisterForm productGroupRegisterForm=new ProductGroupRegisterForm();
		productGroupService.prepareSelectProductGroup(productGroupRegisterForm);
		modelMap.addAttribute("productGroupRegisterForm",productGroupRegisterForm);
		return "selectProductGroup";
	}
	@RequestMapping("/selectProductGroupSubmitPath")
	public String selectPaintGroupSubmitDispatcher(@ModelAttribute("productGroupRegisterForm")ProductGroupRegisterForm productGroupRegisterForm,ModelMap modelMap)
	{   
	
		ProductGroupForm productGroupForm=productGroupRegisterForm.getProductGroupForm();
		productTypeService.getProductTypeByGroup(productGroupForm.getProductGroupId());
		modelMap.addAttribute("productGroupRegisterForm",productGroupRegisterForm);
		return "selectProductGroup";
	}
	
	
}
