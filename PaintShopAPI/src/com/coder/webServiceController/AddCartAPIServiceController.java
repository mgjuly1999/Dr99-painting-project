package com.coder.webServiceController;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.apiForm.AddCartAPIForm;
import com.coder.apiForm.CartErrorForm;
import com.coder.apiForm.CartItem;
import com.coder.apiForm.CheckOutAPIForm;
import com.coder.apiForm.InvoiceIdForm;
import com.coder.apiForm.MemberIdForm;
import com.coder.apiForm.OrderItem;
import com.coder.apiForm.ShopCartAPIForm;
import com.coder.form.PaymentRespForm;
import com.coder.service.AddCartService;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class AddCartAPIServiceController {
	
	@Autowired
	private AddCartService addCartService;
	
	@PostMapping(
	        value = RestURIConstants.Add_to_cart,
	        		  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
	       	        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Object  addShppingCartDispatcher(@RequestBody AddCartAPIForm  addCartAPIForm) throws JSONException {
			
		ShopCartAPIForm	shopCartAPIForm=this.addCartService.prepareAddToCart(addCartAPIForm);
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
		paymentRespForm.setRespDesc("Success Add Cart");
	return paymentRespForm;		
		}
	
		
	}
	
	@PostMapping(
	        value = RestURIConstants.get_All_order_item_By_invoice_id,
	        		  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
	       	        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Object  getInvoiceByInvoiceId(@RequestBody InvoiceIdForm  invoiceIdForm) throws JSONException 
	{
		ShopCartAPIForm	shopCartAPIForm=this.addCartService.prepareInvoiceIdForm(invoiceIdForm);
		if(shopCartAPIForm==null)
		{
	CartErrorForm cartErrorForm=new CartErrorForm();
	cartErrorForm.setRespCode("200");
	cartErrorForm.setRespDesc("Invalid Invoice Id");
	return cartErrorForm;
		}
		return shopCartAPIForm;
	}
	
	@PostMapping(
	        value = RestURIConstants.get_All_order_item_By_member_id,
	        		  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
	       	        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Object  getInvoiceByMemberId(@RequestBody MemberIdForm  memberIdForm) throws JSONException 
	{
		ShopCartAPIForm	shopCartAPIForm=this.addCartService.prepareGetInvoiceByMemberId(memberIdForm);
		if(shopCartAPIForm==null)
		{
	CartErrorForm cartErrorForm=new CartErrorForm();
	cartErrorForm.setRespCode("200");
	cartErrorForm.setRespDesc("No Order Items Member");
	return cartErrorForm;
		}
		return shopCartAPIForm;
	}
	
}
