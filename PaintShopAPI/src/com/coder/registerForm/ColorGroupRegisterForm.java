package com.coder.registerForm;

import java.util.List;

import com.coder.form.ColorGroupForm;
import com.coder.model.ColorGroup;

public class ColorGroupRegisterForm {
private ColorGroupForm colorGroupForm;
private List<ColorGroup> colorGroups;
public ColorGroupForm getColorGroupForm() {
	return colorGroupForm;
}
public void setColorGroupForm(ColorGroupForm colorGroupForm) {
	this.colorGroupForm = colorGroupForm;
}
public List<ColorGroup> getColorGroups() {
	return colorGroups;
}
public void setColorGroups(List<ColorGroup> colorGroups) {
	this.colorGroups = colorGroups;
}

}
