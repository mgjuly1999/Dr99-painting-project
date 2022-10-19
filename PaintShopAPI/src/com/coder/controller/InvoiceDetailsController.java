package com.coder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.registerForm.InvoiceDetailsForm;
import com.coder.service.OrderFormService;

@Controller
@Transactional
public class InvoiceDetailsController {
	@Autowired
	private OrderFormService  orderFormService;
	
	@RequestMapping("/orderFormDetails")
	public String orderFormDetailsDispatcher(ModelMap modelMap, HttpServletRequest req, HttpServletResponse resp) {
	
		String orderFormId=req.getParameter("orderFormId");
		InvoiceDetailsForm  invoiceDetailsForm=new InvoiceDetailsForm();
		invoiceDetailsForm.setOrderFormId(orderFormId);
		orderFormService.preparenInvoiceDetails(invoiceDetailsForm);
		modelMap.addAttribute("invoiceDetailsForm",invoiceDetailsForm);
		
		return "invoicePrint";
	}
}
