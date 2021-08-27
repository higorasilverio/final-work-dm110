package br.inatel.dm110.api.partner;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AuditTO implements Serializable {

	private static final long serialVersionUID = 6792118555485393472L;
	
	private Integer id;
	private Integer partnerCode;
	private String operation;
	private LocalDateTime timeStamp;

	public AuditTO() { }
	
	public AuditTO( 
			Integer partnerCode, 
			String operation, 
			LocalDateTime timeStamp
	) {
		this.partnerCode = partnerCode;
		this.operation = operation;
		this.timeStamp = timeStamp;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getPartnerCode() {
		return partnerCode;
	}
	
	public void setPartnerCode(Integer partnerCode) {
		this.partnerCode = partnerCode;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "AuditTO [id=" + id + ", partnerCode=" + partnerCode 
				+ ", operation=" + operation + ", timeStamp="
				+ timeStamp + "]";
	}

}
