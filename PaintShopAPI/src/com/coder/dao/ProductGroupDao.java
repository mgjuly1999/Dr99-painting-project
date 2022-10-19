package com.coder.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.coder.model.ProductGroup;
@Repository("productGroupDoa")
public class ProductGroupDao extends AbstractDao<Integer,ProductGroup>{
	
	public Integer saveProductGroup(ProductGroup productGroup)
	{
	return (Integer)super.persist(productGroup);
   
		}
	public ProductGroup getProductGroupById(int id){
		ProductGroup product=super.criteriaQuerryGetObjectById(id,"productGroupId");
		return product;
		}
	public List<ProductGroup> getProductGroups() {
		List<ProductGroup> products=(List<ProductGroup>)super.getAllEntity();
			return products;
		}
    

   public Boolean deleteProductGroup(ProductGroup productGroup){
	  Boolean tf= super.delete(productGroup);
	  return tf;
   }
   public Boolean updateProductGroup(ProductGroup productGroup){
	 Boolean tf=super.update(productGroup);
	 return tf;
   }
   
}
