package com.coder.webServiceController;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.APIservice.ProductTypeAPIService;
import com.coder.apiForm.ProductGroupForm;
import com.coder.form.GroupLanguageForm;
import com.coder.form.ProductTypeForm;
import com.coder.form.TypeLanguageForm;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.util.RestURIConstants;



@RestController
@RequestMapping("/niponpain")
public class ShowAllProductTypeWebServiceController {
	
	@Autowired
	private ProductTypeAPIService productTypeAPIService;

	@RequestMapping(value =RestURIConstants.GET_TYPES_BY_GROUP_ID, method = RequestMethod.GET)
  	public @ResponseBody List<TypeLanguageForm> getProductTypesByGroupId(@PathVariable("groupId")String groupId) {
		int id=Integer.parseInt(groupId);
    	List<TypeLanguageForm> typeLanguageForms=this.productTypeAPIService.getProductTypeLanguagesByGroupId(id);
  		return typeLanguageForms;
  	}
	
	@PostMapping(
	        value = RestURIConstants.POST_TYPES_BY_GROUP_ID,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	    public List<TypeLanguageForm> postProductTypesByGroupId(@RequestBody ProductGroupForm productGroupForm) {
		int id=Integer.parseInt(productGroupForm.getProductGroupId());
    	List<TypeLanguageForm> typeLanguageForms=this.productTypeAPIService.getProductTypeLanguagesByGroupId(id);
	        return typeLanguageForms;
	    }
	

	
}