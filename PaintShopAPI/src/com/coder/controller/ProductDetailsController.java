package com.coder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.ProductMediaForm;
import com.coder.registerForm.ProductDetailsForm;
import com.coder.service.ProductService;
import com.coder.service.ShowProductService;

@Controller
@Transactional
public class ProductDetailsController {
	@Autowired
	private ShowProductService showProductServic;
	
	 @RequestMapping("/productDetilsPath")
		public String productDetilsPathDispatcher(@ModelAttribute("productId")String productId , ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{
		 ProductDetailsForm  productDetailsForm=new ProductDetailsForm();
		 productDetailsForm.setProductId(productId);
		 this.showProductServic.prepareProductDetails(productDetailsForm);
		 modelMap.addAttribute("productDetailsForm",productDetailsForm);
		 return "ProductDetails";
		}
}
