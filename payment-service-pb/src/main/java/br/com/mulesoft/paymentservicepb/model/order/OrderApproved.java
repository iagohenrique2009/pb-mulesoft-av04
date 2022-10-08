package br.com.mulesoft.paymentservicepb.model.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderApproved {
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;

	private double total;
	
	private String payment_id;
	
	private String payment_status;
	
	private String message;

	public OrderApproved(double total, String payment_id, String payment_status, String message) {
		this.total = total;
		this.payment_id = payment_id;
		this.payment_status = payment_status;
		this.message = message;
	}
	
	

	
}
