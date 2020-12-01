package com.ibm.orderservice.dto;

import java.util.ArrayList;
import java.util.List;

import com.ibm.orderservice.entity.OrderItem;

public class CustomerOrderDTO {
	
	private String userId;	
    private double cartItemTotal;
    private double shippingTotal;
    private double cartTotal;   
    private String customerId;
    private Integer orderStatus;
    private List<OrderItemDTO> orderItems = new ArrayList<>();
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getCartItemTotal() {
		return cartItemTotal;
	}
	public void setCartItemTotal(double cartItemTotal) {
		this.cartItemTotal = cartItemTotal;
	}
	public double getShippingTotal() {
		return shippingTotal;
	}
	public void setShippingTotal(double shippingTotal) {
		this.shippingTotal = shippingTotal;
	}
	public double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}
    
    

}
