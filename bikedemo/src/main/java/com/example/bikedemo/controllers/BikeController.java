package com.example.bikedemo.controllers;

import java.util.*;
import com.example.bikedemo.models.*;
import com.example.bikedemo.repositories.BikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// NOTE: @@RestController before class indicates that is is controller
// @@RequestMapping can be added to method or class (all method will have same mapping)


@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {
	
	@Autowired
	private BikeRepository bikeRepository;
	
	@GetMapping
	public List<Bike> list() {
		return bikeRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike b) {
		bikeRepository.save(b);
	}
	
	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") long id) {	
		return bikeRepository.getOne(id);
	}
	
	
//@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("/{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") long id) { 
		
		//if (bikeRepository.findById(id) == id)
		try {
			bikeRepository.deleteById(id);
			return new ResponseEntity<>("Bike is deleted successsfully", HttpStatus.OK); 
		} catch(Exception e) {
			return new ResponseEntity<>("Bike is not found", HttpStatus.NOT_FOUND);
		}
	}
	
	// NOTE: appends to the class level mapping ex:localhost:8080/api/v1/bikes/status
	@GetMapping("/status")
	public ResponseEntity<Object> status()
	{
		return new ResponseEntity<>("status: working", HttpStatus.OK);
	}
}
