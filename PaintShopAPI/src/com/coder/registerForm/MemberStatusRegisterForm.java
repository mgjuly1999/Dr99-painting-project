package com.coder.registerForm;

import java.util.List;

import com.coder.form.MemberStatusForm;
import com.coder.model.MemberStatus;

public class MemberStatusRegisterForm {
	
	private MemberStatusForm memberStatusForm;
	private List<MemberStatus>  memberStatus;

	public MemberStatusForm getMemberStatusForm() {
		return memberStatusForm;
	}

	public void setMemberStatusForm(MemberStatusForm memberStatusForm) {
		this.memberStatusForm = memberStatusForm;
	}

	public List<MemberStatus> getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(List<MemberStatus> memberStatus) {
		this.memberStatus = memberStatus;
	}
}
