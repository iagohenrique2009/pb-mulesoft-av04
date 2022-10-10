package br.com.mulesoft.paymentservicepb.form.payment;

import br.com.mulesoft.paymentservicepb.dto.OrderDto;
import br.com.mulesoft.paymentservicepb.form.token.Token;
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
	
	
	public Card(Token token, OrderDto dto) {
		
		this.number_token=token.getAccess_token();
		this.cardholder_name=dto.getPayment().getCardholder_name();
		this.security_code=dto.getPayment().getSecurity_code();
		this.brand=dto.getPayment().getBrand();
		this.expiration_month=dto.getPayment().getExpiration_month();
		this.expiration_year=dto.getPayment().getExpiration_year();
		
	}

}
