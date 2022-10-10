package br.com.mulesoft.paymentservicepb.model.order;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	
	@NotEmpty @Length(min = 1)
	private String item;
	
	@Positive
	private double value;
	
	@Positive
	private int qty;

}
