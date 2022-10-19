package com.coder.registerForm;

import java.util.List;

import com.coder.form.QtyUnitForm;
import com.coder.model.QtyUnit;

public class QtyUnitRegisterForm {
private QtyUnitForm qtyUnitForm;
private List<QtyUnit> qtyUnits;
public QtyUnitForm getQtyUnitForm() {
	return qtyUnitForm;
}
public void setQtyUnitForm(QtyUnitForm qtyUnitForm) {
	this.qtyUnitForm = qtyUnitForm;
}
public List<QtyUnit> getQtyUnits() {
	return qtyUnits;
}
public void setQtyUnits(List<QtyUnit> qtyUnits) {
	this.qtyUnits = qtyUnits;
}
}
