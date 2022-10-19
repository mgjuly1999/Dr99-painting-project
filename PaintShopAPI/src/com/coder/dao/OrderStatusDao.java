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
import com.coder.model.OrderStatus;
import com.coder.model.PaymentMethod;
@Repository("orderStatusDao")
public class OrderStatusDao extends AbstractDao<Integer,OrderStatus>{
	
	public Integer saveOrderStatus(OrderStatus orderStatus)
	{
	return (Integer)super.persist(orderStatus);
   
		}
	public OrderStatus getOrderStatusById(int id){
		OrderStatus orderStatus=super.criteriaQuerryGetObjectById(id,"statusId");
		return orderStatus;
		}
	public List<OrderStatus> getOrderStatuss() {
		List<OrderStatus> orderStatuss=(List<OrderStatus>)super.getAllEntity();
			return orderStatuss;
		}
    

   public Boolean deleteOrderStatus(OrderStatus orderStatus){
	  Boolean tf= super.delete(orderStatus);
	  return tf;
   }
   public Boolean updateOrderStatus(OrderStatus orderStatus){
	 Boolean tf=super.update(orderStatus);
	 return tf;
   }
   public OrderStatus getOrderStatusByOrderForm(int orderFormId){
		Transaction transaction=null;
           OrderStatus orderStatus=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object> criteriaQuery = builder.createQuery(Object.class);
	         Root<OrderForm> orderFormRoot = criteriaQuery.from(OrderForm.class);
	         Root<OrderStatus> orderStatusRoot = criteriaQuery.from(OrderStatus.class);
	         criteriaQuery.multiselect(orderStatusRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(orderFormRoot.get("orderFormId"),orderFormId),
	   	    		 builder.equal(orderFormRoot.get("orderStatus"),orderStatusRoot)
	                 ));
	         Query<Object> query=session.createQuery(criteriaQuery);
	         List<Object> list=query.getResultList();
	         for (Object object : list) {
	        	 orderStatus=(OrderStatus)object;
	           
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return orderStatus;
		}
   
}
