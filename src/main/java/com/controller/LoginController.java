package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.accessingdatamysql.User;
import com.accessingdatamysql.UserRepository;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	private UserRepository userRepository;
	@CrossOrigin
	@PostMapping()
	public String login(@RequestBody User user) {
		System.out.println("Called with " + user.getEmail());
		User userInDb = userRepository.findByEmail(user.getEmail());

		if (userInDb != null) {
			// throw error message
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, user.getEmail() + " - User alread Registered"); 
		} else {
			userRepository.save(user);
			return user.getEmail() + " - Sucessfully added";
		}
	}

}
