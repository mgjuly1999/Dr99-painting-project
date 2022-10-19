package com.coder.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.coder.dao.GuideDao;
import com.coder.dao.GuideLanguageDao;
import com.coder.dao.LanguageDao;
import com.coder.dao.LiterageDao;
import com.coder.dao.ProductDao;
import com.coder.dao.ProductGroupDao;
import com.coder.dao.ProductMediaDao;
import com.coder.dao.ProductQualityDao;
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
import com.coder.model.ProductQuality;
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
@Repository("productService")
public class ProductService {
	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ProductGroupDao productGroupDao;
	@Autowired
	private ProductStatusDao productStatusDao;
	@Autowired
	private ProductTypeDao productTypeDao;
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
	private FolderDao folderDao;
	@Autowired
	private ProductTitleLanguageDao productTitleLanguageDao;
	@Autowired
	private ProductQualityDao  productQualityDao;
	
	public void prepareProductRegister(ProductRegisterForm productRegisterForm){
		
		ProductForm productForm=productRegisterForm.getProductForm();
		if(productForm!=null)
		{
		this.productRegister(productRegisterForm);	
		}else
		{

		}
		
		ProductGroup  productGroup=this.productGroupDao.getProductGroupById(
				Integer.parseInt(productRegisterForm.getGroupId()
						));	
		productRegisterForm.setProductGroup(productGroup);
		
		List<QtyUnit> qtyUnits=this.qtyUnitDao.getQtyUnits();
		List<ProductQuality> productQualitys=this.productQualityDao.getProductQualitys();
		
		for(QtyUnit qtyUnit : qtyUnits)
		{
		productRegisterForm.getMapQtyUnit().put(qtyUnit.getQtyUnitId()+"",qtyUnit.getUnit());
		}
		
		List<ProductType> productTypes=this.productTypeDao.getProductTypesByGroup(productGroup.getProductGroupId());
		for(ProductQuality productQuality : productQualitys)
		{
			productRegisterForm.getMapProductQuality().put(productQuality.getProductQualityId()+"",
					productQuality.getName());
		}
		
		for(ProductType productType : productTypes)
		{
	     Language language=this.languageDao.getLanguageById(1);
		TypeLanguage typeLanguage=this.typeLanguageDao.getTypeLanguageById(language.getLanguageId(),productType);
		productRegisterForm.getMapProductTypes().put(productType.getProductTypeId()+"",typeLanguage.getName());
		
		}
		
		
		
 	}
	private int productRegister(ProductRegisterForm productRegisterForm){
		
		Admin  admin=this.adminDao.getAdminById(1);

		Product product=new Product();
		
		ProductForm productForm=productRegisterForm.getProductForm();
		
		int productTypeId=Integer.parseInt(productForm.getProductTypeId());
		int qtyUnitId=Integer.parseInt(productForm.getQtyUnitId());
		int productQuality=Integer.parseInt(productForm.getQualityId());
		
	
		
		product.setProductType(this.productTypeDao.getProductTypeById(productTypeId));
		product.setTotalQty(Integer.parseInt(productForm.getTotalQty()));
		product.setAdmin(admin);
		product.setProductStatus(this.productStatusDao.getProductStatusById(1));
		product.setQtyUnit(this.qtyUnitDao.getQtyUnitById(qtyUnitId));
		product.setProductQuality(this.productQualityDao.getProductQualityById(productQuality));
		product.setCreateDate(new Date());
		
		int productId=this.productDao.saveProduct(product);
		
		product.setProductId(productId);
		
		ProductTitleLanguage productTitleLanguage=new ProductTitleLanguage();
		
		ProductTitleLanguageId  productTitleLanguageId=new ProductTitleLanguageId();
		productTitleLanguageId.setLanguageId(1);
		productTitleLanguageId.setProductId(productId);
		productTitleLanguage.setId(productTitleLanguageId);
		productTitleLanguage.setName(productForm.getProductTitle());
		
		this.productTitleLanguageDao.saveProductTitleLanguage(productTitleLanguage);
		
		AboutProductLanguage aboutProductLanguage=new AboutProductLanguage();
		
		AboutProductLanguageId id=new AboutProductLanguageId();
	
		id.setLanguageId(1);
		id.setProductId(productId);
		
		aboutProductLanguage.setId(id);
		aboutProductLanguage.setAboutDesc(productForm.getDescription());
		productRegisterForm.setProduct(product);
	
		
		this.aboutProductLanguageDao.saveAboutProductLanguage(aboutProductLanguage);
		
		 ProductMedia productMedia=new ProductMedia();
		 Folder folder=this.folderDao.getFolderById(1);
		 productMedia.setProduct(product);
		 productMedia.setMediaType("jpg");
		 productMedia.setFolder(folder);
		 productMedia.setCreateDate(new Date());
		 
		 int productMediaId=this.productMediaDao.saveProductMedia(productMedia);
		 
		 FileUpload.uploadFile(productForm.getMultipartFile(),productMediaId+"",folder.getName());
		
	return productId; 
	}
	public void prepareProductRegisterNext(ProductRegisterNextForm productRegisterNextForm) {
	
		int productId=Integer.parseInt(productRegisterNextForm.getProductId());
		Product product=this.productDao.getProductById(productId);
		productRegisterNextForm.setProduct(product);
		ProductNextForm productNextForm=productRegisterNextForm.getProductNextForm();
		
		if(productNextForm.getFeatures()!=null)
		{
			Set<Feature> features = new HashSet<Feature>(0);
			for(String featureId : productNextForm.getFeatures())
			{
				Feature  feature=this.featureDao.getFeatureById(Integer.parseInt(featureId));
				features.add(feature);
			}
			product.setFeatures(features);
			this.productDao.update(product);
			
			
		}else if(productNextForm.getGuides()!=null)
		{
			 Set<Guide> guides = new HashSet<Guide>(0);
			 for(String guideId  : productNextForm.getGuides())
			 {
				 Guide guide=this.guideDao.getGuideById(Integer.parseInt(guideId));
				 guides.add(guide);
			 }
			 product.setGuides(guides);
				this.productDao.update(product);
			 
		}else if(productNextForm.getTools()!=null)
		{
			Set<FreeTool> freeTools = new HashSet<FreeTool>(0);
			for(String toolId : productNextForm.getTools())
			{
				FreeTool freeTool=this.freeToolDao.getProductFreeToolById(Integer.parseInt(toolId));
				freeTools.add(freeTool);
			}
			product.setFreeTools(freeTools);
			this.productDao.update(product);
		}
		
		
		Language language=this.languageDao.getLanguageById(1);
		
		List<FeatureLanguage> featureLanguages=this.featureLanguageDao.getFeatureLanguageByLanguage(language);
		List<GuideLanguage> guideLanguages=this.guideLanguageDao.getGuideLanguagesByLanguage(language.getLanguageId());
		List<ToolLanguage> toolLanguages=this.toolLanguageDao.getToolLanguagesByLanguage(language.getLanguageId());
		
		productRegisterNextForm.setFeatureLanguages(featureLanguages);
		productRegisterNextForm.setGuideLanguages(guideLanguages);
		productRegisterNextForm.setToolLanguages(toolLanguages);
		
		
	}
	public void prepareProductLiterageRegister(ProductLiterageRegisterForm productLiterageRegisterForm) {
		
		LiterageForm productLiterageForm=productLiterageRegisterForm.getProductLiterageForm();
		
		if(productLiterageForm!=null)
		{
			Litreage litreage=new Litreage();
			int productId=Integer.parseInt(productLiterageForm.getProductId());
			int qtyUnitId=Integer.parseInt(productLiterageForm.getQtyUnitId());
			Product product=this.productDao.getProductById(productId);
			litreage.setQty(Integer.parseInt(productLiterageForm.getQty()));
			litreage.setProduct(product);
			litreage.setUnitPrice(Double.parseDouble(productLiterageForm.getUnitPrice()));
			litreage.setQtyUnit(this.qtyUnitDao.getQtyUnitById(qtyUnitId));
			litreage.setDescription(productLiterageForm.getDescription());
			
			this.literageDao.saveLitreage(litreage);
			productLiterageRegisterForm.setProduct(product);
		}
		
		List<QtyUnit> qtyUnits=this.qtyUnitDao.getQtyUnits();
		for(QtyUnit qtyUnit : qtyUnits)
		{
			productLiterageRegisterForm.getMapQtyUnits().put(qtyUnit.getQtyUnitId()+"",qtyUnit.getUnit());
		}
		
	}
	public void prepareProductLiterageRegisterFinish(ProductColorRegisterForm productColorRegisterForm) {
		
		ProductColorForm productColorForm=productColorRegisterForm.getProductColorForm();
		
		if(productColorForm!=null)
		{
			int productId=Integer.parseInt(productColorForm.getProductId());
			Product product=this.productDao.getProductById(productId);
			Set<ColorGroup> colorGroups = new HashSet<ColorGroup>(0);
			for(String colorGroupId : productColorForm.getColorGroups())
			{
			ColorGroup colorGroup=this.colorGroupDao.getProductColorGroupById(Integer.parseInt(colorGroupId));
			colorGroups.add(colorGroup);
			productColorRegisterForm.setProduct(product);
			}
			
			product.setColorGroups(colorGroups);
			this.productDao.updateProduct(product);
			
		}else
		{
			int productId=Integer.parseInt(productColorRegisterForm.getProductId());
			Product product=this.productDao.getProductById(productId);
			productColorRegisterForm.setProduct(product);
		}
		
		productColorRegisterForm.setColorGroups(this.colorGroupDao.getColorGroups());
		
	}
	public void prepareProductMediaRegister(ProductMediaRegisterForm productMediaRegisterForm) {
	
		ProductMediaForm productMediaForm=productMediaRegisterForm.getProductMediaForm();
		 Product	product=null;
		if(productMediaForm!=null)
		{
			int productId=Integer.parseInt(productMediaForm.getProductId());
			int folderId=Integer.parseInt(productMediaForm.getFolderId());
			
		   product=this.productDao.getProductById(productId);
		   Folder folder=this.folderDao.getFolderById(folderId);
		   ProductMedia productMedia=new ProductMedia();
		   
		   productMedia.setMediaType("");
		   productMedia.setProduct(product);
		   productMedia.setFolder(folder);
		   productMedia.setCreateDate(new Date());
		   
		   int productMediaId=this.productMediaDao.saveProductMedia(productMedia);
		 
		   FileUpload.uploadFile(productMediaForm.getMultipartFile(),productMediaId+"",folder.getName());
			
		   productMediaRegisterForm.setProduct(product);
		   
		}
		
			List<Folder> folders=this.folderDao.getFolders();
			for(Folder folder : folders)
			{
			productMediaRegisterForm.getMapFolders().put(folder.getFolderId()+"",folder.getName());
			
			}
			
			List<ProductMedia> productMedias=this.productMediaDao.getProductMediaByProductId(product);
			productMediaRegisterForm.setProductMedias(productMedias);
		
		
	}
	public void prepareProductDetails(ProductDetailsForm productDetailsForm) {
		
		int productId=Integer.parseInt(productDetailsForm.getProductId());
		Product product=this.productDao.getProductById(productId);
		Language language=this.languageDao.getLanguageById(1);
		
	   List<FeatureLanguage> featureLanguages=this.featureLanguageDao.getFeatureLanguagesByProduct(productId, language.getLanguageId());
	   List<GuideLanguage> guideLanguages=this.guideLanguageDao.getGuideLanguagesByProduct(productId, language);
	   List<ToolLanguage> toolLanguages=this.toolLanguageDao.getToolLanguagesByProduct(productId, language);
	   List<AboutProductLanguage> aboutProductLanguage=this.aboutProductLanguageDao.getAboutLanguageByProduct(product,language);
	   
	   
	   
	   
	   APIProduct apiProduct=new APIProduct();
		
		
		
		
		productDetailsForm.setProduct(product);
		
	}
	
/*	public void prepareShowAllProductBytypeId(ShowAllProductForm showAllProductForm) {

		int typeId = Integer.parseInt(showAllProductForm.getTypeId());
		ProductType productType = this.productTypeDao.getProductTypeById(typeId);
		List<Product> products = this.productDao.getProductByType(productType);
		showAllProductForm.setProducts(products);
		showAllProductForm.setProductType(productType);

	}*/

}
