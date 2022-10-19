package com.coder.registerForm;

import java.util.List;

import com.coder.model.ProductGroup;
import com.coder.model.ProductType;
import com.coder.model.TypeLanguage;

public class ShowAllTypeForm {

	private String groupId;
	private ProductGroup productGroup;
	private List<TypeLanguage> typeLanguages;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public ProductGroup getProductGroup() {
		return productGroup;
	}
	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}
	public List<TypeLanguage> getTypeLanguages() {
		return typeLanguages;
	}
	public void setTypeLanguages(List<TypeLanguage> typeLanguages) {
		this.typeLanguages = typeLanguages;
	}
	
}
