package com.contact_app.Contact_Application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact_details")
public class Contact{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String cname;
	private String cemail;
	private String cphone;
	private String userEmail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", cname=" + cname + ", cemail=" + cemail + ", cphone=" + cphone + ", userEmail="
				+ userEmail + "]";
	}
	
}
