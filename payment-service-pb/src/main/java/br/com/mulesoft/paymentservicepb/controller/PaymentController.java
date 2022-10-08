package br.com.mulesoft.paymentservicepb.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.LobHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import br.com.mulesoft.paymentservicepb.dto.OrderDto;
import br.com.mulesoft.paymentservicepb.form.TokenForm;
import br.com.mulesoft.paymentservicepb.model.Card;
import br.com.mulesoft.paymentservicepb.model.Customer;
import br.com.mulesoft.paymentservicepb.model.PaymentRequest;
import br.com.mulesoft.paymentservicepb.model.Token;
import br.com.mulesoft.paymentservicepb.service.PaymentService;
import br.com.mulesoft.paymentservicepb.util.PaymentUtil;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService service;

	
    @PostMapping
    @Transactional
    public Object pagamento(@RequestBody @Valid OrderDto dto, UriComponentsBuilder uriBuilder) {
    	
    	Token t = service.update(new TokenForm("client_id_mulesoft", "91452c37-e343-4738-a94a-be113875cb2b"));
    	System.out.println(t.getAccess_token());
    	
    	Customer customerRequestInfo= new Customer("CPF",dto.getCpf());
    	PaymentUtil util = new PaymentUtil();
    	Card card = new Card(t.getAccess_token(),dto.getPayment().getCardholder_name(),dto.getPayment().getSecurity_code(),dto.getPayment().getBrand(),dto.getPayment().getExpiration_month(),dto.getPayment().getExpiration_year());
    	String token = "Bearer "+t.getAccess_token();
    	
    	 Object a= service.ProcessPayment(token,new PaymentRequest("7be8890e-f4da-40c2-975e-0b9a87c5ad69",customerRequestInfo,
    			   dto.getPayment_type(),dto.getCurrency_type(),util.totalItens(dto),card)
    			 );
    	 
    	
    	
    	return a;
    }

}
