package com.coder.registerForm;

import com.coder.apiForm.MemberLoginFrom;
import com.coder.apiForm.RegisterReturnForm;
import com.coder.model.Member;

public class PreMemberLoginForm {
private MemberLoginFrom memberLoginForm;
private Member member;
private RegisterReturnForm  registerReturnForm;

public MemberLoginFrom getMemberLoginForm() {
	return memberLoginForm;
}

public void setMemberLoginForm(MemberLoginFrom memberLoginForm) {
	this.memberLoginForm = memberLoginForm;
}

public Member getMember() {
	return member;
}

public void setMember(Member member) {
	this.member = member;
}

public RegisterReturnForm getRegisterReturnForm() {
	return registerReturnForm;
}

public void setRegisterReturnForm(RegisterReturnForm registerReturnForm) {
	this.registerReturnForm = registerReturnForm;
}
}
