package com.coder.webServiceController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.apiForm.InvoiceAPIForm;
import com.coder.apiForm.InvoiceIdForm;
import com.coder.apiForm.MyOrderAPIForm;
import com.coder.form.MemberIdForm;
import com.coder.form.OrderHistory;
import com.coder.registerForm.InvoiceDetailsForm;
import com.coder.service.OrderFormService;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class OrderHistoryController {
	
	@Autowired 
	private OrderFormService   orderFormService;
	@PostMapping(
	        value = RestURIConstants.Get_Order_Form_By_member_Id,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<MyOrderAPIForm> getMyOrderAPIId(@RequestBody MemberIdForm memberIdForm) {
		
		String memberId=memberIdForm.getMemberId();
		List<MyOrderAPIForm> myOrderAPIForms=orderFormService.getOrderHistorysByMemberId(memberId);
	        return myOrderAPIForms;
	        
	    }
	
	@PostMapping(
	        value = RestURIConstants.get_Invoice_By_id,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public InvoiceAPIForm  orderFormDetailsAPIDispatcher(@RequestBody InvoiceIdForm invoiceIdForm ,ModelMap modelMap, HttpServletRequest req, HttpServletResponse resp) {
	
		String orderFormId=invoiceIdForm.getInvoiceId();
		InvoiceAPIForm  invoiceAPIForm=new InvoiceAPIForm();
		invoiceAPIForm.setInvoiceId(orderFormId);
		orderFormService.preparenInvoiceAPIDetails(invoiceAPIForm);
		
		
		return invoiceAPIForm;
	}
}
