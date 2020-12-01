package com.ibm.orderservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.orderservice.entity.OrderAudit;

@Repository
public interface OrderAuditRepository extends JpaRepository<OrderAudit, Long>{
	
	Optional<OrderAudit> findByOrderId(Long orderId);
	

}
