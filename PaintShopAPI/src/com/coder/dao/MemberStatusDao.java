package com.coder.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.coder.model.MemberStatus;
@Repository("memberStatusDao")
public class MemberStatusDao extends AbstractDao<Integer,MemberStatus>{
	
	public Integer saveMemberStatus(MemberStatus memberStatus)
	{
	return (Integer)super.persist(memberStatus);
   
		}
	public MemberStatus getMemberStatusById(int id){
		MemberStatus adminStatus=super.criteriaQuerryGetObjectById(id,"memberStatusId");
		return adminStatus;
		}
	public List<MemberStatus> getMemberStatuss() {
		List<MemberStatus> memberStatuss=(List<MemberStatus>)super.getAllEntity();
			return memberStatuss;
		}
    

   public Boolean deleteMemberStatus(MemberStatus memberStatus){
	  Boolean tf= super.delete(memberStatus);
	  return tf;
   }
   public Boolean updateMemberStatus(MemberStatus memberStatus){
	 Boolean tf=super.update(memberStatus);
	 return tf;
   }
   
}
