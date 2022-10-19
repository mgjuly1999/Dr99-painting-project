package com.coder.dao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.coder.model.Litreage;
import com.coder.model.Product;
import com.coder.model.ProductMedia;
@Repository("literageDao")
public class LiterageDao extends AbstractDao<Integer,Litreage>{
	
	public Integer saveLitreage(Litreage litreage)
	{
	return (Integer)super.persist(litreage);
   
		}
	public Litreage getLitreageById(int id){
		Litreage litreage=super.criteriaQuerryGetObjectById(id,"litreageId");
		return litreage;
		}
	public List<Litreage> getLitreages() {
		List<Litreage> Litreages=(List<Litreage>)super.getAllEntity();
			return Litreages;
		}
    

   public Boolean deleteLitreage(Litreage litreage){
	  Boolean tf= super.delete(litreage);
	  return tf;
   }
   public Boolean updateLitreage(Litreage litreage){
	 Boolean tf=super.update(litreage);
	 return tf;
   }
public List<Litreage> getLiteragesByProduct(Product product) {
	
	Session s=sessionFactory.openSession();
	Transaction tr = s.beginTransaction();
	CriteriaBuilder builder=s.getCriteriaBuilder();
	CriteriaQuery<Litreage> querry=builder.createQuery(Litreage.class);
	Root<Litreage> root=querry.from(Litreage.class);
	querry.select(root);
	querry.where(builder.equal(root.get("product"),product));
	Query<Litreage> q=s.createQuery(querry);
	List<Litreage> list=q.getResultList();
	tr.commit();
	s.close();
	
	if(list.size()==0){
	return null;
	}else{
	return list;
	}
}
   
}
