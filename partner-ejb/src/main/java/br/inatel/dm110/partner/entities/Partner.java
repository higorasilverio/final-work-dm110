package br.inatel.dm110.partner.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARTNER", schema = "public")
public class Partner implements Serializable {

	private static final long serialVersionUID = 4397509149862936599L;

	@Id
	@Column(name = "PARTNER_CODE")
	private Integer partnerCode;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "RATING")
	private Integer rating;

	public Partner() { }

	public Partner(
			Integer partnerCode, 
			String name, 
			String phone, 
			String email, 
			Integer rating
	) {
		this.partnerCode = partnerCode;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.rating = rating;
	}

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
		return "Partner [partnerCode=" + partnerCode + ", name=" + name 
				+ ", phone=" + phone + ", email=" + email
				+ ", rating=" + rating + "]";
	}	

}
