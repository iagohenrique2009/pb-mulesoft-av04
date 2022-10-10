package br.com.mulesoft.paymentservicepb.controller.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorFormDto {
	
	private String field;
	
	private String message;
	
}
