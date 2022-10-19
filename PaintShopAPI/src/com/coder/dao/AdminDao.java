package com.coder.dao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.coder.model.Admin;
@Repository("adminDoa")
public class AdminDao extends AbstractDao<Integer,Admin>{
	
	public Integer saveAdmin(Admin admin)
	{
	return (Integer)super.persist(admin);
   
		}
	public Admin getAdminById(int id){
		Admin admin=super.criteriaQuerryGetObjectById(id,"adminId");
		return admin;
		}
	public List<Admin> getAdmins() {
		List<Admin> admins=(List<Admin>)super.getAllEntity();
			return admins;
		}
    

   public Boolean deleteAdmin(Admin admin){
	  Boolean tf= super.delete(admin);
	  return tf;
   }
   public Boolean updateAdmin(Admin admin){
	 Boolean tf=super.update(admin);
	 return tf;
   }
   public  Admin adminLogin(String email,String password){
		Transaction transaction=null;
		Admin admin=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Admin> adminRoot = criteriaQuery.from(Admin.class);
	         
	         criteriaQuery.multiselect(adminRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(adminRoot.get("email"),email),
	   	    		 builder.equal(adminRoot.get("password"),password)
	   	    		 ));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
	         for (Object object : list) {
	        	  admin=(Admin)object;
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return admin;
	   }
   
}
