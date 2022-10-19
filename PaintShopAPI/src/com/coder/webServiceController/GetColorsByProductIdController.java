package com.coder.webServiceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coder.APIservice.ProductDetailsAPIService;
import com.coder.apiForm.APIProduct;
import com.coder.apiForm.ProductIdForm;
import com.coder.service.ColorService;
import com.coder.util.RestURIConstants;
import com.coder.form.ColorForm;

@RestController
@RequestMapping("/niponpain")
public class GetColorsByProductIdController {
	@Autowired 
	private ColorService  colorService;
	@PostMapping(
	        value = RestURIConstants.Get_Colors_By_Product_Id,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<ColorForm> getProductByProductId(@RequestBody ProductIdForm productIdForm) {
		
		String productId=productIdForm.getProductId();
		List<ColorForm> colorForms=colorService.getColorsByProductId(productId);
	        return colorForms;
	    }
}
