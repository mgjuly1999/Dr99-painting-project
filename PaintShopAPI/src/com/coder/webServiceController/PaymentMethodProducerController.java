package com.coder.webServiceController;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.form.MakePaymentForm;
import com.coder.form.PaymentRespForm;
import com.coder.form.ReturnRespDirectPaymentAPIForm;
import com.coder.registerForm.MakePaymentRegisterForm;
import com.coder.service.MakePaymentService;
import com.coder.service.VerifyPhoneNumberService;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class PaymentMethodProducerController {
	@Autowired
	private MakePaymentService makePaymentService;
	
	@PostMapping(
	        value = RestURIConstants.Make_Payment,
	        		  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
	       	        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public PaymentRespForm  makePaymentFormDispatcher(@RequestBody MakePaymentForm makePaymentForm) throws JSONException {
		MakePaymentRegisterForm makePaymentRegisterForm=new MakePaymentRegisterForm();
		makePaymentRegisterForm.setMakePaymentForm(makePaymentForm);
		this.makePaymentService.prepareMakePayment(makePaymentRegisterForm);
		
		return makePaymentRegisterForm.getPaymentRespForm();
	}
}
