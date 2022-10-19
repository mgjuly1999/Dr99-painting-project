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
import com.coder.apiForm.GetAllProductForm;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class ProductDetailsServiceController {
	@Autowired 
	private ProductDetailsAPIService  productDetailsAPIService;
	@PostMapping(
	        value = RestURIConstants.GET_ALL_Products_By_Type,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<APIProduct> postSaveMember(@RequestBody GetAllProductForm getAllProductForm) {
		
		String typeId=getAllProductForm.getTypeId();
		List<APIProduct> aPIProducts=productDetailsAPIService.getAllProductsByTypeId(typeId);
	        return aPIProducts;
	    }
}
