package com.coder.registerForm;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.form.ColorForm;

public class ColorRegisterForm {
private ColorForm colorForm;
private Map<String,String> mapColorGroups=new HashedMap<String,String>();
public ColorForm getColorForm() {
	return colorForm;
}

public void setColorForm(ColorForm colorForm) {
	this.colorForm = colorForm;
}

public Map<String, String> getMapColorGroups() {
	return mapColorGroups;
}

public void setMapColorGroups(Map<String, String> mapColorGroups) {
	this.mapColorGroups = mapColorGroups;
}
}
