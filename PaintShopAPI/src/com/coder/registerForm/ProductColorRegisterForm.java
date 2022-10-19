package com.coder.registerForm;

import java.util.ArrayList;
import java.util.List;

import com.coder.form.ProductColorForm;
import com.coder.model.*;

public class ProductColorRegisterForm {
 private ProductColorForm productColorForm;
 private Product product;
 private String productId;
 private List<ColorGroup>  colorGroups=new ArrayList<ColorGroup>();

public ProductColorForm getProductColorForm() {
	return productColorForm;
}

public void setProductColorForm(ProductColorForm productColorForm) {
	this.productColorForm = productColorForm;
}

public List<ColorGroup> getColorGroups() {
	return colorGroups;
}

public void setColorGroups(List<ColorGroup> colorGroups) {
	this.colorGroups = colorGroups;
}

public String getProductId() {
	return productId;
}

public void setProductId(String productId) {
	this.productId = productId;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}
}
