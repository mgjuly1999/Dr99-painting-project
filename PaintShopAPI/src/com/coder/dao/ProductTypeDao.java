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

import com.coder.model.Language;
import com.coder.model.ProductGroup;
import com.coder.model.ProductType;
import com.coder.model.TypeLanguage;
@Repository("productTypeDoa")
public class ProductTypeDao extends AbstractDao<Integer,ProductType>{
	
	public Integer saveProductType(ProductType productType)
	{
	return (Integer)super.persist(productType);
   
		}
	public ProductType getProductTypeById(int id){
		ProductType productType=super.criteriaQuerryGetObjectById(id,"productTypeId");
		return productType;
		}
	public List<ProductType> getProductTypes() {
		List<ProductType> productTypes=(List<ProductType>)super.getAllEntity();
			return productTypes;
		}
    

   public Boolean deleteProductType(ProductType productType){
	  Boolean tf= super.delete(productType);
	  return tf;
   }
   public Boolean updateProductType(ProductType productType){
	 Boolean tf=super.update(productType);
	 return tf;
   }
   public  List<ProductType> getProductTypesByGroup(int groupId){
		Transaction transaction=null;
		List<ProductType> productTypes=new ArrayList<>();
		ProductType productType=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	        
	         Root<ProductType> productTypeRoot=criteriaQuery.from(ProductType.class);

	         criteriaQuery.multiselect(productTypeRoot);
	   	     criteriaQuery.where(builder.and(
	   	    	     builder.equal(productTypeRoot.get("productGroup").get("productGroupId"),groupId)
		   	    	));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("Typelist.size()="+list.size());
	         for (Object object : list) {
	        	 productType=(ProductType)object;
	        	 productTypes.add(productType);
 	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
 	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return productTypes;
	   }
/*public List<ProductType> getProductTypesByGroupId(ProductGroup productGroup) {
	Session s=sessionFactory.openSession();
	Transaction tr = s.beginTransaction();
	CriteriaBuilder builder=s.getCriteriaBuilder();
	CriteriaQuery<ProductType> querry=builder.createQuery(ProductType.class);
	Root<ProductType> root=querry.from(ProductType.class);
	querry.select(root);
	querry.where(builder.equal(root.get("productGroup"),productGroup));
	Query<ProductType> q=s.createQuery(querry);
	List<ProductType> list=q.getResultList();
	tr.commit();
	s.close();
	
	if(list.size()==0){
	return null;
	}else{
	return list;
	}
	
	
}*/
}
