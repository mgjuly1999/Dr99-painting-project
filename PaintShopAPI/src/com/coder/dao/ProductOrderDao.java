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
import com.coder.model.GroupLanguage;
import com.coder.model.Language;
import com.coder.model.Litreage;
import com.coder.model.Member;
import com.coder.model.OrderForm;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ProductOrder;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.QtyUnit;
@Repository("productOrderDao")
public class ProductOrderDao extends AbstractDao<Integer,ProductOrder>{
	
	public Integer saveProductOrder(ProductOrder productOrder)
	{
	return (Integer)super.persist(productOrder);
   
		}
	public ProductOrder getProductOrderId(int id){
		ProductOrder productOrder=super.criteriaQuerryGetObjectById(id,"orderId");
		return productOrder;
		}
	public List<ProductOrder> getProductOrders() {
		List<ProductOrder> productOrders=(List<ProductOrder>)super.getAllEntity();
			return productOrders;
		}
    

   public Boolean deleteProductOrders(ProductOrder productOrder){
	  Boolean tf= super.delete(productOrder);
	  return tf;
   }
   public Boolean updateProductOrder(ProductOrder productOrder){
	 Boolean tf=super.update(productOrder);
	 return tf;
   }
   public List<ProductOrder> getProductOrderByOrderForm(int orderFormId) {
		Transaction transaction=null;
		List<ProductOrder> productOrders=new ArrayList<ProductOrder>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ProductOrder> productOrderRoot = criteriaQuery.from(ProductOrder.class);
	         criteriaQuery.multiselect(productOrderRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		builder.equal(productOrderRoot.get("orderForm").get("orderFormId"),orderFormId)));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
		        	ProductOrder  productOrder=(ProductOrder)object;
		        	productOrders.add(productOrder);
		        	
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	  
	      return productOrders;
	   }
   public ProductOrder getSameTypeProducts(ProductOrder productOrder){
		Transaction transaction=null;
		ProductOrder productOrder1=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ProductOrder> productOrderRoot = criteriaQuery.from(ProductOrder.class);
	         criteriaQuery.multiselect(productOrderRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		builder.equal(productOrderRoot.get("color"),productOrder.getColor()),
	   	    		builder.equal(productOrderRoot.get("litreage"),productOrder.getLitreage()),
	   	    		builder.equal(productOrderRoot.get("qtyUnit"),productOrder.getQtyUnit()),
	   	    		builder.equal(productOrderRoot.get("product"),productOrder.getProduct()),
	   	    		builder.equal(productOrderRoot.get("orderForm"),productOrder.getOrderForm())
	   	    		)
	   	    		 );
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
		        	  productOrder1=(ProductOrder)object;
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	  
	      return productOrder1;
	   }

   
}
