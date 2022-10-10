package br.com.mulesoft.paymentservicepb.model.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.mulesoft.paymentservicepb.model.orderprocess.OrderProcess;
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

	public OrderApproved(OrderProcess order) {
		
		this.total=order.getTransaction_amount();
		this.payment_id=order.getPayment_id();
		this.payment_status=order.getStatus();
		this.message=order.getAuthorization().getReason_message();

		
	}


	
}
