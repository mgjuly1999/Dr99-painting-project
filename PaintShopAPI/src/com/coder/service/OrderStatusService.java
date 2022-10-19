package com.coder.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.ColorDao;
import com.coder.dao.ColorGroupDao;
import com.coder.dao.OrderStatusDao;
import com.coder.form.ColorForm;
import com.coder.form.ColorGroupForm;
import com.coder.form.OrderStatusForm;
import com.coder.model.Color;
import com.coder.model.ColorGroup;
import com.coder.model.OrderStatus;
import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.OrderStatusRegisterForm;
@Service
@Repository("orderStatusService")
public class OrderStatusService {
	@Autowired
	private OrderStatusDao orderStatusDao;
	
	public void prepareOrderStatusRegister(OrderStatusRegisterForm orderStatusRegisterForm){
		OrderStatusForm orderStatusForm=orderStatusRegisterForm.getOrderStatusForm();
		if(orderStatusForm!=null){
		this.orderStatusRegister(orderStatusRegisterForm);	}
		orderStatusRegisterForm.setOrderStatusForm(new OrderStatusForm());
	    orderStatusRegisterForm.setOrderStatusForm(orderStatusForm);
	    orderStatusRegisterForm.setOrderStatuss(this.orderStatusDao.getOrderStatuss());
		
 	}
	private int orderStatusRegister(OrderStatusRegisterForm orderStatusRegisterForm){
		OrderStatus orderStatus=new OrderStatus();
		OrderStatusForm orderStatusForm=orderStatusRegisterForm.getOrderStatusForm();
		orderStatus.setStatusName(orderStatusForm.getStatusName());
		int id=this.orderStatusDao.saveOrderStatus(orderStatus);
	
	return id; 
	}

}
