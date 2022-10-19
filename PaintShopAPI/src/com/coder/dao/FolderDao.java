package com.coder.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.Folder;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ProductType;

@Repository("folderDao")
public class FolderDao  extends AbstractDao<Integer,Folder>{

	public Integer saveFolder(Folder folder)
	{
	return (Integer)super.persist(folder);
   
		}
	public Folder getFolderById(int id){
		Folder folder=super.criteriaQuerryGetObjectById(id,"folderId");
		return folder;
		}
	public List<Folder> getFolders() {
		List<Folder> folders=(List<Folder>)super.getAllEntity();
			return folders;
		}
    

   public Boolean deleteFolder(Folder folder){
	  Boolean tf= super.delete(folder);
	  return tf;
   }
   public Boolean updateFolder(Folder folder){
	 Boolean tf=super.update(folder);
	 return tf;
   }


		
	
}
