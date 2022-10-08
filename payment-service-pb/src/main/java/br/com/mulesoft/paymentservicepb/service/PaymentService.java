package br.com.mulesoft.paymentservicepb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.mulesoft.paymentservicepb.form.TokenForm;
import br.com.mulesoft.paymentservicepb.model.PaymentRequest;
import br.com.mulesoft.paymentservicepb.model.Token;

@FeignClient(name = "aaa",url = "https://pb-getway-payment.herokuapp.com")
public interface PaymentService {
	
	@RequestMapping(method = RequestMethod.POST, value = "/v1/auth", consumes = "application/json", produces = "application/json")
    Token update(@RequestBody TokenForm form);
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/v1/payments/credit-card", consumes = "application/json", produces = "application/json")
    Object ProcessPayment(@RequestHeader("Authorization") String token,@RequestBody PaymentRequest form);


	
}
