package com.coder.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.coder.model.Product;
import com.coder.model.ProductStatus;
@Repository("productStatusDoa")
public class ProductStatusDao extends AbstractDao<Integer,ProductStatus>{
	
	public Integer saveProductStatus(ProductStatus productStatus)
	{
	return (Integer)super.persist(productStatus);
   
		}
	public ProductStatus getProductStatusById(int id){
		ProductStatus productStatus=super.criteriaQuerryGetObjectById(id,"statusId");
		return productStatus;
		}
	public List<ProductStatus> getProductStatuss() {
		List<ProductStatus> productStatuss=(List<ProductStatus>)super.getAllEntity();
			return productStatuss;
		}
    

   public Boolean deleteProductStatus(ProductStatus productStatus){
	  Boolean tf= super.delete(productStatus);
	  return tf;
   }
   public Boolean updateProductStatus(ProductStatus productStatus){
	 Boolean tf=super.update(productStatus);
	 return tf;
   }
   
}
