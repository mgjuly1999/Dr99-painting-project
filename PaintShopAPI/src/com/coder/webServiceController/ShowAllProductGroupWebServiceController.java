package com.coder.webServiceController;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.GroupLanguageForm;
import com.coder.model.GroupLanguage;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.service.ProductGroupService;
import com.coder.util.RestURIConstants;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/niponpain")
public class ShowAllProductGroupWebServiceController {
	@Autowired
	private ProductGroupService productGroupService;
	
	 
	
	 @RequestMapping(value =RestURIConstants.GET_ALL_GROUP, method = RequestMethod.GET)
	public @ResponseBody List<GroupLanguageForm> getAllProductGroup(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) {
	
		ProductGroupRegisterForm productGroupRegisterForm=new ProductGroupRegisterForm();
		productGroupService.showAllProductGroup(productGroupRegisterForm);
		
		List<GroupLanguageForm> GroupLanguages =productGroupRegisterForm.getGroupLanguageForms();
		
		return GroupLanguages;
	}
	
	
	
}
