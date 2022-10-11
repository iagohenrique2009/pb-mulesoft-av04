package br.com.mulesoft.paymentservicepb.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import br.com.mulesoft.paymentservicepb.dto.OrderDto;
import br.com.mulesoft.paymentservicepb.model.order.Item;
import br.com.mulesoft.paymentservicepb.model.order.OrderTransaction;
import br.com.mulesoft.paymentservicepb.model.order.PaymentInfo;
import br.com.mulesoft.paymentservicepb.repository.PaymentRepository;

@SpringBootTest
public class PaymentServiceTest {
	
	@Autowired
	private PaymentService service;
	
	@MockBean
	private PaymentRepository repository;
	
	
	@Test
	public void DeveRetornarUmOrderTransaction() {
		
		OrderDto dto = new OrderDto("1", List.of(new Item("aa",2,1)), 2, 1, "CREDIT_CARD","BRL", 
				new PaymentInfo("1111","adad","123","12","24","MASTERCARD"));
		
    	OrderTransaction order =service.paymentProcess(dto);
    	
    	assertNotEquals(null, order);
		
	}
	
	@Test
	public void DeveRetornarUmaListaComTodosOsPagamentos() {
		List<OrderTransaction> lista =repository.findAll();
		
		assertNotEquals(null, lista);
	}

	@Test
	void deveRetornarUmPagamento() {
		Optional<OrderTransaction> order = repository.findById(1L);
		
		assertNotEquals(null, order);
	}
	

}
