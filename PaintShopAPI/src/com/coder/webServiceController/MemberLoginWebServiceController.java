package com.coder.webServiceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.APIservice.ProductTypeAPIService;
import com.coder.apiForm.MemberLoginFrom;
import com.coder.apiForm.RegisterReturnForm;
import com.coder.form.MemberForm;
import com.coder.registerForm.MemberRegisterForm;
import com.coder.registerForm.PreMemberLoginForm;
import com.coder.service.MemberService;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class MemberLoginWebServiceController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping(
	        value = RestURIConstants.POST_Member_Login,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	   
	public RegisterReturnForm postSaveMember(@RequestBody MemberLoginFrom memberLoginFrom) {
		PreMemberLoginForm preMemberLoginForm=new PreMemberLoginForm();
		preMemberLoginForm.setMemberLoginForm(memberLoginFrom);
		this.memberService.prepareMemberLogin(preMemberLoginForm);
		
	        return preMemberLoginForm.getRegisterReturnForm();
	    }
	
}
