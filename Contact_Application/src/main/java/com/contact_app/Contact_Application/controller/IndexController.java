package com.contact_app.Contact_Application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.contact_app.Contact_Application.model.Contact;
import com.contact_app.Contact_Application.model.Signup;
import com.contact_app.Contact_Application.repository.ContactRepo;
import com.contact_app.Contact_Application.service.ContactServiceImpl;
import com.contact_app.Contact_Application.service.UserServiceImpl;

@Controller
@SessionAttributes("signin")
public class IndexController {
	

	
	@Autowired
	private UserServiceImpl userservice;
	
	@Autowired
	private ContactServiceImpl contactservice;
	
	@Autowired
	private ContactRepo crepo;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signup",new Signup());
		return "signup";
	}
	
	@RequestMapping("/register")
	public String registerUser(@ModelAttribute("signin") Signup signup, Model model){
		
		userservice.addUser(signup);
		return "index";
	}

	@RequestMapping("/signin")
	public String sigin(Model model) {
		Signup signin=new Signup();
		model.addAttribute("signin", signin);
		return "signin";
	}
	
	@RequestMapping("/addNewContact")
	public String addNewContact(Contact contact, Model model,@ModelAttribute("signin")Signup signup) {
		contactservice.addContact(contact,signup);
		List<Contact> allContacts=crepo.findContactByUserEmail(signup.getEmail());
		model.addAttribute("Contact",allContacts);
		model.addAttribute("addContact",new Contact());
		return "home";
	}
	@RequestMapping("/home")
	public ModelAndView home(@ModelAttribute("signin")Signup signin, Model model) {
		return userservice.signUser(signin,model);
		
	}
	@RequestMapping("/logout")
	public String logout() {
		return "index";
	}
}
