package br.com.mulesoft.paymentservicepb.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

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


	
	@NotNull @NotEmpty
	private String cpf;
	
	@NotNull
	private List<Item> items;
	
	@PositiveOrZero
	private double shipping;
	
	@PositiveOrZero
	private double discount;
	
	@NotNull @NotEmpty
	private String payment_type;

	@NotNull @NotEmpty
	private String currency_type;
	
	@NotNull
	private PaymentInfo payment;

}
