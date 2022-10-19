package com.coder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.FolderDao;
import com.coder.form.FolderForm;
import com.coder.model.Folder;
import com.coder.registerForm.FolderRegisterForm;

@Service
@Repository("folderService")
public class FolderService {
	@Autowired
	private FolderDao folderDao;

	public void prepareFolderRegister(FolderRegisterForm folderRegisterForm) {
	
		FolderForm folderForm=folderRegisterForm.getFolderForm();
		if(folderForm!=null)
		{
			Folder folder=new Folder();
			folder.setName(folderForm.getName());
			this.folderDao.saveFolder(folder);
		}
		
		List<Folder> folders=this.folderDao.getFolders();
		folderRegisterForm.setFolders(folders);
		
	}
	
	
}
