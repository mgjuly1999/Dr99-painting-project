package com.coder.registerForm;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.form.OrderFormForm;
import com.coder.form.ShowOrderForm;
import com.coder.model.OrderForm;

public class OrderFormRegisterForm {
private OrderFormForm orderFormForm;
private List<ShowOrderForm> showOrderForms;
private Map<String,String> mapOrderStatuss=new HashedMap<String,String>();
private Map<String,String> mapDeliveryTypes=new HashedMap<String,String>();
private Map<String,String> mapDeliveryAddresss=new HashedMap<String,String>();
private Map<String,String> mapPaymentMethods=new HashedMap<String,String>();
public OrderFormForm getOrderFormForm() {
	return orderFormForm;
}
public void setOrderFormForm(OrderFormForm orderFormForm) {
	this.orderFormForm = orderFormForm;
}
public Map<String, String> getMapOrderStatuss() {
	return mapOrderStatuss;
}
public void setMapOrderStatuss(Map<String, String> mapOrderStatuss) {
	this.mapOrderStatuss = mapOrderStatuss;
}
public Map<String, String> getMapDeliveryTypes() {
	return mapDeliveryTypes;
}
public void setMapDeliveryTypes(Map<String, String> mapDeliveryTypes) {
	this.mapDeliveryTypes = mapDeliveryTypes;
}
public Map<String, String> getMapDeliveryAddresss() {
	return mapDeliveryAddresss;
}
public void setMapDeliveryAddresss(Map<String, String> mapDeliveryAddresss) {
	this.mapDeliveryAddresss = mapDeliveryAddresss;
}
public Map<String, String> getMapPaymentMethods() {
	return mapPaymentMethods;
}
public void setMapPaymentMethods(Map<String, String> mapPaymentMethods) {
	this.mapPaymentMethods = mapPaymentMethods;
}
public List<ShowOrderForm> getShowOrderForms() {
	return showOrderForms;
}
public void setShowOrderForms(List<ShowOrderForm> showOrderForms) {
	this.showOrderForms = showOrderForms;
}
}
