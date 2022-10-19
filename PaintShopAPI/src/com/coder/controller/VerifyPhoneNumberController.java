package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coder.form.DirectPaymentAPIRespForm;
import com.coder.form.VerifyPhoneNumberForm;
import com.coder.form.VerifyPhoneNumberRespForm;
import com.coder.registerForm.DirectPaymentAPIPrepareForm;
import com.coder.registerForm.VerifyPhoneNumberRegisterForm;
import com.coder.service.VerifyPhoneNumberService;

@Controller
@Transactional
public class VerifyPhoneNumberController {
	@Autowired
	private VerifyPhoneNumberService verifyPhoneNumberService;

	@RequestMapping("/verifyPhoneNumberPath")
	public String verifyPhoneNumberDispatcher(ModelMap modelMap, HttpServletRequest req, HttpServletResponse resp) {

		modelMap.addAttribute("verifyPhoneNumberForm", new VerifyPhoneNumberForm());
		modelMap.addAttribute("message","");
		return "PaymentMethod";
	}

	@RequestMapping("/verifyPhoneNumberSubmit")
	public String verifyPhoneNumberSubmitDispatcher(
	@ModelAttribute("verifyPhoneNumberForm")VerifyPhoneNumberForm verifyPhoneNumberForm
	,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		VerifyPhoneNumberRegisterForm  verifyPhoneNumberRegisterForm=new VerifyPhoneNumberRegisterForm();
		verifyPhoneNumberForm.setChannel("EVOLVE MYANMAR");
		verifyPhoneNumberForm.setMerchantUserId("MM202144071244435371349");
		verifyPhoneNumberRegisterForm.setVerifyPhoneNumberForm(verifyPhoneNumberForm);
		
		verifyPhoneNumberService.prepareVerifyPhoneNumber(verifyPhoneNumberRegisterForm);

		VerifyPhoneNumberRespForm verifyPhoneNumberRespForm=verifyPhoneNumberRegisterForm.getVerifyPhoneNumberRespForm();
		
		if(verifyPhoneNumberRespForm.getRespCode().equals("000")&&
			verifyPhoneNumberRespForm.getRespDescription().equals("Success.")){
		
		DirectPaymentAPIPrepareForm directPaymentAPIPrepareForm=new DirectPaymentAPIPrepareForm();
		
		directPaymentAPIPrepareForm.setOnePayPaymentMethod(verifyPhoneNumberRegisterForm.getOnePayPaymentMethod());
		directPaymentAPIPrepareForm.setVerifyPhoneNumberRespForm(verifyPhoneNumberRegisterForm.getVerifyPhoneNumberRespForm());
		directPaymentAPIPrepareForm.setVerifyPhoneNumberForm(verifyPhoneNumberRegisterForm.getVerifyPhoneNumberForm());
		
		verifyPhoneNumberService.prepareDirectPaymantAPI(directPaymentAPIPrepareForm);
		
		String errorMsg="Your Phone Number Success!!!!!";
		DirectPaymentAPIRespForm directPaymentAPIRespForm=directPaymentAPIPrepareForm.getDirectPaymentAPIRespForm();
		
		if(directPaymentAPIRespForm.getRespCode().equals("000")&&
		directPaymentAPIRespForm.getRespDescription().equals("Success"))
		{
			modelMap.addAttribute("message",errorMsg);
		
		}else
		{
			errorMsg+="Your Payment is not Success!!!!!";
			modelMap.addAttribute("message",errorMsg);
		}
		
		
		modelMap.addAttribute("verifyPhoneNumberForm",new VerifyPhoneNumberForm());
			return "PaymentMethod";
			
		}else
		{
			modelMap.addAttribute("message","Your Phone Number Error!!!!!");
		modelMap.addAttribute("verifyPhoneNumberForm",new VerifyPhoneNumberForm());
			return "PaymentMethod";
		}
		
	   
	}

}
