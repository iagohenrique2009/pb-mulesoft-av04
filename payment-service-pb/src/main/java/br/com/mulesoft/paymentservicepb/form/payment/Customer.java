package br.com.mulesoft.paymentservicepb.form.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
	

	private String document_type;
	
	private String document_number;

}
