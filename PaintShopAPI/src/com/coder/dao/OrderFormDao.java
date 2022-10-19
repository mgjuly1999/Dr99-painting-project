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
import com.coder.model.Admin;
import com.coder.model.Color;
import com.coder.model.Member;
import com.coder.model.OrderForm;
import com.coder.model.Product;
@Repository("orderFormDoa")
public class OrderFormDao extends AbstractDao<Integer,OrderForm>{
	
	public Integer saveOrderForm(OrderForm orderForm)
	{
		
	return (Integer)super.persist(orderForm);
   
		}
	public OrderForm getOrderFormById(int id){
		OrderForm admin=super.criteriaQuerryGetObjectById(id,"orderFormId");
		return admin;
		}
	public List<OrderForm> getOrderForms() {
		List<OrderForm> orderForms=(List<OrderForm>)super.getAllEntity();
			return orderForms;
		}
    

   public Boolean deleteOrderForm(OrderForm orderForm){
	  Boolean tf= super.delete(orderForm);
	  return tf;
   }
   public Boolean updateOrderForm(OrderForm orderForm){
	 Boolean tf=super.update(orderForm);
	 return tf;
   }
   public List<OrderForm> getOrderFormByMember(int memberId){
		Transaction transaction=null;
				List<OrderForm> orderForms=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Member> memberRoot=criteriaQuery.from(Member.class);
	         Join<Object,Object> orderFormJoin=memberRoot.join("orderForms");
	         criteriaQuery.multiselect(orderFormJoin);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(memberRoot.get("memberId"),memberId),
	   	    		 builder.notEqual(orderFormJoin.get("orderStatus").get("statusName"),"AddToCart")
	   	    	));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list="+list.size());
		       for (Object object : list) {
		    	   OrderForm orderForm=(OrderForm)object;
		    	   orderForms.add(orderForm);
		          System.out.println("orderForm="+orderForm.getOrderFormId());
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return orderForms;
	   }
 
   public OrderForm getOrderFormByMemberAndStatus(int memberId){
		Transaction transaction=null;
		  OrderForm orderForm=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Member> memberRoot=criteriaQuery.from(Member.class);
	         Join<Object,Object> orderFormJoin=memberRoot.join("orderForms");
	         criteriaQuery.multiselect(orderFormJoin);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(memberRoot.get("memberId"),memberId),
	   	    		 builder.equal(orderFormJoin.get("orderStatus").get("statusName"),"AddToCart")
	   	    	));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list="+list.size());
		       for (Object object : list) {
		    	  orderForm=(OrderForm)object;
		    	  
		          System.out.println("orderForm="+orderForm.getOrderFormId());
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return orderForm;
	   }
public OrderForm getOrderFormByorderFormIdAndStatusId(int invoiceId, int statusId) {
	Transaction transaction=null;
	  OrderForm orderForm=null;
    try ( Session    session=sessionFactory.openSession();) {
  	 transaction = session.beginTransaction();
       CriteriaBuilder builder = session.getCriteriaBuilder();
       CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
       Root<OrderForm> orderFormRoot=criteriaQuery.from(OrderForm.class);
     
       criteriaQuery.multiselect(orderFormRoot);
 	     criteriaQuery.where(builder.and(
 	    		 builder.equal(orderFormRoot.get("orderFormId"),invoiceId),
 	    		 builder.equal(orderFormRoot.get("orderStatus").get("statusId"),statusId)
 	    	));
       Query<Object[]> query=session.createQuery(criteriaQuery);
       List<Object[]> list=query.getResultList();
       System.out.println("list="+list.size());
	       for (Object object : list) {
	    	  orderForm=(OrderForm)object;
	    	  
	          System.out.println("orderForm="+orderForm.getOrderFormId());
       }
       transaction.commit();
       session.close();
    } catch (Exception e) {
       e.printStackTrace();
       if (transaction != null) {
          transaction.rollback();
       }
    }
    return orderForm;
 }

}

   
   

