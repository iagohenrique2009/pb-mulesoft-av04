package br.com.mulesoft.paymentservicepb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mulesoft.paymentservicepb.dto.OrderDto;
import br.com.mulesoft.paymentservicepb.form.payment.Card;
import br.com.mulesoft.paymentservicepb.form.payment.Customer;
import br.com.mulesoft.paymentservicepb.form.payment.PaymentForm;
import br.com.mulesoft.paymentservicepb.form.token.Token;
import br.com.mulesoft.paymentservicepb.form.token.TokenForm;
import br.com.mulesoft.paymentservicepb.http.PaymentClient;
import br.com.mulesoft.paymentservicepb.model.order.OrderTransaction;
import br.com.mulesoft.paymentservicepb.model.orderprocess.OrderProcess;
import br.com.mulesoft.paymentservicepb.repository.PaymentRepository;
import br.com.mulesoft.paymentservicepb.util.PaymentUtil;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentClient client;
	
	@Autowired
	private PaymentRepository repository;
	

	public OrderTransaction paymentProcess(OrderDto dto) {
		
    	Token t = client.getToken(new TokenForm("client_id_mulesoft", "91452c37-e343-4738-a94a-be113875cb2b"));
    	System.out.println(t.getAccess_token());
    	
    	Customer customerRequestInfo;
    	
    	if(dto.getCpf()==null) { 
    		customerRequestInfo= new Customer("CNPJ",dto.getCnpj());
    	}else {
    		customerRequestInfo= new Customer("CPF",dto.getCpf());
    	}
  
    	
    	PaymentUtil util = new PaymentUtil();
    	Double itemTotal =util.totalItens(dto);
    	
    	Card card = new Card(t,dto);
    	String token = "Bearer "+t.getAccess_token();
    	
    	PaymentForm paymentForm =new PaymentForm("7be8890e-f4da-40c2-975e-0b9a87c5ad69",customerRequestInfo,
				dto.getPayment_type(),dto.getCurrency_type(),itemTotal,card);
    	
    	OrderProcess order= client.processPayment(token,paymentForm);
    			 
			return new OrderTransaction(order);

	}
	public void SavePayment(OrderTransaction approved) {
		
		repository.save(approved);
	}
	
	
	 public List<OrderTransaction> getAll() {
	        return repository.findAll();
	 }
	 
	 public Optional<OrderTransaction> getById(Long id) {
	        Optional<OrderTransaction> order = repository.findById(id);

	        return order;
	    }
	
	
	
}
