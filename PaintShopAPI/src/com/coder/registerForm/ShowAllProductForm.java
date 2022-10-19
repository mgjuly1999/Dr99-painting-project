package com.coder.registerForm;
import java.util.List;
import com.coder.form.ShowProductForm;
public class ShowAllProductForm {
private String orderFormId;
private String productTypeId;
private List<ShowProductForm>  showProductForms;
public List<ShowProductForm> getShowProductForms() {
	return showProductForms;
}
public void setShowProductForms(List<ShowProductForm> showProductForms) {
	this.showProductForms = showProductForms;
}
public String getProductTypeId() {
	return productTypeId;
}
public void setProductTypeId(String productTypeId) {
	this.productTypeId = productTypeId;
}
public String getOrderFormId() {
	return orderFormId;
}
public void setOrderFormId(String orderFormId) {
	this.orderFormId = orderFormId;
}}
