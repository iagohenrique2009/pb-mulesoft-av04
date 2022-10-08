package br.com.mulesoft.paymentservicepb.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mulesoft.paymentservicepb.dto.OrderDto;
import br.com.mulesoft.paymentservicepb.form.payment.Card;
import br.com.mulesoft.paymentservicepb.form.payment.Customer;
import br.com.mulesoft.paymentservicepb.form.payment.PaymentForm;
import br.com.mulesoft.paymentservicepb.form.token.Token;
import br.com.mulesoft.paymentservicepb.form.token.TokenForm;
import br.com.mulesoft.paymentservicepb.http.PaymentClient;
import br.com.mulesoft.paymentservicepb.model.order.OrderApproved;
import br.com.mulesoft.paymentservicepb.model.orderprocess.OrderProcess;
import br.com.mulesoft.paymentservicepb.repository.PaymentRepository;
import br.com.mulesoft.paymentservicepb.util.PaymentUtil;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentClient service;
	
	@Autowired
	private PaymentRepository repository;
	

	public OrderApproved paymentProcess(OrderDto dto) {
		
    	Token t = service.update(new TokenForm("client_id_mulesoft", "91452c37-e343-4738-a94a-be113875cb2b"));
    	System.out.println(t.getAccess_token());
    	
    	Customer customerRequestInfo= new Customer("CPF",dto.getCpf());
    	
    	PaymentUtil util = new PaymentUtil();
    	Double itemTotal =util.totalItens(dto);
    	
    	Card card = new Card(t.getAccess_token(),dto.getPayment().getCardholder_name(),dto.getPayment().getSecurity_code(),dto.getPayment().getBrand(),dto.getPayment().getExpiration_month(),dto.getPayment().getExpiration_year());
    	String token = "Bearer "+t.getAccess_token();
    	
    	OrderProcess order= service.ProcessPayment(token,new PaymentForm("7be8890e-f4da-40c2-975e-0b9a87c5ad69",customerRequestInfo,
    			   dto.getPayment_type(),dto.getCurrency_type(),itemTotal,card));
    			 
    	if(order.getStatus().equals("APPROVED")) {
			return new OrderApproved(order.getTransaction_amount(),order.getPayment_id(),order.getStatus(),order.getAuthorization().getReason_message());

    	}
    	return null;
	}
	public void SavePayment(OrderApproved approved) {
		
		repository.save(approved);
	}
	
	
	 public List<OrderApproved> getAll() {
	        return repository.findAll();
	 }
	 
	 public OrderApproved getById(Long id) {
	        OrderApproved order = repository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Id não Encontrado"));

	        return order;
	    }
	
	
	
}
