package com.coder.registerForm;

import java.util.List;

import com.coder.form.DeliveryAddressForm;
import com.coder.model.DeliveryAddress;

public class DeliveryAddressRegisterForm {
private DeliveryAddressForm deliveryAddressForm;
private List<DeliveryAddress> deliveryAddresss;
public DeliveryAddressForm getDeliveryAddressForm() {
	return deliveryAddressForm;
}
public void setDeliveryAddressForm(DeliveryAddressForm deliveryAddressForm) {
	this.deliveryAddressForm = deliveryAddressForm;
}
public List<DeliveryAddress> getDeliveryAddresss() {
	return deliveryAddresss;
}
public void setDeliveryAddresss(List<DeliveryAddress> deliveryAddresss) {
	this.deliveryAddresss = deliveryAddresss;
}
}
