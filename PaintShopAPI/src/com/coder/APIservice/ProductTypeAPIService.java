package com.coder.APIservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.LanguageDao;
import com.coder.dao.ProductGroupDao;
import com.coder.dao.ProductTypeDao;
import com.coder.dao.TypeLanguageDao;
import com.coder.form.ProductTypeForm;
import com.coder.form.TypeLanguageForm;
import com.coder.model.Language;
import com.coder.model.ProductGroup;
import com.coder.model.ProductType;
import com.coder.model.TypeLanguage;
import com.coder.util.RestURIConstants;

@Service
@Repository("productTypeAPIService")
public class ProductTypeAPIService {
	@Autowired
	private TypeLanguageDao typeLanguageDao;
	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private ProductGroupDao productGroupDao;

	public List<TypeLanguageForm> getProductTypeLanguagesByGroupId(int groupId) {
		
		Language language=this.languageDao.getLanguageById(1);
		ProductGroup productGroup=this.productGroupDao.getProductGroupById(groupId);
		List<TypeLanguage> typeLanguages=this.typeLanguageDao.getTypeLanguageByGroup(productGroup,1);
		List<TypeLanguageForm> typeLanguageForms=new ArrayList<TypeLanguageForm>();
		
		for(TypeLanguage typeLanguage : typeLanguages)
		{
			TypeLanguageForm  typeLanguageForm=new TypeLanguageForm();
			
			
			typeLanguageForm.setProductTypeId(typeLanguage.getProductType().getProductTypeId()+"");
			typeLanguageForm.setLanguageId(typeLanguage.getLanguage().getLanguageId()+"");
			typeLanguageForm.setName(typeLanguage.getName());
			typeLanguageForm.setDescription(typeLanguage.getDescription());
			typeLanguageForm.setColor(typeLanguage.getProductType().getHtmlColorCode());
			typeLanguageForm.setImageUrl(RestURIConstants.GET_HOSTING_PATH+"/typeImageUploadPath?"+"id="+
					typeLanguage.getProductType().getProductTypeId()+""+typeLanguage.getProductType().getProductGroup().getProductGroupId()
					+"&frmType=0&frmImage=1");
			typeLanguageForms.add(typeLanguageForm);
			
		}
		
		return typeLanguageForms;
	}
}
