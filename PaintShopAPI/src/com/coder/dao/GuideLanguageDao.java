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

import com.coder.model.GroupLanguage;
import com.coder.model.GuideLanguage;
import com.coder.model.Language;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ToolLanguage;

@Repository("guideLanguageDao")
public class GuideLanguageDao extends AbstractDao<Integer,GuideLanguage>{
	
	public Object saveToolLanguage(GuideLanguage toolLanguage)
	{
	return (Object)super.persistMtoM(toolLanguage);
   
		}
	public GuideLanguage getToolLanguageById(int id){
		GuideLanguage toolLanguage=super.criteriaQuerryGetObjectById(id,"toolLanguageId");
		return toolLanguage;
		}
	public List<GuideLanguage> getToolLanguages() {
		List<GuideLanguage> toolLanguages=(List<GuideLanguage>)super.getAllEntity();
			return toolLanguages;
		}
    

   public Boolean deleteGuideLanguage(GuideLanguage groupLanguage){
	  Boolean tf= super.delete(groupLanguage);
	  return tf;
   }
   public Boolean updateGuideLanguage(GuideLanguage groupLanguage){
	 Boolean tf=super.update(groupLanguage);
	 return tf;
   }
   public List<GuideLanguage> getGuideLanguagesByLanguage(int languageId){
		Transaction transaction=null;
		List<GuideLanguage> guideLanguages=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<GuideLanguage> guideLanguageRoot = criteriaQuery.from(GuideLanguage.class);
	         criteriaQuery.multiselect(guideLanguageRoot);
	   	     criteriaQuery.where(
	   	    		 builder.equal(guideLanguageRoot.get("language").get("languageId"),languageId)   
	   	    	);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
		        	 GuideLanguage  guideLanguage=(GuideLanguage)object;
	        	guideLanguages.add(guideLanguage);
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return guideLanguages;
	   }
   
   public List<GuideLanguage> getGuideLanguagesByProduct(int productId,Language language){
 		Transaction transaction=null;
 				List<GuideLanguage> guideLanguages=new ArrayList<>();
 	      try ( Session    session=sessionFactory.openSession();) {
 	    	 transaction = session.beginTransaction();
 	         CriteriaBuilder builder = session.getCriteriaBuilder();
 	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
 	         Root<Product> productRoot=criteriaQuery.from(Product.class);
 	      
 	         Join<Object,Object> guideJoin=productRoot.join("guides");
 	         Join<Object,Object> guideLanguageJoin=guideJoin.join("guideLanguages");
 	         
 	         criteriaQuery.multiselect(guideLanguageJoin);
 	   	     criteriaQuery.where(builder.and(
 	   	    		 builder.equal(productRoot.get("productId"),productId),   
 	   	    		 builder.equal(guideLanguageJoin.get("language"),language)
 	   	    	));
 	         Query<Object[]> query=session.createQuery(criteriaQuery);
 	         List<Object[]> list=query.getResultList();
 	 
 		       for (Object object : list) {
 		    	   GuideLanguage  guideLanguage=(GuideLanguage)object;
 		    	   guideLanguages.add(guideLanguage);
 		          System.out.println("guideLanguage="+guideLanguage.getGuideValue());
 	         }
 	         transaction.commit();
 	         session.close();
 	      } catch (Exception e) {
 	         e.printStackTrace();
 	         if (transaction != null) {
 	            transaction.rollback();
 	         }
 	      }
 	      return guideLanguages;
 	   }
   
   
}
