package com.coder.apiForm;

public class OrderItem {
	
private String productId;
private String litreageId;
private String colorId;
private String productName;
private String color;
private String qty;
private String litreage;
private String unitPrice;
private String subTotal;

public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getQty() {
	return qty;
}
public void setQty(String qty) {
	this.qty = qty;
}
public String getLitreage() {
	return litreage;
}
public void setLitreage(String litreage) {
	this.litreage = litreage;
}
public String getUnitPrice() {
	return unitPrice;
}
public void setUnitPrice(String unitPrice) {
	this.unitPrice = unitPrice;
}
public String getSubTotal() {
	return subTotal;
}
public void setSubTotal(String subTotal) {
	this.subTotal = subTotal;
}
public String getLitreageId() {
	return litreageId;
}
public void setLitreageId(String litreageId) {
	this.litreageId = litreageId;
}
public String getColorId() {
	return colorId;
}
public void setColorId(String colorId) {
	this.colorId = colorId;
}
@Override
public String toString() {
	return "OrderItem [productId=" + productId + ", productName=" + productName + ", color=" + color + ", qty=" + qty
			+ ", litreage=" + litreage + ", unitPrice=" + unitPrice + "]";
}

}
