package br.com.mulesoft.paymentservicepb.util;

import br.com.mulesoft.paymentservicepb.dto.OrderDto;
import br.com.mulesoft.paymentservicepb.exception.LessThan0r0Exception;

public class PaymentUtil {
	
	
	public double totalItens(OrderDto dto) {
		double itemTotal=0;

		
		for(int i=0;i<dto.getItems().size();i++) {
			itemTotal+=dto.getItems().get(i).getValue()*dto.getItems().get(i).getQty();
		
			if(dto.getItems().get(i).getValue() <=0 || dto.getItems().get(i).getQty()<=0)
					throw new LessThan0r0Exception("Less than 0 or 0 value in Qty or Value ");
		}
		
		
		return itemTotal+dto.getShipping()-dto.getDiscount();
		
	}

}
