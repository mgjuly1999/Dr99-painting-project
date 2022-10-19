package com.coder.dao;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.coder.model.Color;
import com.coder.model.ColorGroup;
@Repository("colorGroupDao")
public class ColorGroupDao extends AbstractDao<Integer,ColorGroup>{
	
	public Integer saveColorGroup(ColorGroup colorGroup)
	{
	return (Integer)super.persist(colorGroup);
   
		}
	public ColorGroup getProductColorGroupById(int id){
		ColorGroup colorGroup=super.criteriaQuerryGetObjectById(id,"colorGroupId");
		return colorGroup;
		}
	public List<ColorGroup> getColorGroups() {
		List<ColorGroup> colorGroups=(List<ColorGroup>)super.getAllEntity();
			return colorGroups;
		}
    

   public Boolean deleteColorGroup(ColorGroup colorGroup){
	  Boolean tf= super.delete(colorGroup);
	  return tf;
   }
   public Boolean updateColorGroup(ColorGroup colorGroup){
	 Boolean tf=super.update(colorGroup);
	 return tf;
   }
   
}
