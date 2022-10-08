package br.com.mulesoft.paymentservicepb.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TokenForm {
	
	private String client_id;
	
	private String api_key;

}
