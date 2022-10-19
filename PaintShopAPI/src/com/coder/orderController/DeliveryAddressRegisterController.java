package com.coder.orderController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.DeliveryAddressForm;
import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.DeliveryAddressRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.service.ColorGroupService;
import com.coder.service.ColorService;
import com.coder.service.DeliveyAddressService;
import com.coder.service.LanguageService;
@Controller
@Transactional
public class DeliveryAddressRegisterController {
	@Autowired
	private DeliveyAddressService deliveyAddressService;
	@RequestMapping("/deliveryAddressRegisterPath")
	public String deliveryAddressRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		DeliveryAddressRegisterForm deliveryAddressRegisterForm=new DeliveryAddressRegisterForm();
		deliveyAddressService.prepareDeliveryAddressRegister(deliveryAddressRegisterForm);
		modelMap.addAttribute("deliveryAddressRegisterForm",deliveryAddressRegisterForm);
		return "deliveryAddressRegister";
	}
	
	@RequestMapping("/deliveryAddressRegisterSubmitPath")
	public String deliveryAddressRegisterSubmitDispatcher(@ModelAttribute("deliveryAddressRegisterForm")DeliveryAddressRegisterForm deliveryAddressRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		 deliveyAddressService.prepareDeliveryAddressRegister(deliveryAddressRegisterForm);
		 modelMap.addAttribute("deliveryAddressRegisterForm",deliveryAddressRegisterForm);
	     return "deliveryAddressRegister";
		}else{
			return "home";  
		}
	
	}
	
}
