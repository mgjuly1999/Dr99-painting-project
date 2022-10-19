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
import com.coder.model.Product;
import com.coder.model.QtyUnit;
import com.coder.model.ToolLanguage;
@Repository("qtyUnitDao")
public class QtyUnitDao extends AbstractDao<Integer,QtyUnit>{
	
	public Integer saveQtyUnit(QtyUnit qtyUnit)
	{
	return (Integer)super.persist(qtyUnit);
   
		}
	public QtyUnit getQtyUnitById(int id){
		QtyUnit color=super.criteriaQuerryGetObjectById(id,"qtyUnitId");
		return color;
		}
	public List<QtyUnit> getQtyUnits() {
		List<QtyUnit> qtyUnits=(List<QtyUnit>)super.getAllEntity();
			return qtyUnits;
		}
    

   public Boolean deleteQtyUnit(QtyUnit qtyUnit){
	  Boolean tf= super.delete(qtyUnit);
	  return tf;
   }
   public Boolean updateQtyUnit(QtyUnit qtyUnit){
	 Boolean tf=super.update(qtyUnit);
	 return tf;
   }
   public QtyUnit getQtyUnitByProductId(int productId){
		Transaction transaction=null;
		QtyUnit qtyUnit=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<QtyUnit> qtyUnitRoot = criteriaQuery.from(QtyUnit.class);
	         Root<Product> productRoot = criteriaQuery.from(Product.class);
	         criteriaQuery.multiselect(qtyUnitRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(productRoot.get("productId"),productId) ,
	   	    		 builder.equal(qtyUnitRoot.get("qtyUnitId"),productRoot.get("qtyUnit").get("qtyUnitId"))   
	   	    	));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
	        	 qtyUnit=(QtyUnit)object;
	        
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return qtyUnit;
	   }
   
}
