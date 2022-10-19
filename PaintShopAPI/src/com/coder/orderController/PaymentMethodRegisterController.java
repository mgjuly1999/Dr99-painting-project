package com.coder.orderController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.PaymentMethodForm;
import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.PaymentMethodRegisterForm;
import com.coder.service.ColorGroupService;
import com.coder.service.ColorService;
import com.coder.service.LanguageService;
import com.coder.service.PaymentMethodService;
@Controller
@Transactional
public class PaymentMethodRegisterController {
	@Autowired
	private PaymentMethodService paymentMethodService;
	@RequestMapping("/paymentMethodRegisterPath")
	public String paymentMethodRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
	    PaymentMethodRegisterForm paymentMethodRegisterForm=new PaymentMethodRegisterForm();
	    paymentMethodService.preparePaymentMethodRegister(paymentMethodRegisterForm);
		modelMap.addAttribute("paymentMethodRegisterForm",paymentMethodRegisterForm);
		return "paymentMethodRegister";
	}
	
	@RequestMapping("/paymentMethodRegisterSubmitPath")
	public String colorRegisterSubmitDispatcher(@ModelAttribute("paymentMethodRegisterForm")PaymentMethodRegisterForm paymentMethodRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		paymentMethodService.preparePaymentMethodRegister(paymentMethodRegisterForm);
		 modelMap.addAttribute("colorRegisterForm",paymentMethodRegisterForm);
	     return "paymentMethodRegister";
		}else{
			return "home";  
		}
	
	}
	
}
