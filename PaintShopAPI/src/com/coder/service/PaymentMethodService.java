package com.coder.service;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.coder.dao.PaymentMethodDao;
import com.coder.form.PaymentMethodForm;
import com.coder.model.PaymentMethod;
import com.coder.registerForm.PaymentMethodRegisterForm;
@Service
@Repository("paymentMethodService")
public class PaymentMethodService {
	@Autowired
	private PaymentMethodDao paymentMethodDao;

	public void preparePaymentMethodRegister(PaymentMethodRegisterForm paymentMethodRegisterForm){
		PaymentMethodForm paymentMethodForm=paymentMethodRegisterForm.getPaymentMethodForm();
		if(paymentMethodForm!=null){
		this.paymentMethodRegister(paymentMethodRegisterForm);
		}
		paymentMethodRegisterForm.setPaymentMethodForm(new PaymentMethodForm());
		paymentMethodRegisterForm.setPaymentMethods(this.paymentMethodDao.getPaymentMethods());
		
 	}
	private int paymentMethodRegister(PaymentMethodRegisterForm paymentMethodRegisterForm){
	PaymentMethodForm paymentMethodForm=paymentMethodRegisterForm.getPaymentMethodForm();	
	 PaymentMethod paymentMethod=new PaymentMethod();
     paymentMethod.setCreateDate(new Date());	   
     paymentMethod.setDescription(paymentMethodForm.getDescription());
     paymentMethod.setPhone(paymentMethodForm.getPhone());
     paymentMethod.setSerialId(paymentMethodForm.getSerialId());
     paymentMethod.setChannel(paymentMethodForm.getServiceName());
     int id=this.paymentMethodDao.savePaymentMethod(paymentMethod);
     return id;
     
	}
	

}
