package com.coder.registerForm;

import java.util.List;

import com.coder.form.DeliveryTypeForm;
import com.coder.model.DeliveryType;

public class DeliveryTypeRegisterForm {
private DeliveryTypeForm deliveryTypeForm;
private List<DeliveryType> deliveryTypes;
public DeliveryTypeForm getDeliveryTypeForm() {
	return deliveryTypeForm;
}
public void setDeliveryTypeForm(DeliveryTypeForm deliveryTypeForm) {
	this.deliveryTypeForm = deliveryTypeForm;
}
public List<DeliveryType> getDeliveryTypes() {
	return deliveryTypes;
}
public void setDeliveryTypes(List<DeliveryType> deliveryTypes) {
	this.deliveryTypes = deliveryTypes;
}
}
