package com.coder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.dao.ProductMediaDao;
import com.coder.form.ProductForm;
import com.coder.form.ProductNextForm;
import com.coder.model.ProductMedia;
import com.coder.registerForm.ProductRegisterForm;
import com.coder.registerForm.ProductRegisterNextForm;
import com.coder.service.ProductService;


@Controller
@Transactional
public class ProductRegisterController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductMediaDao productMediaDao;
	
	 @RequestMapping("/productRegisterPath")
		public String productRegisterPathDispatcher(@ModelAttribute("groupId")String groupId, ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{   
		   
			ProductRegisterForm productRegisterForm=new ProductRegisterForm();
			productRegisterForm.setGroupId(groupId);
			productService.prepareProductRegister(productRegisterForm);
			modelMap.addAttribute("productForm",new ProductForm());
			modelMap.addAttribute("productRegisterForm",productRegisterForm);
			
			return "ProductRegister";
		}
	 
	 @RequestMapping("/productRegisterSubmit")
		public String productRegisterPathDispatcher(@ModelAttribute("productForm")ProductForm productForm, ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{   
		   
			ProductRegisterForm productRegisterForm=new ProductRegisterForm();
			productRegisterForm.setProductForm(productForm);
			productRegisterForm.setGroupId(productForm.getGroupId());
			
			productService.prepareProductRegister(productRegisterForm);
			
			
			 ProductRegisterNextForm productRegisterNextForm=new ProductRegisterNextForm();
			 
			 productRegisterNextForm.setProductId(productRegisterForm.getProduct().getProductId()+"");
			 productRegisterNextForm.setProductNextForm(new ProductNextForm());
			 productService.prepareProductRegisterNext(productRegisterNextForm);
			 modelMap.addAttribute("productRegisterNextForm",productRegisterNextForm);
			 modelMap.addAttribute("productNextForm",new ProductNextForm());
			 
			
				return "SelectProductFeatureForProductRegister";
		}
	
	
}
