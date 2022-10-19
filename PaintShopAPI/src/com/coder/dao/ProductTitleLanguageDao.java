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

import com.coder.model.AboutProductLanguage;
import com.coder.model.Language;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.ProductType;
import com.coder.model.ToolLanguage;
@Repository("productTitleLanguageDoa")
public class ProductTitleLanguageDao extends AbstractDao<Integer,ProductTitleLanguage>{
	
	public Object saveProductTitleLanguage(ProductTitleLanguage productTitleLanguage)
	{
	return (Object)super.persistMtoM(productTitleLanguage);
   
		}
	public ProductTitleLanguage getProductTitleLanguageById(int id){
		ProductTitleLanguage productTitleLanguage=super.criteriaQuerryGetObjectById(id,"productId");
		return productTitleLanguage;
		}
	public List<ProductTitleLanguage> getProductTitleLanguages() {
		List<ProductTitleLanguage> productTitleLanguages=(List<ProductTitleLanguage>)super.getAllEntity();
			return productTitleLanguages;
		}
    

   public Boolean deleteProductTitleLanguage(ProductTitleLanguage productTitleLanguage){
	  Boolean tf= super.delete(productTitleLanguage);
	  return tf;
   }
   public Boolean updateProductTitleLanguage(ProductTitleLanguage productTitleLanguage){
	 Boolean tf=super.update(productTitleLanguage);
	 return tf;
   }
   
   public ProductTitleLanguage getProductTitleLanguageByProduct(int productId,int languageId) {
		Transaction transaction=null;
		ProductTitleLanguage productTitleLanguage=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ProductTitleLanguage> rootProductTitleLanguage = criteriaQuery.from(ProductTitleLanguage.class);
	         criteriaQuery.multiselect(rootProductTitleLanguage);
	   	     criteriaQuery.where(builder.and(

	   	    		builder.equal(rootProductTitleLanguage.get("product").get("productId"),productId)),
	   	    		builder.equal(rootProductTitleLanguage.get("language").get("languageId"),languageId));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
		        	   productTitleLanguage=(ProductTitleLanguage)object;
		        	
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	  
	      return productTitleLanguage;
	   }
   public List<ProductTitleLanguage> getProductTitleLanguageByProduct(int productId) {
 		Transaction transaction=null;
 		List<ProductTitleLanguage> productTitleLanguages=new ArrayList<>();
 		ProductTitleLanguage productTitleLanguag=null;
 	      try ( Session    session=sessionFactory.openSession();) {
 	    	 transaction = session.beginTransaction();
 	         CriteriaBuilder builder = session.getCriteriaBuilder();
 	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
 	         Root<ProductTitleLanguage> rootProductTitleLanguage = criteriaQuery.from(ProductTitleLanguage.class);
 	         criteriaQuery.multiselect(rootProductTitleLanguage);
 	   	     criteriaQuery.where(
 	   	    		builder.equal(rootProductTitleLanguage.get("product").get("productId"),productId));
 	         Query<Object[]> query=session.createQuery(criteriaQuery);
 	         List<Object[]> list=query.getResultList();
 	         System.out.println("list.size()="+list.size());
 		         for (Object object : list) {
 		        	productTitleLanguag=(ProductTitleLanguage)object;
 		        	productTitleLanguages.add(productTitleLanguag);
 		        	
 	         }
 	         transaction.commit();
 	         session.close();
 	      } catch (Exception e) {
 	         e.printStackTrace();
 	         if (transaction != null) {
 	            transaction.rollback();
 	         }
 	      }
 	  
 	      return productTitleLanguages;
 	   }
   

}
