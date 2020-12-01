package com.ibm.orderservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.orderservice.dto.CustomerOrderDTO;
import com.ibm.orderservice.entity.CustomerOrder;
import com.ibm.orderservice.entity.OrderAudit;
import com.ibm.orderservice.enums.OrderStatusEnum;
import com.ibm.orderservice.mapper.CustomerOrderMapper;
import com.ibm.orderservice.mapper.OrderItemMapper;
import com.ibm.orderservice.repository.CustomerOrderRepository;
import com.ibm.orderservice.repository.OrderAuditRepository;
import com.ibm.orderservice.repository.OrderItemRepository;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	
	@Autowired
	CustomerOrderRepository customerOrderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	OrderAuditService orderAuditService;
	
	@Autowired
	OrderAuditRepository orderAuditRepository;

	@Override
	public void createOrder(CustomerOrderDTO customerDTO, String token) {
		CustomerOrderMapper orderMapper = new CustomerOrderMapper();
		OrderItemMapper itemMapper = new OrderItemMapper();
		customerOrderRepository.save(orderMapper.convertToCustomerOrder(customerDTO));
		customerDTO.getOrderItems().forEach(itemDto->{
			orderItemRepository.save(itemMapper.convertToOrderItem(itemDto));
		});
		orderAuditService.createOrderAuditRecord(customerDTO.getCustomerId(), token);
		
		
	}

	@Override
	public void finish(Long orderId, String token) {
		Optional<CustomerOrder> opOrder = customerOrderRepository.findById(orderId);
		if(opOrder.isPresent()) {
			CustomerOrder order = opOrder.get();
			order.setOrderStatus(OrderStatusEnum.DELIVERED.getCode());
			customerOrderRepository.save(order);
			
			
		}
		Optional<OrderAudit> opaudit = orderAuditRepository.findByOrderId(orderId);
		if(opaudit.isPresent()) {
			OrderAudit audit = opaudit.get();
			audit.setTransactionToken(token);
			orderAuditRepository.save(audit);
		}
		
		
	}

}
