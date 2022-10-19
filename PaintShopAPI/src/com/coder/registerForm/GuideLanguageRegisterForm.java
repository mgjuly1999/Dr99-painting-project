package com.coder.registerForm;

import java.util.List;

import com.coder.form.GuideLanguageForm;
import com.coder.model.GuideLanguage;

public class GuideLanguageRegisterForm {
private GuideLanguageForm guideLanguageForm;
private List<GuideLanguage> guideLanguages;

public GuideLanguageForm getGuideLanguageForm() {
	return guideLanguageForm;
}

public void setGuideLanguageForm(GuideLanguageForm guideLanguageForm) {
	this.guideLanguageForm = guideLanguageForm;
}

public List<GuideLanguage> getGuideLanguages() {
	return guideLanguages;
}

public void setGuideLanguages(List<GuideLanguage> guideLanguages) {
	this.guideLanguages = guideLanguages;
}
}
