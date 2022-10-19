package com.coder.service;
import java.text.DateFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;

import com.coder.apiForm.InvoiceAPIForm;
import com.coder.apiForm.InvoiceItemAPIForm;
import com.coder.apiForm.MyOrderAPIForm;
import com.coder.apiForm.OrderItem;
import com.coder.dao.ColorDao;
import com.coder.dao.ColorGroupDao;
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
import com.coder.form.ColorForm;
import com.coder.form.ColorGroupForm;
import com.coder.form.OrderFormForm;
import com.coder.form.OrderHistory;
import com.coder.form.OrderStatusForm;
import com.coder.form.ShowOrderForm;
import com.coder.form.ViewAllOrderForm;
import com.coder.model.Color;
import com.coder.model.ColorGroup;
import com.coder.model.DeliveryAddress;
import com.coder.model.DeliveryType;
import com.coder.model.Litreage;
import com.coder.model.Member;
import com.coder.model.OrderForm;
import com.coder.model.OrderStatus;
import com.coder.model.PaymentMethod;
import com.coder.model.Product;
import com.coder.model.ProductOrder;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.QtyUnit;
import com.coder.registerForm.ColorGroupRegisterForm;
import com.coder.registerForm.ColorRegisterForm;
import com.coder.registerForm.InvoiceDetailsForm;
import com.coder.registerForm.OrderFormRegisterForm;
import com.coder.registerForm.OrderStatusRegisterForm;
@Service
@Repository("orderFormService")
public class OrderFormService {
	@Autowired
	private OrderStatusDao orderStatusDao;
	@Autowired
	private OrderFormDao orderFormDao;
	@Autowired
	private DeliveryAddressDao deliveryAddressDao;
	@Autowired
	private DeliveryTypeDao deliveryTypeDao;
	@Autowired
	private PaymentMethodDao paymentMethodDao;
	@Autowired
	private ProductOrderDao  productOrderDao;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private LiterageDao litreageDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private QtyUnitDao qtyUnitDao;
	@Autowired
	private ProductTitleLanguageDao  productTitleLanguageDao;
	@Autowired
	private MemberDao memberDao;
	
	
	public void prepareOrderFormRegister(OrderFormRegisterForm orderFormRegisterForm){
		OrderFormForm orderFormForm=orderFormRegisterForm.getOrderFormForm();
		if(orderFormForm!=null){
		this.orderFormRegister(orderFormRegisterForm);	}
		orderFormRegisterForm.setOrderFormForm(new OrderFormForm());
	  List<PaymentMethod> paymentMethods=this.paymentMethodDao.getPaymentMethods();
	  for(PaymentMethod paymentMethod:paymentMethods){
		  orderFormRegisterForm.getMapPaymentMethods().put(paymentMethod.getPaymentMethodId()+"",paymentMethod.getChannel());
	  }
	  List<DeliveryAddress> deliveryAddresses=this.deliveryAddressDao.getDeliveryAddresss();
	  for(DeliveryAddress deliveryAddress:deliveryAddresses){
		  orderFormRegisterForm.getMapDeliveryAddresss().put(deliveryAddress.getDeliveryAddressId()+"",deliveryAddress.getAddress());
	  }
	  List<DeliveryType> deliveryTypes=this.deliveryTypeDao.getDeliveryTypes();
	  for(DeliveryType deliveryType:deliveryTypes){
		  orderFormRegisterForm.getMapDeliveryTypes().put(deliveryType.getDeliveryTypeId()+"",deliveryType.getName());
	  }
//	this.orderFormDao.getOrderFormByMemberAndStatus(1);
//	this.orderFormDao.getOrderFormByMemberAndStatus(2);
//	this.orderFormDao.getOrderFormByMemberAndStatus(3);
//	this.productOrderDao.getProductOrderByOrderForm(19);
//	this.productOrderDao.getProductOrderByOrderForm(20);
	
		
 	}
	private int orderFormRegister(OrderFormRegisterForm orderFormRegisterForm){
		OrderForm orderForm=new OrderForm();
	    OrderFormForm orderFormForm=orderFormRegisterForm.getOrderFormForm();
	    OrderStatus orderStatus=this.orderStatusDao.getOrderStatusById(1);
        DeliveryAddress deliveryAddress=this.deliveryAddressDao.getDeliveryAddressById(Integer.parseInt(orderFormForm.getDeliveryAddressId()));
	    DeliveryType deliveryType=this.deliveryTypeDao.getDeliveryTypeById(Integer.parseInt(orderFormForm.getDeliveryTypeId()));
	    PaymentMethod paymentMethod=this.paymentMethodDao.getPaymentMethodById(Integer.parseInt(orderFormForm.getPaymentMethodId()));
	    orderForm.setDeliveryType(deliveryType);
	    orderForm.setDeliveryAddress(deliveryAddress);
	    orderForm.setOrderStatus(orderStatus);
	    orderForm.setCreateDate(new Date());
	    orderForm.setAddressDetails(orderFormForm.getAddressDetails());
	    orderForm.setNote(orderFormForm.getNote());
	    orderForm.setPhone(orderFormForm.getPhone());
	    
	    orderForm.setPaymentMethod(paymentMethod);
	    orderForm.setTotalDicountRate(Double.parseDouble(orderFormForm.getTotalDicountRate()));
	    orderForm.setTotalPrice(Double.parseDouble(orderFormForm.getTotalPrice()));
	    
	    int id=this.orderFormDao.saveOrderForm(orderForm);
	return id; 
	}
    public void prepareShowAllOrderFrom(OrderFormRegisterForm orderFormRegisterForm){
    List<OrderForm> orderForms=this.orderFormDao.getOrderForms();
    List<ShowOrderForm> showOrderForms=new ArrayList<>();
    for(OrderForm orderForm:orderForms){
    	ShowOrderForm showOrderForm=new ShowOrderForm();
    	showOrderForm.setOrderStatus(this.orderStatusDao.getOrderStatusByOrderForm(orderForm.getOrderFormId()));
    	showOrderForm.setDeliveryType(this.deliveryTypeDao.getDeliveryTypeByOrderForm(orderForm.getOrderFormId()));
    	showOrderForm.setPaymentMethod(this.paymentMethodDao.getPaymentMethodByOrderForm(orderForm.getOrderFormId()));
    	showOrderForm.setDeliveryAddress(this.deliveryAddressDao.getDeliveryAddressByOrderForm(orderForm.getOrderFormId()));
    	showOrderForm.setOrderForm(orderForm);
    	showOrderForms.add(showOrderForm);
    }
    
    System.out.println("showOrderForms.size()="+showOrderForms.size());
    orderFormRegisterForm.setShowOrderForms(showOrderForms);  
    }
    
	public void prepareViewAllOrder(ViewAllOrderForm viewAllOrderForm) {
		
	
		List<OrderForm> orderForms=this.orderFormDao.getOrderForms();
		List<OrderHistory> orderHistorys=new ArrayList<OrderHistory>();
		
		for(OrderForm orderForm : orderForms){
		OrderHistory orderHistory=new OrderHistory();	
		int	orderFormId=orderForm.getOrderFormId();
		DeliveryAddress	deliveryAddress=this.deliveryAddressDao.getDeliveryAddressByOrderForm(orderFormId);
		DeliveryType deliveryType=this.deliveryTypeDao.getDeliveryTypeByOrderForm(orderFormId);
		OrderStatus orderStatus=this.orderStatusDao.getOrderStatusByOrderForm(orderFormId);
		
		

		orderHistory.setOrderFormId(orderForm.getOrderFormId()+"");
		orderHistory.setDeliveryAddress(deliveryAddress.getAddress());
		orderHistory.setDeliveryType(deliveryType.getName());
		orderHistory.setOrderStatus(orderStatus.getStatusName());
		orderHistory.setTotalDicountRate("0.0");
		orderHistory.setTotalPrice(orderForm.getTotalPrice()+"");
		orderHistory.setPhone(orderForm.getPhone());
		orderHistory.setAddressDetails(orderForm.getAddressDetails());
		orderHistory.setPaymentDue(orderForm.getCreateDate().toString());
		orderHistory.setNote(orderForm.getNote());
		
		orderHistorys.add(orderHistory);
		}
		
		viewAllOrderForm.setOrderHistory(orderHistorys);
	}
	public void preparenInvoiceDetails(InvoiceDetailsForm invoiceDetailsForm) {
		String orderFormIdStr=invoiceDetailsForm.getOrderFormId();
		if(orderFormIdStr!=null)
		{
			int orderFormId=Integer.parseInt(orderFormIdStr);
			OrderForm orderForm=this.orderFormDao.getOrderFormById(orderFormId);
			
			DeliveryAddress	deliveryAddress=this.deliveryAddressDao.getDeliveryAddressByOrderForm(orderFormId);
			DeliveryType deliveryType=this.deliveryTypeDao.getDeliveryTypeByOrderForm(orderFormId);
			OrderStatus orderStatus=this.orderStatusDao.getOrderStatusByOrderForm(orderFormId);
		
			invoiceDetailsForm.setOrderFormId(orderFormIdStr);
			invoiceDetailsForm.setDeliveryAddress(deliveryAddress.getAddress());
			invoiceDetailsForm.setDeliveryType(deliveryType.getName());
			invoiceDetailsForm.setOrderStatus(orderStatus.getStatusName());
			invoiceDetailsForm.setTotalDicountRate("0.0");
			invoiceDetailsForm.setTotalPrice(orderForm.getTotalPrice()+"");
			invoiceDetailsForm.setPhone(orderForm.getPhone());
			invoiceDetailsForm.setAddressDetails(orderForm.getAddressDetails());
			invoiceDetailsForm.setPaymentDue(orderForm.getCreateDate().toString());
			invoiceDetailsForm.setNote(orderForm.getNote());
			
			List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(orderFormId);
			List<OrderItem> orderItems=new ArrayList<>(0);
		
			for(ProductOrder productOrder : productOrders)
			{
				
				OrderItem orderItem=new OrderItem();
				
				Color color=this.colorDao.getColorById(productOrder.getColor().getColorId());
				Litreage literage=this.litreageDao.getLitreageById(productOrder.getLitreage().getLitreageId());
				Product product=this.productDao.getProductById(productOrder.getProduct().getProductId());
				QtyUnit qtyUnit=this.qtyUnitDao.getQtyUnitById(productOrder.getQtyUnit().getQtyUnitId());
				
				ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.
				getProductTitleLanguageByProduct(product.getProductId(),1);
				
				int literageQty=literage.getQty();
				String qtyUnitStr=qtyUnit.getUnit();
	
				double subTotal=productOrder.getOrderQty()*literage.getUnitPrice();
				
				orderItem.setProductId(product.getProductId()+"");
				orderItem.setProductName(productTitleLanguage.getName()+" / ");
				orderItem.setLitreage(literageQty+" "+qtyUnitStr);
				orderItem.setUnitPrice(literage.getUnitPrice()+"");
				orderItem.setQty(productOrder.getOrderQty()+"");
				orderItem.setSubTotal(subTotal+"");
				orderItem.setColor(color.getColorName()+" "+color.getColorNumber());
				
				orderItems.add(orderItem);
			}
			
			invoiceDetailsForm.setOrderItems(orderItems);
			
		}
		
	}
	
	public void preparenInvoiceAPIDetails(InvoiceAPIForm invoiceAPIForm) {
		String orderFormIdStr=invoiceAPIForm.getInvoiceId();
		if(orderFormIdStr!=null)
		{
			int orderFormId=Integer.parseInt(orderFormIdStr);
			OrderForm orderForm=this.orderFormDao.getOrderFormById(orderFormId);
			
			DeliveryAddress	deliveryAddress=this.deliveryAddressDao.getDeliveryAddressByOrderForm(orderFormId);
			DeliveryType deliveryType=this.deliveryTypeDao.getDeliveryTypeByOrderForm(orderFormId);
			OrderStatus orderStatus=this.orderStatusDao.getOrderStatusByOrderForm(orderFormId);
			PaymentMethod paymentMethod=this.paymentMethodDao.getPaymentMethodByOrderForm(orderFormId);
			Member member=this.memberDao.getMemberByOrderForm(orderFormId).get(0);
			DecimalFormat  df = new DecimalFormat("00000");
			String InvoiceNo=df.format(orderForm.getOrderFormId());
		
			invoiceAPIForm.setInvoiceId(InvoiceNo);
			invoiceAPIForm.setDeliveryAddress(orderForm.getAddressDetails());
			invoiceAPIForm.setDeliveryTownship(deliveryAddress.getAddress());
			if(deliveryAddress.getDeliveryPrice()<=0.0)
			{
			invoiceAPIForm.setDeliveryCharge("Free");
			invoiceAPIForm.setSubSubTotal(paymentMethod.getAmount()+"");
			}else
			{
			invoiceAPIForm.setSubSubTotal((paymentMethod.getAmount()+deliveryAddress.getDeliveryPrice())+"");
			invoiceAPIForm.setDeliveryCharge(deliveryAddress.getDeliveryPrice()+" mmk");	
			}
			invoiceAPIForm.setDeliveryType(deliveryType.getName());
			invoiceAPIForm.setOrderStatus(orderStatus.getStatusName());
			invoiceAPIForm.setTotalDiscountRate("0.0");
			invoiceAPIForm.setTaxRate("0.0");
			invoiceAPIForm.setCustomer(member.getName());
			invoiceAPIForm.setTotalPrice(orderForm.getTotalPrice()+"");
			invoiceAPIForm.setPhone(orderForm.getPhone());
			invoiceAPIForm.setPaymentDue(orderForm.getCreateDate().toString());
			
			List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(orderFormId);
			List<InvoiceItemAPIForm> invoiceItemAPIForms=new ArrayList<InvoiceItemAPIForm>(0);
			
			for(ProductOrder productOrder : productOrders)
			{
				InvoiceItemAPIForm invoiceItemAPIForm=new InvoiceItemAPIForm();
				
				Color color=this.colorDao.getColorById(productOrder.getColor().getColorId());
				Litreage literage=this.litreageDao.getLitreageById(productOrder.getLitreage().getLitreageId());
				Product product=this.productDao.getProductById(productOrder.getProduct().getProductId());
				QtyUnit qtyUnit=this.qtyUnitDao.getQtyUnitById(productOrder.getQtyUnit().getQtyUnitId());
				
				ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.
				getProductTitleLanguageByProduct(product.getProductId(),1);
				int literageQty=literage.getQty();
				String qtyUnitStr=qtyUnit.getUnit();
				double subTotal=productOrder.getOrderQty()*literage.getUnitPrice();
				
				invoiceItemAPIForm.setProductId(product.getProductId()+"");
				invoiceItemAPIForm.setProductName(productTitleLanguage.getName()+"/"+literageQty+" "+qtyUnitStr);
				invoiceItemAPIForm.setUnitPrice(literage.getUnitPrice()+"");
				invoiceItemAPIForm.setQty(productOrder.getOrderQty()+"");
				invoiceItemAPIForm.setSubTotal(subTotal+"");
				invoiceItemAPIForm.setColorNumber(color.getColorName()+" "+color.getColorNumber());
				
				invoiceItemAPIForms.add(invoiceItemAPIForm);
			}
			
			invoiceAPIForm.setInvoiceItemAPIForms(invoiceItemAPIForms);
		}
		
		
	}
		
	public List<MyOrderAPIForm> getOrderHistorysByMemberId(String memberIdStr) {
	
		int memberId=Integer.parseInt(memberIdStr);
		List<OrderForm> orderForms=this.orderFormDao.getOrderFormByMember(memberId);
		List<MyOrderAPIForm> myOrderAPIForms=new ArrayList<MyOrderAPIForm>(0);
		
		for(OrderForm orderForm : orderForms){
			
		MyOrderAPIForm myOrderAPIForm=new MyOrderAPIForm();
		DecimalFormat  df = new DecimalFormat("00000");
		String InvoiceNo=df.format(orderForm.getOrderFormId());
		myOrderAPIForm.setInvoiceId(orderForm.getOrderFormId()+"");
		myOrderAPIForm.setInvoiceNo(InvoiceNo);
		myOrderAPIForm.setDescription(orderForm.getNote());	
		myOrderAPIForm.setOrderDate(orderForm.getCreateDate()+"");
		
		if(orderForm.getOrderStatus().getStatusId().equals(1))
		{myOrderAPIForm.setStatus("unpaid");}
		else if(orderForm.getOrderStatus().getStatusId().equals(2))
		{myOrderAPIForm.setStatus("paid");}
	
		myOrderAPIForms.add(myOrderAPIForm);
		}
		return myOrderAPIForms;
		
	
	}
	
}
