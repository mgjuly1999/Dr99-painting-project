package com.coder.registerForm;

import java.util.List;

import com.coder.form.LanguageForm;
import com.coder.model.Language;



public class LanguageRegisterForm {
private LanguageForm languageForm;
private List<Language> languages;
public LanguageForm getLanguageForm() {
	return languageForm;
}

public void setLanguageForm(LanguageForm languageForm) {
	this.languageForm = languageForm;
}

public List<Language> getLanguages() {
	return languages;
}

public void setLanguages(List<Language> languages) {
	this.languages = languages;
}
}
