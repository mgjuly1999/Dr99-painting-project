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

import com.coder.model.Folder;
import com.coder.model.Product;
import com.coder.model.ProductMedia;
import com.coder.model.ProductTitleLanguage;
@Repository("productMediaDao")
public class ProductMediaDao extends AbstractDao<Integer,ProductMedia> {
	public Integer saveProductMedia(ProductMedia productMedia)
	{
	return (Integer)super.persist(productMedia);
   
		}
	public ProductMedia getProductMediaById(int id){
		ProductMedia productMedia=super.criteriaQuerryGetObjectById(id,"productMediaId");
		return productMedia;
		}
	public List<ProductMedia> getProductMedias() {
		List<ProductMedia> productMedias=(List<ProductMedia>)super.getAllEntity();
			return productMedias;
		}
    

   public Boolean deleteProductMedia(ProductMedia productMedia){
	  Boolean tf= super.delete(productMedia);
	  return tf;
   }
   public Boolean updateProductMedia(ProductMedia productMedia){
	 Boolean tf=super.update(productMedia);
	 return tf;
   }
   
   public List<ProductMedia> getProductMediaByProductId(Product product) {
		
		
		Session s=sessionFactory.openSession();
		Transaction tr = s.beginTransaction();
		CriteriaBuilder builder=s.getCriteriaBuilder();
		CriteriaQuery<ProductMedia> querry=builder.createQuery(ProductMedia.class);
		Root<ProductMedia> root=querry.from(ProductMedia.class);
		querry.select(root);
		querry.where(builder.equal(root.get("product"),product));
		Query<ProductMedia> q=s.createQuery(querry);
		List<ProductMedia> list=q.getResultList();
		tr.commit();
		s.close();
		
		if(list.size()==0){
		return null;
		}else{
		return list;
		}
}
   public List<ProductMedia> getProductMediaByProductIdAndFloderName(int productId,int folderId){
		Transaction transaction=null;
		List<ProductMedia> productMedias=new ArrayList<ProductMedia>(0);
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<ProductMedia> rootProductMedia=criteriaQuery.from(ProductMedia.class);
	         criteriaQuery.multiselect(rootProductMedia);
	   	     criteriaQuery.where(builder.and(
	   	    		builder.equal(rootProductMedia.get("product").get("productId"),productId)),
	   	    		builder.equal(rootProductMedia.get("folder").get("folderId"),folderId));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
		         for (Object object : list) {
		        ProductMedia productMedia=(ProductMedia)object;
		        productMedias.add(productMedia);
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	  
	      return productMedias;
	   }

}
