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

import com.accessingdatamysql.Marks;
import com.accessingdatamysql.MarksRepository;
import com.accessingdatamysql.User;
import com.accessingdatamysql.UserRepository;

@RestController
@RequestMapping("/api/marks")
public class MarksController {
	@Autowired
	private MarksRepository marksRepository;
	
	/**
	 * Returns marks of all subjects
	 * @return
	 */
	@GetMapping()
	public List<Marks> getMarks() {
		return (List<Marks>)marksRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Marks> getMarks(@PathVariable int id ) {
		return marksRepository.findById(id);
	}

	@PostMapping()
	public void addNewMarks(@RequestBody Marks marks) {
		marksRepository.save(marks);
		
	}
	
	@GetMapping("/del/{id}")
	public String delMarks(@PathVariable int id) {
		marksRepository.deleteById(id);
		return "Successfully Deleted " + id;
	}
}
