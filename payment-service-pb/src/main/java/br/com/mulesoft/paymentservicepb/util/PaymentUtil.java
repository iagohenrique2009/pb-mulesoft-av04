package br.com.mulesoft.paymentservicepb.util;

import br.com.mulesoft.paymentservicepb.dto.OrderDto;

public class PaymentUtil {
	
	
	public double totalItens(OrderDto dto) {
		double itemTotal=0;

		for(int i=0;i<dto.getItems().size();i++)
			itemTotal+=dto.getItems().get(i).getValue()*dto.getItems().get(i).getQty();
		
		
		return itemTotal+dto.getShipping()-dto.getDiscount();
		
	}

}
