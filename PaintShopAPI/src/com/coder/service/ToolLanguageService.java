package com.coder.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.FreeToolDao;
import com.coder.dao.GroupLanguageDao;
import com.coder.dao.LanguageDao;
import com.coder.dao.ProductGroupDao;
import com.coder.dao.ToolLanguageDao;
import com.coder.form.LanguageForm;
import com.coder.form.ProductGroupForm;
import com.coder.form.ToolLanguageForm;
import com.coder.model.FreeTool;
import com.coder.model.GroupLanguage;
import com.coder.model.GroupLanguageId;
import com.coder.model.Language;
import com.coder.model.ProductGroup;
import com.coder.model.ToolLanguage;
import com.coder.model.ToolLanguageId;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.registerForm.ToolLanguageRegisterForm;
import com.coder.util.FileUpload;
@Service
@Repository("toolLanguageService")
public class ToolLanguageService {
	@Autowired
	private FreeToolDao freeToolDao;
	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private ToolLanguageDao toolLanguageDao;
	
	public void prepareToolLanguageRegister(ToolLanguageRegisterForm toolLanguageRegisterForm){
		ToolLanguageForm toolLanguageForm=toolLanguageRegisterForm.getToolLanguageForm();
		if(toolLanguageForm!=null){
		this.toolLanguageRegister(toolLanguageRegisterForm);
		}
		toolLanguageRegisterForm.setToolLanguageForm(new ToolLanguageForm());
		Language language=this.languageDao.getLanguageById(1);
		List<ToolLanguage> toolLanguages=this.toolLanguageDao.getToolLanguagesByLanguage(1);
		toolLanguageRegisterForm.setToolLanguages(toolLanguages);
		toolLanguageRegisterForm.setToolLanguageForm(new ToolLanguageForm());

 	}
	private void toolLanguageRegister(ToolLanguageRegisterForm toolLanguageRegisterForm){
	    
		ToolLanguage toolLanguage=new ToolLanguage();		
		FreeTool freeTool=new FreeTool();
		int freeToolId=this.freeToolDao.saveFreeTool(freeTool);

		ToolLanguageForm toolLanguageForm=toolLanguageRegisterForm.getToolLanguageForm();
	
		FileUpload.uploadFile(toolLanguageForm.getMultipartFile(),freeToolId+"","freetool");
		
		ToolLanguageId toolLanguageId=new ToolLanguageId();
	toolLanguageId.setLanguageId(Integer.parseInt(toolLanguageForm.getLanguageId()));
	toolLanguageId.setToolId(freeToolId);
	toolLanguage.setToolName(toolLanguageForm.getToolName());
	toolLanguage.setId(toolLanguageId);
	toolLanguage.setToolDescription(toolLanguageForm.getToolDescription());
	this.toolLanguageDao.saveToolLanguage(toolLanguage);
	
	}

}
