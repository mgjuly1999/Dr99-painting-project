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
import com.coder.registerForm.DeliveryTypeRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.service.ColorGroupService;
import com.coder.service.ColorService;
import com.coder.service.DeliveryTypeService;
import com.coder.service.DeliveyAddressService;
import com.coder.service.LanguageService;
@Controller
@Transactional
public class DeliveryTypeRegisterController {
	@Autowired
	private DeliveryTypeService deliveryTypeService;
	@RequestMapping("/deliveryTypeRegisterPath")
	public String deliveryAddressRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		DeliveryTypeRegisterForm deliveryTypeRegisterForm=new DeliveryTypeRegisterForm();
		deliveryTypeService.prepareDeliveryTypeRegister(deliveryTypeRegisterForm);
		modelMap.addAttribute("deliveryTypeRegisterForm",deliveryTypeRegisterForm);
		return "deliveryTypeRegister";
	}
	
	@RequestMapping("/deliveryTypeRegisterSubmitPath")
	public String deliveryTypeRegisterSubmitDispatcher(@ModelAttribute("deliveryTypeRegisterForm")DeliveryTypeRegisterForm deliveryTypeRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
			deliveryTypeService.prepareDeliveryTypeRegister(deliveryTypeRegisterForm);
		 modelMap.addAttribute("deliveryTypeRegisterForm",deliveryTypeRegisterForm);
	     return "deliveryTypeRegister";
		}else{
			return "home";  
		}
	
	}
	
}
