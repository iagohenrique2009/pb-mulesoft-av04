package br.com.mulesoft.paymentservicepb.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import br.com.mulesoft.paymentservicepb.model.order.Item;
import br.com.mulesoft.paymentservicepb.model.order.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class OrderDto {


	
	@Length(min = 1)
	private String cpf;
	
	@Length(min = 1)
	private String cnpj;
	
	@NotNull @Valid
	private List<Item> items;
	
	@PositiveOrZero
	private double shipping;
	
	@PositiveOrZero
	private double discount;
	
	@NotEmpty @Length(min = 1)
	private String payment_type;

	@NotEmpty @Length(min = 1)
	private String currency_type;
	
	@NotNull @Valid 
	private PaymentInfo payment;

}
