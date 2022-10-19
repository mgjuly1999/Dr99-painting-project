package com.coder.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.GroupLanguage;
import com.coder.model.GroupLanguageId;
import com.coder.model.Language;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ProductType;

@Repository("groupLanguageDao")
public class GroupLanguageDao extends AbstractDao<GroupLanguageId,GroupLanguage>{
	
	public Object saveGroupLanguage(GroupLanguage groupLanguage)
	{
	return (Object)super.persistMtoM(groupLanguage);
   
		}
	public GroupLanguage getGroupLanguageById(int id){
		GroupLanguage groupLanguage=super.criteriaQuerryGetObjectById(id,"productGroupId");
		return groupLanguage;
		}
	public List<GroupLanguage> getGroupLanguages() {
		List<GroupLanguage> groupLanguages=(List<GroupLanguage>)super.getAllEntity();
			return groupLanguages;
		}
    

   public Boolean deleteGroupLanguage(GroupLanguage groupLanguage){
	  Boolean tf= super.delete(groupLanguage);
	  return tf;
   }
   public Boolean updateGroupLanguage(GroupLanguage groupLanguage){
	 Boolean tf=super.update(groupLanguage);
	 return tf;
   }
   public  List<GroupLanguage> getGroupLanguagesByLanguage(int languageId){
		Transaction transaction=null;
		List<GroupLanguage> groupLanguages=new ArrayList<>();
		GroupLanguage groupLanguage=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<GroupLanguage> groupLanguageRoot = criteriaQuery.from(GroupLanguage.class);
	         criteriaQuery.multiselect(groupLanguageRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(groupLanguageRoot.get("language").get("languageId"),languageId)
	   	    		 
		   	    	));
	   	     criteriaQuery.distinct(true);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
	         for (Object object : list) {
	        	
	        	  groupLanguage=(GroupLanguage)object;
	        	  groupLanguages.add(groupLanguage);
	        
	            
	           
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return groupLanguages;
	   }
   public  GroupLanguage getGroupLanguageByGroup(ProductGroup productGroup,Language language){
		Transaction transaction=null;
		GroupLanguage groupLanguage=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ProductGroup> productGroupRoot = criteriaQuery.from(ProductGroup.class);
	         Root<GroupLanguage> groupLanguageRoot = criteriaQuery.from(GroupLanguage.class);
	         criteriaQuery.multiselect(groupLanguageRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(groupLanguageRoot.get("language"),language),
	   	    		 builder.equal(groupLanguageRoot.get("productGroup"),productGroup)
	   	    		 ));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
	   
	         
	         for (Object object : list) {
	        	
	        	  groupLanguage=(GroupLanguage)object;
	        
	            
	           
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return groupLanguage;
	   }
   public  GroupLanguage getGroupLanguageByProductId(int productId,int languageId){
		Transaction transaction=null;
		GroupLanguage groupLanguage=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Product> productRoot = criteriaQuery.from(Product.class);
	         Root<ProductType> productTypeRoot = criteriaQuery.from(ProductType.class);
	         Root<ProductGroup> productGroupRoot = criteriaQuery.from(ProductGroup.class);
	         Root<GroupLanguage> groupLanguageRoot = criteriaQuery.from(GroupLanguage.class);
	         criteriaQuery.multiselect(groupLanguageRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		builder.equal(productRoot.get("productId"),productId),
	   	    		builder.equal(productTypeRoot.get("productTypeId"),productRoot.get("productType").get("productTypeId")),
	   	    		builder.equal(productTypeRoot.get("productGroup"),productGroupRoot.get("productGroupId")),
	   	    		builder.equal(groupLanguageRoot.get("productGroup"),productGroupRoot),
	   	    		builder.equal(groupLanguageRoot.get("language").get("languageId"),languageId)
	   	    		 ));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
	         for (Object object : list) {
	        	  groupLanguage=(GroupLanguage)object;
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
		         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return groupLanguage;
	   }
   
}
