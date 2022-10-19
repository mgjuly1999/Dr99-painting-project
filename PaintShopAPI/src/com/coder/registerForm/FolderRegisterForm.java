package com.coder.registerForm;

import java.util.List;

import com.coder.form.FolderForm;
import com.coder.model.Folder;

public class FolderRegisterForm {
private FolderForm folderForm;
private List<Folder> folders;

public FolderForm getFolderForm() {
	return folderForm;
}
public void setFolderForm(FolderForm folderForm) {
	this.folderForm = folderForm;
}
public List<Folder> getFolders() {
	return folders;
}
public void setFolders(List<Folder> folders) {
	this.folders = folders;
}
}
