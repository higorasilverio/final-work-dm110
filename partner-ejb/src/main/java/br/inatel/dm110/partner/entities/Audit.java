package br.inatel.dm110.partner.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "AUDIT", schema = "public")
public class Audit implements Serializable {

	private static final long serialVersionUID = 3488063828493515930L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "PARTNER_CODE")
	private Integer partnerCode;
	
	@Column(name = "OPERATION")
	private String operation;
	
	@Column(name = "TIME_STAMP")
	private LocalDateTime timeStamp;

	public Audit() { }
	
	public Audit( 
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
		return "Audit [id=" + id + ", partnerCode=" + partnerCode 
				+ ", operation=" + operation + ", timeStamp="
				+ timeStamp + "]";
	}	
   
}
