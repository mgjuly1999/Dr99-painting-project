package com.coder.orderController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.OrderFormRegisterForm;
import com.coder.registerForm.OrderStatusRegisterForm;
import com.coder.service.ColorGroupService;
import com.coder.service.ColorService;
import com.coder.service.LanguageService;
import com.coder.service.OrderFormService;
import com.coder.service.OrderStatusService;
@Controller
@Transactional
public class OrderFormRegisterController {
	@Autowired
	private OrderFormService orderFormService;
	@RequestMapping("/orderFormRegisterPath")
	public String OrderStatusRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		OrderFormRegisterForm orderFormRegisterForm=new OrderFormRegisterForm();
		orderFormService.prepareOrderFormRegister(orderFormRegisterForm);
		modelMap.addAttribute("orderFormRegisterForm",orderFormRegisterForm);
		return "orderFormRegister";
	}
	
	@RequestMapping("/orderFormRegisterSubmitPath")
	public String orderStatusRegisterSubmitDispatcher(@ModelAttribute("orderFormRegisterForm")OrderFormRegisterForm orderFormRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
			orderFormService.prepareOrderFormRegister(orderFormRegisterForm);
		 modelMap.addAttribute("orderFormRegisterForm",orderFormRegisterForm);
	     return "orderFormRegister";
		}else{
			return "home";  
		}
	
	}
	
}
