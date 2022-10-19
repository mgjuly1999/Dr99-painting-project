package com.coder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.registerForm.ShowAllProductForm;
import com.coder.registerForm.ShowAllTypeForm;
import com.coder.service.ProductGroupService;
import com.coder.service.ProductService;
import com.coder.service.ProductTypeService;
import com.coder.service.ShowProductService;


@Controller
@Transactional
public class ShowAllProductController {
	@Autowired
	 private ShowProductService showProductService;
	@Autowired
	private ProductGroupService productGroupService;
	@Autowired
	private ProductTypeService productTypeService;
	 @RequestMapping("/showAllGroupForProductDetailPath")
	   	public String showAllGroupForProductDetailDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	   	{   
	   		
	   		ProductGroupRegisterForm productGroupRegisterForm=new ProductGroupRegisterForm();
	   		productGroupService.showAllProductGroup(productGroupRegisterForm);
	   		modelMap.addAttribute("productGroupRegisterForm",productGroupRegisterForm);
	   		return "showAllGroupForProductDetails";
	   	}
	 @RequestMapping("/showAllTypeByGroupIdForProductDetails")
		public String showAllTypeByGroupIdForProductDetailsDispatcher(@ModelAttribute("groupId")String groupId,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{   
	    	ShowAllTypeForm  showAllTypeForm=new ShowAllTypeForm();
	    	showAllTypeForm.setGroupId(groupId);
	    	productTypeService.prepareShowAllTypeByGroupId(showAllTypeForm);
	    	 modelMap.addAttribute("showAllTypeForm",showAllTypeForm);
			
			return "showAllTypForProductDetails";
		}

	  @RequestMapping("/showAllProductForProductDetails")
		public String showAllProductForProductDetailsDispatcher(@ModelAttribute("typeId")String typeId,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{   
			
		  ShowAllProductForm  showAllProductForm=new ShowAllProductForm();
		  showAllProductForm.setProductTypeId(typeId);
	    showProductService.prepareShowAllProductBytypeId(showAllProductForm);
	    	 modelMap.addAttribute("showAllProductForm",showAllProductForm);
			
			return "ShowAllProductForProductDetails";
		}
	  @RequestMapping("/showAllProductForOrderForm")
		public String showAllProductForOrderFromDispatcher(@ModelAttribute("frmOrderFormId")String frmOrderformId,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
		{   
		  String frmOrderFormId=req.getParameter("frmOrderFormId");
		  System.out.println("frmOrderFormId="+frmOrderFormId);
		  ShowAllProductForm  showAllProductForm=new ShowAllProductForm();
		  showAllProductForm.setOrderFormId(frmOrderformId);
	      showProductService.prepareShowAllProductByOrderFormId(showAllProductForm);
	    	 modelMap.addAttribute("showAllProductForm",showAllProductForm);
			
			return "ShowAllProductForProductDetails";
		}
}
