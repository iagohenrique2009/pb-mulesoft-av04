package br.com.mulesoft.paymentservicepb.model.order;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {

	@NotEmpty
	private String card_number;
	
	@NotEmpty
	private String cardholder_name;
	
	@NotEmpty
	private String security_code;
	
	@NotEmpty
	private String expiration_month;
	
	@NotEmpty
	private String expiration_year;
	
	@NotEmpty
	private String brand;
	
	
	
}
