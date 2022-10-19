package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.QtyUnitRegisterForm;
import com.coder.service.LanguageService;
import com.coder.service.QtyUnitService;
@Controller
@Transactional
public class QtyUnitRegisterController {
	@Autowired
	private QtyUnitService qtyUnitService;
	@RequestMapping("/qtyUnitRegisterPath")
	public String qtyUnitRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		QtyUnitRegisterForm qtyUnitRegisterForm=new QtyUnitRegisterForm();
		modelMap.addAttribute("qtyUnitRegisterForm",qtyUnitRegisterForm);
		qtyUnitService.prepareQtyUnitRegister(qtyUnitRegisterForm);
		return "qtyUnitRegister";
	}
	
	@RequestMapping("/qtyUnitRegisterSubmitPath")
	public String qtyUnitRegisterSubmitDispatcher(@ModelAttribute("qtyUnitRegisterForm")QtyUnitRegisterForm qtyUnitRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
			qtyUnitService.prepareQtyUnitRegister(qtyUnitRegisterForm);
		 modelMap.addAttribute("qtyUnitRegisterForm",qtyUnitRegisterForm);
	     return "qtyUnitRegister";
		}else{
			return "home";
		}
	
	}
	
}
