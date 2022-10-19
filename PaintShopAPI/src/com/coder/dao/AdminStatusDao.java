package com.coder.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.coder.model.Admin;
import com.coder.model.AdminStatus;
@Repository("adminStatusDao")
public class AdminStatusDao extends AbstractDao<Integer,AdminStatus>{
	
	public Integer saveAdminStatus(AdminStatus adminStatus)
	{
	return (Integer)super.persist(adminStatus);
   
		}
	public AdminStatus getAdminStatusById(int id){
		AdminStatus adminStatus=super.criteriaQuerryGetObjectById(id,"adminStatusId");
		return adminStatus;
		}
	public List<AdminStatus> getAdminStatuss() {
		List<AdminStatus> adminStatuss=(List<AdminStatus>)super.getAllEntity();
			return adminStatuss;
		}
    

   public Boolean deleteAdminStatus(AdminStatus adminStatus){
	  Boolean tf= super.delete(adminStatus);
	  return tf;
   }
   public Boolean updateAdminStatus(AdminStatus adminStatus){
	 Boolean tf=super.update(adminStatus);
	 return tf;
   }
   
}
