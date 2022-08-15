package com.contact_app.Contact_Application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ModelAttribute;

@Entity
@Table(name="user_details")

public class Signup {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Id
	private String email;
	private String password;
	private String secret;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ModelAttribute("signedUserEmail")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	@Override
	
	public String toString() {
		return "Signup [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", secret="
				+ secret + "]";
	}

}
