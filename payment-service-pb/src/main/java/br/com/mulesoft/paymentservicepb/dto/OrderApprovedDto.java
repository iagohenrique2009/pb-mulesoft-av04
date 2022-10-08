package br.com.mulesoft.paymentservicepb.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mulesoft.paymentservicepb.model.order.OrderApproved;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderApprovedDto {

	private Long order_id;

	private double total;
	
	private String payment_id;
	
	private String payment_status;
	
	private String message;
	
	
	public OrderApprovedDto(OrderApproved order) {
		
		this.order_id = order.getOrder_id();
		this.total = order.getTotal();
		this.payment_id = order.getPayment_id();
		this.payment_status = order.getPayment_status();
		this.message = order.getMessage();
		
		
	}
	
	
	public static List<OrderApprovedDto> convert(List<OrderApproved> order){
		return order.stream().map(OrderApprovedDto::new).collect(Collectors.toList());
		
	}
	
}
