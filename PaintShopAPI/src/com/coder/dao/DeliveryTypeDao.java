package com.coder.dao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.Color;
import com.coder.model.DeliveryAddress;
import com.coder.model.DeliveryType;
import com.coder.model.OrderForm;
@Repository("deliveryTypeDao")
public class DeliveryTypeDao extends AbstractDao<Integer,DeliveryType>{
	
	public Integer saveDeliveryType(DeliveryType deliveryType)
	{
	return (Integer)super.persist(deliveryType);
   
		}
	public DeliveryType getDeliveryTypeById(int id){
		DeliveryType deliveryType=super.criteriaQuerryGetObjectById(id,"deliveryTypeId");
		return deliveryType;
		}
	public List<DeliveryType> getDeliveryTypes() {
		List<DeliveryType> deliveryTypes=(List<DeliveryType>)super.getAllEntity();
			return deliveryTypes;
		}
    

   public Boolean deleteDeliveryType(DeliveryType deliveryType){
	  Boolean tf= super.delete(deliveryType);
	  return tf;
   }
   public Boolean updateDeliveryType(DeliveryType deliveryType){
	 Boolean tf=super.update(deliveryType);
	 return tf;
   }
   public DeliveryType getDeliveryTypeByOrderForm(int orderFormId){
		Transaction transaction=null;
		DeliveryType deliveryType=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object> criteriaQuery = builder.createQuery(Object.class);
	         Root<OrderForm> orderFormRoot = criteriaQuery.from(OrderForm.class);
	         Root<DeliveryType> deliveryTypeRoot = criteriaQuery.from(DeliveryType.class);
	         criteriaQuery.multiselect(deliveryTypeRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(orderFormRoot.get("orderFormId"),orderFormId),
	   	    		 builder.equal(orderFormRoot.get("deliveryType"),deliveryTypeRoot)
	                 ));
	         Query<Object> query=session.createQuery(criteriaQuery);
	         List<Object> list=query.getResultList();
	         for (Object object : list) {
	        	  deliveryType=(DeliveryType)object;
	           
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return deliveryType;
		}
}
