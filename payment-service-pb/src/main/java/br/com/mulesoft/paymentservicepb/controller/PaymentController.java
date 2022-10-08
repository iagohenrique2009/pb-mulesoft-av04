package br.com.mulesoft.paymentservicepb.controller;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mulesoft.paymentservicepb.dto.OrderApprovedDto;
import br.com.mulesoft.paymentservicepb.dto.OrderDto;
import br.com.mulesoft.paymentservicepb.model.order.OrderApproved;
import br.com.mulesoft.paymentservicepb.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	
    @PostMapping
    @Transactional
    public ResponseEntity<OrderApproved> Payment(@Valid @RequestBody OrderDto dto, UriComponentsBuilder uriBuilder) {
    	
    	
    	OrderApproved approved= paymentService.paymentProcess(dto);
    	
    	if(approved!=null) {
            URI address = uriBuilder.path("/api/v1/payment/{id}").buildAndExpand(approved.getOrder_id()).toUri();

        	paymentService.SavePayment(approved);
      
            return ResponseEntity.created(address).body(approved);
 
    	}
    	return ResponseEntity.badRequest().build();


    }
    
    @GetMapping
    public List<OrderApprovedDto> getAll(){
    	List<OrderApproved> order=paymentService.getAll();
    	return OrderApprovedDto.convert(order);
    	
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderApprovedDto> getByid(@PathVariable Long id) {

    	
    	try{
    		OrderApproved order =paymentService.getById(id);
    		return ResponseEntity.ok(new OrderApprovedDto(order));
    	}
    	catch (EntityNotFoundException e) {
    		return ResponseEntity.notFound().build();
		}
    	
    	
    }

}
