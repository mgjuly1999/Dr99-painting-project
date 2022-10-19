package com.coder.registerForm;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.apiForm.RegisterReturnForm;
import com.coder.form.MemberForm;


public class MemberRegisterForm {
	
private MemberForm memberForm;
private String message;
private RegisterReturnForm registerReturnForm;
private Map<String,String> mapMemberStatus=new HashedMap<String,String>();

public MemberForm getMemberForm() {
	return memberForm;
}

public void setMemberForm(MemberForm memberForm) {
	this.memberForm = memberForm;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public RegisterReturnForm getRegisterReturnForm() {
	return registerReturnForm;
}

public void setRegisterReturnForm(RegisterReturnForm registerReturnForm) {
	this.registerReturnForm = registerReturnForm;
}

public Map<String, String> getMapMemberStatus() {
	return mapMemberStatus;
}

public void setMapMemberStatus(Map<String, String> mapMemberStatus) {
	this.mapMemberStatus = mapMemberStatus;
}




}
