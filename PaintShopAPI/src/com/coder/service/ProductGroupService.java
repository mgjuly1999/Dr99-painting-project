package com.coder.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.GroupLanguageDao;
import com.coder.dao.LanguageDao;
import com.coder.dao.ProductGroupDao;
import com.coder.form.GroupLanguageForm;
import com.coder.form.LanguageForm;
import com.coder.form.ProductGroupForm;
import com.coder.model.GroupLanguage;
import com.coder.model.GroupLanguageId;
import com.coder.model.Language;
import com.coder.model.ProductGroup;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.util.FileUpload;
import com.coder.util.RestURIConstants;
@Service
@Repository("productGroupService")
public class ProductGroupService {
	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private ProductGroupDao productGroupDao;
	@Autowired 
	private GroupLanguageDao groupLanguageDao;
	
	public void prepareProductGroupRegister(ProductGroupRegisterForm productGroupRegisterForm){
		ProductGroupForm productGroupForm=productGroupRegisterForm.getProductGroupForm();
		if(productGroupForm!=null){
		this.productGroupRegister(productGroupRegisterForm);
		}
		productGroupRegisterForm.setProductGroupForm(new ProductGroupForm());
		productGroupRegisterForm.setGroupLanguages(this.groupLanguageDao.getGroupLanguagesByLanguage(1));

 	}
	private void productGroupRegister(ProductGroupRegisterForm productGroupRegisterForm){
	    GroupLanguage groupLanguage=new GroupLanguage();		
		ProductGroup productGroup=new ProductGroup();
		int productGroupId=this.productGroupDao.saveProductGroup(productGroup);
		ProductGroupForm productGroupForm=productGroupRegisterForm.getProductGroupForm();
		FileUpload.uploadFile(productGroupForm.getMultipartFile(),productGroupId+"","ProductGroup");
		
		groupLanguage.setDescription(productGroupForm.getDescription());
		groupLanguage.setName(productGroupForm.getName());
		GroupLanguageId groupLanguageId=new GroupLanguageId();
		groupLanguageId.setProductGroupId(productGroupId);
		groupLanguageId.setLanguageId(Integer.parseInt(productGroupForm.getLanguageId()));
		groupLanguage.setId(groupLanguageId);
		this.groupLanguageDao.saveGroupLanguage(groupLanguage);
	}
	public void showAllProductGroup(ProductGroupRegisterForm productGroupRegisterForm){
		List<GroupLanguage> groupLanguages=this.groupLanguageDao.getGroupLanguagesByLanguage(1);
		List<GroupLanguageForm>  GroupLanguageForms=new ArrayList<GroupLanguageForm>();
		
		for(GroupLanguage groupLanguage : groupLanguages)
		{
		
		GroupLanguageForm  groupLanguageForm=new GroupLanguageForm();
		
		groupLanguageForm.setId(groupLanguage.getProductGroup().getProductGroupId()+"");
		groupLanguageForm.setName(groupLanguage.getName());
		groupLanguageForm.setDescription(groupLanguage.getDescription());
		groupLanguageForm.setImageUrl(RestURIConstants.GET_HOSTING_PATH+"/groupImageUploadPath?"+"id="+
		groupLanguageForm.getId()+"&frmType=0&frmImage=1");
		GroupLanguageForms.add(groupLanguageForm);

		
		}
		
		productGroupRegisterForm.setGroupLanguages(groupLanguages);
		productGroupRegisterForm.setGroupLanguageForms(GroupLanguageForms);
	}
	public void prepareSelectProductGroup(ProductGroupRegisterForm productGroupRegisterForm) {
	
		
		
	}

}
