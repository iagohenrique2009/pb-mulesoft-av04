package br.com.mulesoft.paymentservicepb.form.payment;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentForm {

	private String seller_id;
	
	private Customer customer;
	
	private String payment_type;
	
	private String currency;
	
	private double transaction_amount;
	
	private Card card;

}
