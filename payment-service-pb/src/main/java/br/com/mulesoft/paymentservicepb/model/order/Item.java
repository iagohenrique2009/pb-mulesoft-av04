package br.com.mulesoft.paymentservicepb.model.order;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	
	@NotEmpty @NotBlank
	private String item;
	
	@PositiveOrZero
	private double value;
	
	@PositiveOrZero
	private int qty;

}
