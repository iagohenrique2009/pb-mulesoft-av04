package br.com.mulesoft.paymentservicepb.model;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @JoinColumn(name = "order_items_id")
	 private String order_id;
	
	@Enumerated(EnumType.STRING)
	private Document cpf;
	@OneToMany(targetEntity= Order.class, fetch=FetchType.EAGER)
	private List<Item> items;
	
	private double shipping;
	
	private double discount;
	
	private String paymentType;
	
	private String currencyType;
	
	@Transient
	private PaymentInfo payment;
	
	
	
	
	
	

}
