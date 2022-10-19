package com.coder.form;

import org.springframework.web.multipart.MultipartFile;

public class ProductTypeForm {
	
	private String languageId;
	private String productGroupId;
	private String htmlColorCode;
	private String name;
	private String description;
	private MultipartFile multipartFile;
	
	public String getProductGroupId() {
		return productGroupId;
	}
	public void setProductGroupId(String productGroupId) {
		this.productGroupId = productGroupId;
	}
	public String getHtmlColorCode() {
		return htmlColorCode;
	}
	public void setHtmlColorCode(String htmlColorCode) {
		this.htmlColorCode = htmlColorCode;
	}
	
	public String getLanguageId() {
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
}
