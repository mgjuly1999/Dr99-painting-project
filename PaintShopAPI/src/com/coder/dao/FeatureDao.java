package com.coder.dao;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.coder.model.Color;
import com.coder.model.Feature;
@Repository("featureDao")
public class FeatureDao extends AbstractDao<Integer,Feature>{
	
	public Integer saveFeature(Feature feature)
	{
	return (Integer)super.persist(feature);
   
		}
	public Feature getFeatureById(int id){
		Feature color=super.criteriaQuerryGetObjectById(id,"featureId");
		return color;
		}
	public List<Feature> getFeatures() {
		List<Feature> features=(List<Feature>)super.getAllEntity();
			return features;
		}
    

   public Boolean deleteFeature(Feature feature){
	  Boolean tf= super.delete(feature);
	  return tf;
   }
   public Boolean updateFeature(Feature feature){
	 Boolean tf=super.update(feature);
	 return tf;
   }
   
}
