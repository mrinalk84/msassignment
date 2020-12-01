package com.ibm.orderservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="OrderAudit")
public class OrderAudit implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8887986958339932039L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long auditId;
	private String userId;
	private String orderId;
	@Column(length = 800)
	private String userToken;
	@Column(length = 800)
	private String transactionToken;
	@Column(length = 800)
	private String serviceToken;
	private Boolean activeIndr;	
	@CreationTimestamp
	private Date createDateTime;
	@UpdateTimestamp
	private Date updateDateTime;
	public Long getAuditId() {
		return auditId;
	}
	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getTransactionToken() {
		return transactionToken;
	}
	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}
	public String getServiceToken() {
		return serviceToken;
	}
	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}
	public Boolean getActiveIndr() {
		return activeIndr;
	}
	public void setActiveIndr(Boolean activeIndr) {
		this.activeIndr = activeIndr;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Date getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	
	
	

}
