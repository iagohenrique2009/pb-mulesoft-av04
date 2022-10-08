package br.com.mulesoft.paymentservicepb.form;

import java.util.List;

import br.com.mulesoft.paymentservicepb.model.Item;
import br.com.mulesoft.paymentservicepb.model.PaymentInfo;

public class OrderForm {

	
	private String cpf;
	
	private List<Item> items;
	
	private double shipping;
	
	private double discount;
	
	private String paymentType;
	
	private String cyrrencyType;
	
	private PaymentInfo payment;
}
