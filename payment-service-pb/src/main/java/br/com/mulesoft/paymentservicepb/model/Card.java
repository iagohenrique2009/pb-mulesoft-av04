package br.com.mulesoft.paymentservicepb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Card {
	
	private String number_token;
	
	private String cardholder_name;
	
	private String security_code;
	
	private String brand;
	
	private	String expiration_month;
	
	private String expiration_year;

}
