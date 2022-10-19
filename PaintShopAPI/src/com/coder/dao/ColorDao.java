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

import com.coder.model.Color;
import com.coder.model.GuideLanguage;
import com.coder.model.Language;
import com.coder.model.Product;
import com.coder.model.ProductType;
import com.coder.model.TypeLanguage;
@Repository("colorDao")
public class ColorDao extends AbstractDao<Integer,Color>{
	
	public Integer saveColor(Color color)
	{
	return (Integer)super.persist(color);
   
		}
	public Color getColorById(int id){
		Color color=super.criteriaQuerryGetObjectById(id,"colorId");
		return color;
		}
	public List<Color> getProductColors() {
		List<Color> colors=(List<Color>)super.getAllEntity();
			return colors;
		}
    

   public Boolean deleteColor(Color color){
	  Boolean tf= super.delete(color);
	  return tf;
   }
   public Boolean updateColor(Color color){
	 Boolean tf=super.update(color);
	 return tf;
   }
   public List<Color> getColorsByProduct(int productId){
		Transaction transaction=null;
				List<Color> colors=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Product> productRoot=criteriaQuery.from(Product.class);
	         Root<Color> colorRoot=criteriaQuery.from(Color.class);
	         Join<Object,Object> colorGroupJoin=productRoot.join("colorGroups");
	         criteriaQuery.multiselect(colorRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(productRoot.get("productId"),productId),   
	   	    		 builder.equal(colorGroupJoin,colorRoot.get("colorGroup"))
	   	    	));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	 
		       for (Object object : list) {
		    	   Color  color=(Color)object;
		    	   colors.add(color);
		          System.out.println("color="+color.getColorName());
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return colors;
	   }
  
   
}
