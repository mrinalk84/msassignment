package com.ibm.orderservice.mapper;

import com.ibm.orderservice.dto.CustomerOrderDTO;
import com.ibm.orderservice.entity.CustomerOrder;

public class CustomerOrderMapper {
	
	public CustomerOrder convertToCustomerOrder(CustomerOrderDTO dto) {
		CustomerOrder order = new CustomerOrder();
		order.setCustomerId(dto.getCustomerId());
		order.setCartTotal(dto.getCartTotal());
		order.setCartItemTotal(dto.getCartItemTotal());
		order.setShippingTotal(dto.getShippingTotal());
		order.setOrderStatus(dto.getOrderStatus());
		
		return order;
		
		
	}

}
