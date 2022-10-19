package com.coder.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AdminDao;
import com.coder.dao.AdminStatusDao;
import com.coder.dao.DeliveryAddressDao;
import com.coder.form.AdminForm;
import com.coder.form.DeliveryAddressForm;
import com.coder.model.Admin;
import com.coder.model.AdminStatus;
import com.coder.model.DeliveryAddress;
import com.coder.model.Member;
import com.coder.registerForm.AdminRegisterForm;
import com.coder.registerForm.DeliveryAddressRegisterForm;
@Service
@Repository("deliveyAddressService")
public class DeliveyAddressService {
	@Autowired
	private DeliveryAddressDao deliveryAddressDao;
	
	public void prepareDeliveryAddressRegister(DeliveryAddressRegisterForm deliveryAddressRegisterForm){
		DeliveryAddressForm deliveryAddressForm=deliveryAddressRegisterForm.getDeliveryAddressForm();
		if(deliveryAddressForm!=null){
		this.deliveryAddressRegister(deliveryAddressRegisterForm);
		}
		deliveryAddressRegisterForm.setDeliveryAddressForm(new DeliveryAddressForm());
		deliveryAddressRegisterForm.setDeliveryAddresss(this.deliveryAddressDao.getDeliveryAddresss());
		
 	}
	private int deliveryAddressRegister(DeliveryAddressRegisterForm deliveryAddressRegisterForm){
		DeliveryAddress deliveryAddress=new DeliveryAddress();
		DeliveryAddressForm deliveryAddressForm=deliveryAddressRegisterForm.getDeliveryAddressForm();
		deliveryAddress.setAddress(deliveryAddressForm.getAddress());
		deliveryAddress.setDeliveryPrice(Integer.parseInt(deliveryAddressForm.getDeliveryPrice()));
		deliveryAddress.setDescription(deliveryAddressForm.getDescription());
		int id=this.deliveryAddressDao.saveDeliveryAddress(deliveryAddress);
		
	return id; 
	}
	

}
