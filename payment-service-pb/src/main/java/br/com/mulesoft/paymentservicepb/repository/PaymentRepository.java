package br.com.mulesoft.paymentservicepb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mulesoft.paymentservicepb.model.order.OrderTransaction;

public interface PaymentRepository extends JpaRepository<OrderTransaction, Long> {

}
