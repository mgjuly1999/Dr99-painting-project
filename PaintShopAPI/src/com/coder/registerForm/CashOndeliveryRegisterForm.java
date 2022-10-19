package com.coder.registerForm;

import com.coder.apiForm.CashOnDeliverForm;
import com.coder.form.PaymentRespForm;

public class CashOndeliveryRegisterForm {
private CashOnDeliverForm cashOnDeliverForm;
private PaymentRespForm paymentRespForm;

public CashOnDeliverForm getCashOnDeliverForm() {
	return cashOnDeliverForm;
}

public void setCashOnDeliverForm(CashOnDeliverForm cashOnDeliverForm) {
	this.cashOnDeliverForm = cashOnDeliverForm;
}

public PaymentRespForm getPaymentRespForm() {
	return paymentRespForm;
}

public void setPaymentRespForm(PaymentRespForm paymentRespForm) {
	this.paymentRespForm = paymentRespForm;
}
}
