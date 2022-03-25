package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accessingdatamysql.Details;
import com.accessingdatamysql.DetailsRepository;


@RestController
@RequestMapping("/api/userDetails")
public class UserDetailsController {
	@Autowired
	private DetailsRepository userDetailsRepository;
	
	@GetMapping()
	public List<Details> getUserDetails() {
		return (List<Details>)userDetailsRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Details> getUserDetails(@PathVariable int id ) {
		return userDetailsRepository.findById(id);
	}

	@PostMapping()
	public void addNewUserDetails(@RequestBody Details user) {
		userDetailsRepository.save(user);
		
	}
	
	@GetMapping("/del/{id}")
	public String delUserDetails(@PathVariable int id) {
		userDetailsRepository.deleteById(id);
		return "Successfully Deleted " + id;
	}
}
