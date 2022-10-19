package com.coder.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.ColorDao;
import com.coder.dao.ColorGroupDao;
import com.coder.dao.QtyUnitDao;
import com.coder.form.ColorForm;
import com.coder.form.ColorGroupForm;
import com.coder.form.QtyUnitForm;
import com.coder.model.Color;
import com.coder.model.ColorGroup;
import com.coder.model.QtyUnit;
import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.QtyUnitRegisterForm;
@Service
@Repository("qtyUnitService")
public class QtyUnitService {
	@Autowired
	private QtyUnitDao qtyUnitDao;
	
	public void prepareQtyUnitRegister(QtyUnitRegisterForm qtyUnitRegisterForm){
		QtyUnitForm qtyUnitForm=qtyUnitRegisterForm.getQtyUnitForm();
		if(qtyUnitForm!=null){
		this.qtyUnitRegister(qtyUnitRegisterForm);	}
		qtyUnitRegisterForm.setQtyUnitForm(new QtyUnitForm());
		List<QtyUnit> qtyUnits=this.qtyUnitDao.getQtyUnits();
		qtyUnitRegisterForm.setQtyUnits(qtyUnits);
 	}
	private int qtyUnitRegister(QtyUnitRegisterForm qtyUnitRegisterForm){
		QtyUnit qtyUnit=new QtyUnit();
		QtyUnitForm qtyUnitForm=qtyUnitRegisterForm.getQtyUnitForm();
		qtyUnit.setUnit(qtyUnitForm.getUnit());
		qtyUnit.setDescription(qtyUnitForm.getDescription());
		int id=this.qtyUnitDao.saveQtyUnit(qtyUnit);
	return id; 
	}

}
