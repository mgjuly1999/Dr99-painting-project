package com.coder.registerForm;

import java.util.List;

import com.coder.form.PaymentMethodForm;
import com.coder.model.PaymentMethod;

public class PaymentMethodRegisterForm {
private PaymentMethodForm paymentMethodForm;
private List<PaymentMethod> paymentMethods;
public PaymentMethodForm getPaymentMethodForm() {
	return paymentMethodForm;
}
public void setPaymentMethodForm(PaymentMethodForm paymentMethodForm) {
	this.paymentMethodForm = paymentMethodForm;
}
public List<PaymentMethod> getPaymentMethods() {
	return paymentMethods;
}
public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
	this.paymentMethods = paymentMethods;
}
}
