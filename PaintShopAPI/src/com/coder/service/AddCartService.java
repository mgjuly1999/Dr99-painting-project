package com.coder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.apiForm.AddCartAPIForm;
import com.coder.apiForm.CartItem;
import com.coder.apiForm.DeleteAllItemForm;
import com.coder.apiForm.DeleteOrderItemForm;
import com.coder.apiForm.InvoiceIdForm;
import com.coder.apiForm.MemberIdForm;
import com.coder.apiForm.OrderItem;
import com.coder.apiForm.ShopCartAPIForm;
import com.coder.apiForm.UpdateAllOrderItemForm;
import com.coder.apiForm.UpdateOrderItemForm;
import com.coder.dao.ColorDao;
import com.coder.dao.DeliveryAddressDao;
import com.coder.dao.DeliveryTypeDao;
import com.coder.dao.LiterageDao;
import com.coder.dao.MemberDao;
import com.coder.dao.OrderFormDao;
import com.coder.dao.OrderStatusDao;
import com.coder.dao.PaymentMethodDao;
import com.coder.dao.ProductDao;
import com.coder.dao.ProductMediaDao;
import com.coder.dao.ProductOrderDao;
import com.coder.dao.ProductTitleLanguageDao;
import com.coder.dao.QtyUnitDao;
import com.coder.model.Color;
import com.coder.model.DeliveryAddress;
import com.coder.model.DeliveryType;
import com.coder.model.Litreage;
import com.coder.model.Member;
import com.coder.model.OrderForm;
import com.coder.model.OrderStatus;
import com.coder.model.PaymentMethod;
import com.coder.model.Product;
import com.coder.model.ProductMedia;
import com.coder.model.ProductOrder;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.QtyUnit;
import com.coder.util.RestURIConstants;

@Service
@Repository("addCartService")
public class AddCartService {
@Autowired
private	MemberDao memberDao;
@Autowired
private	ProductDao productDao;
@Autowired
private	ColorDao colorDao;
@Autowired
private	LiterageDao litreageDao;
@Autowired
private OrderFormDao orderFormDao;
@Autowired
private ProductOrderDao  productOrderDao;
@Autowired
private DeliveryAddressDao deliveryAddressDao;
@Autowired
private DeliveryTypeDao deliveryTypeDao;
@Autowired
private OrderStatusDao orderStatusDao;
@Autowired
private PaymentMethodDao paymentMethodDao;
@Autowired
private QtyUnitDao qtyUnitDao;
@Autowired
private ProductTitleLanguageDao  productTitleLanguageDao;
@Autowired
private ProductMediaDao  productMediaDao;

	public ShopCartAPIForm prepareAddToCart(AddCartAPIForm addCartAPIForm) {
		ShopCartAPIForm shopCartAPIForm=null;
		int memberId=Integer.parseInt(addCartAPIForm.getMemberId());
		int productId=Integer.parseInt(addCartAPIForm.getProductId());
		int colorId=Integer.parseInt(addCartAPIForm.getColorId());
		int literageId=Integer.parseInt(addCartAPIForm.getLitreageId());
		int qty=Integer.parseInt(addCartAPIForm.getQty());
		
		
		Member member=this.memberDao.getMemberById(memberId);
		Product product=this.productDao.getProductById(productId);
		Color color=this.colorDao.getColorById(colorId);
		Litreage litreage=this.litreageDao.getLitreageById(literageId);
		QtyUnit qtyUnit=this.qtyUnitDao.getQtyUnitById(litreage.getQtyUnit().getQtyUnitId());
		if(
				member!=null &&
				product!=null &&
				color != null &&
				litreage !=null 
				)
		{
		OrderForm orderForm=this.orderFormDao.getOrderFormByMemberAndStatus(memberId);
		
		if(orderForm!=null)
		{
			 
			ProductOrder productOrder=new ProductOrder();
				
			 productOrder.setColor(color);
			 productOrder.setLitreage(litreage);
			 productOrder.setOrderForm(orderForm);
			 productOrder.setProduct(product);
			 productOrder.setQtyUnit(qtyUnit);
			 productOrder.setOrderQty(qty);
		
			ProductOrder sameProductOrder=this.productOrderDao.getSameTypeProducts(productOrder);
			
			if(sameProductOrder==null)
			{
				
		int	productOrderId=this.productOrderDao.saveProductOrder(productOrder);
		productOrder.setOrderId(productOrderId);
				
			}else if(sameProductOrder!=null)
			{
				int totalQty=sameProductOrder.getOrderQty()+productOrder.getOrderQty();
				sameProductOrder.setOrderQty(totalQty);
				this.productOrderDao.update(sameProductOrder);
				
			}
		
		}else if(orderForm==null)
		{
			
DeliveryAddress deliveryAddress=this.deliveryAddressDao.getDeliveryAddressById(1);
DeliveryType deliveryType=this.deliveryTypeDao.getDeliveryTypeById(1);
OrderStatus orderStatus=this.orderStatusDao.getOrderStatusById(3);
PaymentMethod paymentMethod=this.paymentMethodDao.getPaymentMethodById(1);

			OrderForm newOrderForm=new OrderForm();
			newOrderForm.setDeliveryAddress(deliveryAddress);
			newOrderForm.setDeliveryType(deliveryType);
			newOrderForm.setOrderStatus(orderStatus);
			newOrderForm.setPaymentMethod(paymentMethod);
			newOrderForm.setPhone("0900001000");
			newOrderForm.setAddressDetails("Cat....");
			newOrderForm.setTotalDicountRate(0.0);
			newOrderForm.setCreateDate(new Date());
			newOrderForm.setTotalPrice(0.0);
			newOrderForm.setNote("no...");
			
			Set<Member> members = new HashSet<Member>(0);
			members.add(member);
			newOrderForm.setMembers(members);
			
			int orderFormId=this.orderFormDao.saveOrderForm(newOrderForm);
			
			newOrderForm.setOrderFormId(orderFormId);
			
		 Set<ProductOrder> productOrders = new HashSet<ProductOrder>(0);
		 
		 ProductOrder productOrder=new ProductOrder();
			
		 productOrder.setColor(color);
		 productOrder.setLitreage(litreage);
		 productOrder.setOrderForm(newOrderForm);
		 productOrder.setProduct(product);
		 productOrder.setQtyUnit(qtyUnit);
		 productOrder.setOrderQty(qty);
		 
		 productOrders.add(productOrder);
		 this.productOrderDao.saveProductOrder(productOrder);
		  orderForm=this.orderFormDao.getOrderFormById(orderFormId);
		}
		
	
		List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(orderForm.getOrderFormId());
		List<CartItem> cartItems=new ArrayList<CartItem>(0);
		double grantTotal=0.0;
		for(ProductOrder productOrder : productOrders)
		{
			CartItem cartItem=new CartItem();
			
			 color=this.colorDao.getColorById(productOrder.getColor().getColorId());
			 litreage=this.litreageDao.getLitreageById(productOrder.getLitreage().getLitreageId());
			 product=this.productDao.getProductById(productOrder.getProduct().getProductId());
			 qtyUnit=this.qtyUnitDao.getQtyUnitById(productOrder.getQtyUnit().getQtyUnitId());
			
			ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.
			getProductTitleLanguageByProduct(product.getProductId(),1);
			int literageQty=litreage.getQty();
			String unitStr=qtyUnit.getUnit();
			String qtyUnitStr=literageQty+unitStr;
			
			String productName=productTitleLanguage.getName()+"/"+qtyUnitStr;
			String colorStr=color.getColorName()+" "+color.getColorNumber();
			
			List<ProductMedia> productMedias=this.productMediaDao.getProductMediaByProductIdAndFloderName(product.getProductId(),1);
			
			String imageUrl=null;
			
		if (productMedias != null) {
			ProductMedia	productMedia=productMedias.get(0);
					 imageUrl = RestURIConstants.GET_HOSTING_PATH + "/productMediaImageUploadPath?id="
							+ productMedia.getProductMediaId() + "&folderName=" + productMedia.getFolder().getName()
							+ "&frmType=0&frmImage=1";
				
				}
			

			
			cartItem.setOrderLineId(productOrder.getOrderId()+"");
			cartItem.setProductId(product.getProductId()+"");
			cartItem.setProductName(productName);
			cartItem.setUnitPrice(litreage.getUnitPrice()+"");
			cartItem.setQty(productOrder.getOrderQty()+"");
			cartItem.setColorId(color.getColorId()+"");
			cartItem.setColor(colorStr);
			cartItem.setLitreageId(litreage.getLitreageId()+"");
			cartItem.setLitreage(qtyUnitStr);
			cartItem.setImageUrl(imageUrl);
			
			 
			
			cartItems.add(cartItem);
			grantTotal+=litreage.getUnitPrice()*productOrder.getOrderQty();
		}
		
		 shopCartAPIForm=new ShopCartAPIForm();
		
		
		
		shopCartAPIForm.setInvoiceId(orderForm.getOrderFormId()+"");
		shopCartAPIForm.setTotalPrice(grantTotal+"");
		shopCartAPIForm.setCartItems(cartItems);
		shopCartAPIForm.setCreateDate(orderForm.getCreateDate().toString());

		}

		return shopCartAPIForm;
	}

	public ShopCartAPIForm prepareUpdateOrderItem(UpdateOrderItemForm updateOrderItemForm) {
			QtyUnit qtyUnit=null;
			Product product=null;
			ShopCartAPIForm shopCartAPIForm=null;
		 int orderLineId=Integer.parseInt(updateOrderItemForm.getOrderLineId());
		
		 ProductOrder updateProductOrder=this.productOrderDao.getProductOrderId(orderLineId);
		 if(updateProductOrder!=null)
		 { 
			 int litreageId=Integer.parseInt(updateOrderItemForm.getLitreageId());
		 int colorId=Integer.parseInt(updateOrderItemForm.getColorId());
		 int qty=Integer.parseInt(updateOrderItemForm.getQty());
		 
		 Litreage litreage=this.litreageDao.getLitreageById(litreageId);
		 Color color=this.colorDao.getColorById(colorId);
			 
		 updateProductOrder.setColor(color);
		 updateProductOrder.setLitreage(litreage);
		 updateProductOrder.setOrderQty(qty);
		 this.productOrderDao.updateProductOrder(updateProductOrder);
		 int orderFormId=updateProductOrder.getOrderForm().getOrderFormId();
		
		 OrderForm orderForm=this.orderFormDao.getOrderFormById(orderFormId);
		 List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(orderFormId);
		 List<CartItem> cartItems=new ArrayList<CartItem>(0);
		 double grantTotal=0.0;
		 for(ProductOrder productOrder : productOrders)
		 {
			 CartItem cartItem=new CartItem();
				
			 color=this.colorDao.getColorById(productOrder.getColor().getColorId());
			 litreage=this.litreageDao.getLitreageById(productOrder.getLitreage().getLitreageId());
			 product=this.productDao.getProductById(productOrder.getProduct().getProductId());
			 qtyUnit=this.qtyUnitDao.getQtyUnitById(productOrder.getQtyUnit().getQtyUnitId());
			
			ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.
			getProductTitleLanguageByProduct(product.getProductId(),1);
			int literageQty=litreage.getQty();
			String unitStr=qtyUnit.getUnit();
			String qtyUnitStr=literageQty+unitStr;
			
			String productName=productTitleLanguage.getName()+" /"+qtyUnitStr;
			String colorStr=color.getColorName()+" "+color.getColorNumber();
			
			String imageUrl=null;
			List<ProductMedia> productMedias=this.productMediaDao.
					getProductMediaByProductIdAndFloderName(product.getProductId(),1);
			
			if (productMedias != null) {
				ProductMedia	productMedia=productMedias.get(0);
						 imageUrl = RestURIConstants.GET_HOSTING_PATH + "/productMediaImageUploadPath?id="
								+ productMedia.getProductMediaId() + "&folderName=" + productMedia.getFolder().getName()
								+ "&frmType=0&frmImage=1";
					
					}
			
			cartItem.setOrderLineId(productOrder.getOrderId()+"");
			cartItem.setProductId(product.getProductId()+"");
			cartItem.setProductName(productName);
			cartItem.setUnitPrice(litreage.getUnitPrice()+"");
			cartItem.setQty(productOrder.getOrderQty()+"");
			cartItem.setColorId(color.getColorId()+"");
			cartItem.setColor(colorStr);
			cartItem.setLitreageId(litreage.getLitreageId()+"");
			cartItem.setLitreage(qtyUnitStr);
			cartItem.setImageUrl(imageUrl);
			
			cartItems.add(cartItem);
			grantTotal+=litreage.getUnitPrice()*productOrder.getOrderQty();	 
		 }
		  shopCartAPIForm=new ShopCartAPIForm();
			
			shopCartAPIForm.setInvoiceId(orderForm.getOrderFormId()+"");
			shopCartAPIForm.setTotalPrice(grantTotal+"");
			shopCartAPIForm.setCartItems(cartItems);
			shopCartAPIForm.setCreateDate(orderForm.getCreateDate().toString());
		 }
		

			return shopCartAPIForm;
	}

	public ShopCartAPIForm prepareDeleteOrderItem(DeleteOrderItemForm deleteOrderItemForm) {
		 ShopCartAPIForm shopCartAPIForm=null;
		int orderItemId=Integer.parseInt(deleteOrderItemForm.getOrderLineId());
		ProductOrder deleteProductOrder=this.productOrderDao.getProductOrderId(orderItemId);
		
		if(deleteProductOrder!=null)
		{
		this.productOrderDao.deleteProductOrders(deleteProductOrder);
		
		int orderFormId=deleteProductOrder.getOrderForm().getOrderFormId();
		OrderForm orderForm=this.orderFormDao.getOrderFormById(orderFormId);
		List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(orderFormId);
		
		if(productOrders.size()>0)
		{
		List<CartItem> cartItems=new ArrayList<CartItem>(0);
		 double grantTotal=0.0;
		 
		 for(ProductOrder productOrder : productOrders)
		 {
			 CartItem cartItem=new CartItem();
				
		Color color=this.colorDao.getColorById(productOrder.getColor().getColorId());
		Litreage litreage=this.litreageDao.getLitreageById(productOrder.getLitreage().getLitreageId());
		Product product=this.productDao.getProductById(productOrder.getProduct().getProductId());
		QtyUnit qtyUnit=this.qtyUnitDao.getQtyUnitById(productOrder.getQtyUnit().getQtyUnitId());
			
			ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.
			getProductTitleLanguageByProduct(product.getProductId(),1);
			int literageQty=litreage.getQty();
			String unitStr=qtyUnit.getUnit();
			String qtyUnitStr=literageQty+unitStr;
			String imageUrl=null;
			List<ProductMedia> productMedias=this.productMediaDao.
					getProductMediaByProductIdAndFloderName(product.getProductId(),1);
			
			if (productMedias != null) {
				ProductMedia	productMedia=productMedias.get(0);
						 imageUrl = RestURIConstants.GET_HOSTING_PATH + "/productMediaImageUploadPath?id="
								+ productMedia.getProductMediaId() + "&folderName=" + productMedia.getFolder().getName()
								+ "&frmType=0&frmImage=1";
					
					}
			
			String productName=productTitleLanguage.getName()+" /"+qtyUnitStr;
			String colorStr=color.getColorName()+" "+color.getColorNumber();
			
			cartItem.setOrderLineId(productOrder.getOrderId()+"");
			cartItem.setProductId(product.getProductId()+"");
			cartItem.setProductName(productName);
			cartItem.setUnitPrice(litreage.getUnitPrice()+"");
			cartItem.setQty(productOrder.getOrderQty()+"");
			cartItem.setColorId(color.getColorId()+"");
			cartItem.setColor(colorStr);
			cartItem.setLitreageId(litreage.getLitreageId()+"");
			cartItem.setLitreage(qtyUnitStr);
			cartItem.setImageUrl(imageUrl);
			
			cartItems.add(cartItem);
			grantTotal+=litreage.getUnitPrice()*productOrder.getOrderQty();	 
	
		 }
		 
		  shopCartAPIForm=new ShopCartAPIForm();
			
			shopCartAPIForm.setInvoiceId(orderForm.getOrderFormId()+"");
			shopCartAPIForm.setTotalPrice(grantTotal+"");
			shopCartAPIForm.setCartItems(cartItems);
			shopCartAPIForm.setCreateDate(orderForm.getCreateDate().toString());
		 
		}else if(productOrders.size()<=0)
		 {
			this.orderFormDao.deleteOrderForm(orderForm);
		 }
		
		}
			return shopCartAPIForm;
	}

	public ShopCartAPIForm prepareDeleteAllItem(DeleteAllItemForm deleteAllItemForm) {
	
		int invoiceId=Integer.parseInt(deleteAllItemForm.getInvoiceId());
		OrderForm orderForm=this.orderFormDao.getOrderFormById(invoiceId);
		if(orderForm!=null){
		List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(invoiceId);
		for(ProductOrder productOrder: productOrders)
		{
			this.productOrderDao.deleteProductOrders(productOrder);	
		}
		this.orderFormDao.deleteOrderForm(orderForm);
		
		ShopCartAPIForm shopCartAPIForm=new ShopCartAPIForm();
		shopCartAPIForm.setInvoiceId("deleted");
		shopCartAPIForm.setCreateDate("deleted");
		shopCartAPIForm.setTotalPrice("0.0");
		return shopCartAPIForm;
		}else
		{
			ShopCartAPIForm shopCartAPIForm=new ShopCartAPIForm();
			shopCartAPIForm.setInvoiceId("invalidId");
			shopCartAPIForm.setCreateDate("invalidId");
			shopCartAPIForm.setTotalPrice("0.0");
			return shopCartAPIForm;
		}
		
	}

	public ShopCartAPIForm prepareInvoiceIdForm(InvoiceIdForm invoiceIdForm) {
		
		 int invoiceId=Integer.parseInt(invoiceIdForm.getInvoiceId());
		 ShopCartAPIForm shopCartAPIForm=null;
		OrderForm orderForm=this.orderFormDao.getOrderFormById(invoiceId);
		
		if(orderForm!=null)
		{
		List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(invoiceId);
		 List<CartItem> cartItems=new ArrayList<CartItem>(0);
		 double grantTotal=0.0;
		 
		 for(ProductOrder productOrder : productOrders)
		 {
			 CartItem cartItem=new CartItem();
				
		Color color=this.colorDao.getColorById(productOrder.getColor().getColorId());
		Litreage litreage=this.litreageDao.getLitreageById(productOrder.getLitreage().getLitreageId());
		Product product=this.productDao.getProductById(productOrder.getProduct().getProductId());
		QtyUnit qtyUnit=this.qtyUnitDao.getQtyUnitById(productOrder.getQtyUnit().getQtyUnitId());
			
			ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.
			getProductTitleLanguageByProduct(product.getProductId(),1);
			int literageQty=litreage.getQty();
			String unitStr=qtyUnit.getUnit();
			String qtyUnitStr=literageQty+unitStr;
			
			String productName=productTitleLanguage.getName()+" /"+qtyUnitStr;
			String colorStr=color.getColorName()+" "+color.getColorNumber();
			String imageUrl=null;
			List<ProductMedia> productMedias=this.productMediaDao.
					getProductMediaByProductIdAndFloderName(product.getProductId(),1);
			
			if (productMedias != null) {
				ProductMedia	productMedia=productMedias.get(0);
						 imageUrl = RestURIConstants.GET_HOSTING_PATH + "/productMediaImageUploadPath?id="
								+ productMedia.getProductMediaId() + "&folderName=" + productMedia.getFolder().getName()
								+ "&frmType=0&frmImage=1";
					
					}
			
			cartItem.setOrderLineId(productOrder.getOrderId()+"");
			cartItem.setProductId(product.getProductId()+"");
			cartItem.setProductName(productName);
			cartItem.setUnitPrice(litreage.getUnitPrice()+"");
			cartItem.setQty(productOrder.getOrderQty()+"");
			cartItem.setColorId(color.getColorId()+"");
			cartItem.setColor(colorStr);
			cartItem.setLitreageId(litreage.getLitreageId()+"");
			cartItem.setLitreage(qtyUnitStr);
			cartItem.setImageUrl(imageUrl);
			
			cartItems.add(cartItem);
			grantTotal+=litreage.getUnitPrice()*productOrder.getOrderQty();	 
		 }
		 
		    shopCartAPIForm=new ShopCartAPIForm();
			
			shopCartAPIForm.setInvoiceId(orderForm.getOrderFormId()+"");
			shopCartAPIForm.setTotalPrice(grantTotal+"");
			shopCartAPIForm.setCartItems(cartItems);
			shopCartAPIForm.setCreateDate(orderForm.getCreateDate().toString());
		}

			return shopCartAPIForm;
	}

	public ShopCartAPIForm prepareUpdateAllOrderItem(UpdateAllOrderItemForm updateAllOrderItemForm) {
		
		ShopCartAPIForm	shopCartAPIForm=null;
		if(updateAllOrderItemForm!=null)
		{
			List<UpdateOrderItemForm> updateOrderItemForms=updateAllOrderItemForm.getUpdateOrderItems();
			for(UpdateOrderItemForm updateOrderItemForm : updateOrderItemForms)
			{
					shopCartAPIForm=this.prepareUpdateOrderItem(updateOrderItemForm);
					if(shopCartAPIForm==null)
					{
						return shopCartAPIForm;
					}
			}
		}
		
		return shopCartAPIForm;
	}

	public ShopCartAPIForm prepareGetInvoiceByMemberId(MemberIdForm memberIdForm) {
		int memberId=Integer.parseInt(memberIdForm.getMemberId());
		ShopCartAPIForm shopCartAPIForm=null;
		OrderForm orderForm=this.orderFormDao.getOrderFormByMemberAndStatus(memberId);
		
		if(orderForm!=null)
		{
		List<ProductOrder> productOrders=this.productOrderDao.getProductOrderByOrderForm(orderForm.getOrderFormId());
		 List<CartItem> cartItems=new ArrayList<CartItem>(0);
		 double grantTotal=0.0;
		 
		 for(ProductOrder productOrder : productOrders)
		 {
			 CartItem cartItem=new CartItem();
				
		Color color=this.colorDao.getColorById(productOrder.getColor().getColorId());
		Litreage litreage=this.litreageDao.getLitreageById(productOrder.getLitreage().getLitreageId());
		Product product=this.productDao.getProductById(productOrder.getProduct().getProductId());
		QtyUnit qtyUnit=this.qtyUnitDao.getQtyUnitById(productOrder.getQtyUnit().getQtyUnitId());
			
			ProductTitleLanguage productTitleLanguage=this.productTitleLanguageDao.
			getProductTitleLanguageByProduct(product.getProductId(),1);
			int literageQty=litreage.getQty();
			String unitStr=qtyUnit.getUnit();
			String qtyUnitStr=literageQty+unitStr;
			
			String productName=productTitleLanguage.getName()+" /"+qtyUnitStr;
			String colorStr=color.getColorName()+" "+color.getColorNumber();
			String imageUrl=null;
			List<ProductMedia> productMedias=this.productMediaDao.
					getProductMediaByProductIdAndFloderName(product.getProductId(),1);
			
			if (productMedias != null) {
				ProductMedia	productMedia=productMedias.get(0);
						 imageUrl = RestURIConstants.GET_HOSTING_PATH + "/productMediaImageUploadPath?id="
								+ productMedia.getProductMediaId() + "&folderName=" + productMedia.getFolder().getName()
								+ "&frmType=0&frmImage=1";
					
					}
			
			cartItem.setOrderLineId(productOrder.getOrderId()+"");
			cartItem.setProductId(product.getProductId()+"");
			cartItem.setProductName(productName);
			cartItem.setUnitPrice(litreage.getUnitPrice()+"");
			cartItem.setQty(productOrder.getOrderQty()+"");
			cartItem.setColorId(color.getColorId()+"");
			cartItem.setColor(colorStr);
			cartItem.setLitreageId(litreage.getLitreageId()+"");
			cartItem.setLitreage(qtyUnitStr);
			cartItem.setImageUrl(imageUrl);
			
			cartItems.add(cartItem);
			grantTotal+=litreage.getUnitPrice()*productOrder.getOrderQty();	 
		 }
		 
		    shopCartAPIForm=new ShopCartAPIForm();
			
			shopCartAPIForm.setInvoiceId(orderForm.getOrderFormId()+"");
			shopCartAPIForm.setTotalPrice(grantTotal+"");
			shopCartAPIForm.setCartItems(cartItems);
			shopCartAPIForm.setCreateDate(orderForm.getCreateDate().toString());
		}

			return shopCartAPIForm;
	}
	
}
