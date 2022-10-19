package com.coder.APIservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.apiForm.APIProduct;
import com.coder.apiForm.Feature;
import com.coder.apiForm.Guide;
import com.coder.apiForm.LiteragePrice;
import com.coder.apiForm.Tool;

import com.coder.dao.AboutProductLanguageDao;
import com.coder.dao.ColorDao;
import com.coder.dao.ColorGroupDao;
import com.coder.dao.FeatureDao;
import com.coder.dao.FeatureLanguageDao;
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
import com.coder.model.AboutProductLanguage;
import com.coder.model.Color;
import com.coder.model.FeatureLanguage;
import com.coder.model.GroupLanguage;
import com.coder.model.GuideLanguage;
import com.coder.model.Language;
import com.coder.model.Litreage;
import com.coder.model.Product;
import com.coder.model.ProductMedia;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.ProductType;
import com.coder.model.ToolLanguage;
import com.coder.model.TypeLanguage;
import com.coder.registerForm.ProductDetailsForm;
import com.coder.util.RestURIConstants;

@Service
@Repository("productDetailsAPIService")
public class ProductDetailsAPIService {
	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private GroupLanguageDao  groupLanguageDao;
	@Autowired
	private TypeLanguageDao typeLanguageDao;
	@Autowired
	private QtyUnitDao qtyUnitDao;
	@Autowired
	private AboutProductLanguageDao aboutProductLanguageDao;
	@Autowired
	private FeatureLanguageDao  featureLanguageDao;
	@Autowired
	private ToolLanguageDao  toolLanguageDao;
	@Autowired
	private GuideLanguageDao  guideLanguageDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductGroupDao productGroupDao;
	@Autowired
	private ProductStatusDao productStatusDao;
	@Autowired
	private ProductTypeDao productTypeDao;
	@Autowired
	private  FeatureDao  featureDao;
	@Autowired
	private GuideDao guideDao;
	@Autowired
	private FreeToolDao freeToolDao;
	@Autowired
	private LiterageDao  literageDao;
	@Autowired
	private  ColorGroupDao  colorGroupDao;
	@Autowired
	private ProductMediaDao productMediaDao;
	@Autowired
	private ProductTitleLanguageDao productTitleLanguageDao;
	@Autowired
	private ColorDao  colorDao;
	
public void prepareProductDetails(ProductDetailsForm productDetailsForm) {
		
		int productId=Integer.parseInt(productDetailsForm.getProductId());
		Product product=this.productDao.getProductById(productId);

		productDetailsForm.setProduct(product);
		productDetailsForm.setAPIProduct(this.getAPIProductByProduct(product));
		
	}


public List<APIProduct> getAllProductsByTypeId(String typeId) {

	int productTypeId=Integer.parseInt(typeId);
	ProductType productType=this.productTypeDao.getProductTypeById(productTypeId);
	List<APIProduct>  aPIProducts=new ArrayList<>(0);
	List<Product> products=this.productDao.getProductByType(productType);
	if(products!=null){
	for(Product product : products)
	{
		aPIProducts.add(this.getAPIProductByProduct(product));
	}
	}
	
	return aPIProducts;
	
}


public APIProduct getAPIProductByProduct(Product product)
{
	Language language=this.languageDao.getLanguageById(1);
	
	   List<FeatureLanguage> featureLanguages=this.featureLanguageDao.getFeatureLanguagesByProduct(product.getProductId(),1);
	   List<GuideLanguage> guideLanguages=this.guideLanguageDao.getGuideLanguagesByProduct(product.getProductId(), language);
	   List<ToolLanguage> toolLanguages=this.toolLanguageDao.getToolLanguagesByProduct(product.getProductId(), language);
	   List<AboutProductLanguage> aboutProductLanguages=this.aboutProductLanguageDao.getAboutLanguageByProduct(product,language);
	   List<ProductMedia>  productMedias=this.productMediaDao.getProductMediaByProductId(product);
	   List<Litreage> litreages=this.literageDao.getLiteragesByProduct(product);
	   List<ColorForm> colorForms=this.getColorsByProductId(product.getProductId()+"");
	   GroupLanguage  groupLanguage=this.groupLanguageDao.getGroupLanguageByProductId(product.getProductId(),1);
	   TypeLanguage typeLanguage=this.typeLanguageDao.getTypeLanguageById(1,product.getProductType());
	   ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.getProductTitleLanguageByProduct(product.getProductId(),language.getLanguageId());
	   
	   APIProduct APIProduct=new APIProduct();
	    APIProduct.setProductId(product.getProductId());
	    if(productTitleLanguage!=null){
	    APIProduct.setProductName(productTitleLanguage.getName());
	    }
	    if(groupLanguage!=null)
	    {
	    APIProduct.setProductGroup(groupLanguage.getName());
	    }
	    if(typeLanguage!=null){
	    APIProduct.setProductType(typeLanguage.getName());
	    }
	  
	    if(aboutProductLanguages!=null){
	    APIProduct.setProductAbout(aboutProductLanguages.get(0).getAboutDesc());
	    }
	    
	    List<Feature> features=new ArrayList<>(0);
	    List<Guide>  guides=new ArrayList<>(0);
	    List<LiteragePrice>  literagePrices=new ArrayList<>(0);
	    List<Tool> tools=new ArrayList<>(0);
	    List<String> imageUrls=new ArrayList<>(0);
	    
	    if(featureLanguages!=null){
	   for(FeatureLanguage featureLanguage : featureLanguages)
	   {
		   Feature  feature=new Feature();
		   feature.setFeatureId(featureLanguage.getId().getFeatureId());
		   feature.setFeatureName(featureLanguage.getFeatureName());
		   features.add(feature);
	   }
	    }
	   if(guideLanguages!=null){
	   for(GuideLanguage guideLanguage : guideLanguages)
	   {
		   Guide guide=new Guide();
		   guide.setGuideId(guideLanguage.getId().getGuideId());
		   guide.setGuideType(guideLanguage.getGuideType());
		   guide.setGuideValue(guideLanguage.getGuideValue());
		   guides.add(guide);
	   }
	   }
	   if(litreages!=null){
	   for(Litreage litreage  : litreages)
	   {
		   LiteragePrice literagePrice=new LiteragePrice();
		   
		   literagePrice.setLiterageId(litreage.getLitreageId()+"");
		   literagePrice.setLiterage(litreage.getQty()+" "+litreage.getQtyUnit().getUnit());
		   literagePrice.setUnitPrice(litreage.getUnitPrice());
		   literagePrices.add(literagePrice);
	   }
	   }
	   if(toolLanguages!=null){
	   for(ToolLanguage toolLanguage : toolLanguages)
	   {
		   Tool tool=new Tool();
		   tool.setToolId(toolLanguage.getId().getToolId());
		   tool.setToolName(toolLanguage.getToolName());
		   tool.setToolDescription(toolLanguage.getToolDescription());
		   String imageUrl=RestURIConstants.GET_HOSTING_PATH+"/productMediaImageUploadPath?id="+
				   toolLanguage.getId().getToolId()
				   +"&folderName=freetool&frmType=0&frmImage=1";
		   tool.setImageUrl(imageUrl);
		   tools.add(tool);
	   }
	   }
	   if(productMedias!=null){
	   for(ProductMedia productMedia : productMedias)
	   {
		   String imageUrl=RestURIConstants.GET_HOSTING_PATH+"/productMediaImageUploadPath?id="+
				   productMedia.getProductMediaId()
				   +"&folderName="+productMedia.getFolder().getName()+"&frmType=0&frmImage=1";
		   imageUrls.add(imageUrl);
	   }
	   }
	   APIProduct.setFeatures(features);
	   APIProduct.setGuides(guides);
	   APIProduct.setImageUrls(imageUrls);
	   APIProduct.setLiterages(literagePrices);
	   APIProduct.setTools(tools);	
	   APIProduct.setColors(colorForms);
	   return APIProduct;
}


public APIProduct getProductsById(String productId) {
	APIProduct aPIProduct=null;
	if(productId!=null)
	{
		int id=Integer.parseInt(productId);
		Product product=this.productDao.getProductById(id);
		aPIProduct=this.getAPIProductByProduct(product);
	}
	
	return aPIProduct;
}


public List<ColorForm> getColorsByProductId(String productId) {
	List<ColorForm> colorForms=null;
	if(productId!=null)
	{
		int id=Integer.parseInt(productId);
		List<Color> colors=this.colorDao.getColorsByProduct(id);
		colorForms=new ArrayList<ColorForm>();
		
		for(Color color : colors)
		{
			ColorForm colorForm=new ColorForm();
			colorForm.setColorGroupId(color.getColorId()+"");
			colorForm.setColorName(color.getColorName());
			colorForm.setColorNumber(color.getColorNumber());
			colorForm.setHtmlColorCode(color.getHtmlColorCode());
			
			colorForms.add(colorForm);
		}
		
	}
	return colorForms;
}

}
