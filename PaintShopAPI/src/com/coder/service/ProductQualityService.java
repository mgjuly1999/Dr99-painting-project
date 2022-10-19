package com.coder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AdminDao;
import com.coder.dao.ProductQualityDao;
import com.coder.form.ProductQualityForm;
import com.coder.model.ProductQuality;
import com.coder.registerForm.ProductQualityRegisterForm;
@Service
@Repository("productQualityService")
public class ProductQualityService {
	@Autowired
	private ProductQualityDao productQualityDao;

	public void prepareProductQualityRegister(ProductQualityRegisterForm productQualityRegisterForm) {
		ProductQualityForm	productQualityForm=productQualityRegisterForm.getProductQualityForm();
		
		if(productQualityForm!=null)
		{
			ProductQuality productQuality=new ProductQuality();
			productQuality.setName(productQualityForm.getName());
			productQuality.setDescription(productQualityForm.getDescription());
			
			this.productQualityDao.saveProductQuality(productQuality);
		}
		List<ProductQuality> productQualitys=this.productQualityDao.getProductQualitys();
	
		productQualityRegisterForm.setProductQualitys(productQualitys);
		
	}

}
