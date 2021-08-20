package br.inatel.dm110.api.partner;

import java.io.Serializable;

public class PartnerTO implements Serializable {

	private static final long serialVersionUID = -191922861043294749L;
	
	private Integer partnerCode;
	private String name;
	private String phone;
	private String email;
	private Integer rating;
	
	public Integer getPartnerCode() {
		return partnerCode;
	}
	
	public void setPartnerCode(Integer partnerCode) {
		this.partnerCode = partnerCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getRating() {
		return rating;
	}
	
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "PartnerTO [partnerCode=" + partnerCode + ", name=" + name 
				+ ", phone=" + phone + ", email=" + email
				+ ", rating=" + rating + "]";
	}

}
