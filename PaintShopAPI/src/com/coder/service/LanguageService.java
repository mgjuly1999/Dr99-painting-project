package com.coder.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.coder.dao.LanguageDao;
import com.coder.form.LanguageForm;
import com.coder.model.Language;
import com.coder.registerForm.LanguageRegisterForm;
@Service
@Repository("languageService")
public class LanguageService {
	@Autowired
	private LanguageDao languageDao;
	public void prepareLanguageRegister(LanguageRegisterForm languageRegisterForm){
		LanguageForm languageForm=languageRegisterForm.getLanguageForm();
		if(languageForm!=null){
		this.languageRegister(languageRegisterForm);
		}
		languageRegisterForm.setLanguageForm(new LanguageForm());
		List<Language> languages=this.languageDao.getLanguages();
		languageRegisterForm.setLanguages(languages);
 	}
	private int languageRegister(LanguageRegisterForm languageRegisterForm){
	
		Language language=new Language(); 
		LanguageForm languageForm=languageRegisterForm.getLanguageForm();
		language.setName(languageForm.getName());
		language.setCode(languageForm.getCode());
		int id=this.languageDao.saveLanguage(language);
	return id; 
	}

}
