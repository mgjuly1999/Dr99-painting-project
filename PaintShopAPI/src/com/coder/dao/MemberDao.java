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

import com.coder.model.GroupLanguage;
import com.coder.model.Language;
import com.coder.model.Member;
import com.coder.model.OrderForm;
import com.coder.model.ProductGroup;
@Repository("memberDoa")
public class MemberDao extends AbstractDao<Integer,Member>{
	
	public Integer saveMember(Member member)
	{
	return (Integer)super.persist(member);
   
		}
	public Member getMemberById(int id){
		Member member=super.criteriaQuerryGetObjectById(id,"memberId");
		return member;
		}
	public List<Member> getMembers() {
		List<Member> members=(List<Member>)super.getAllEntity();
			return members;
		}
    

   public Boolean deleteMember(Member member){
	  Boolean tf= super.delete(member);
	  return tf;
   }
   public Boolean updateMember(Member member){
	 Boolean tf=super.update(member);
	 return tf;
   }
   public  Member memberLogin(String mail,String password){
		Transaction transaction=null;
		Member member=null;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Member> memberRoot = criteriaQuery.from(Member.class);
	         
	         criteriaQuery.multiselect(memberRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(memberRoot.get("mail"),mail),
	   	    		 builder.equal(memberRoot.get("password"),password)
	   	    		 ));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
	   
	         
	         for (Object object : list) {
	        	
	        	  member=(Member)object;
	        
	            
	           
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return member;
	   }
   public List<Member> getMemberByOrderForm(int orderFormId){
		Transaction transaction=null;
				List<Member> members=new ArrayList<>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	 transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	       //  Root<Member> memberRoot=criteriaQuery.from(Member.class);
	         Root<OrderForm> orderFormRoot=criteriaQuery.from(OrderForm.class);
	         Join<Object,Object> memberJoin=orderFormRoot.join("members");
	         criteriaQuery.multiselect(memberJoin);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(orderFormRoot.get("orderFormId"),orderFormId)
	   	    	
	   	    	));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list="+list.size());
		       for (Object object : list) {
		    	   Member member=(Member)object;
		    	   members.add(member);
		          System.out.println("member="+member.getName());
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return members;
	   }
   
}
