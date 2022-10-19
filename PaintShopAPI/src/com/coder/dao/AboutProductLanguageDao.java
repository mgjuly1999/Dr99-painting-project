package com.coder.dao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.coder.model.AboutProductLanguage;
import com.coder.model.Language;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ProductType;
@Repository("aboutProductLanguageDao")
public class AboutProductLanguageDao extends AbstractDao<Integer,AboutProductLanguage>{
	
	public Object saveAboutProductLanguage(AboutProductLanguage aboutProductLanguage)
	{
	return (Object)super.persistMtoM(aboutProductLanguage);
   
		}
	public AboutProductLanguage getAboutProductLanguageById(int id){
		AboutProductLanguage aboutProductLanguage=super.criteriaQuerryGetObjectById(id,"productId");
		return aboutProductLanguage;
		}
	public List<AboutProductLanguage> getAboutProductLanguages() {
		List<AboutProductLanguage> typeLanguages=(List<AboutProductLanguage>)super.getAllEntity();
			return typeLanguages;
		}
    

   public Boolean deleteAboutProductLanguage(AboutProductLanguage aboutProductLanguage){
	  Boolean tf= super.delete(aboutProductLanguage);
	  return tf;
   }
   public Boolean updateAboutProductLanguage(AboutProductLanguage aboutProductLanguage){
	 Boolean tf=super.update(aboutProductLanguage);
	 return tf;
   }
public  List<AboutProductLanguage>  getAboutLanguageByProduct(Product product, Language language) {
		
		Session s=sessionFactory.openSession();
		Transaction tr = s.beginTransaction();
		CriteriaBuilder builder=s.getCriteriaBuilder();
		CriteriaQuery<AboutProductLanguage> querry=builder.createQuery(AboutProductLanguage.class);
		Root<AboutProductLanguage> root=querry.from(AboutProductLanguage.class);
		querry.select(root);
		querry.where(builder.equal(root.get("product"),product));
		querry.where(builder.equal(root.get("language"),language));
		Query<AboutProductLanguage> q=s.createQuery(querry);
		List<AboutProductLanguage> list=q.getResultList();
		tr.commit();
		s.close();
		if(list.size()==0){
		return null;
		}else{
		return list;
	}
	
}
   
}
