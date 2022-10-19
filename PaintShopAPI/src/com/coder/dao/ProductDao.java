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

import com.coder.model.OrderForm;
import com.coder.model.Product;
import com.coder.model.ProductOrder;
import com.coder.model.ProductType;
import com.coder.model.ToolLanguage;
@Repository("productDoa")
public class ProductDao extends AbstractDao<Integer,Product>{
	
	public Integer saveProduct(Product product)
	{
	return (Integer)super.persist(product);
   
		}
	public Product getProductById(int id){
		Product product=super.criteriaQuerryGetObjectById(id,"productId");
		return product;
		}
	public List<Product> getProducts() {
		List<Product> products=(List<Product>)super.getAllEntity();
			return products;
		}
    

   public Boolean deleteProduct(Product product){
	  Boolean tf= super.delete(product);
	  return tf;
   }
   public Boolean updateProduct(Product product){
	 Boolean tf=super.update(product);
	 return tf;
   }
   public List<Product> getProductByType(int typeId){
		Transaction transaction=null;
		List<Product> products=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Product> productRoot = criteriaQuery.from(Product.class);
	         Root<ProductType> productTypeRoot=criteriaQuery.from(ProductType.class);
	         criteriaQuery.multiselect(productRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(productTypeRoot.get("productTypeId"),typeId),   
	   	    		 builder.equal(productTypeRoot.get("productTypeId"),productRoot.get("productType").get("productTypeId")))  
	   	    	);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
	        	Product product=(Product)object;
	        	products.add(product);
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();}}
	      return products;
	   }
   
   public List<Product> getProductByOrderForm(int orderFormId){
		Transaction transaction=null;
		List<Product> products=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ProductOrder> productOrderRoot = criteriaQuery.from(ProductOrder.class);
	         Root<Product> productRoot = criteriaQuery.from(Product.class);
	         Root<OrderForm> orderFormRoot=criteriaQuery.from(OrderForm.class);
	         criteriaQuery.multiselect(productRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(productOrderRoot.get("orderForm").get("orderFormId"),orderFormId),   
	   	    		 builder.equal(productOrderRoot.get("orderForm"),orderFormRoot),   
	   	    		 builder.equal(productOrderRoot.get("product"),productRoot)  
	   	    	));
	   	     criteriaQuery.distinct(true);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
	        	Product product=(Product)object;
	        	products.add(product);
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();}}
	      return products;
	   }
   
public List<Product> getProductByType(ProductType productType) {
	Session s=sessionFactory.openSession();
	Transaction tr = s.beginTransaction();
	CriteriaBuilder builder=s.getCriteriaBuilder();
	CriteriaQuery<Product> querry=builder.createQuery(Product.class);
	Root<Product> root=querry.from(Product.class);
	querry.select(root);
	querry.where(builder.equal(root.get("productType"),productType));
	Query<Product> q=s.createQuery(querry);
	List<Product> list=q.getResultList();
	tr.commit();
	s.close();
	
	if(list.size()==0){
	return null;
	}else{
	return list;
	}
}
   
}
