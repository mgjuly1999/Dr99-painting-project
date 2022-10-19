package com.coder.registerForm;

import java.util.List;

import com.coder.form.ProductQualityForm;
import com.coder.model.ProductQuality;

public class ProductQualityRegisterForm {
	
private ProductQualityForm productQualityForm;
private List<ProductQuality> ProductQualitys;

public ProductQualityForm getProductQualityForm() {
	return productQualityForm;
}
public void setProductQualityForm(ProductQualityForm productQualityForm) {
	this.productQualityForm = productQualityForm;
}
public List<ProductQuality> getProductQualitys() {
	return ProductQualitys;
}
public void setProductQualitys(List<ProductQuality> productQualitys) {
	ProductQualitys = productQualitys;
}

}
