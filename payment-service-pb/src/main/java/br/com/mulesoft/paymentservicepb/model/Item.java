package br.com.mulesoft.paymentservicepb.model;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	
	private String item;
	
	@Positive
	private double value;
	
	@Positive
	private int qty;

}
