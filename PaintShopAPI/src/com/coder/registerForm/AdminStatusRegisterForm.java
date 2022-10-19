package com.coder.registerForm;

import java.util.List;

import com.coder.form.AdminStatusForm;
import com.coder.model.AdminStatus;

public class AdminStatusRegisterForm {
	
	private AdminStatusForm adminStatusForm;
	private List<AdminStatus> adminStatuss;
	
	public AdminStatusForm getAdminStatusForm() {
		return adminStatusForm;
	}

	public void setAdminStatusForm(AdminStatusForm adminStatusForm) {
		this.adminStatusForm = adminStatusForm;
	}

	public List<AdminStatus> getAdminStatuss() {
		return adminStatuss;
	}

	public void setAdminStatuss(List<AdminStatus> adminStatuss) {
		this.adminStatuss = adminStatuss;
	}
}
