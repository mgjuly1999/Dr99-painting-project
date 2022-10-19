package com.coder.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.formula.ptg.Ptg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.apiForm.APIProduct;
import com.coder.dao.AboutProductLanguageDao;
import com.coder.dao.AdminDao;
import com.coder.dao.ColorDao;
import com.coder.dao.ColorGroupDao;
import com.coder.dao.FeatureDao;
import com.coder.dao.FeatureLanguageDao;
import com.coder.dao.FolderDao;
import com.coder.dao.FreeToolDao;
import com.coder.dao.GroupLanguageDao;
import com.coder.dao.GuideDao;
import com.coder.dao.GuideLanguageDao;
import com.coder.dao.LanguageDao;
import com.coder.dao.LiterageDao;
import com.coder.dao.ProductDao;
import com.coder.dao.ProductGroupDao;
import com.coder.dao.ProductMediaDao;
import com.coder.dao.ProductStatusDao;
import com.coder.dao.ProductTitleLanguageDao;
import com.coder.dao.ProductTypeDao;
import com.coder.dao.QtyUnitDao;
import com.coder.dao.ToolLanguageDao;
import com.coder.dao.TypeLanguageDao;
import com.coder.form.ColorForm;
import com.coder.form.ColorGroupForm;
import com.coder.form.ProductColorForm;
import com.coder.form.ProductForm;
import com.coder.form.LiterageForm;
import com.coder.form.ProductMediaForm;
import com.coder.form.ProductNextForm;
import com.coder.form.ShowProductForm;
import com.coder.model.AboutProductLanguage;
import com.coder.model.AboutProductLanguageId;
import com.coder.model.Admin;
import com.coder.model.Color;
import com.coder.model.ColorGroup;
import com.coder.model.Feature;
import com.coder.model.FeatureLanguage;
import com.coder.model.Folder;
import com.coder.model.FreeTool;
import com.coder.model.Guide;
import com.coder.model.GuideLanguage;
import com.coder.model.Language;
import com.coder.model.Litreage;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ProductMedia;
import com.coder.model.ProductStatus;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.ProductTitleLanguageId;
import com.coder.model.ProductType;
import com.coder.model.QtyUnit;
import com.coder.model.ToolLanguage;
import com.coder.model.TypeLanguage;
import com.coder.model.TypeLanguageId;
import com.coder.util.*;
import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.ProductColorRegisterForm;
import com.coder.registerForm.ProductDetailsForm;
import com.coder.registerForm.ProductLiterageRegisterForm;
import com.coder.registerForm.ProductMediaRegisterForm;
import com.coder.registerForm.ProductRegisterForm;
import com.coder.registerForm.ProductRegisterNextForm;
import com.coder.registerForm.ShowAllProductForm;
@Service
@Repository("showProductService")
public class ShowProductService {
	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private AboutProductLanguageDao aboutProductLanguageDao;
	@Autowired
	private FeatureLanguageDao  featureLanguageDao;
	@Autowired
	private ToolLanguageDao  toolLanguageDao;
	@Autowired
	private TypeLanguageDao typeLanguageDao;
	@Autowired
	private GuideLanguageDao  guideLanguageDao;
	@Autowired
	private GroupLanguageDao  groupLanguageDao;
	@Autowired
	private ProductTitleLanguageDao productTitleLanguageDao;
	@Autowired
	private QtyUnitDao qtyUnitDao;
	
	public void prepareProductDetails(ProductDetailsForm productDetailsForm) {
		
		int productId=Integer.parseInt(productDetailsForm.getProductId());
		Product product=this.productDao.getProductById(productId);
		Language language=this.languageDao.getLanguageById(1);
	   List<FeatureLanguage> featureLanguages=this.featureLanguageDao.getFeatureLanguagesByProduct(productId,1);
	   List<GuideLanguage> guideLanguages=this.guideLanguageDao.getGuideLanguagesByProduct(productId, language);
	   List<ToolLanguage> toolLanguages=this.toolLanguageDao.getToolLanguagesByProduct(productId, language);
	   List<AboutProductLanguage> aboutProductLanguages=this.aboutProductLanguageDao.getAboutLanguageByProduct(product,language);
	   List<ProductTitleLanguage> productTitleLanguages=this.productTitleLanguageDao.getProductTitleLanguageByProduct(product.getProductId());
	   productDetailsForm.setProduct(product);
	   productDetailsForm.setToolLanguages(toolLanguages);
	   productDetailsForm.setAboutProductLanguages(aboutProductLanguages);
	   productDetailsForm.setFeatureLanguages(featureLanguages);
	   productDetailsForm.setGuideLanguages(guideLanguages);
	   productDetailsForm.setProductTitleLanguages(productTitleLanguages);
	   
	}
	
	
	public void prepareShowAllProductBytypeId(ShowAllProductForm showAllProductForm) {
		List<ShowProductForm> showProductForms=new ArrayList<>();
		int typeId=Integer.parseInt(showAllProductForm.getProductTypeId());
		//ProductType productType=this.productTypeDao.getProductTypeById(typeId);
		List<Product> products=this.productDao.getProductByType(typeId);
		for(Product pro:products){
			ShowProductForm showProductForm=new ShowProductForm();
			showProductForm.setProductTitleLanguage(this.productTitleLanguageDao.getProductTitleLanguageByProduct(pro.getProductId(),1));
			showProductForm.setProduct(pro);
			showProductForm.setQtyUnit(this.qtyUnitDao.getQtyUnitByProductId(pro.getProductId()));
			showProductForm.setGroupLanguage(this.groupLanguageDao.getGroupLanguageByProductId(pro.getProductId(),1));
			showProductForm.setTypeLanguage(this.typeLanguageDao.getTypeLanguageByProductId(pro.getProductId(),1 ));
			showProductForms.add(showProductForm);
		}
		showAllProductForm.setShowProductForms(showProductForms);
		
	}
	
	public void prepareShowAllProductByOrderFormId(ShowAllProductForm showAllProductForm) {
		List<ShowProductForm> showProductForms=new ArrayList<>();
		int orderFormId=Integer.parseInt(showAllProductForm.getOrderFormId());
		List<Product> products=this.productDao.getProductByOrderForm(orderFormId);
		for(Product pro:products){
			ShowProductForm showProductForm=new ShowProductForm();
			showProductForm.setProductTitleLanguage(this.productTitleLanguageDao.getProductTitleLanguageByProduct(pro.getProductId(),1));
			showProductForm.setProduct(pro);
			showProductForm.setQtyUnit(this.qtyUnitDao.getQtyUnitByProductId(pro.getProductId()));
			showProductForm.setGroupLanguage(this.groupLanguageDao.getGroupLanguageByProductId(pro.getProductId(),1));
			showProductForm.setTypeLanguage(this.typeLanguageDao.getTypeLanguageByProductId(pro.getProductId(),1 ));
			showProductForms.add(showProductForm);
		}
		showAllProductForm.setShowProductForms(showProductForms);
		
	}

}
