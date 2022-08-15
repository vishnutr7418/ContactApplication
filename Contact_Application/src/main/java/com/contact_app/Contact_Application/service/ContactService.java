package com.contact_app.Contact_Application.service;


import com.contact_app.Contact_Application.model.Contact;

public interface ContactService {
	public String addContact(Contact contact,String userEmail);
	public String displayContact(Contact contact,String userEmail);

}
