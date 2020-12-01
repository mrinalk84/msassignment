package com.ibm.orderservice.enums;

public enum OrderStatusEnum {
	
	NEW(0, "New ShoppingCart"),
    FINISHED(1, "Finished"),
    CANCELED(2, "Canceled"),
    PACKAGED(3, "Packaged"),
    SHIPPING_INPROGRESS(4, "Shipping In Progress"),
    SHIPPED(5, "Shipped"),
    INTRANSIT(6, "In Transit"),
    OUTFORDELIVERY(7, "Out For Delivery"),
    DELIVERED(8, "Delivered")
    ;

    private  int code;
    private String message;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    

}
