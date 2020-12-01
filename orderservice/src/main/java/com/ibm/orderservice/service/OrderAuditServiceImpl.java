package com.ibm.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.orderservice.entity.OrderAudit;
import com.ibm.orderservice.repository.OrderAuditRepository;

@Service
public class OrderAuditServiceImpl implements OrderAuditService {
	
	@Autowired
	OrderAuditRepository orderAuditRepository;

	@Override
	public void createOrderAuditRecord(String customerId, String token) {
		OrderAudit orderAudit = new OrderAudit();
		orderAudit.setActiveIndr(true);
		orderAudit.setUserToken(token);
		orderAuditRepository.save(orderAudit);
		
		
	}

}
