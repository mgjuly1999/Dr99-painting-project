package com.coder.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coder.apiForm.ApiMemberForm;
import com.coder.apiForm.MemberLoginFrom;
import com.coder.apiForm.RegisterReturnForm;
import com.coder.dao.AdminDao;
import com.coder.dao.AdminStatusDao;
import com.coder.dao.MemberDao;
import com.coder.dao.MemberStatusDao;
import com.coder.form.AdminForm;
import com.coder.form.MemberForm;
import com.coder.form.ShowAllMemberForm;
import com.coder.model.Admin;
import com.coder.model.AdminStatus;
import com.coder.model.Member;
import com.coder.model.MemberStatus;
import com.coder.registerForm.AdminRegisterForm;
import com.coder.registerForm.MemberRegisterForm;
import com.coder.registerForm.PreMemberLoginForm;
import com.coder.util.FileUpload;
import com.coder.util.RestURIConstants;
import com.coder.util.ServerPath;
@Service
@Repository("memberService")
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private  MemberStatusDao memberStatusDao;
	
	public void prepareMemberRegister(MemberRegisterForm memberRegisterForm){
		MemberForm memberForm=memberRegisterForm.getMemberForm();
		if(memberForm!=null){
			System.out.println(memberForm.toString());
		this.memberRegister(memberRegisterForm);
		
		
		}
		List<MemberStatus> memberStatus=this.memberStatusDao.getMemberStatuss();
		for(MemberStatus  memberStatu : memberStatus)
		{
			memberRegisterForm.getMapMemberStatus().put(memberStatu.getMemberStatusId()+"",
					memberStatu.getStatusName());
		}
	
		
		
		memberRegisterForm.setMemberForm(new MemberForm());
		
 	}
	private int memberRegister(MemberRegisterForm memberRegisterForm){
		Member member=new Member();
		MemberForm memberForm=memberRegisterForm.getMemberForm();
		MemberStatus memberStatus=this.memberStatusDao.getMemberStatusById(1);
		member.setName(memberForm.getName());
		member.setPassword(memberForm.getPassword());
		member.setPhone(memberForm.getPhone());
		member.setMemberStatus(memberStatus);
		member.setMail(memberForm.getMail());
		member.setAddress(memberForm.getAddress());
		member.setNote(memberForm.getName());
		member.setCreateDate(new Date());
		int id=-1;
		try{
		 id=this.memberDao.saveMember(member);
				
			 MultipartFile multipartFile=memberForm.getMultipartFile();
			
	       if(multipartFile!=null&&(!multipartFile.isEmpty())){
	         	
	       		FileUpload.uploadFile(multipartFile,id+"","member");
	       		RegisterReturnForm  registerReturnForm=new RegisterReturnForm();
	       		registerReturnForm.setRespDescription("Success");
	       		registerReturnForm.setRespCode("200");
	       		memberRegisterForm.setRegisterReturnForm(registerReturnForm);
	       }
	     
		}catch (Exception e) {
			RegisterReturnForm  registerReturnForm=new RegisterReturnForm();
       		registerReturnForm.setRespDescription("Fail");
       		registerReturnForm.setRespCode("100");
       		memberRegisterForm.setRegisterReturnForm(registerReturnForm);
       		
       		
		}
	return id; 
	}
	
	public void showAllMember(ShowAllMemberForm showAllMemberForm) {
		
		List<Member> members=this.memberDao.getMembers();
		List<ApiMemberForm> apiMemberList=new ArrayList<ApiMemberForm>();
		
		for(Member member : members)
		{
			ApiMemberForm apiMemberForm=new ApiMemberForm();
			
			MemberStatus memberStatus=this.memberStatusDao.getMemberStatusById(member.getMemberStatus().getMemberStatusId());
			
			apiMemberForm.setMemberId(member.getMemberId()+"");
			apiMemberForm.setName(member.getName());
			apiMemberForm.setMail(member.getMail());
			apiMemberForm.setMemberStatus(memberStatus.getStatusName());
			apiMemberForm.setPassword(member.getPassword());
			apiMemberForm.setPhone(member.getPhone());
			apiMemberForm.setAddress(member.getAddress());
			apiMemberForm.setNote(member.getNote());
			apiMemberForm.setCreateDate(member.getCreateDate().toString());
			apiMemberForm.setImageUrl(
					RestURIConstants.GET_HOSTING_PATH+
					"/memberImageUploadPath?"+"id="+
					member.getMemberId()+"&frmType=0&frmImage=1");
		
			apiMemberList.add(apiMemberForm);
			
		}
		
		showAllMemberForm.setApiMemberList(apiMemberList);
		
	}
	public void prepareMemberLogin(PreMemberLoginForm preMemberLoginForm) {
	
		MemberLoginFrom memberLoginForm=preMemberLoginForm.getMemberLoginForm();
		Member member=this.memberDao.memberLogin(memberLoginForm.getMail(),memberLoginForm.getPassword());
		preMemberLoginForm.setMember(member);
		
		if(member!=null)
		{
			RegisterReturnForm  registerReturnForm=new RegisterReturnForm();
			registerReturnForm.setRespCode("200");
			registerReturnForm.setRespDescription("Success");
			
			ApiMemberForm	apiMemberForm=new ApiMemberForm();
			MemberStatus memberStatus=this.memberStatusDao.getMemberStatusById(member.getMemberStatus().getMemberStatusId());
		
			apiMemberForm.setMemberId(member.getMemberId()+"");
			apiMemberForm.setName(member.getName());
			apiMemberForm.setMail(member.getMail());
			apiMemberForm.setMemberStatus(memberStatus.getStatusName());
			apiMemberForm.setPassword(member.getPassword());
			apiMemberForm.setPhone(member.getPhone());
			apiMemberForm.setAddress(member.getAddress());
			apiMemberForm.setNote(member.getNote());
			apiMemberForm.setCreateDate(member.getCreateDate().toString());
			apiMemberForm.setImageUrl(
					RestURIConstants.GET_HOSTING_PATH+
					"/memberImageUploadPath?"+"id="+
					member.getMemberId()+"&frmType=0&frmImage=1");
		
			
			registerReturnForm.setApiMemberForm(apiMemberForm);
			preMemberLoginForm.setRegisterReturnForm(registerReturnForm);
		}else
		{
			RegisterReturnForm  registerReturnForm=new RegisterReturnForm();
			registerReturnForm.setRespCode("000");
			registerReturnForm.setRespDescription("Fail");
			registerReturnForm.setApiMemberForm(null);
			preMemberLoginForm.setRegisterReturnForm(registerReturnForm);

		}
		
		
	}

}
