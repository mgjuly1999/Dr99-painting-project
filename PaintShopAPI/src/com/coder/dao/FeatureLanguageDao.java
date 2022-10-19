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

import com.coder.model.FeatureLanguage;
import com.coder.model.GroupLanguage;
import com.coder.model.Language;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ToolLanguage;

@Repository("featureLanguageDao")
public class FeatureLanguageDao extends AbstractDao<Integer,FeatureLanguage>{
	
	public Object saveFeatureLanguage(FeatureLanguage featureLanguage)
	{
	return (Object)super.persistMtoM(featureLanguage);
   
		}
	public FeatureLanguage getFeatureLanguageById(int id){
		FeatureLanguage toolLanguage=super.criteriaQuerryGetObjectById(id,"toolLanguageId");
		return toolLanguage;
		}
	public List<FeatureLanguage> getFeatureLanguages() {
		List<FeatureLanguage> toolLanguages=(List<FeatureLanguage>)super.getAllEntity();
			return toolLanguages;
		}
    

   public Boolean deleteFeatureLanguage(FeatureLanguage featureLanguage){
	  Boolean tf= super.delete(featureLanguage);
	  return tf;
   }
   public Boolean updateFeatureLanguage(FeatureLanguage featureLanguage){
	 Boolean tf=super.update(featureLanguage);
	 return tf;
   }
   public List<FeatureLanguage> getFeatureLanguagesByProduct(int productId,int languageId){
		Transaction transaction=null;
				List<FeatureLanguage> featureLanguages=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Product> productRoot=criteriaQuery.from(Product.class);
	      
	         Join<Object,Object> featureJoin= productRoot.join("features");
	         Join<Object,Object> featureLanguageJoin= featureJoin.join("featureLanguages");
	         
	         criteriaQuery.multiselect(featureLanguageJoin);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(productRoot.get("productId"),productId),   
	   	    		 builder.equal(featureLanguageJoin.get("language").get("languageId"),languageId)
	   	    	));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	 
		       for (Object object : list) {
		    	  FeatureLanguage  featureLanguage=(FeatureLanguage)object;
		    	  featureLanguages.add(featureLanguage);
		          System.out.println("FeatureLanguage="+featureLanguage.getFeatureName());
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return featureLanguages;
	   }
   
   public List<FeatureLanguage> getFeatureLanguageByLanguage(Language language){
		Transaction transaction=null;
		List<FeatureLanguage> featureLanguages=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<FeatureLanguage> featureLanguageRoot = criteriaQuery.from(FeatureLanguage.class);
	         criteriaQuery.multiselect(featureLanguageRoot);
	   	     criteriaQuery.where(
	   	    		 builder.equal(featureLanguageRoot.get("language"),language)   
	   	    	);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
		        	 FeatureLanguage  featureLanguage=(FeatureLanguage)object;
	        	featureLanguages.add(featureLanguage);
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return featureLanguages;
	   }
   
   
}
