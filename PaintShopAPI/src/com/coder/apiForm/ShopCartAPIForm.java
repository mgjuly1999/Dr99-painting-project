package com.coder.apiForm;

import java.util.ArrayList;
import java.util.List;

public class ShopCartAPIForm {
private String invoiceId;
private String totalPrice;
private String createDate;
private List<CartItem> cartItems=new ArrayList<CartItem>();


public List<CartItem> getCartItems() {
	return cartItems;
}

public void setCartItems(List<CartItem> cartItems) {
	this.cartItems = cartItems;
}

public String getInvoiceId() {
	return invoiceId;
}

public void setInvoiceId(String invoiceId) {
	this.invoiceId = invoiceId;
}

public String getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(String totalPrice) {
	this.totalPrice = totalPrice;
}

public String getCreateDate() {
	return createDate;
}

public void setCreateDate(String createDate) {
	this.createDate = createDate;
}


}
