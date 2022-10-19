package com.coder.registerForm;

import java.util.List;

import com.coder.form.FeatureLanguageForm;
import com.coder.model.FeatureLanguage;

public class FeatureLanguageRegisterForm {
private FeatureLanguageForm featureLanguageForm;
private List<FeatureLanguage> featureLanguages;
public FeatureLanguageForm getFeatureLanguageForm() {
	return featureLanguageForm;
}

public void setFeatureLanguageForm(FeatureLanguageForm featureLanguageForm) {
	this.featureLanguageForm = featureLanguageForm;
}

public List<FeatureLanguage> getFeatureLanguages() {
	return featureLanguages;
}

public void setFeatureLanguages(List<FeatureLanguage> featureLanguages) {
	this.featureLanguages = featureLanguages;
}
}
