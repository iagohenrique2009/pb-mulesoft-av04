package br.com.mulesoft.paymentservicepb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mulesoft.paymentservicepb.model.order.OrderApproved;

public interface PaymentRepository extends JpaRepository<OrderApproved, Long> {

}
