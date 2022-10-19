package com.coder.webServiceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.apiForm.ProductGroupForm;
import com.coder.apiForm.RegisterReturnForm;
import com.coder.form.MemberForm;
import com.coder.form.TypeLanguageForm;
import com.coder.registerForm.MemberRegisterForm;
import com.coder.service.MemberService;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class MemberRegisterWebServiceController {
@Autowired
private MemberService memberService;

@PostMapping(
        value = RestURIConstants.POST_Member_Register,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public RegisterReturnForm postSaveMember(@RequestBody MemberForm memberForm) {
	MemberRegisterForm memberRegisterForm=new MemberRegisterForm();
	memberRegisterForm.setMemberForm(memberForm);
	this.memberService.prepareMemberRegister(memberRegisterForm);
        return memberRegisterForm.getRegisterReturnForm();
    }

}
