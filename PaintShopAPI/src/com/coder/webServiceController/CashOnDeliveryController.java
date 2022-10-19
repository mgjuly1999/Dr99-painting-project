package com.coder.webServiceController;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.apiForm.CashOnDeliverForm;
import com.coder.apiForm.CheckOutAPIForm;
import com.coder.form.MakePaymentForm;
import com.coder.form.PaymentRespForm;
import com.coder.form.ReturnRespDirectPaymentAPIForm;
import com.coder.registerForm.CashOndeliveryRegisterForm;
import com.coder.registerForm.MakePaymentRegisterForm;
import com.coder.service.MakePaymentService;
import com.coder.service.VerifyPhoneNumberService;
import com.coder.util.RestURIConstants;
import com.coder.service.CashOnDeliveryService;
import com.coder.service.CheckOutService;
import com.coder.service.MakeCheckOutService;

@RestController
@RequestMapping("/niponpain")
public class CashOnDeliveryController {
	
	
	@Autowired
	private CashOnDeliveryService cashOnDeliveryService;
	
	@PostMapping(
	        value = RestURIConstants.Cash_On_Delivery,
	        		  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
	       	        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public PaymentRespForm  makePaymentFormDispatcher(@RequestBody CashOnDeliverForm cashOnDeliverForm) throws JSONException {
	
		System.out.println(cashOnDeliverForm);
		
		CashOndeliveryRegisterForm cashOndeliveryRegisterForm=new CashOndeliveryRegisterForm();
		cashOndeliveryRegisterForm.setCashOnDeliverForm(cashOnDeliverForm);
		this.cashOnDeliveryService.prepareCashDelivery(cashOndeliveryRegisterForm);
		
		return cashOndeliveryRegisterForm.getPaymentRespForm();
	}
}
