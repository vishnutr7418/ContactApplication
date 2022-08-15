package com.contact_app.Contact_Application.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.contact_app.Contact_Application.model.Contact;

public interface ContactRepo extends JpaRepository<Contact,String>{
	
	List<Contact> findContactByUserEmail(String userEmail);

}
