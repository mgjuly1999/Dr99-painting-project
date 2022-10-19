package com.coder.webServiceController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.apiForm.ApiMemberForm;
import com.coder.form.GroupLanguageForm;
import com.coder.form.ShowAllMemberForm;
import com.coder.model.Member;
import com.coder.registerForm.ProductGroupRegisterForm;
import com.coder.service.MemberService;
import com.coder.service.ProductGroupService;
import com.coder.util.RestURIConstants;

@RestController
@RequestMapping("/niponpain")
public class ShowAllMemberWebServiceAPI {

	@Autowired
	private MemberService memberService;
	
	 
	
	 @RequestMapping(value =RestURIConstants.GET_ALL_MEMBER, method = RequestMethod.GET)
	public @ResponseBody List<ApiMemberForm> getAllMember(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) {
	
		ShowAllMemberForm showAllMemberForm=new ShowAllMemberForm();
		memberService.showAllMember(showAllMemberForm);
		
		
		return showAllMemberForm.getApiMemberList();
	}
	
}
