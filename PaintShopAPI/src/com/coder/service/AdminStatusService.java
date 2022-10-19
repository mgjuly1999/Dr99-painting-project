package com.coder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AdminStatusDao;
import com.coder.form.AdminStatusForm;
import com.coder.model.AdminStatus;
import com.coder.registerForm.AdminStatusRegisterForm;

@Service
@Repository("adminStatusService")
public class AdminStatusService {
	@Autowired
	private AdminStatusDao  adminStatusDao;

	public void prepareAdminStatusRegister(AdminStatusRegisterForm adminStatusRegisterForm) {
		AdminStatusForm adminStatusForm=adminStatusRegisterForm.getAdminStatusForm();
		if(adminStatusForm!=null)
		{
			AdminStatus adminStatus=new AdminStatus();
			adminStatus.setStatusName(adminStatusForm.getStatusName());
			adminStatus.setStatusDesc(adminStatusForm.getStatusDesc());
			this.adminStatusDao.saveAdminStatus(adminStatus);

		}
		adminStatusRegisterForm.setAdminStatuss(this.adminStatusDao.getAdminStatuss());
	}

}
