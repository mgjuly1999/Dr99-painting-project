package com.coder.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coder.dao.OnePayPaymentMethodDao;
import com.coder.form.DirectPaymentAPIForm;
import com.coder.form.DirectPaymentAPIRespForm;
import com.coder.form.ResponseDirectPaymentAPIForm;
import com.coder.form.ReturnRespDirectPaymentAPIForm;
import com.coder.form.VerifyPhoneNumberForm;
import com.coder.form.VerifyPhoneNumberRespForm;
import com.coder.model.OnePayPaymentMethod;
import com.coder.model.PaymentMethod;
import com.coder.registerForm.DirectPaymentAPIPrepareForm;
import com.coder.registerForm.RespDirectPaymentAPIPrepareForm;
import com.coder.registerForm.VerifyPhoneNumberRegisterForm;
import com.coder.util.RestURIConstants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
@Repository("verifyPhoneNumberService")
public class VerifyPhoneNumberService {
	@Autowired
	private OnePayPaymentMethodDao onePayPaymentMethodDao;

	public final String Version="02";
	public final String SecretKey="DC2B6AAE9B9B";

	
	public void prepareVerifyPhoneNumber(VerifyPhoneNumberRegisterForm verifyPhoneNumberRegisterForm) {

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
		
			OnePayPaymentMethod  onePayPaymentMethod=new OnePayPaymentMethod();
			
			
			onePayPaymentMethod.setSerialId("");
			onePayPaymentMethod.setPhone(verifyPhoneNumberForm.getOnepayPhoneNo());
			onePayPaymentMethod.setDescription("Verify Phone Number Success");
			onePayPaymentMethod.setChannel(verifyPhoneNumberForm.getChannel());
			onePayPaymentMethod.setInvoiceNo(verifyPhoneNumberForm.getInvoiceNo());
			onePayPaymentMethod.setAmount(Double.parseDouble(verifyPhoneNumberForm.getAmount()));
			onePayPaymentMethod.setRespCode(verifyPhoneNumberRespForm.getRespCode());
			onePayPaymentMethod.setMerchantUserId(verifyPhoneNumberForm.getMerchantUserId());
			onePayPaymentMethod.setRespDesc(verifyPhoneNumberRespForm.getRespDescription());
			onePayPaymentMethod.setCreateDate(new Date());
			
			int paymentMethodId=this.onePayPaymentMethodDao.saveOnePayPaymentMethod(onePayPaymentMethod);
			onePayPaymentMethod.setPaymentMethodId(paymentMethodId);
			String SerialId="CEF11DB8546456B9F10055510143AE983"+paymentMethodId;
			onePayPaymentMethod.setSerialId(SerialId);
			this.onePayPaymentMethodDao.update(onePayPaymentMethod);
			
			verifyPhoneNumberRegisterForm.setOnePayPaymentMethod(onePayPaymentMethod);
		}else
		{
			verifyPhoneNumberRegisterForm.setErrorMSG("Your Phone Number is Errors");
		}
		

	}

	

	public void prepareDirectPaymantAPI(DirectPaymentAPIPrepareForm directPaymentAPIPrepareForm) {

		
		VerifyPhoneNumberForm verifyPhoneNumberForm=directPaymentAPIPrepareForm.getVerifyPhoneNumberForm();
		OnePayPaymentMethod  onePayPaymentMethod=directPaymentAPIPrepareForm.getOnePayPaymentMethod();
		VerifyPhoneNumberRespForm verifyPhoneNumberRespForm=directPaymentAPIPrepareForm.getVerifyPhoneNumberRespForm();
		
		DirectPaymentAPIForm directPaymentAPIForm=new DirectPaymentAPIForm();
		
		if(verifyPhoneNumberRespForm.getRespCode().equals("000")&&
			verifyPhoneNumberRespForm.getRespDescription().equals("Success."))
		{
			
		directPaymentAPIForm.setVersion(Version);
		directPaymentAPIForm.setChannel(onePayPaymentMethod.getChannel());
		directPaymentAPIForm.setMerchantUserId(onePayPaymentMethod.getMerchantUserId());
		directPaymentAPIForm.setInvoiceNo(onePayPaymentMethod.getInvoiceNo());
		directPaymentAPIForm.setSequenceNo(onePayPaymentMethod.getSerialId());
		directPaymentAPIForm.setAmount(onePayPaymentMethod.getAmount()+"");
		directPaymentAPIForm.setRemark(onePayPaymentMethod.getChannel());
		directPaymentAPIForm.setWalletUserID(verifyPhoneNumberForm.getOnepayPhoneNo());
		directPaymentAPIForm.setCallBackUrl(RestURIConstants.GET_HOSTING_PATH+RestURIConstants.Call_Back_Url);
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
		
		onePayPaymentMethod.setRespCode(directPaymentAPIRespForm.getRespCode());
		onePayPaymentMethod.setRespDesc(directPaymentAPIRespForm.getRespDescription());
		onePayPaymentMethod.setDescription("Success Direct Payment");
		
		this.onePayPaymentMethodDao.update(onePayPaymentMethod);
		
		directPaymentAPIPrepareForm.setDirectPaymentAPIRespForm(directPaymentAPIRespForm);
		}
		
	
	}

	
	public void  prepareResponseDirectPaymentAPI(RespDirectPaymentAPIPrepareForm respDirectPaymentAPIPrepareForm) throws JSONException {
		
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
		
		OnePayPaymentMethod onePayPaymentMethod=
				this.onePayPaymentMethodDao.getOnePayPaymentMethodByReferIntegrationId(referIntegrationId);
	
		String HashValue1 = hash_hmac(strSignatureString,SecretKey);
		
		if(HashValue1.equals(responseDirectPaymentAPIForm.getHashValue())){
		
			
	
			if(onePayPaymentMethod.getRespCode().equals("000"))
			{	
		if(responseDirectPaymentAPIForm.getTransactionStatus().equals("000"))
			{
			
			onePayPaymentMethod.setRespCode(responseDirectPaymentAPIForm.getTransactionStatus());
			onePayPaymentMethod.setRespDesc("Success");
			onePayPaymentMethod.setDescription("Payment Success");
			this.onePayPaymentMethodDao.update(onePayPaymentMethod);
			
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
			String ReferIntegrationID =onePayPaymentMethod.getSerialId();
			String DataType = returnObject.getDataType();
			String ConfrimationUrl = returnObject.getConfrimationUrl();

			strSignatureString = RespCode + RespDescription + ItemListJsonStr + ReferIntegrationID + DataType +ConfrimationUrl;
			
			String HashValue2 = hash_hmac(strSignatureString, SecretKey);
			
			returnObject.setHashValue(HashValue2);

			respDirectPaymentAPIPrepareForm.setReturnRespDirectPaymentAPIForm(returnObject);	
			
			respDirectPaymentAPIPrepareForm.setErrorMSG("Success");		
				
			}else
		if(responseDirectPaymentAPIForm.getTransactionStatus().equals("014"))
		{
			
			onePayPaymentMethod.setRespCode(responseDirectPaymentAPIForm.getTransactionStatus());
			onePayPaymentMethod.setRespDesc("System Error");
			onePayPaymentMethod.setDescription("System Error");
			
			this.onePayPaymentMethodDao.update(onePayPaymentMethod);
			
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
			String ReferIntegrationID =onePayPaymentMethod.getSerialId();
			String DataType = returnObject.getDataType();
			String ConfrimationUrl = returnObject.getConfrimationUrl();

			strSignatureString = RespCode + RespDescription + ItemListJsonStr + ReferIntegrationID + DataType +ConfrimationUrl;
			
			String HashValue2 = hash_hmac(strSignatureString,SecretKey);
			
			returnObject.setHashValue(HashValue2);

			respDirectPaymentAPIPrepareForm.setReturnRespDirectPaymentAPIForm(returnObject);	
			
			respDirectPaymentAPIPrepareForm.setErrorMSG("Fail");		
			
			
		}else if(responseDirectPaymentAPIForm.getTransactionStatus().equals("012"))	
		{
			onePayPaymentMethod.setRespCode(responseDirectPaymentAPIForm.getTransactionStatus());
			onePayPaymentMethod.setRespDesc("Cancel Transaction");
			onePayPaymentMethod.setDescription("Cancel Transaction");
			this.onePayPaymentMethodDao.update(onePayPaymentMethod);
			
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
			String ReferIntegrationID =onePayPaymentMethod.getSerialId();
			String DataType = returnObject.getDataType();
			String ConfrimationUrl = returnObject.getConfrimationUrl();

			strSignatureString = RespCode + RespDescription + ItemListJsonStr + ReferIntegrationID + DataType +ConfrimationUrl;
			
			String HashValue2 = hash_hmac(strSignatureString, SecretKey);
			
			returnObject.setHashValue(HashValue2);

			respDirectPaymentAPIPrepareForm.setReturnRespDirectPaymentAPIForm(returnObject);	
			
			respDirectPaymentAPIPrepareForm.setErrorMSG("Cancel Transaction");
		}else
		{
			onePayPaymentMethod.setRespCode(responseDirectPaymentAPIForm.getTransactionStatus());
			onePayPaymentMethod.setRespDesc("Something Worng");
			onePayPaymentMethod.setDescription("Something Worng");
			this.onePayPaymentMethodDao.update(onePayPaymentMethod);
			
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
			String ReferIntegrationID =onePayPaymentMethod.getSerialId();
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
			onePayPaymentMethod.setRespCode("014");
			onePayPaymentMethod.setRespDesc("System Security Error");
			
			this.onePayPaymentMethodDao.update(onePayPaymentMethod);
			respDirectPaymentAPIPrepareForm.setErrorMSG("System Security Error");
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



	public void prepareRespDirectPaymentAPICheckOut(RespDirectPaymentAPIPrepareForm respDirectPaymentAPIPrepareForm) {
	
		
	}


}
