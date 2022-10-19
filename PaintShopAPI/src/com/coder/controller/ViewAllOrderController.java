package com.coder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.ViewAllOrderForm;
import com.coder.service.OrderFormService;

@Controller
@Transactional
public class ViewAllOrderController {
	@Autowired
	private OrderFormService  orderFormService;
	
	@RequestMapping("/viewAllOrderPath")
	public String viewAllOrderPathDispatcher(ModelMap modelMap, HttpServletRequest req, HttpServletResponse resp) {
		ViewAllOrderForm   viewAllOrderForm=new ViewAllOrderForm();
		
		this.orderFormService.prepareViewAllOrder(viewAllOrderForm);
		modelMap.addAttribute("viewAllOrderForm",viewAllOrderForm);
		return "ViewAllProductOrder";
	}
}
