package com.coder.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AdminDao;
import com.coder.dao.AdminStatusDao;
import com.coder.form.AdminForm;
import com.coder.model.Admin;
import com.coder.model.AdminStatus;
import com.coder.registerForm.AdminRegisterForm;
@Service
@Repository("adminService")
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private  AdminStatusDao adminStatusDao;
	public void prepareAdminRegister(AdminRegisterForm adminRegisterForm){
		AdminForm adminForm=adminRegisterForm.getAdminForm();
		if(adminForm!=null)
		{
		this.adminRegister(adminRegisterForm);
		}
		adminRegisterForm.setAdminForm(new AdminForm());
		
 	}
	private int adminRegister(AdminRegisterForm adminRegisterForm){
		Admin admin=new Admin();
		
		AdminForm adminForm=adminRegisterForm.getAdminForm();
		AdminStatus adminStatus=this.adminStatusDao.getAdminStatusById(1);
		admin.setName(adminForm.getName());
		admin.setEmail(adminForm.getEmail());
		admin.setNrc(adminForm.getNrc());
		admin.setPassword(adminForm.getPassword());
		admin.setPhone(adminForm.getPhone());
		admin.setDescription(adminForm.getDescription());
		admin.setAdminStatus(adminStatus);
		admin.setGender(adminForm.getGender());
		admin.setCreateDate(new Date());
		int id=this.adminDao.saveAdmin(admin);
	return id; 
	}
	
	public Admin adminLogin(AdminRegisterForm adminRegisterForm){
		AdminForm adminForm=adminRegisterForm.getAdminForm();
		Admin admin=this.adminDao.adminLogin(adminForm.getEmail(),adminForm.getPassword());
	
		return admin;
		
	}


}
