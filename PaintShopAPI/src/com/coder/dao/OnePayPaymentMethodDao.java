package com.coder.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.coder.model.OnePayPaymentMethod;

@Repository("onePayPaymentMethodDao")
public class OnePayPaymentMethodDao  extends AbstractDao<Integer,OnePayPaymentMethod>{
	
	public Integer saveOnePayPaymentMethod(OnePayPaymentMethod onePayPaymentMethod)
	{
	return (Integer)super.persist(onePayPaymentMethod);
   
		}
	public OnePayPaymentMethod getOnePayPaymentMethodById(int id){
		OnePayPaymentMethod onePayPaymentMethod=super.criteriaQuerryGetObjectById(id,"paymentMethodId");
		return onePayPaymentMethod;
		}
	public List<OnePayPaymentMethod> getOnePayPaymentMethods() {
		List<OnePayPaymentMethod> OnePayPaymentMethods=(List<OnePayPaymentMethod>)super.getAllEntity();
			return OnePayPaymentMethods;
		}
    

   public Boolean deleteOnePayPaymentMethod(OnePayPaymentMethod onePayPaymentMethod){
	  Boolean tf= super.delete(onePayPaymentMethod);
	  return tf;
   }
   public Boolean updateOnePayPaymentMethod(OnePayPaymentMethod onePayPaymentMethod){
	 Boolean tf=super.update(onePayPaymentMethod);
	 return tf;
   }
public OnePayPaymentMethod getOnePayPaymentMethodByReferIntegrationId(String serialId) {
	
return	super.criteriaQuerryGetObjectsByName(serialId,"serialId").get(0);
	
}
   
}
