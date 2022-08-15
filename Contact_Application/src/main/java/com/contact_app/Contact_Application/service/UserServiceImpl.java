package com.contact_app.Contact_Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.contact_app.Contact_Application.model.Contact;
import com.contact_app.Contact_Application.model.Signup;
import com.contact_app.Contact_Application.repository.ContactRepo;
import com.contact_app.Contact_Application.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private ContactRepo crepo;
	
	public Signup addUser(Signup signup) {
		return userrepo.save(signup);
	}
	
	public ModelAndView signUser(@ModelAttribute("signin")Signup signin,Model model) {
		Optional<Signup> findUser=userrepo.findById(signin.getEmail());
		
		ModelAndView modelandview=new ModelAndView();
		if(findUser.isPresent()) {
			Signup userFound=findUser.get();
			if((signin.getPassword()).equals(userFound.getPassword())) {
				modelandview.setViewName("home");
				model.addAttribute("addContact",new Contact());
				List<Contact> allContacts=crepo.findContactByUserEmail(signin.getEmail());
				model.addAttribute("Contact",allContacts);
				return modelandview;
			}
			else {
				model.addAttribute("signin",signin);
				modelandview.setViewName("index");
				return modelandview;
				}
		}
		else {
			model.addAttribute("signin",signin);
			modelandview.setViewName("index");
			return modelandview;
		}		
	}
}
