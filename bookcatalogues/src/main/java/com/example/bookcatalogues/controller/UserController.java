package com.example.bookcatalogues.controller;



import com.example.bookcatalogues.entity.User;
import com.example.bookcatalogues.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path="/user/add")
	public @ResponseBody String addNewUser(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String password, @RequestParam String username ) {
		
		User n = new User();
		n.setNom(nom);
		n.setPrenom(prenom);
		n.setEmail(email);
		n.setPassword(password);
		n.setUsername(username);
		userRepository.save(n);
		
		
		return "Saved";
		
	}
	
	@GetMapping(path="/user/all")
	public @ResponseBody Iterable<User> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userRepository.findAll();
	  }
	
	@GetMapping(path="/user/{id}")
	public @ResponseBody Optional<User> getUserById(@PathVariable Integer id){
		return userRepository.findById(id);
		
	}
	
	@GetMapping(path="/user/{username}")
	public @ResponseBody Optional<User> getUserByUsername(@PathVariable("username") String username){
		return userRepository.findUserByUsername(username);
		
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/update/{id}")
	public void updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
		userRepository.save(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/user/delete/{id}")
	public void deleteUser(@RequestBody User user, @PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}
	
	@RequestMapping(value="/user/save", method=RequestMethod.POST)    
	public ModelAndView save(@ModelAttribute User user){
		ModelAndView modelAndView = new ModelAndView();    
	    modelAndView.setViewName("form");        
	    modelAndView.addObject("user", user);      
	    return modelAndView;    
	}    
	
	
	

}
