package com.coder.webServiceController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class ConfrimationPageController {
	
    @RequestMapping(value =RestURIConstants.ConfrimationPage, method = RequestMethod.GET)
	public String  ConfrimationPageDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
    	return "Comfirmation";
	}
}
