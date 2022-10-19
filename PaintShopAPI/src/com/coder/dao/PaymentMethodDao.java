package com.coder.dao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.DeliveryType;
import com.coder.model.OrderForm;
import com.coder.model.PaymentMethod;
import com.coder.model.Product;
@Repository("paymentMethodDao")
public class PaymentMethodDao extends AbstractDao<Integer,PaymentMethod>{
	
	public Integer savePaymentMethod(PaymentMethod paymentMethod)
	{
	return (Integer)super.persist(paymentMethod);
   
		}
	public PaymentMethod getPaymentMethodById(int id){
		PaymentMethod paymentMethod=super.criteriaQuerryGetObjectById(id,"paymentMethodId");
		return paymentMethod;
		}
	public List<PaymentMethod> getPaymentMethods() {
		List<PaymentMethod> paymentMethods=(List<PaymentMethod>)super.getAllEntity();
			return paymentMethods;
		}
    

   public Boolean deletePaymentMethod(PaymentMethod paymentMethod){
	  Boolean tf= super.delete(paymentMethod);
	  return tf;
   }
   public Boolean updatePaymentMethod(PaymentMethod paymentMethod){
	 Boolean tf=super.update(paymentMethod);
	 return tf;
   }
   public PaymentMethod getPaymentMethodByOrderForm(int orderFormId){
		Transaction transaction=null;
		PaymentMethod paymentMethod=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object> criteriaQuery = builder.createQuery(Object.class);
	         Root<OrderForm> orderFormRoot = criteriaQuery.from(OrderForm.class);
	         Root<PaymentMethod> paymentMethodRoot = criteriaQuery.from(PaymentMethod.class);
	         criteriaQuery.multiselect(paymentMethodRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(orderFormRoot.get("orderFormId"),orderFormId),
	   	    		 builder.equal(orderFormRoot.get("paymentMethod"),paymentMethodRoot)
	                 ));
	         Query<Object> query=session.createQuery(criteriaQuery);
	         List<Object> list=query.getResultList();
	         for (Object object : list) {
	        	  paymentMethod=(PaymentMethod)object;
	           
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return paymentMethod;
		}
public PaymentMethod getPaymentMethodByReferIntegrationId(String referIntegrationId) {
	
	return	super.criteriaQuerryGetObjectsByName(referIntegrationId,"serialId").get(0);
}
   
}
