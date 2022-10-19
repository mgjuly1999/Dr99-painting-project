package com.coder.dao;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.coder.model.Color;
import com.coder.model.Guide;
@Repository("guideDao")
public class GuideDao extends AbstractDao<Integer,Guide>{
	
	public Integer saveGuide(Guide guide)
	{
	return (Integer)super.persist(guide);
   
		}
	public Guide getGuideById(int id){
		Guide guide=super.criteriaQuerryGetObjectById(id,"guideId");
		return guide;
		}
	public List<Guide> getGuides() {
		List<Guide> guides=(List<Guide>)super.getAllEntity();
			return guides;
		}
    

   public Boolean deleteGuide(Guide guide){
	  Boolean tf= super.delete(guide);
	  return tf;
   }
   public Boolean updateGuide(Guide guide){
	 Boolean tf=super.update(guide);
	 return tf;
   }
   
}
