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

import com.coder.model.Color;
import com.coder.model.FreeTool;
import com.coder.model.Product;
import com.coder.model.ToolLanguage;
@Repository("freeToolDao")
public class FreeToolDao extends AbstractDao<Integer,FreeTool>{
	
	public Integer saveFreeTool(FreeTool freeTool)
	{
	return (Integer)super.persist(freeTool);
   
		}
	public FreeTool getProductFreeToolById(int id){
		FreeTool freeTool=super.criteriaQuerryGetObjectById(id,"toolId");
		return freeTool;
		}
	public List<FreeTool> getProductFreeTools() {
		List<FreeTool> freeTools=(List<FreeTool>)super.getAllEntity();
			return freeTools;
		}
    

   public Boolean deleteFreeTool(FreeTool freeTool){
	  Boolean tf= super.delete(freeTool);
	  return tf;
   }
   public Boolean updateFreeTool(FreeTool freeTool){
	 Boolean tf=super.update(freeTool);
	 return tf;
   }
public List<FreeTool> getFreeToolsByProduct(Product product) {
	Transaction transaction=null;
	List<FreeTool> freeTools=new ArrayList<FreeTool>();
      try ( Session    session=sessionFactory.openSession();) {
    	 transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<FreeTool> freeToolRoot = criteriaQuery.from(FreeTool.class);
         criteriaQuery.multiselect(freeToolRoot);
   	     criteriaQuery.where(
   	    		 builder.equal(freeToolRoot.get("product"),product)   
   	    	);
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
        
	         for (Object object : list) {
	        	 FreeTool  freeTool=(FreeTool)object;
	        	 freeTools.add(freeTool);
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
      return freeTools;
}
   
}
