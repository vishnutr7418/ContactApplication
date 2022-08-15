package com.contact_app.Contact_Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact_app.Contact_Application.model.Signup;


public interface UserRepo extends JpaRepository<Signup,String>{

}

