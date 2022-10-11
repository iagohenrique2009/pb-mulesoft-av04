package br.com.mulesoft.paymentservicepb.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mulesoft.paymentservicepb.form.payment.PaymentForm;
import br.com.mulesoft.paymentservicepb.form.token.Token;
import br.com.mulesoft.paymentservicepb.form.token.TokenForm;
import br.com.mulesoft.paymentservicepb.model.orderprocess.OrderProcess;

@FeignClient(name = "gateway",url = "https://pb-getway-payment.herokuapp.com")
public interface PaymentClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/v1/auth", consumes = "application/json", produces = "application/json")
    Token getToken(@RequestBody TokenForm form);
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/v1/payments/credit-card", consumes = "application/json", produces = "application/json")
    OrderProcess processPayment(@RequestHeader("Authorization") String token,@RequestBody PaymentForm form);


	
}
