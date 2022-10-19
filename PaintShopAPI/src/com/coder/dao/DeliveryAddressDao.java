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
import com.coder.model.OrderForm;
import com.coder.model.ProductType;
import com.coder.model.TypeLanguage;
@Repository("deliveryAddressDao")
public class DeliveryAddressDao extends AbstractDao<Integer,DeliveryAddress>{
	
	public Integer saveDeliveryAddress(DeliveryAddress deliveryAddress)
	{
	return (Integer)super.persist(deliveryAddress);
   
		}
	public DeliveryAddress getDeliveryAddressById(int id){
		DeliveryAddress deliveryAddress=super.criteriaQuerryGetObjectById(id,"deliveryAddressId");
		return deliveryAddress;
		}
	public List<DeliveryAddress> getDeliveryAddresss() {
		List<DeliveryAddress> deliveryAddresss=(List<DeliveryAddress>)super.getAllEntity();
			return deliveryAddresss;
		}
    

   public Boolean deleteDeliveryAddress(DeliveryAddress deliveryAddress){
	  Boolean tf= super.delete(deliveryAddress);
	  return tf;
   }
   public Boolean updateDeliveryAddress(DeliveryAddress deliveryAddress){
	 Boolean tf=super.update(deliveryAddress);
	 return tf;
   }
   public DeliveryAddress getDeliveryAddressByOrderForm(int orderFormId){
		Transaction transaction=null;
		DeliveryAddress deliveryAddress=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object> criteriaQuery = builder.createQuery(Object.class);
	         Root<OrderForm> orderFormRoot = criteriaQuery.from(OrderForm.class);
	         Root<DeliveryAddress> deliveryAddressRoot = criteriaQuery.from(DeliveryAddress.class);
	         criteriaQuery.multiselect(deliveryAddressRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(orderFormRoot.get("orderFormId"),orderFormId),
	   	    		 builder.equal(orderFormRoot.get("deliveryAddress"),deliveryAddressRoot)
	                 ));
	         Query<Object> query=session.createQuery(criteriaQuery);
	         List<Object> list=query.getResultList();
	         for (Object object : list) {
	        	  deliveryAddress=(DeliveryAddress)object;
	           
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return deliveryAddress;
		}
	}
