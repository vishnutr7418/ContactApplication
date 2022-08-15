package com.contact_app.Contact_Application.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact_app.Contact_Application.model.Contact;
import com.contact_app.Contact_Application.model.Signup;
import com.contact_app.Contact_Application.repository.ContactRepo;

@Service
public class ContactServiceImpl {
	@Autowired
	private ContactRepo crepo;
	
	public Contact addContact(Contact contact,Signup signup) {
	
		contact.setUserEmail(signup.getEmail());
		return crepo.save(contact);
	}

}
