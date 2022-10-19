package com.coder.webServiceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coder.apiForm.*;

import com.coder.service.DeliveryAddressService;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class GetAllDeliveryAddressController {

	@Autowired
	private DeliveryAddressService  deliveryAddressService;
	
	
	 @RequestMapping(value =RestURIConstants.Get_All_Delivery_Address, method = RequestMethod.GET)	
	public List<DeliveryAddressAPIForm> getAllDeliveryAddressDispatcher()
	{
List<DeliveryAddressAPIForm> deliveryAddressAPIForms=deliveryAddressService.prepareGetAllDeliveryAddress();
	return	deliveryAddressAPIForms;
	}
	
}
