package com.coder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.coder.apiForm.DeliveryAddressAPIForm;
import com.coder.dao.DeliveryAddressDao;
import com.coder.model.DeliveryAddress;

@Service
@Repository("deliveryAddressService")
public class DeliveryAddressService {
	@Autowired
	private DeliveryAddressDao  deliveryAddressDao;

	public List<DeliveryAddressAPIForm> prepareGetAllDeliveryAddress() {

	List<DeliveryAddress> deliveryAddress=this.deliveryAddressDao.getDeliveryAddresss();
	List<DeliveryAddressAPIForm>  deliveryAddressAPIForms=new ArrayList<DeliveryAddressAPIForm>();
	for(DeliveryAddress deliveryAddres : deliveryAddress)
	{
		DeliveryAddressAPIForm deliveryAddressAPIForm=new DeliveryAddressAPIForm();
		deliveryAddressAPIForm.setDeliveryAddressId(deliveryAddres.getDeliveryAddressId()+"");
		deliveryAddressAPIForm.setDeliveryPrice(deliveryAddres.getDeliveryPrice()+"");
		deliveryAddressAPIForm.setAddress(deliveryAddres.getAddress());
		deliveryAddressAPIForm.setDescription(deliveryAddres.getDescription());
		
		deliveryAddressAPIForms.add(deliveryAddressAPIForm);
	}
		
		return deliveryAddressAPIForms;
	}

}
