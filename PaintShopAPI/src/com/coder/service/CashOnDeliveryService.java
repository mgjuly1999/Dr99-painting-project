package com.coder.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.apiForm.CashOnDeliverForm;
import com.coder.apiForm.OrderItem;
import com.coder.dao.ColorDao;
import com.coder.dao.DeliveryAddressDao;
import com.coder.dao.DeliveryTypeDao;
import com.coder.dao.LiterageDao;
import com.coder.dao.MemberDao;
import com.coder.dao.OrderFormDao;
import com.coder.dao.OrderStatusDao;
import com.coder.dao.PaymentMethodDao;
import com.coder.dao.ProductDao;
import com.coder.dao.ProductOrderDao;
import com.coder.dao.ProductTitleLanguageDao;
import com.coder.dao.QtyUnitDao;
import com.coder.model.*;
import com.coder.form.PaymentRespForm;
import com.coder.registerForm.CashOndeliveryRegisterForm;

@Service
@Repository("cashOnDeliveryService")
public class CashOnDeliveryService {
	
@Autowired
private MemberDao memberDao;
@Autowired
private DeliveryAddressDao  deliveryAddressDao;
@Autowired
private DeliveryTypeDao  deliveryTypeDao;
@Autowired
private OrderStatusDao  orderStatusDao;
@Autowired
private PaymentMethodDao  paymentMethodDao;
@Autowired
private ProductOrderDao  productOrderDao;
@Autowired
private LiterageDao  literageDao;
@Autowired
private ColorDao colorDao;
@Autowired
private QtyUnitDao  qtyUnitDao;
@Autowired
private ProductDao  productDao;
@Autowired
private OrderFormDao orderFormDao;
@Autowired
private ProductTitleLanguageDao productTitleLanguageDao;


	public void prepareCashDelivery(CashOndeliveryRegisterForm cashOndeliveryRegisterForm) {
		
		CashOnDeliverForm cashOnDeliverForm=cashOndeliveryRegisterForm.getCashOnDeliverForm();
		int invoiceId=Integer.parseInt(cashOnDeliverForm.getInvoiceId());
		
		OrderForm  orderForm=this.orderFormDao.getOrderFormByorderFormIdAndStatusId(invoiceId,3);
		if(orderForm!=null){
		DeliveryAddress deliveryAddress=this.deliveryAddressDao.getDeliveryAddressById(1);
		DeliveryType deliveryType=this.deliveryTypeDao.getDeliveryTypeById(1);
		OrderStatus orderStatus=this.orderStatusDao.getOrderStatusById(1);
		PaymentMethod paymentMethod=this.paymentMethodDao.getPaymentMethodById(1);
	
		
		
		List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(invoiceId);
		double grandTotal=0.0;
		
		for(ProductOrder productOrder : productOrders)
		{
		Litreage litreage =this.literageDao.getLitreageById(productOrder.getLitreage().getLitreageId());
			double subTotal=productOrder.getOrderQty()*litreage.getUnitPrice();
			grandTotal+=subTotal;
		}
		
		orderForm.setDeliveryAddress(deliveryAddress);
		orderForm.setDeliveryType(deliveryType);
		orderForm.setOrderStatus(orderStatus);
		orderForm.setPaymentMethod(paymentMethod);
		orderForm.setPhone(cashOnDeliverForm.getPhone());
		orderForm.setAddressDetails(cashOnDeliverForm.getAddress());
		orderForm.setTotalPrice(grandTotal);
		orderForm.setTotalDicountRate(0.0);
		orderForm.setCreateDate(new Date());
		ProductOrder productOrder=productOrders.get(0);
		ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.
		getProductTitleLanguageByProduct(productOrder.getProduct().getProductId(),1);
		orderForm.setNote("x"+productOrder.getOrderQty()+" "+productTitleLanguage.getName());
	
		this.orderFormDao.updateOrderForm(orderForm);
		
		PaymentRespForm paymentRespForm=new PaymentRespForm();
		paymentRespForm.setRespCode("000");
		paymentRespForm.setRespDesc("လူကြီးမင်းတို့အိမ်အရောက် ပို့ဆောင်ပေးပါမယ်။"+
									"ဝယ်ယူအားပေးမှုအတွက်အထူးကျေးဇူးတင်ပါသည်။");
		cashOndeliveryRegisterForm.setPaymentRespForm(paymentRespForm);
		
	}else if(orderForm==null)
	{
		PaymentRespForm paymentRespForm=new PaymentRespForm();
		paymentRespForm.setRespCode("200");
		paymentRespForm.setRespDesc("Invalid Invoice Id");
		cashOndeliveryRegisterForm.setPaymentRespForm(paymentRespForm);
	}

	}
}
