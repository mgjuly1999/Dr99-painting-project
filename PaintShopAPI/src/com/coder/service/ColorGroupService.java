package com.coder.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.coder.dao.ColorGroupDao;
import com.coder.form.ColorGroupForm;
import com.coder.model.ColorGroup;
import com.coder.registerForm.ColorGroupRegisterForm;
@Service
@Repository("colorGroupService")
public class ColorGroupService {
	@Autowired
	private ColorGroupDao colorGroupDao;
	public void prepareColorGroupRegister(ColorGroupRegisterForm colorGroupRegisterForm){
		ColorGroupForm colorGroupForm=colorGroupRegisterForm.getColorGroupForm();
		if(colorGroupForm!=null){
		this.colorGroupRegister(colorGroupRegisterForm);
		}
		colorGroupRegisterForm.setColorGroupForm(new ColorGroupForm());
		List<ColorGroup> colorGroups=this.colorGroupDao.getColorGroups();
		colorGroupRegisterForm.setColorGroups(colorGroups);
 	}
	private int colorGroupRegister(ColorGroupRegisterForm colorGroupRegisterForm){
	
		ColorGroup colorGroup=new ColorGroup(); 
		ColorGroupForm colorGroupForm=colorGroupRegisterForm.getColorGroupForm();
		colorGroup.setName(colorGroupForm.getName());
		colorGroup.setColorNumber(colorGroupForm.getColorNumber());
		colorGroup.setDescription(colorGroupForm.getDescription());
		colorGroup.setHtmlColorCode(colorGroupForm.getHtmlColorCode());
		colorGroup.setColorName(colorGroupForm.getName());
		
		int id=this.colorGroupDao.saveColorGroup(colorGroup);
	return id; 
	}

}
