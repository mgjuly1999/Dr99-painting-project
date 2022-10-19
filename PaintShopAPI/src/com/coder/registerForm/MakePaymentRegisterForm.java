package com.coder.registerForm;

import com.coder.apiForm.CheckOutAPIForm;
import com.coder.form.MakePaymentForm;
import com.coder.form.PaymentRespForm;

public class MakePaymentRegisterForm {
	
private MakePaymentForm  makePaymentForm;
private PaymentRespForm paymentRespForm;
private CheckOutAPIForm checkOutAPIForm;

public MakePaymentForm getMakePaymentForm() {
	return makePaymentForm;
}

public void setMakePaymentForm(MakePaymentForm makePaymentForm) {
	this.makePaymentForm = makePaymentForm;
}

public PaymentRespForm getPaymentRespForm() {
	return paymentRespForm;
}

public void setPaymentRespForm(PaymentRespForm paymentRespForm) {
	this.paymentRespForm = paymentRespForm;
}

public CheckOutAPIForm getCheckOutAPIForm() {
	return checkOutAPIForm;
}

public void setCheckOutAPIForm(CheckOutAPIForm checkOutAPIForm) {
	this.checkOutAPIForm = checkOutAPIForm;
}

}
