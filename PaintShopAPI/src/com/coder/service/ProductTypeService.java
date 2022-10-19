package com.coder.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.GroupLanguageDao;
import com.coder.dao.LanguageDao;
import com.coder.dao.ProductGroupDao;
import com.coder.dao.ProductTypeDao;
import com.coder.dao.TypeLanguageDao;
import com.coder.form.LanguageForm;
import com.coder.form.ProductGroupForm;
import com.coder.form.ProductTypeForm;
import com.coder.model.GroupLanguage;
import com.coder.model.GroupLanguageId;
import com.coder.model.Language;
import com.coder.model.ProductGroup;
import com.coder.model.ProductType;
import com.coder.model.TypeLanguage;
import com.coder.model.TypeLanguageId;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.registerForm.ProductTypeRegisterForm;
import com.coder.registerForm.ShowAllTypeForm;
import com.coder.util.FileUpload;
@Service
@Repository("productTypeRegisterServic")
public class ProductTypeService {
	@Autowired
	private ProductGroupDao productGroupDao;
	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private ProductTypeDao productTypeDao;
	@Autowired 
	private GroupLanguageDao groupLanguageDao;
	@Autowired 
	private TypeLanguageDao typeLanguageDao;
	
	public void prepareProductTypeRegister(ProductTypeRegisterForm productTypeRegisterForm){
		
		ProductTypeForm productTypeForm=productTypeRegisterForm.getProductTypeForm();
		if(productTypeForm!=null){
		this.productTypeRegister(productTypeRegisterForm);
		}
		
		productTypeRegisterForm.setProductTypeForm(new ProductTypeForm());
		Language language=this.languageDao.getLanguageById(1);
		List<GroupLanguage> groupLanguages=this.groupLanguageDao.getGroupLanguagesByLanguage(1);
		
		for(GroupLanguage  groupLanguage : groupLanguages)
		{
			productTypeRegisterForm.getMapProductGroups().
			put(groupLanguage.getProductGroup().getProductGroupId()+"",groupLanguage.getName());
		}
		
 	}
	private void productTypeRegister(ProductTypeRegisterForm productTypeRegisterForm){
	  ProductTypeForm productTypeForm=productTypeRegisterForm.getProductTypeForm();	
	  TypeLanguage typeLanguage=new TypeLanguage();
	  ProductType productType=new ProductType();
	    ProductGroup productGroup=this.productGroupDao.getProductGroupById(Integer.parseInt(productTypeForm.getProductGroupId()));
	    productType.setProductGroup(productGroup);
	    productType.setHtmlColorCode(productTypeForm.getHtmlColorCode());
	    int productTypeId=this.productTypeDao.saveProductType(productType);
	    
	    FileUpload.uploadFile(productTypeForm.getMultipartFile(),
	    		productTypeId+""+productGroup.getProductGroupId(),"productType");
	    
		typeLanguage.setName(productTypeForm.getName());
		typeLanguage.setDescription(productTypeForm.getDescription());
		TypeLanguageId typeLanguageId=new TypeLanguageId();
		typeLanguageId.setLanguageId(Integer.parseInt(productTypeForm.getLanguageId()));
		typeLanguageId.setProductTypeId(productTypeId);
		typeLanguage.setId(typeLanguageId);
		this.typeLanguageDao.saveTypeLanguage(typeLanguage);
	}
	public void getProductTypeByGroup(String groupId){
		Language language=this.languageDao.getLanguageById(1);
		ProductGroup productGroup=this.productGroupDao.getProductGroupById(Integer.parseInt(groupId));
		List<TypeLanguage> typeLanguages=this.typeLanguageDao.getTypeLanguageByGroup(productGroup, language.getLanguageId());
		System.out.println("typeLanguage="+typeLanguages.size()); 
	}
	public void prepareShowAllTypeByGroupId(ShowAllTypeForm showAllTypeForm) {
		
		int groupId=Integer.parseInt(showAllTypeForm.getGroupId()); 
		
		Language language=this.languageDao.getLanguageById(1);
		ProductGroup productGroup=this.productGroupDao.getProductGroupById(groupId);
		List<TypeLanguage> typeLanguages=this.typeLanguageDao.getTypeLanguageByGroup(productGroup,language.getLanguageId());
		showAllTypeForm.setTypeLanguages(typeLanguages);
		showAllTypeForm.setProductGroup(productGroup);
	}

}
