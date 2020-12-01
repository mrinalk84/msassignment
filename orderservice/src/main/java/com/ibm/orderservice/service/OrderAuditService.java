package com.ibm.orderservice.service;

public interface OrderAuditService {
	
	public void createOrderAuditRecord(String customerId, String token);

}
