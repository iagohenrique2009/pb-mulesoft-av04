package br.com.mulesoft.paymentservicepb.form.order;

import java.util.List;

import br.com.mulesoft.paymentservicepb.model.order.Item;
import br.com.mulesoft.paymentservicepb.model.order.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
	
	private String cpf;
	
	private List<Item> items;
	
	private double shipping;
	
	private double discount;
	
	private String paymentType;
	
	private String currencyType;
	
	private PaymentInfo payment;
}
