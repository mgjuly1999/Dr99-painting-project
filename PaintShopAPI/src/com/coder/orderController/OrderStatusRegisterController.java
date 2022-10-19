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
import com.coder.registerForm.OrderStatusRegisterForm;
import com.coder.service.ColorGroupService;
import com.coder.service.ColorService;
import com.coder.service.LanguageService;
import com.coder.service.OrderStatusService;
@Controller
@Transactional
public class OrderStatusRegisterController {
	@Autowired
	private OrderStatusService orderStatusService;
	@RequestMapping("/orderStatusRegisterPath")
	public String OrderStatusRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		OrderStatusRegisterForm orderStatusRegisterForm=new OrderStatusRegisterForm();
		orderStatusService.prepareOrderStatusRegister(orderStatusRegisterForm);
		modelMap.addAttribute("orderStatusRegisterForm",orderStatusRegisterForm);
		return "orderStatusRegister";
	}
	
	@RequestMapping("/orderStatusRegisterSubmitPath")
	public String orderStatusRegisterSubmitDispatcher(@ModelAttribute("orderStatusRegisterForm")OrderStatusRegisterForm orderStatusRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
			orderStatusService.prepareOrderStatusRegister(orderStatusRegisterForm);
		 modelMap.addAttribute("orderStatusRegisterForm",orderStatusRegisterForm);
	     return "orderStatusRegister";
		}else{
			return "home";  
		}
	
	}
	
}
