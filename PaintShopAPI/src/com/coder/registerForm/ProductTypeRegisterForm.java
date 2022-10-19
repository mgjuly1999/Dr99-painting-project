package com.coder.registerForm;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.map.HashedMap;
import com.coder.form.ProductTypeForm;
import com.coder.model.TypeLanguage;

public class ProductTypeRegisterForm {
private String productGroupId;
private ProductTypeForm productTypeForm;
private Map<String,String> mapProductGroups=new HashedMap<String,String>();
private List<TypeLanguage> typeLanguages;
public ProductTypeForm getProductTypeForm() {
	return productTypeForm;
}
public void setProductTypeForm(ProductTypeForm productTypeForm) {
	this.productTypeForm = productTypeForm;
}
public Map<String, String> getMapProductGroups() {
	return mapProductGroups;
}
public void setMapProductGroups(Map<String, String> mapProductGroups) {
	this.mapProductGroups = mapProductGroups;
}
public String getProductGroupId() {
	return productGroupId;
}
public void setProductGroupId(String productGroupId) {
	this.productGroupId = productGroupId;
}
public List<TypeLanguage> getTypeLanguages() {
	return typeLanguages;
}
public void setTypeLanguages(List<TypeLanguage> typeLanguages) {
	this.typeLanguages = typeLanguages;
}

}
