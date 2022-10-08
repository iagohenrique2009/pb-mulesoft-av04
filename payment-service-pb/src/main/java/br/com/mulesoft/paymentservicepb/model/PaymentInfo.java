package br.com.mulesoft.paymentservicepb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {

	private String card_number;
	
	private String cardholder_name;
	
	private String security_code;
	
	private String expiration_month;
	
	private String expiration_year;
	
	private String brand;
	
	
	
}
