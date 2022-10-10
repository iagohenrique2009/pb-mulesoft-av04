package br.com.mulesoft.paymentservicepb.model.order;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {

	@NotEmpty @Length(min = 1)
	private String card_number;
	
	@NotEmpty @Length(min = 1)
	private String cardholder_name;
	
	@NotEmpty @Length(min = 1)
	private String security_code;
	
	@NotEmpty @Length(min = 1)
	private String expiration_month;
	
	@NotEmpty @Length(min = 1)
	private String expiration_year;
	
	@NotEmpty @Length(min = 1)
	private String brand;
	
	
	
}
