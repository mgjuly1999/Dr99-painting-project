package com.coder.registerForm;

import java.util.List;

import com.coder.form.ToolLanguageForm;
import com.coder.model.ToolLanguage;

public class ToolLanguageRegisterForm {
private ToolLanguageForm toolLanguageForm;
private List<ToolLanguage> toolLanguages;
public ToolLanguageForm getToolLanguageForm() {
	return toolLanguageForm;
}
public void setToolLanguageForm(ToolLanguageForm toolLanguageForm) {
	this.toolLanguageForm = toolLanguageForm;
}
public List<ToolLanguage> getToolLanguages() {
	return toolLanguages;
}
public void setToolLanguages(List<ToolLanguage> toolLanguages) {
	this.toolLanguages = toolLanguages;
}
}
