package com.ibm.orderservice.mapper;

import com.ibm.orderservice.dto.OrderItemDTO;
import com.ibm.orderservice.entity.OrderItem;

public class OrderItemMapper {
	
	public OrderItem convertToOrderItem(OrderItemDTO dto) {
		OrderItem item = new OrderItem();
		item.setCategoryType(dto.getCategoryType());
		item.setProductDescription(dto.getProductDescription());
		item.setProductIcon(dto.getProductIcon());
		item.setProductName(dto.getProductName());
		item.setProductPrice(dto.getProductPrice());
		item.setQuantity(dto.getQuantity());
		return item;
		
	}

}
