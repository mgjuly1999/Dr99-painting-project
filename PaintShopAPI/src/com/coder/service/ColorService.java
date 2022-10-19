package com.coder.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.ColorDao;
import com.coder.dao.ColorGroupDao;
import com.coder.form.ColorForm;
import com.coder.form.ColorGroupForm;
import com.coder.model.Color;
import com.coder.model.ColorGroup;
import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
@Service
@Repository("colorService")
public class ColorService {
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private ColorGroupDao colorGroupDao;
	public void prepareColorRegister(ColorRegisterForm colorRegisterForm){
		ColorForm colorForm=colorRegisterForm.getColorForm();
		if(colorForm!=null){
		this.colorRegister(colorRegisterForm);	}
		colorRegisterForm.setColorForm(new ColorForm());
		List<ColorGroup> colorGroups=this.colorGroupDao.getColorGroups();
		for(ColorGroup colorGroup:colorGroups){
			colorRegisterForm.getMapColorGroups().put(colorGroup.getColorGroupId()+"",colorGroup.getColorName());
		}
		
 	}
	private int colorRegister(ColorRegisterForm colorRegisterForm){
		Color color=new Color();
		ColorForm colorForm=colorRegisterForm.getColorForm();
		ColorGroup colorGroup=this.colorGroupDao.getProductColorGroupById(Integer.parseInt(colorForm.getColorGroupId()));
		color.setColorGroup(colorGroup);
		color.setColorName(colorForm.getColorName());
		color.setColorNumber(colorForm.getColorNumber());
		color.setHtmlColorCode(colorForm.getHtmlColorCode());
		
		int id=this.colorDao.saveColor(color);
	return id; 
	}
	public List<ColorForm> getColorsByProductId(String productId) {
		List<ColorForm> colorForms=null;
		if(productId!=null)
		{
			int id=Integer.parseInt(productId);
			List<Color> colors=this.colorDao.getColorsByProduct(id);
			colorForms=new ArrayList<ColorForm>();
			
			for(Color color : colors)
			{
				ColorForm colorForm=new ColorForm();
				colorForm.setColorGroupId(color.getColorId()+"");
				colorForm.setColorName(color.getColorName());
				colorForm.setColorNumber(color.getColorNumber());
				colorForm.setHtmlColorCode(color.getHtmlColorCode());
				
				colorForms.add(colorForm);
			}
			
		}
		return colorForms;
	}

}
