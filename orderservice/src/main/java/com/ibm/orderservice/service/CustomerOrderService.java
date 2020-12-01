package com.ibm.orderservice.service;

import com.ibm.orderservice.dto.CustomerOrderDTO;

public interface CustomerOrderService {
	
	public void createOrder(CustomerOrderDTO customerDTO,  String token);
	
	public void finish(Long orderId,  String token);
}
