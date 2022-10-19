package com.coder.webServiceController;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coder.form.ResponseDirectPaymentAPIForm;
import com.coder.form.ReturnRespDirectPaymentAPIForm;
import com.coder.form.VerifyPhoneNumberRespForm;
import com.coder.registerForm.RespDirectPaymentAPIPrepareForm;
import com.coder.service.VerifyPhoneNumberService;
import com.coder.util.RestURIConstants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/niponpain")
public class CallBackUrlEvolveMyanmarController {
	@Autowired
	private VerifyPhoneNumberService verifyPhoneNumberService;
	
	@PostMapping(
	        value = RestURIConstants.Call_Back_Url,
	        		  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
	       	        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ReturnRespDirectPaymentAPIForm  RespDirectPaymentDispatcher
	
	(@RequestBody Object object) throws JSONException {
	
		System.out.println("Calling Call Back Url!!!!!");
		ResponseDirectPaymentAPIForm responseDirectPaymentAPIForm=null;
		System.out.println(object);
		 Gson g = new Gson();
		 try {
			
			 responseDirectPaymentAPIForm= g.fromJson(object.toString(), ResponseDirectPaymentAPIForm.class);
				
		    } catch (Exception e) {
		     
		    	String jsonString=object.toString();
		    	System.out.println(jsonString);
		    	String replaceString=jsonString.replace("transactionID=","transactionID=null");
		    	responseDirectPaymentAPIForm= g.fromJson(replaceString, ResponseDirectPaymentAPIForm.class);
		    	
		    }
		
		
		RespDirectPaymentAPIPrepareForm respDirectPaymentAPIPrepareForm=new RespDirectPaymentAPIPrepareForm();
		respDirectPaymentAPIPrepareForm.setResponseDirectPaymentAPIForm(responseDirectPaymentAPIForm);
		
		this.verifyPhoneNumberService.prepareResponseDirectPaymentAPI(respDirectPaymentAPIPrepareForm);
		
		System.out.println(respDirectPaymentAPIPrepareForm.getErrorMSG());
		
		ReturnRespDirectPaymentAPIForm returnRespDirectPaymentAPIForm=respDirectPaymentAPIPrepareForm.getReturnRespDirectPaymentAPIForm();
		
		return	returnRespDirectPaymentAPIForm;

	    
	}
	
	
}
