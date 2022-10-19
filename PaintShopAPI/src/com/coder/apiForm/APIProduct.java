package com.coder.apiForm;

import java.util.ArrayList;
import java.util.List;

import com.coder.form.ColorForm;

public class APIProduct {
	
private int productId;
private String productName;
private String productGroup;
private String productType;
private String productAbout;
private List<Feature> features=new ArrayList<>(0);
private List<Guide>  guides=new ArrayList<>(0);
private List<LiteragePrice>  literages=new ArrayList<>(0);
private List<Tool> tools=new ArrayList<>(0);
private List<String> imageUrls=new ArrayList<>(0);
private List<ColorForm> colors=new ArrayList<>(0);



public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductGroup() {
	return productGroup;
}
public void setProductGroup(String productGroup) {
	this.productGroup = productGroup;
}
public String getProductType() {
	return productType;
}
public void setProductType(String productType) {
	this.productType = productType;
}
public String getProductAbout() {
	return productAbout;
}
public void setProductAbout(String productAbout) {
	this.productAbout = productAbout;
}
public List<Feature> getFeatures() {
	return features;
}
public void setFeatures(List<Feature> features) {
	this.features = features;
}
public List<Guide> getGuides() {
	return guides;
}
public void setGuides(List<Guide> guides) {
	this.guides = guides;
}
public List<LiteragePrice> getLiterages() {
	return literages;
}
public void setLiterages(List<LiteragePrice> literages) {
	this.literages = literages;
}
public List<Tool> getTools() {
	return tools;
}
public void setTools(List<Tool> tools) {
	this.tools = tools;
}
public List<String> getImageUrls() {
	return imageUrls;
}
public void setImageUrls(List<String> imageUrls) {
	this.imageUrls = imageUrls;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public List<ColorForm> getColors() {
	return colors;
}
public void setColors(List<ColorForm> colors) {
	this.colors = colors;
}

}
