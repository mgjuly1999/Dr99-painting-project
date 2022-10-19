package com.coder.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.FeatureDao;
import com.coder.dao.FeatureLanguageDao;
import com.coder.dao.FreeToolDao;
import com.coder.dao.GroupLanguageDao;
import com.coder.dao.LanguageDao;
import com.coder.dao.ProductGroupDao;
import com.coder.dao.ToolLanguageDao;
import com.coder.form.FeatureLanguageForm;
import com.coder.form.LanguageForm;
import com.coder.form.ProductGroupForm;
import com.coder.form.ToolLanguageForm;
import com.coder.model.Feature;
import com.coder.model.FeatureLanguage;
import com.coder.model.FeatureLanguageId;
import com.coder.model.FreeTool;
import com.coder.model.GroupLanguage;
import com.coder.model.GroupLanguageId;
import com.coder.model.Language;
import com.coder.model.ProductGroup;
import com.coder.model.ToolLanguage;
import com.coder.model.ToolLanguageId;
import com.coder.registerForm.FeatureLanguageRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.registerForm.ToolLanguageRegisterForm;
@Service
@Repository("featureLanguageService")
public class FeatureLanguageService {
	@Autowired
	private FeatureDao featureDao;
	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private FeatureLanguageDao featureLanguageDao;
	
	public void prepareFeatureLanguageRegister(FeatureLanguageRegisterForm featureLanguageRegisterForm){
		FeatureLanguageForm featureLanguageForm=featureLanguageRegisterForm.getFeatureLanguageForm();
		if(featureLanguageForm!=null){
		this.featureLanguageRegister(featureLanguageRegisterForm);
		}
		featureLanguageRegisterForm.setFeatureLanguageForm(new FeatureLanguageForm());
		Language language=this.languageDao.getLanguageById(1);
		List<FeatureLanguage> featureLanguages=this.featureLanguageDao.getFeatureLanguageByLanguage(language);
		featureLanguageRegisterForm.setFeatureLanguages(featureLanguages);
		featureLanguageRegisterForm.setFeatureLanguageForm(new FeatureLanguageForm());

 	}
	private void featureLanguageRegister(FeatureLanguageRegisterForm featureLanguageRegisterForm){
	    FeatureLanguage featureLanguage=new FeatureLanguage();		
		Feature feature=new Feature();
		int featureId=this.featureDao.saveFeature(feature);
		FeatureLanguageForm featureLanguageForm=featureLanguageRegisterForm.getFeatureLanguageForm();
	FeatureLanguageId featureLanguageId=new FeatureLanguageId();
	featureLanguageId.setLanguageId(Integer.parseInt(featureLanguageForm.getLanguageId()));
	featureLanguageId.setFeatureId(featureId);
	featureLanguage.setFeatureName(featureLanguageForm.getFeatureName());
	featureLanguage.setId(featureLanguageId);
	this.featureLanguageDao.saveFeatureLanguage(featureLanguage);
	}

}
