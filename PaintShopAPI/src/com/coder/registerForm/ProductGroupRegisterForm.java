package com.coder.registerForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.form.GroupLanguageForm;
import com.coder.form.ProductGroupForm;
import com.coder.model.GroupLanguage;
import com.coder.model.Language;

public class ProductGroupRegisterForm {
	private ProductGroupForm productGroupForm;
	private Map<String,String> mapProductGroups=new HashedMap<String,String>();
	private List<GroupLanguage> groupLanguages;
	private List<GroupLanguageForm> groupLanguageForms=new ArrayList<GroupLanguageForm>();
	public ProductGroupForm getProductGroupForm() {
		return productGroupForm;
	}
	public void setProductGroupForm(ProductGroupForm productGroupForm) {
		this.productGroupForm = productGroupForm;
	}

	public List<GroupLanguage> getGroupLanguages() {
		return groupLanguages;
	}
	public void setGroupLanguages(List<GroupLanguage> groupLanguages) {
		this.groupLanguages = groupLanguages;
	}
	public Map<String, String> getMapProductGroups() {
		return mapProductGroups;
	}
	public void setMapProductGroups(Map<String, String> mapProductGroups) {
		this.mapProductGroups = mapProductGroups;
	}
	public List<GroupLanguageForm> getGroupLanguageForms() {
		return groupLanguageForms;
	}
	public void setGroupLanguageForms(List<GroupLanguageForm> groupLanguageForms) {
		this.groupLanguageForms = groupLanguageForms;
	}


}
