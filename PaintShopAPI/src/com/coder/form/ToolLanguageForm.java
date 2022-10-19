package com.coder.form;

import org.springframework.web.multipart.MultipartFile;

public class ToolLanguageForm {

private String toolId;
private String languageId;
private String toolName;
private String toolDescription;
private MultipartFile multipartFile;
private String imageUrl;

public String getLanguageId() {
	return languageId;
}
public void setLanguageId(String languageId) {
	this.languageId = languageId;
}
public String getToolName() {
	return toolName;
}
public void setToolName(String toolName) {
	this.toolName = toolName;
}
public String getToolId() {
	return toolId;
}
public void setToolId(String toolId) {
	this.toolId = toolId;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}
public String getToolDescription() {
	return toolDescription;
}
public void setToolDescription(String toolDescription) {
	this.toolDescription = toolDescription;
}
public MultipartFile getMultipartFile() {
	return multipartFile;
}
public void setMultipartFile(MultipartFile multipartFile) {
	this.multipartFile = multipartFile;
}

}
