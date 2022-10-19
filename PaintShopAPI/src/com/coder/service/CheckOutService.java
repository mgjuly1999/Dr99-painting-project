package com.coder.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.coder.dao.OnePayPaymentMethodDao;
import com.coder.dao.OrderFormDao;
import com.coder.dao.OrderStatusDao;
import com.coder.dao.PaymentMethodDao;
import com.coder.form.DirectPaymentAPIForm;
import com.coder.form.DirectPaymentAPIRespForm;
import com.coder.form.ResponseDirectPaymentAPIForm;
import com.coder.form.ReturnRespDirectPaymentAPIForm;
import com.coder.form.VerifyPhoneNumberForm;
import com.coder.form.VerifyPhoneNumberRespForm;
import com.coder.model.OnePayPaymentMethod;
import com.coder.model.OrderForm;
import com.coder.model.PaymentMethod;
import com.coder.registerForm.DirectPaymentAPIPrepareForm;
import com.coder.registerForm.MakePaymentRegisterForm;
import com.coder.registerForm.RespDirectPaymentAPIPrepareForm;
import com.coder.registerForm.VerifyPhoneNumberRegisterForm;
import com.coder.util.RestURIConstants;
import com.google.gson.Gson;

@Service
@Repository("checkOutService")
public class CheckOutService {
	@Autowired
	private PaymentMethodDao paymentMethodDao;
	@Autowired
	private OnePayPaymentMethodDao onePayPaymentMethodDao;
	@Autowired
	private OrderFormDao  orderFormDao;
	@Autowired
	private OrderStatusDao orderStatusDao;

	public final String Version="02";
	public final String SecretKey="DC2B6AAE9B9B";



	public void prepareDirectPaymantAPICheckOut(DirectPaymentAPIPrepareForm directPaymentAPIPrepareForm) {
	
		
		VerifyPhoneNumberForm verifyPhoneNumberForm=directPaymentAPIPrepareForm.getVerifyPhoneNumberForm();
		PaymentMethod  paymentMethod=directPaymentAPIPrepareForm.getPaymentMethod();
		VerifyPhoneNumberRespForm verifyPhoneNumberRespForm=directPaymentAPIPrepareForm.getVerifyPhoneNumberRespForm();
		
		DirectPaymentAPIForm directPaymentAPIForm=new DirectPaymentAPIForm();
		
		if(verifyPhoneNumberRespForm.getRespCode().equals("000")&&
			verifyPhoneNumberRespForm.getRespDescription().equals("Success."))
		{
			
		directPaymentAPIForm.setVersion(Version);
		directPaymentAPIForm.setChannel(paymentMethod.getChannel());
		directPaymentAPIForm.setMerchantUserId(paymentMethod.getMerchantUserId());
		directPaymentAPIForm.setInvoiceNo(paymentMethod.getInvoiceNo());
		directPaymentAPIForm.setSequenceNo(paymentMethod.getSerialId());
		directPaymentAPIForm.setAmount(paymentMethod.getAmount()+"");
		directPaymentAPIForm.setRemark(paymentMethod.getChannel());
		directPaymentAPIForm.setWalletUserID(verifyPhoneNumberForm.getOnepayPhoneNo());
		directPaymentAPIForm.setCallBackUrl(RestURIConstants.GET_HOSTING_PATH+RestURIConstants.Call_Back_Url_Check_Out);
		directPaymentAPIForm.setExpiredSeconds("180");

		
		
		String strSignatureString = 
				directPaymentAPIForm.getVersion() + 
				directPaymentAPIForm.getChannel()+ 
				directPaymentAPIForm.getMerchantUserId() + 
				directPaymentAPIForm.getWalletUserID()+ 
				directPaymentAPIForm.getAmount()+ 
				directPaymentAPIForm.getRemark()+ 
				directPaymentAPIForm.getInvoiceNo()+ 
				directPaymentAPIForm.getSequenceNo() + 
				directPaymentAPIForm.getCallBackUrl() + 
				directPaymentAPIForm.getExpiredSeconds();
		


		String HashValue = hash_hmac(strSignatureString,SecretKey);
	
		directPaymentAPIForm.setHashValue(HashValue);

		final String uri = "https://onepayuat.agdbank.com/API/Ver02/Wallet/Wallet_DirectAPIV2";
		
		
		String jsonString=postObjectWebService(uri, directPaymentAPIForm, String.class);
	
		Gson g = new Gson();
		DirectPaymentAPIRespForm directPaymentAPIRespForm = g.fromJson(jsonString, DirectPaymentAPIRespForm.class);
		
		paymentMethod.setRespCode(directPaymentAPIRespForm.getRespCode());
		paymentMethod.setRespDesc(directPaymentAPIRespForm.getRespDescription());
		paymentMethod.setDescription("Success Direct Payment");
		
		this.paymentMethodDao.update(paymentMethod);
		
		directPaymentAPIPrepareForm.setDirectPaymentAPIRespForm(directPaymentAPIRespForm);
		directPaymentAPIPrepareForm.setPaymentMethod(paymentMethod);
		}
		
	}



	public void prepareVerifyPhoneNumberCashOut(VerifyPhoneNumberRegisterForm verifyPhoneNumberRegisterForm) {
		
		VerifyPhoneNumberForm verifyPhoneNumberForm=verifyPhoneNumberRegisterForm.getVerifyPhoneNumberForm();
		
		String strSignatureString = verifyPhoneNumberForm.getChannel() + verifyPhoneNumberForm.getMerchantUserId() + verifyPhoneNumberForm.getOnepayPhoneNo();
		
		String HashValue = hash_hmac(strSignatureString,SecretKey);

		verifyPhoneNumberForm.setChannel(verifyPhoneNumberForm.getChannel());
		verifyPhoneNumberForm.setMerchantUserId(verifyPhoneNumberForm.getMerchantUserId() );
		verifyPhoneNumberForm.setHashValue(HashValue);
	
	

		String jsonString=postObjectWebService(RestURIConstants.Verify_Phone_Number_API, verifyPhoneNumberForm, String.class);
	
		
		Gson g = new Gson();
		VerifyPhoneNumberRespForm verifyPhoneNumberRespForm = g.fromJson(jsonString, VerifyPhoneNumberRespForm.class);
		verifyPhoneNumberRegisterForm.setVerifyPhoneNumberRespForm(verifyPhoneNumberRespForm);
		
		if(verifyPhoneNumberRespForm.getRespCode().equals("000")&&
		verifyPhoneNumberRespForm.getRespDescription().equals("Success."))
		{
		
			PaymentMethod  paymentMethod=new PaymentMethod();
			
			
			paymentMethod.setSerialId("");
			paymentMethod.setPhone(verifyPhoneNumberForm.getOnepayPhoneNo());
			paymentMethod.setDescription("Verify Phone Number Success");
			paymentMethod.setChannel(verifyPhoneNumberForm.getChannel());
			paymentMethod.setInvoiceNo(verifyPhoneNumberForm.getInvoiceNo());
			paymentMethod.setAmount(Double.parseDouble(verifyPhoneNumberForm.getAmount()));
			paymentMethod.setRespCode(verifyPhoneNumberRespForm.getRespCode());
			paymentMethod.setMerchantUserId(verifyPhoneNumberForm.getMerchantUserId());
			paymentMethod.setRespDesc(verifyPhoneNumberRespForm.getRespDescription());
			paymentMethod.setCreateDate(new Date());
			
			int paymentMethodId=this.paymentMethodDao.savePaymentMethod(paymentMethod);
			paymentMethod.setPaymentMethodId(paymentMethodId);
			String SerialId="CEF11PAINTDR8903333AE981100113"+paymentMethodId;
			paymentMethod.setSerialId(SerialId);
			this.paymentMethodDao.update(paymentMethod);
			verifyPhoneNumberRegisterForm.setPaymentMethod(paymentMethod);
		}else
		{
			verifyPhoneNumberRegisterForm.setErrorMSG("Your Phone Number is Errors");
		}
		
		
	}


	
	private String postObjectWebService(String uri, Object object, Class<String> class1) {

		System.out.println(uri);
		System.out.println(object);
		
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		// Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		String messageList = restTemplate.postForObject(uri, object, String.class);

		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		
		System.out.println();
		System.out.println(messageList);
		System.out.println();
		
		return messageList;

	}

	public void prepareRespDirectPaymentAPICheckOut(RespDirectPaymentAPIPrepareForm respDirectPaymentAPIPrepareForm) {
		
		ResponseDirectPaymentAPIForm responseDirectPaymentAPIForm=respDirectPaymentAPIPrepareForm.getResponseDirectPaymentAPIForm();
		String strSignatureString = null;
		
		if(responseDirectPaymentAPIForm.getTransactionID()!=null){
		 strSignatureString = 
				responseDirectPaymentAPIForm.getMerchantUserId()
				+ responseDirectPaymentAPIForm.getReferIntegrationId() 
				+responseDirectPaymentAPIForm.getInvoiceNo()
				+ responseDirectPaymentAPIForm.getAmount() 
				+ responseDirectPaymentAPIForm.getTransactionStatus()
				+ responseDirectPaymentAPIForm.getTransactionID();
		}else
		{
			 strSignatureString = 
						responseDirectPaymentAPIForm.getMerchantUserId()
						+ responseDirectPaymentAPIForm.getReferIntegrationId() 
						+responseDirectPaymentAPIForm.getInvoiceNo()
						+ responseDirectPaymentAPIForm.getAmount() 
						+ responseDirectPaymentAPIForm.getTransactionStatus()
						+"";
		}
		
		String referIntegrationId=responseDirectPaymentAPIForm.getReferIntegrationId();
		
		PaymentMethod paymentMethod=
				this.paymentMethodDao.getPaymentMethodByReferIntegrationId(referIntegrationId);
	
		String HashValue1 = hash_hmac(strSignatureString,SecretKey);
		
		if(HashValue1.equals(responseDirectPaymentAPIForm.getHashValue())){
		
			
	
			if(paymentMethod.getRespCode().equals("000"))
			{	
		if(responseDirectPaymentAPIForm.getTransactionStatus().equals("000"))
			{
			
			paymentMethod.setRespCode(responseDirectPaymentAPIForm.getTransactionStatus());
			paymentMethod.setRespDesc("Success");
			paymentMethod.setDescription("Payment Success");
			this.paymentMethodDao.update(paymentMethod);
			
			ReturnRespDirectPaymentAPIForm returnObject = new ReturnRespDirectPaymentAPIForm();

			returnObject.setReferIntegrationId(responseDirectPaymentAPIForm.getReferIntegrationId());
			returnObject.setDataType("Link");
			returnObject.setConfrimationUrl(RestURIConstants.GET_HOSTING_PATH+RestURIConstants.ConfrimationPage);
			returnObject.setItemListJsonStr(null);
			returnObject.setRespDescription("Success");
			returnObject.setRespCode("000");
			
			String RespCode = returnObject.getRespCode();
			
			String RespDescription = returnObject.getRespDescription();
			String ItemListJsonStr =null;
			String ReferIntegrationID =paymentMethod.getSerialId();
			String DataType = returnObject.getDataType();
			String ConfrimationUrl = returnObject.getConfrimationUrl();

			strSignatureString = RespCode + RespDescription + ItemListJsonStr + ReferIntegrationID + DataType +ConfrimationUrl;
			
			String HashValue2 = hash_hmac(strSignatureString, SecretKey);
			
			returnObject.setHashValue(HashValue2);

			respDirectPaymentAPIPrepareForm.setReturnRespDirectPaymentAPIForm(returnObject);	
			
			respDirectPaymentAPIPrepareForm.setErrorMSG("Success");	
			int invoiceNo=Integer.parseInt(paymentMethod.getInvoiceNo());
			OrderForm orderForm=this.orderFormDao.getOrderFormById(invoiceNo);
			
			orderForm.setOrderStatus(orderStatusDao.getOrderStatusById(2));
			//orderForm.setNote("OnePay Appကိုအသုံးပြု၍ငွေပေးခြေမှူပြီးပါပြီ");
			this.orderFormDao.updateOrderForm(orderForm);
		  
				
			}else
		if(responseDirectPaymentAPIForm.getTransactionStatus().equals("014"))
		{
			
			paymentMethod.setRespCode(responseDirectPaymentAPIForm.getTransactionStatus());
			paymentMethod.setRespDesc("System Error");
			paymentMethod.setDescription("System Error");
			
			this.paymentMethodDao.update(paymentMethod);
			
			ReturnRespDirectPaymentAPIForm returnObject = new ReturnRespDirectPaymentAPIForm();

			returnObject.setReferIntegrationId(responseDirectPaymentAPIForm.getReferIntegrationId());
			returnObject.setDataType("Link");
			returnObject.setConfrimationUrl(RestURIConstants.GET_HOSTING_PATH+RestURIConstants.ConfrimationPage);
			returnObject.setItemListJsonStr(null);
			returnObject.setRespDescription("Fail");
			returnObject.setRespCode("001");
			
			String RespCode = returnObject.getRespCode();
			
			String RespDescription = returnObject.getRespDescription();
			String ItemListJsonStr =null;
			String ReferIntegrationID =paymentMethod.getSerialId();
			String DataType = returnObject.getDataType();
			String ConfrimationUrl = returnObject.getConfrimationUrl();

			strSignatureString = RespCode + RespDescription + ItemListJsonStr + ReferIntegrationID + DataType +ConfrimationUrl;
			
			String HashValue2 = hash_hmac(strSignatureString,SecretKey);
			
			returnObject.setHashValue(HashValue2);

			respDirectPaymentAPIPrepareForm.setReturnRespDirectPaymentAPIForm(returnObject);	
			
			respDirectPaymentAPIPrepareForm.setErrorMSG("Fail");		
			
			
		}else if(responseDirectPaymentAPIForm.getTransactionStatus().equals("012"))	
		{
			paymentMethod.setRespCode(responseDirectPaymentAPIForm.getTransactionStatus());
			paymentMethod.setRespDesc("Cancel Transaction");
			paymentMethod.setDescription("Cancel Transaction");
			this.paymentMethodDao.update(paymentMethod);
			
			ReturnRespDirectPaymentAPIForm returnObject = new ReturnRespDirectPaymentAPIForm();

			returnObject.setReferIntegrationId(responseDirectPaymentAPIForm.getReferIntegrationId());
			returnObject.setDataType("Link");
			returnObject.setConfrimationUrl(RestURIConstants.GET_HOSTING_PATH+RestURIConstants.ConfrimationPage);
			returnObject.setItemListJsonStr(null);
			returnObject.setRespDescription("Fail");
			returnObject.setRespCode("002");
			
			String RespCode = returnObject.getRespCode();
			
			String RespDescription = returnObject.getRespDescription();
			String ItemListJsonStr =null;
			String ReferIntegrationID =paymentMethod.getSerialId();
			String DataType = returnObject.getDataType();
			String ConfrimationUrl = returnObject.getConfrimationUrl();

			strSignatureString = RespCode + RespDescription + ItemListJsonStr + ReferIntegrationID + DataType +ConfrimationUrl;
			
			String HashValue2 = hash_hmac(strSignatureString, SecretKey);
			
			returnObject.setHashValue(HashValue2);

			respDirectPaymentAPIPrepareForm.setReturnRespDirectPaymentAPIForm(returnObject);	
			
			respDirectPaymentAPIPrepareForm.setErrorMSG("Cancel Transaction");
			
		}else
		{
			paymentMethod.setRespCode(responseDirectPaymentAPIForm.getTransactionStatus());
			paymentMethod.setRespDesc("Something Worng");
			paymentMethod.setDescription("Something Worng");
			this.paymentMethodDao.update(paymentMethod);
			
			ReturnRespDirectPaymentAPIForm returnObject = new ReturnRespDirectPaymentAPIForm();

			returnObject.setReferIntegrationId(responseDirectPaymentAPIForm.getReferIntegrationId());
			returnObject.setDataType("Link");
			returnObject.setConfrimationUrl(RestURIConstants.GET_HOSTING_PATH+RestURIConstants.ConfrimationPage);
			returnObject.setItemListJsonStr(null);
			returnObject.setRespDescription("Fail");
			returnObject.setRespCode("002");
			
			String RespCode = returnObject.getRespCode();
			
			String RespDescription = returnObject.getRespDescription();
			String ItemListJsonStr =null;
			String ReferIntegrationID =paymentMethod.getSerialId();
			String DataType = returnObject.getDataType();
			String ConfrimationUrl = returnObject.getConfrimationUrl();

			strSignatureString = RespCode + RespDescription + ItemListJsonStr + ReferIntegrationID + DataType +ConfrimationUrl;
			
			String HashValue2 = hash_hmac(strSignatureString, SecretKey);
			
			returnObject.setHashValue(HashValue2);

			respDirectPaymentAPIPrepareForm.setReturnRespDirectPaymentAPIForm(returnObject);	
			
			respDirectPaymentAPIPrepareForm.setErrorMSG("Something Worng");
		}
		

	}else 
	{
		respDirectPaymentAPIPrepareForm.setErrorMSG("Fail");	
	}

		}else
		{
			paymentMethod.setRespCode("014");
			paymentMethod.setRespDesc("System Security Error");
			
			this.paymentMethodDao.update(paymentMethod);
			respDirectPaymentAPIPrepareForm.setErrorMSG("System Security Error");
		}
		
	}
	public static String hash_hmac(String testString, String secretKey) {
		String mykey = secretKey;
		String test = testString;
		String hashing = "";
		try {
			Mac mac = Mac.getInstance("HMACSHA1");
			SecretKeySpec secret = new SecretKeySpec(mykey.getBytes(), "HMACSHA1");
			mac.init(secret);
			byte[] digest = mac.doFinal(test.getBytes());

			for (byte b : digest) {
				hashing += String.format("%02x", b);
			}
			return hashing.toUpperCase();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hashing;
	}






}
