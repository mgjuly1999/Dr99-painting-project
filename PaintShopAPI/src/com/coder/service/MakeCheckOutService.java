package com.coder.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.apiForm.CheckOutAPIForm;
import com.coder.apiForm.MyOrderAPIForm;
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
import com.coder.form.DirectPaymentAPIRespForm;
import com.coder.form.MakePaymentForm;
import com.coder.form.PaymentRespForm;
import com.coder.form.VerifyPhoneNumberForm;
import com.coder.form.VerifyPhoneNumberRespForm;
import com.coder.model.Color;
import com.coder.model.DeliveryAddress;
import com.coder.model.Litreage;
import com.coder.model.Member;
import com.coder.model.OrderForm;
import com.coder.model.PaymentMethod;
import com.coder.model.Product;
import com.coder.model.ProductOrder;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.QtyUnit;
import com.coder.registerForm.DirectPaymentAPIPrepareForm;
import com.coder.registerForm.MakePaymentRegisterForm;
import com.coder.registerForm.VerifyPhoneNumberRegisterForm;

@Service
@Repository("makeCheckOutService")
public class MakeCheckOutService {
	@Autowired
	private CheckOutService checkOutService;
	@Autowired
	private OrderFormDao orderFormDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private DeliveryTypeDao deliveryTypeDao;
	@Autowired
	private OrderStatusDao  orderStatusDao;
	@Autowired
	private DeliveryAddressDao  deliveryAddressDao;
	@Autowired
	private ProductOrderDao productOrderDao;
	@Autowired
	private ProductDao  productDao;
	@Autowired
	private LiterageDao  literageDao;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private QtyUnitDao  qtyUnitDao;
	@Autowired
	private PaymentMethodDao  paymentMethodDao;
	@Autowired
	private ProductTitleLanguageDao productTitleLanguageDao;

	public void prepareMakePayment(MakePaymentRegisterForm makePaymentRegisterForm) {
		
		PaymentRespForm paymentRespForm=new PaymentRespForm();
	
		CheckOutAPIForm checkOutAPIForm=makePaymentRegisterForm.getCheckOutAPIForm();
		MakePaymentForm makePaymentForm=checkOutAPIForm.getMakePaymentForm();
		int invoiceId=Integer.parseInt(makePaymentForm.getInvoiceId());
		int deliveryAddressId=Integer.parseInt(checkOutAPIForm.getDeliveryAddressId());
		OrderForm  orderForm=this.orderFormDao.getOrderFormByorderFormIdAndStatusId(invoiceId,3);
	
	System.out.println(makePaymentForm);
	
		if(orderForm!=null){
		if(makePaymentForm!=null)
		{
			if(makePaymentForm.getInvoiceId()!=null &&
					makePaymentForm.getPhone()!=null)
			{
				VerifyPhoneNumberForm verifyPhoneNumberForm=new VerifyPhoneNumberForm();
		
				List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(invoiceId);
				DeliveryAddress deliveryAddress=this.deliveryAddressDao.getDeliveryAddressById(deliveryAddressId);
				double grandTotal=0.0;
				grandTotal=+deliveryAddress.getDeliveryPrice();
				for(ProductOrder productOrder : productOrders)
				{
				Litreage litreage =this.literageDao.getLitreageById(productOrder.getLitreage().getLitreageId());
					double subTotal=productOrder.getOrderQty()*litreage.getUnitPrice();
					grandTotal+=subTotal;
				}
				
				verifyPhoneNumberForm.setAmount(grandTotal+"");
				verifyPhoneNumberForm.setChannel(makePaymentForm.getChannel());
				verifyPhoneNumberForm.setInvoiceNo(makePaymentForm.getInvoiceId());
				verifyPhoneNumberForm.setOnepayPhoneNo(makePaymentForm.getPhone());
				verifyPhoneNumberForm.setMerchantUserId(makePaymentForm.getMerchantUserId());
				
				VerifyPhoneNumberRegisterForm  verifyPhoneNumberRegisterForm=new VerifyPhoneNumberRegisterForm();
				verifyPhoneNumberRegisterForm.setVerifyPhoneNumberForm(verifyPhoneNumberForm);
				
				checkOutService.prepareVerifyPhoneNumberCashOut(verifyPhoneNumberRegisterForm);

				VerifyPhoneNumberRespForm verifyPhoneNumberRespForm=verifyPhoneNumberRegisterForm.getVerifyPhoneNumberRespForm();
				
				if(verifyPhoneNumberRespForm.getRespCode().equals("000")&&
					verifyPhoneNumberRespForm.getRespDescription().equals("Success.")){
				
				DirectPaymentAPIPrepareForm directPaymentAPIPrepareForm=new DirectPaymentAPIPrepareForm();
				
				directPaymentAPIPrepareForm.setPaymentMethod(verifyPhoneNumberRegisterForm.getPaymentMethod());
				directPaymentAPIPrepareForm.setVerifyPhoneNumberRespForm(verifyPhoneNumberRegisterForm.getVerifyPhoneNumberRespForm());
				directPaymentAPIPrepareForm.setVerifyPhoneNumberForm(verifyPhoneNumberRegisterForm.getVerifyPhoneNumberForm());
				
				checkOutService.prepareDirectPaymantAPICheckOut(directPaymentAPIPrepareForm);
				
				String errorMsg="သင်၏ဖုန်းနံပတ်သည် one pay ဖုန်းနံပတ် ဖြစ်ပါသည်။";
				DirectPaymentAPIRespForm directPaymentAPIRespForm=directPaymentAPIPrepareForm.getDirectPaymentAPIRespForm();
				PaymentMethod paymentMethod=directPaymentAPIPrepareForm.getPaymentMethod();
				
				if(directPaymentAPIRespForm.getRespCode().equals("000")&&
				directPaymentAPIRespForm.getRespDescription().equals("Success"))
				{
					String successStr="သင်၏One Pay APP တွင်အကြောင်းကြားစာရောက်ပါမည်။"+
									"ငွေပေးချေမှု အောင်မြင်ရန် ထိုအကြောင်းကြားစာကို နိုပ်ပြီးငွေပေးခြေမှုပြုလုပ်ပေးပါ။";
					
					paymentRespForm.setRespCode("000");
					paymentRespForm.setRespDesc(errorMsg+successStr);
				
					ProductOrder productOrder=productOrders.get(0);
					ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.
					getProductTitleLanguageByProduct(productOrder.getProduct().getProductId(),1);
					
					orderForm.setPaymentMethod(paymentMethod);
					orderForm.setDeliveryType(this.deliveryTypeDao.getDeliveryTypeById(1));
					orderForm.setOrderStatus(this.orderStatusDao.getOrderStatusById(1));
					orderForm.setDeliveryAddress(this.deliveryAddressDao.getDeliveryAddressById(1));
					orderForm.setPhone(paymentMethod.getPhone());
					orderForm.setTotalPrice(paymentMethod.getAmount());
					orderForm.setTotalDicountRate(0.0);
					orderForm.setAddressDetails(checkOutAPIForm.getMakePaymentForm().getAddress());
					orderForm.setNote("x"+productOrder.getOrderQty()+" "+productTitleLanguage.getName()+"...");
					orderForm.setCreateDate(new Date());
					this.orderFormDao.updateOrderForm(orderForm);
					paymentMethod.setInvoiceNo(orderForm.getOrderFormId()+"");
					this.paymentMethodDao.updatePaymentMethod(paymentMethod);
				
				}else
				{
					errorMsg+="သင်၏ငွေပေးချေမှု မအောင်မြင်ပါ။";
					paymentRespForm.setRespCode("014");
					paymentRespForm.setRespDesc(errorMsg);
				}
			
					
				}else
				{
					String errorMsg="သင်၏ဖုန်းနံပတ်သည် one pay Account ဖွင့်ထားသော ဖုန်းနံပတ် မဟုတ်ပါ။";
					paymentRespForm.setRespCode("012");
					paymentRespForm.setRespDesc(errorMsg);
				}
		
			}
		}
		
		}else if(orderForm==null)
		{
			paymentRespForm.setRespCode("200");
			paymentRespForm.setRespDesc("Invalid Invoice Id");
		}
		
		makePaymentRegisterForm.setPaymentRespForm(paymentRespForm);
	}

	

}
