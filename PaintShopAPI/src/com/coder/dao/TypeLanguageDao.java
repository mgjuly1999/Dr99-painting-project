package com.coder.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.GroupLanguage;
import com.coder.model.Language;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ProductType;
import com.coder.model.TypeLanguage;
import com.coder.model.TypeLanguageId;
@Repository("typeLanguageDao")
public class TypeLanguageDao extends AbstractDao<TypeLanguageId,TypeLanguage>{
	
	public Object saveTypeLanguage(TypeLanguage typeLanguage)
	{
	return (Object)super.persistMtoM(typeLanguage);
   
		}
	
	public TypeLanguage getTypeLanguageById(int languageId,ProductType productType){
		
		Transaction transaction=null;
		
		TypeLanguage typeLanguage=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object> criteriaQuery = builder.createQuery(Object.class);
	         Root<TypeLanguage> typeLanguageRoot = criteriaQuery.from(TypeLanguage.class);
	         criteriaQuery.multiselect(typeLanguageRoot);
	   	     criteriaQuery.where(
	   	    		builder.equal(typeLanguageRoot.get("productType").get("productTypeId"),productType.getProductTypeId()),
	    			builder.equal(typeLanguageRoot.get("language").get("languageId"),languageId)
	   	    	
	                 );
	         Query<Object> query=session.createQuery(criteriaQuery);
	         List<Object> list=query.getResultList();
	      

	         for (Object object : list) {
	        	
	        	  typeLanguage=(TypeLanguage)object;
	         
	           
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return typeLanguage;
		}
	
	public List<TypeLanguage> getTypeLanguages() {
		List<TypeLanguage> typeLanguages=(List<TypeLanguage>)super.getAllEntity();
			return typeLanguages;
		}
    

   public Boolean deleteTypeLanguage(TypeLanguage typeLanguage){
	  Boolean tf= super.delete(typeLanguage);
	  return tf;
   }
   public Boolean updateTypeLanguage(TypeLanguage typeLanguage){
	 Boolean tf=super.update(typeLanguage);
	 return tf;
   }
   public  List<TypeLanguage> getTypeLanguagesByLanguage(int languageId){
 		Transaction transaction=null;
 		List<TypeLanguage> typeLanguages=new ArrayList<>();
 		TypeLanguage typeLanguage=null;
 	      try ( Session    session=sessionFactory.openSession();) {
 	    	   transaction = session.beginTransaction();
 	         CriteriaBuilder builder = session.getCriteriaBuilder();
 	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
 	        Root<Language> languageRoot=criteriaQuery.from(Language.class);
 	         Root<TypeLanguage> typeLanguageRoot=criteriaQuery.from(TypeLanguage.class);
 	         criteriaQuery.multiselect(typeLanguageRoot);
 	   	     criteriaQuery.where(builder.and(
 	   	    		 builder.equal(languageRoot.get("languageId"),languageId),
 	   	    	     builder.equal(typeLanguageRoot.get("language"),languageRoot)
 		   	    	));
 	         Query<Object[]> query=session.createQuery(criteriaQuery);
 	         List<Object[]> list=query.getResultList();
 	         System.out.println("list.size()="+list.size());
 	         for (Object object : list) {
  	        	  typeLanguage=(TypeLanguage)object;
  	        	typeLanguages.add(typeLanguage);
  	         }
 	         transaction.commit();
 	         session.close();
 	      } catch (Exception e) {
 	         e.printStackTrace();
  	         if (transaction != null) {
 	            transaction.rollback();
 	         }
 	      }
 	      return typeLanguages;
 	   }
   public  List<TypeLanguage> getTypeLanguageByGroup(ProductGroup productGroup,int languageId){
		Transaction transaction=null;
		List<TypeLanguage> typeLanguages=new ArrayList<>();
		TypeLanguage typeLanguage=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ProductType> productTypeRoot = criteriaQuery.from(ProductType.class);
	         Root<TypeLanguage> typeLanguageRoot = criteriaQuery.from(TypeLanguage.class);
	         criteriaQuery.multiselect(typeLanguageRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(productTypeRoot.get("productGroup"),productGroup),
	   	    		 builder.equal(typeLanguageRoot.get("productType"),productTypeRoot.get("productTypeId")),
	   	    		 builder.equal(typeLanguageRoot.get("language").get("languageId"),languageId)
		   	    	));
	   	     criteriaQuery.distinct(true);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	        
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
	   	         for (Object object : list) {
		        	  typeLanguage=(TypeLanguage)object;
	        	      typeLanguages.add(typeLanguage);
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return typeLanguages;
	   }
   public  TypeLanguage getTypeLanguageByType(int productTypeId,int languageId){
		Transaction transaction=null;
		
		TypeLanguage typeLanguage=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ProductType> productTypeRoot = criteriaQuery.from(ProductType.class);
	         Root<TypeLanguage> typeLanguageRoot = criteriaQuery.from(TypeLanguage.class);
	         criteriaQuery.multiselect(typeLanguageRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(productTypeRoot.get("productTypeId"),productTypeId),
	   	    		 builder.equal(typeLanguageRoot.get("productType"),productTypeRoot),
	   	    		 builder.equal(typeLanguageRoot.get("language").get("languageId"),languageId)
		   	    	));
	   	     criteriaQuery.distinct(true);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	        
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
	   	         for (Object object : list) {
		        	  typeLanguage=(TypeLanguage)object;
	        	  
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return typeLanguage;
	   }
   public  TypeLanguage getTypeLanguageByProductId(int productId,int languageId){
		Transaction transaction=null;
		
		TypeLanguage typeLanguage=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ProductType> productTypeRoot = criteriaQuery.from(ProductType.class);
	         Root<Product> productRoot = criteriaQuery.from(Product.class);
	         Root<TypeLanguage> typeLanguageRoot = criteriaQuery.from(TypeLanguage.class);
	         criteriaQuery.multiselect(typeLanguageRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		builder.equal(productRoot.get("productId"),productId),
	   	    		 builder.equal(productTypeRoot.get("productTypeId"),productRoot.get("productType").get("productTypeId")),
	   	    		 builder.equal(typeLanguageRoot.get("productType"),productTypeRoot),
	   	    		 builder.equal(typeLanguageRoot.get("language").get("languageId"),languageId)
		   	    	));
	   	     criteriaQuery.distinct(true);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	        
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
	   	         for (Object object : list) {
		        	  typeLanguage=(TypeLanguage)object;
	        	  
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return typeLanguage;
	   }
  
   
}
