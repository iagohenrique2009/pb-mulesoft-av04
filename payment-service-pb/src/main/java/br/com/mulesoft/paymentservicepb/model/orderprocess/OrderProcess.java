package br.com.mulesoft.paymentservicepb.model.orderprocess;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProcess {
	

	private String payment_id;
	
	private String seller_id;
	
	private double transaction_amount;
	
	private String currency;
	
	private String status;
	
	private String received_at;
	
	private Authorization authorization;

}
