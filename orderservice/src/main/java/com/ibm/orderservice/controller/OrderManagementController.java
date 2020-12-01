package com.ibm.orderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.orderservice.dto.CustomerOrderDTO;
import com.ibm.orderservice.service.CustomerOrderService;
import com.ibm.orderservice.util.OrderUtil;

@RestController
@RequestMapping("/ordermgt")
public class OrderManagementController {
	private static Logger logger = LoggerFactory.getLogger(OrderManagementController.class);
	
	@Autowired
	CustomerOrderService customerOrderService;
	@PostMapping("/order")
	public ResponseEntity<String> receiveOrder(@RequestHeader("Authorization") String bearerToken,
			@RequestBody CustomerOrderDTO orderDto){
		
		logger.info("bearerToken[" + bearerToken + "]");
		customerOrderService.createOrder(orderDto, OrderUtil.getTokenFromBearerToken(bearerToken));
		return ResponseEntity.ok("Success");
		
	}
	
	@PutMapping("/order/{orderId}")
	public ResponseEntity<String> deliver(@RequestHeader("Authorization") String bearerToken,
			@PathVariable(name="orderId") Long orderId){
		
		return ResponseEntity.ok("Success");
		
	}
	

}
