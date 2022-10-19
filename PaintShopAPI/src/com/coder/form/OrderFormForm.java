package com.coder.form;

import java.util.Date;

import com.coder.model.DeliveryAddress;
import com.coder.model.DeliveryType;
import com.coder.model.OrderStatus;
import com.coder.model.PaymentMethod;

public class OrderFormForm {
	
	private String deliveryAddressId;
	private String deliveryTypeId;
	private String statusId;
	private String paymentMethodId;
	private String phone;
	private String addressDetails;
	private String totalDicountRate;
	private String totalPrice;
	private String note;
	public String getDeliveryAddressId() {
		return deliveryAddressId;
	}
	public void setDeliveryAddressId(String deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}
	public String getDeliveryTypeId() {
		return deliveryTypeId;
	}
	public void setDeliveryTypeId(String deliveryTypeId) {
		this.deliveryTypeId = deliveryTypeId;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}
	public String getTotalDicountRate() {
		return totalDicountRate;
	}
	public void setTotalDicountRate(String totalDicountRate) {
		this.totalDicountRate = totalDicountRate;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
