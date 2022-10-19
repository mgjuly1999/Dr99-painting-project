package com.coder.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.coder.model.Product;
import com.coder.model.ProductQuality;
import com.coder.model.ProductStatus;
@Repository("productQualityDao")
public class ProductQualityDao extends AbstractDao<Integer,ProductQuality>{
	
	public Integer saveProductQuality(ProductQuality productQuality)
	{
	return (Integer)super.persist(productQuality);
   
		}
	public ProductQuality getProductQualityById(int id){
		ProductQuality productQuality=super.criteriaQuerryGetObjectById(id,"productQualityId");
		return productQuality;
		}
	public List<ProductQuality> getProductQualitys() {
		List<ProductQuality> productQualitys=(List<ProductQuality>)super.getAllEntity();
			return productQualitys;
		}
    

   public Boolean deleteProductQuality(ProductQuality productQuality){
	  Boolean tf= super.delete(productQuality);
	  return tf;
   }
   public Boolean updateProductQuality(ProductQuality productQuality){
	 Boolean tf=super.update(productQuality);
	 return tf;
   }
   
}
