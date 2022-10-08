package br.com.mulesoft.paymentservicepb.model.orderprocess;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authorization {
	
	private Long authorization_code;
	
	private String authorized_at;
	
	private int reason_code;
	
	private String reason_message;

}
