package com.coder.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.AdminStatusForm;
import com.coder.form.FolderForm;
import com.coder.form.MemberStatusForm;
import com.coder.form.ProductQualityForm;
import com.coder.model.MemberStatus;
import com.coder.registerForm.AdminStatusRegisterForm;
import com.coder.registerForm.FolderRegisterForm;
import com.coder.registerForm.LanguageRegisterForm;
import com.coder.registerForm.MemberStatusRegisterForm;
import com.coder.registerForm.ProductQualityRegisterForm;
import com.coder.registerForm.ProductStatusRegisterForm;
import com.coder.service.AdminStatusService;
import com.coder.service.FolderService;
import com.coder.service.LanguageService;
import com.coder.service.MemberStatusService;
import com.coder.service.ProductQualityService;
import com.coder.service.ProductStatusService;
@Controller
@Transactional
public class FolderRegisterController {
	@Autowired
	private FolderService folderService;
	@RequestMapping("/folderRegisterPath")
	public String memberStatusRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		FolderRegisterForm folderRegisterForm=new FolderRegisterForm();
		folderService.prepareFolderRegister(folderRegisterForm);
		modelMap.addAttribute("folderForm",new FolderForm());
		modelMap.addAttribute("folderRegisterForm",folderRegisterForm);
		return "ImageFloderRegister";
	}
	
	@RequestMapping("/folderRegisterSubmit")
	public String memberStatusRegisterSubmitDispatcher(@ModelAttribute("folderForm")FolderForm folderForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		
		FolderRegisterForm folderRegisterForm=new FolderRegisterForm();
		folderRegisterForm.setFolderForm(folderForm);
		folderService.prepareFolderRegister(folderRegisterForm);
		modelMap.addAttribute("folderForm",new FolderForm());
		modelMap.addAttribute("folderRegisterForm",folderRegisterForm);
		return "ImageFloderRegister";
		
	
	}
	
}
