package com.coder.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.GuideDao;
import com.coder.dao.GuideLanguageDao;
import com.coder.dao.LanguageDao;

import com.coder.form.GuideLanguageForm;

import com.coder.model.Guide;
import com.coder.model.GuideLanguage;
import com.coder.model.GuideLanguageId;
import com.coder.model.Language;
import com.coder.registerForm.GuideLanguageRegisterForm;
@Service
@Repository("guideLanguageService")
public class GuideLanguageService {
	@Autowired
	private GuideLanguageDao guideLanguageDao;
	@Autowired
	private GuideDao guideDao;
	
	public void prepareGuideLanguageRegister(GuideLanguageRegisterForm guideLanguageRegisterForm){
		GuideLanguageForm guideLanguageForm=guideLanguageRegisterForm.getGuideLanguageForm();
		if(guideLanguageForm!=null){
		this.guideLanguageRegister(guideLanguageRegisterForm);
		}
		guideLanguageRegisterForm.setGuideLanguageForm(new GuideLanguageForm());
		List<GuideLanguage> guideLanguages=this.guideLanguageDao.getGuideLanguagesByLanguage(1);
		guideLanguageRegisterForm.setGuideLanguages(guideLanguages);
		guideLanguageRegisterForm.setGuideLanguageForm(new GuideLanguageForm());

 	}
	private void guideLanguageRegister(GuideLanguageRegisterForm toolLanguageRegisterForm){
		GuideLanguage guideLanguage=new GuideLanguage();		
		Guide guide=new Guide();
		int guideId=this.guideDao.saveGuide(guide);
		GuideLanguageForm guideLanguageForm=toolLanguageRegisterForm.getGuideLanguageForm();
		GuideLanguageId guideLanguageId=new GuideLanguageId();
		guideLanguageId.setLanguageId(Integer.parseInt(guideLanguageForm.getLanguageId()));
		guideLanguageId.setGuideId(guideId);
		guideLanguage.setGuideType(guideLanguageForm.getGuideType());
		guideLanguage.setGuideValue(guideLanguageForm.getGuideValue());
		
		guideLanguage.setId(guideLanguageId);
	this.guideLanguageDao.saveToolLanguage(guideLanguage);
	}

}
