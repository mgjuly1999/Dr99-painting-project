package com.coder.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.coder.dao.LanguageDao;
import com.coder.dao.ProductStatusDao;
import com.coder.form.LanguageForm;
import com.coder.form.ProductStatusForm;
import com.coder.model.Language;
import com.coder.model.ProductStatus;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.ProductStatusRegisterForm;
@Service
@Repository("productStatusService")
public class ProductStatusService {
	@Autowired
	private ProductStatusDao productStatusDao;
	public void prepareProductStatusRegister(ProductStatusRegisterForm productStatusRegisterForm){
		ProductStatusForm productStatusForm=productStatusRegisterForm.getProductStatusForm();
		if(productStatusForm!=null){
		this.productStatusRegister(productStatusRegisterForm);
		}
		productStatusRegisterForm.setProductStatusForm(new ProductStatusForm());
		List<ProductStatus> productStatuss=this.productStatusDao.getProductStatuss();
		productStatusRegisterForm.setProductStatuss(productStatuss);
 	}
	private int productStatusRegister(ProductStatusRegisterForm productStatusRegisterForm){
	
		ProductStatus productStatus=new ProductStatus();
		ProductStatusForm productStatusForm=productStatusRegisterForm.getProductStatusForm();
		productStatus.setStatusName(productStatusForm.getStatusName());
		productStatus.setDescription(productStatusForm.getDescription());
		int id=this.productStatusDao.saveProductStatus(productStatus);
	return id; 
	}

}
