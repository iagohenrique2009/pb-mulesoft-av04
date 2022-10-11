package br.com.mulesoft.paymentservicepb.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mulesoft.paymentservicepb.dto.OrderApprovedDto;
import br.com.mulesoft.paymentservicepb.dto.OrderDto;
import br.com.mulesoft.paymentservicepb.http.PaymentClient;
import br.com.mulesoft.paymentservicepb.model.order.Item;
import br.com.mulesoft.paymentservicepb.model.order.OrderTransaction;
import br.com.mulesoft.paymentservicepb.model.order.PaymentInfo;
import br.com.mulesoft.paymentservicepb.repository.PaymentRepository;
import br.com.mulesoft.paymentservicepb.service.PaymentService;

@WebMvcTest(controllers =PaymentController.class)
class PaymentControllerTest {

	@MockBean
	private PaymentClient client;
	
	@Autowired
	private PaymentController controller;
	
	@MockBean
	private PaymentService service;
	
	@MockBean
	private PaymentRepository repository;
	
	@Mock
	UriComponentsBuilder uriComponentsBuilder;

	
	@Test
	void deveRetornarUmaListaquandoBuscarTodososPagamentos() throws Exception {
		
		List<OrderApprovedDto> pagamentos = controller.getAll();
		assertNotEquals(null, pagamentos);

	}

	@Test
	void deveRetornarOKQuandoBuscarUmId() {
		ResponseEntity<OrderApprovedDto> order=controller.getByid(1L);
		assertNotEquals(order, null);
		
	}
	
	@Test
	void deveRetornarUmobjetoSefoiCriadoUmObjeto() {
		
		OrderDto dto = new OrderDto("1", List.of(new Item("aa",2,1)), 2, 1, "CREDIT_CARD","BRL", 
				new PaymentInfo("1111","adad","123","12","24","MASTERCARD"));
		
		ResponseEntity<OrderTransaction> pay=controller.Payment(dto, uriComponentsBuilder);
		if(pay==null) {
			fail();
		}
		assertNotEquals(null,pay);
		
	}

}
