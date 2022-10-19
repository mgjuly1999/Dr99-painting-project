package com.coder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.MemberStatusDao;
import com.coder.form.MemberStatusForm;
import com.coder.model.MemberStatus;
import com.coder.registerForm.MemberStatusRegisterForm;

@Service
@Repository("memberStatusService")
public class MemberStatusService {
  @Autowired
  private MemberStatusDao  memberStatusDao;
	public void prepareMemberStatusRegister(MemberStatusRegisterForm memberStatusRegisterForm) {
	
		MemberStatusForm  memberStatusForm=memberStatusRegisterForm.getMemberStatusForm();
		if(memberStatusForm!=null)
		{
			MemberStatus memberStatus=new MemberStatus();
			memberStatus.setStatusName(memberStatusForm.getStatusName());
			memberStatus.setStatusDesc(memberStatusForm.getStatusDesc());
			this.memberStatusDao.saveMemberStatus(memberStatus);
		}
		
		List<MemberStatus> memberStatuss=this.memberStatusDao.getMemberStatuss();
		memberStatusRegisterForm.setMemberStatus(memberStatuss);
		
	}
	
	

}
