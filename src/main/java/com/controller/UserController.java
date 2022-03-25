package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accessingdatamysql.User;
import com.accessingdatamysql.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Returns all users
	 * @return
	 */
	@GetMapping()
	public List<User> getUsers() {
		return (List<User>)userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable int id ) {
		return userRepository.findById(id);
	}

	@PostMapping()
	public void addNewUser(@RequestBody User user) {
		userRepository.save(user);
		
	}
	
	@DeleteMapping("/{id}")
	public String delUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "Successfully Deleted " + id;
	}
}
