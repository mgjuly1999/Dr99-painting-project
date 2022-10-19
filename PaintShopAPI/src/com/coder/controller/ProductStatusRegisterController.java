package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductStatusRegisterForm;
import com.coder.service.LanguageService;
import com.coder.service.ProductStatusService;
@Controller
@Transactional
public class ProductStatusRegisterController {
	@Autowired
	private ProductStatusService productStatusService;
	@RequestMapping("/productStatusRegisterPath")
	public String productStatusRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		ProductStatusRegisterForm productStatusRegisterForm=new ProductStatusRegisterForm();
		modelMap.addAttribute("productStatusRegisterForm",productStatusRegisterForm);
		productStatusService.prepareProductStatusRegister(productStatusRegisterForm);
		return "productStatusRegister";
	}
	
	@RequestMapping("/productStatusRegisterSubmitPath")
	public String productStatusRegisterSubmitDispatcher(@ModelAttribute("productStatusRegisterForm")ProductStatusRegisterForm productStatusRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
			productStatusService.prepareProductStatusRegister(productStatusRegisterForm);
		 modelMap.addAttribute("productStatusRegisterForm",productStatusRegisterForm);
	     return "productStatusRegister";
		}else{
			return "home";
		}
	
	}
	
}
