package com.coder.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AdminDao;
import com.coder.dao.AdminStatusDao;
import com.coder.dao.DeliveryAddressDao;
import com.coder.dao.DeliveryTypeDao;
import com.coder.form.AdminForm;
import com.coder.form.DeliveryAddressForm;
import com.coder.form.DeliveryTypeForm;
import com.coder.model.Admin;
import com.coder.model.AdminStatus;
import com.coder.model.DeliveryAddress;
import com.coder.model.DeliveryType;
import com.coder.model.Member;
import com.coder.registerForm.AdminRegisterForm;
import com.coder.registerForm.DeliveryAddressRegisterForm;
import com.coder.registerForm.DeliveryTypeRegisterForm;
@Service
@Repository("deliveryTypeService")
public class DeliveryTypeService {
	@Autowired
	private DeliveryTypeDao deliveryTypeDao;
	
	public void prepareDeliveryTypeRegister(DeliveryTypeRegisterForm deliveryTypeRegisterForm){
		DeliveryTypeForm deliveryAddressForm=deliveryTypeRegisterForm.getDeliveryTypeForm();
		if(deliveryAddressForm!=null){
		this.deliveryTypeRegister(deliveryTypeRegisterForm);	}
		deliveryTypeRegisterForm.setDeliveryTypeForm(new DeliveryTypeForm());
		deliveryTypeRegisterForm.setDeliveryTypes(this.deliveryTypeDao.getDeliveryTypes());
		
		
 	}
	private int deliveryTypeRegister(DeliveryTypeRegisterForm deliveryTypeRegisterForm){
		DeliveryType deliveryType=new DeliveryType();
		DeliveryTypeForm deliveryTypeForm=deliveryTypeRegisterForm.getDeliveryTypeForm();
		deliveryType.setName(deliveryTypeForm.getName());
		int id=this.deliveryTypeDao.saveDeliveryType(deliveryType);
	return id; 
	}
	

}
