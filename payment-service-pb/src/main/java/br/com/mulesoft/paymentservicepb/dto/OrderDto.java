package br.com.mulesoft.paymentservicepb.dto;

import java.util.List;

import br.com.mulesoft.paymentservicepb.model.Item;
import br.com.mulesoft.paymentservicepb.model.PaymentInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
	
	private String order_id;
	
	private String cpf;
	
	private List<Item> items;
	
	private double shipping;
	
	private double discount;
	
	private String payment_type;
	
	private String currency_type;
	
	private PaymentInfo payment;

}
