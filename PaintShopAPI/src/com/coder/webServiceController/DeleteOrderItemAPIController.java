package com.coder.webServiceController;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.apiForm.DeleteAllItemForm;
import com.coder.apiForm.DeleteOrderItemForm;
import com.coder.apiForm.ShopCartAPIForm;
import com.coder.apiForm.UpdateOrderItemForm;
import com.coder.form.PaymentRespForm;
import com.coder.service.AddCartService;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class DeleteOrderItemAPIController {
	@Autowired
	private AddCartService addCartService;
	
	@PostMapping(
	        value = RestURIConstants.Delete_Order_Item,
	        		  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
	       	        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Object  addUpdateOrderItemDispatcher(@RequestBody DeleteOrderItemForm  deleteOrderItemForm) throws JSONException {
			
		ShopCartAPIForm	shopCartAPIForm=this.addCartService.prepareDeleteOrderItem(deleteOrderItemForm);
		if(shopCartAPIForm==null)
		{
	PaymentRespForm paymentRespForm=new PaymentRespForm();
	paymentRespForm.setRespCode("200");
	paymentRespForm.setRespDesc("Invalid Id");
	return paymentRespForm;
		}else
		{
		PaymentRespForm paymentRespForm=new PaymentRespForm();
		paymentRespForm.setRespCode("000");
		paymentRespForm.setRespDesc("Delete Success");
	return paymentRespForm;		
		}
		
		
	}
	
	@PostMapping(
	        value = RestURIConstants.Delete_All_Order_Item,
	        		  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
	       	        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Object  deleteAllOrderItemDispatcher(@RequestBody DeleteAllItemForm  deleteAllItemForm) throws JSONException {
			
		return this.addCartService.prepareDeleteAllItem(deleteAllItemForm);
		
	}
}
