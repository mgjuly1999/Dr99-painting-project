package com.coder.webServiceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coder.APIservice.ProductDetailsAPIService;
import com.coder.apiForm.APIProduct;
import com.coder.apiForm.ProductIdForm;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class GetProductByProductIdWebServiceController {
	@Autowired 
	private ProductDetailsAPIService  productDetailsAPIService;
	@PostMapping(
	        value = RestURIConstants.Get_Product_By_Id,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public APIProduct getProductByProductId(@RequestBody ProductIdForm productIdForm) {
		
		String productId=productIdForm.getProductId();
		APIProduct aPIProduct=productDetailsAPIService.getProductsById(productId);
	        return aPIProduct;
	    }
}
