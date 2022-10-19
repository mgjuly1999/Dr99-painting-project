package com.coder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.ProductColorForm;
import com.coder.form.ProductForm;
import com.coder.form.LiterageForm;
import com.coder.form.ProductMediaForm;
import com.coder.form.ProductNextForm;
import com.coder.registerForm.ProductColorRegisterForm;
import com.coder.registerForm.ProductLiterageRegisterForm;
import com.coder.registerForm.ProductMediaRegisterForm;
import com.coder.registerForm.ProductRegisterForm;
import com.coder.registerForm.ProductRegisterNextForm;
import com.coder.service.ProductService;

@Controller
@Transactional
public class productRegisterNextController {
	
	@Autowired
	private ProductService productService;
	
	
	
	 @RequestMapping("/SelectProductFeatureForProductRegisterSubmit")
	public String selectFeatureForProductRegisterSubmitDispatcher(@ModelAttribute("productNextForm")ProductNextForm productNextForm, ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
	   
		 ProductRegisterNextForm productRegisterNextForm=new ProductRegisterNextForm();
		 productNextForm.setTools(null);
		 productNextForm.setGuides(null);
		 productRegisterNextForm.setProductNextForm(productNextForm);
		 productRegisterNextForm.setProductId(productNextForm.getProductId());
		 productService.prepareProductRegisterNext(productRegisterNextForm);
		 modelMap.addAttribute("productRegisterNextForm",productRegisterNextForm);
		 modelMap.addAttribute("productNextForm",new ProductNextForm());
		 
			return "SelectToolsForProductRegister";
	}
	 
	 @RequestMapping("/SelectToolsForProductRegisterSubmit")
		public String selectToolsForProductRegisterSubmitDispatcher(@ModelAttribute("productNextForm")ProductNextForm productNextForm, ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{   
		   
			 ProductRegisterNextForm productRegisterNextForm=new ProductRegisterNextForm();
			 productNextForm.setGuides(null);
			 productNextForm.setFeatures(null);
			 productRegisterNextForm.setProductNextForm(productNextForm);
			 productRegisterNextForm.setProductId(productNextForm.getProductId());
			 productService.prepareProductRegisterNext(productRegisterNextForm);
			 modelMap.addAttribute("productRegisterNextForm",productRegisterNextForm);
			 modelMap.addAttribute("productNextForm",new ProductNextForm());
			 
				return "SelectGuideForProductRegister";
		}
	 
	 @RequestMapping("/selectGuideForProductRegisterSubmit")
		public String SelectGuideForProductRegisterSubmitDispatcher(@ModelAttribute("productNextForm")ProductNextForm productNextForm, ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{   
		   
			 ProductRegisterNextForm productRegisterNextForm=new ProductRegisterNextForm();
			 productNextForm.setFeatures(null);
			 productNextForm.setTools(null);
			 productRegisterNextForm.setProductNextForm(productNextForm);
			 productRegisterNextForm.setProductId(productNextForm.getProductId());
			 productService.prepareProductRegisterNext(productRegisterNextForm);
			
			 ProductLiterageRegisterForm productLiterageRegisterForm=new ProductLiterageRegisterForm();
			 productLiterageRegisterForm.setProduct(productRegisterNextForm.getProduct());
			 productService.prepareProductLiterageRegister(productLiterageRegisterForm);
			 modelMap.addAttribute("productLiterageRegisterForm",productLiterageRegisterForm);
			 modelMap.addAttribute("productLiterageForm",new LiterageForm());
			 
				return "ProductLiterageRegister";
		}
	 
	 @RequestMapping("/productLiterageRegisterSubmit")
		public String productLiterageRegisterSubmitDispatcher(@ModelAttribute("productLiterageForm")LiterageForm productLiterageForm, ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{
		 ProductLiterageRegisterForm productLiterageRegisterForm=new ProductLiterageRegisterForm();
		 productLiterageRegisterForm.setProductLiterageForm(productLiterageForm);
		 productService.prepareProductLiterageRegister(productLiterageRegisterForm);
		 modelMap.addAttribute("productLiterageRegisterForm",productLiterageRegisterForm);
		 modelMap.addAttribute("productLiterageForm",new LiterageForm());
		 
			return "ProductLiterageRegister";
		}
	 @RequestMapping("/productLiterageRegisterFinishSubmit")
		public String productLiterageRegisterFinishSubmit(@ModelAttribute("productLiterageForm")LiterageForm productLiterageForm, ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{
		 
		 ProductColorRegisterForm productColorRegisterForm=new ProductColorRegisterForm();
		 productColorRegisterForm.setProductId(productLiterageForm.getProductId());
		 productService.prepareProductLiterageRegisterFinish(productColorRegisterForm);
		 modelMap.addAttribute("productColorRegisterForm",productColorRegisterForm);
		 modelMap.addAttribute("productColorForm",new ProductColorForm());
		 
		 return "ProductColorRegister";
		
		}
	 @RequestMapping("/productColorRegisterSubmit")
		public String productColorRegisterSubmit(@ModelAttribute("productColorForm")ProductColorForm productColorForm, ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{
		 
		 ProductColorRegisterForm productColorRegisterForm=new ProductColorRegisterForm();
		 productColorRegisterForm.setProductColorForm(productColorForm);
		 productService.prepareProductLiterageRegisterFinish(productColorRegisterForm);
		
		 
		 ProductMediaRegisterForm  productMediaRegisterForm=new ProductMediaRegisterForm();
	 		productMediaRegisterForm.setProduct(productColorRegisterForm.getProduct());
	 		productService.prepareProductMediaRegister(productMediaRegisterForm);
	 		 modelMap.addAttribute("productMediaRegisterForm",productMediaRegisterForm);
			 modelMap.addAttribute("productMediaForm",new ProductMediaForm());
		 
		 return "ProductMediaRegister";
	 
		}
	 
	 	@RequestMapping("/productMediaRegisterSubmit")
		public String prepareProductMediaRegisterDispatcher(@ModelAttribute("productMediaForm")ProductMediaForm productMediaForm, ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{
		 
	 		ProductMediaRegisterForm  productMediaRegisterForm=new ProductMediaRegisterForm();
	 		productMediaRegisterForm.setProductMediaForm(productMediaForm);
	 		productService.prepareProductMediaRegister(productMediaRegisterForm);
	 		 modelMap.addAttribute("productMediaRegisterForm",productMediaRegisterForm);
			 modelMap.addAttribute("productMediaForm",new ProductMediaForm());
			 
			 return "ProductMediaRegister";
		 
		}
	 
		}


		

