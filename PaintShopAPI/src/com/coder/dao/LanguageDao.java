package com.coder.dao;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.coder.model.Language;
import com.coder.model.ProductGroup;
@Repository("languageDoa")
public class LanguageDao extends AbstractDao<Integer,Language>{
	
	public Integer saveLanguage(Language language)
	{
	return (Integer)super.persist(language);
   
		}
	public Language getLanguageById(int id){
		Language product=super.criteriaQuerryGetObjectById(id,"languageId");
		return product;
		}
	public List<Language> getLanguages() {
		List<Language> languages=(List<Language>)super.getAllEntity();
			return languages;
		}
    

   public Boolean deleteLanguage(Language language){
	  Boolean tf= super.delete(language);
	  return tf;
   }
   public Boolean updateLanguage(Language language){
	 Boolean tf=super.update(language);
	 return tf;
   }
   
}
