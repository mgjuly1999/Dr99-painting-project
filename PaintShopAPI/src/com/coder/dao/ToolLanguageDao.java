package com.coder.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.FreeTool;
import com.coder.model.GroupLanguage;
import com.coder.model.Language;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ToolLanguage;
import com.coder.model.TypeLanguage;

@Repository("toolLanguageDao")
public class ToolLanguageDao extends AbstractDao<Integer,ToolLanguage>{
	
	public Object saveToolLanguage(ToolLanguage toolLanguage)
	{
	return (Object)super.persistMtoM(toolLanguage);
   
		}
	public ToolLanguage getToolLanguageById(int id){
		ToolLanguage toolLanguage=super.criteriaQuerryGetObjectById(id,"toolLanguageId");
		return toolLanguage;
		}
	public List<ToolLanguage> getToolLanguages() {
		List<ToolLanguage> toolLanguages=(List<ToolLanguage>)super.getAllEntity();
			return toolLanguages;
		}
    

   public Boolean deleteToolLanguage(ToolLanguage groupLanguage){
	  Boolean tf= super.delete(groupLanguage);
	  return tf;
   }
   public Boolean updateToolLanguage(ToolLanguage groupLanguage){
	 Boolean tf=super.update(groupLanguage);
	 return tf;
   }
   public List<ToolLanguage> getToolLanguagesByLanguage(int languageId){
		Transaction transaction=null;
		List<ToolLanguage> toolLanguages=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ToolLanguage> tooLanguageRoot = criteriaQuery.from(ToolLanguage.class);
	         criteriaQuery.multiselect(tooLanguageRoot);
	   	     criteriaQuery.where(
	   	    		 builder.equal(tooLanguageRoot.get("language").get("languageId"),languageId)   
	   	    	);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
	        	ToolLanguage  toolLanguage=(ToolLanguage)object;
	            toolLanguages.add(toolLanguage);
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return toolLanguages;
	   }
   
   public List<ToolLanguage> getToolLanguagesByProduct(int productId,Language language){
		Transaction transaction=null;
				List<ToolLanguage> toolLanguages=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Product> productRoot=criteriaQuery.from(Product.class);
	      
	         Join<Object,Object> freeToolJoin= productRoot.join("freeTools");
	         Join<Object,Object> toolLanguageJoin= freeToolJoin.join("toolLanguages");
	         
	         criteriaQuery.multiselect(toolLanguageJoin);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(productRoot.get("productId"),productId),   
	   	    		 builder.equal(toolLanguageJoin.get("language"),language)
	   	    	));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	 
		       for (Object object : list) {
		    	  ToolLanguage  toolLanguage=(ToolLanguage)object;
		          toolLanguages.add(toolLanguage);
		        	System.out.println("toolLanguage="+toolLanguage.getToolName());
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return toolLanguages;
	   }

   
   
}
