package com.coder.apiForm;

import java.util.ArrayList;
import java.util.List;

public class CartErrorForm {
	
private String respCode;
private String respDesc;
private List<CartItem> cartItems=new ArrayList<CartItem>();

public String getRespCode() {
	return respCode;
}
public void setRespCode(String respCode) {
	this.respCode = respCode;
}

public List<CartItem> getCartItems() {
	return cartItems;
}
public void setCartItems(List<CartItem> cartItems) {
	this.cartItems = cartItems;
}
public String getRespDesc() {
	return respDesc;
}
public void setRespDesc(String respDesc) {
	this.respDesc = respDesc;
}
}
