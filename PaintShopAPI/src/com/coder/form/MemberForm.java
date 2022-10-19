package com.coder.form;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.coder.model.MemberStatus;


public class MemberForm {
	
	private String memberId;
	private String memberStatusId;
	private String name;
	private String phone;
	private String password;
	private String mail;
	private String address;
	private String note;
	private MultipartFile multipartFile;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getMemberStatusId() {
		return memberStatusId;
	}
	public void setMemberStatusId(String memberStatusId) {
		this.memberStatusId = memberStatusId;
	}
	
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "MemberForm [memberId=" + memberId + ", memberStatusId=" + memberStatusId + ", name=" + name + ", phone="
				+ phone + ", password=" + password + ", mail=" + mail + ", address=" + address + ", note=" + note
				+ ", multipartFile=" + multipartFile + "]";
	}
	
	
	
}
