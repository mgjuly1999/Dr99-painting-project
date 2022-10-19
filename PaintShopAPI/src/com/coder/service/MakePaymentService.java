package com.coder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.form.DirectPaymentAPIRespForm;
import com.coder.form.MakePaymentForm;
import com.coder.form.PaymentRespForm;
import com.coder.form.VerifyPhoneNumberForm;
import com.coder.form.VerifyPhoneNumberRespForm;
import com.coder.registerForm.DirectPaymentAPIPrepareForm;
import com.coder.registerForm.MakePaymentRegisterForm;
import com.coder.registerForm.VerifyPhoneNumberRegisterForm;

@Service
@Repository("makePaymentService")
public class MakePaymentService {
	@Autowired
	private VerifyPhoneNumberService verifyPhoneNumberService;

	public void prepareMakePayment(MakePaymentRegisterForm makePaymentRegisterForm) {
		
		PaymentRespForm paymentRespForm=new PaymentRespForm();
		MakePaymentForm makePaymentForm=makePaymentRegisterForm.getMakePaymentForm();
		if(makePaymentForm!=null)
		{
			if(		makePaymentForm.getAmount()!=null &&
					makePaymentForm.getOrderId()!=null &&
					makePaymentForm.getPhone()!=null)
			{
				VerifyPhoneNumberForm verifyPhoneNumberForm=new VerifyPhoneNumberForm();
				
				verifyPhoneNumberForm.setAmount(makePaymentForm.getAmount());
				verifyPhoneNumberForm.setChannel(makePaymentForm.getChannel());
				verifyPhoneNumberForm.setInvoiceNo(makePaymentForm.getOrderId());
				verifyPhoneNumberForm.setOnepayPhoneNo(makePaymentForm.getPhone());
				verifyPhoneNumberForm.setMerchantUserId(makePaymentForm.getMerchantUserId());
				
				VerifyPhoneNumberRegisterForm  verifyPhoneNumberRegisterForm=new VerifyPhoneNumberRegisterForm();
				verifyPhoneNumberRegisterForm.setVerifyPhoneNumberForm(verifyPhoneNumberForm);
				
				verifyPhoneNumberService.prepareVerifyPhoneNumber(verifyPhoneNumberRegisterForm);

				VerifyPhoneNumberRespForm verifyPhoneNumberRespForm=verifyPhoneNumberRegisterForm.getVerifyPhoneNumberRespForm();
				
				if(verifyPhoneNumberRespForm.getRespCode().equals("000")&&
					verifyPhoneNumberRespForm.getRespDescription().equals("Success.")){
				
				DirectPaymentAPIPrepareForm directPaymentAPIPrepareForm=new DirectPaymentAPIPrepareForm();
				
				directPaymentAPIPrepareForm.setOnePayPaymentMethod(verifyPhoneNumberRegisterForm.getOnePayPaymentMethod());
				directPaymentAPIPrepareForm.setVerifyPhoneNumberRespForm(verifyPhoneNumberRegisterForm.getVerifyPhoneNumberRespForm());
				directPaymentAPIPrepareForm.setVerifyPhoneNumberForm(verifyPhoneNumberRegisterForm.getVerifyPhoneNumberForm());
				
				verifyPhoneNumberService.prepareDirectPaymantAPI(directPaymentAPIPrepareForm);
				
				String errorMsg="သင်၏ဖုန်းနံပတ်သည် one pay ဖုန်းနံပတ် ဖြစ်ပါသည်။";
				DirectPaymentAPIRespForm directPaymentAPIRespForm=directPaymentAPIPrepareForm.getDirectPaymentAPIRespForm();
				
				if(directPaymentAPIRespForm.getRespCode().equals("000")&&
				directPaymentAPIRespForm.getRespDescription().equals("Success"))
				{
					String successStr="သင်၏One Pay APP တွင်အကြောင်းကြားစာရောက်ပါမည်။"+
									"ငွေပေးချေမှု အောင်မြင်ရန် ထိုအကြောင်းကြားစာကို နိုပ်ပြီးငွေပေးခြေမှုပြုလုပ်ပေးပါ။";
					paymentRespForm.setRespCode("000");
					paymentRespForm.setRespDesc(errorMsg+successStr);
					
					makePaymentRegisterForm.getCheckOutAPIForm();
				
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
		
		makePaymentRegisterForm.setPaymentRespForm(paymentRespForm);
	}

	

}
