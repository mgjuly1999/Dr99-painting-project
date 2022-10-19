package com.coder.registerForm;

import com.coder.form.ResponseDirectPaymentAPIForm;
import com.coder.form.ReturnRespDirectPaymentAPIForm;

public class RespDirectPaymentAPIPrepareForm {
	
private ResponseDirectPaymentAPIForm responseDirectPaymentAPIForm;
private ReturnRespDirectPaymentAPIForm returnRespDirectPaymentAPIForm;
private String   errorMSG;

public ResponseDirectPaymentAPIForm getResponseDirectPaymentAPIForm() {
	return responseDirectPaymentAPIForm;
}

public void setResponseDirectPaymentAPIForm(ResponseDirectPaymentAPIForm responseDirectPaymentAPIForm) {
	this.responseDirectPaymentAPIForm = responseDirectPaymentAPIForm;
}

public String getErrorMSG() {
	return errorMSG;
}

public void setErrorMSG(String errorMSG) {
	this.errorMSG = errorMSG;
}

public ReturnRespDirectPaymentAPIForm getReturnRespDirectPaymentAPIForm() {
	return returnRespDirectPaymentAPIForm;
}

public void setReturnRespDirectPaymentAPIForm(ReturnRespDirectPaymentAPIForm returnRespDirectPaymentAPIForm) {
	this.returnRespDirectPaymentAPIForm = returnRespDirectPaymentAPIForm;
}
}
