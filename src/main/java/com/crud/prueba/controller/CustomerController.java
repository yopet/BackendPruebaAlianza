package com.crud.prueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.prueba.model.Customer;
import com.crud.prueba.service.CustomerService;

@RestController
@RequestMapping("api")
public class CustomerController {
	@Autowired
	CustomerService userService;

	// creating a get mapping that retrieves all the User detail from the database
	@GetMapping("/customer")
	private List<Customer> getAllCustomer() {
		return userService.getAllCustomer();
	}

	// creating a get mapping that retrieves the detail of a specific Customer
	@GetMapping("/customer/{userid}")
	private Optional<Customer> getCustomer(@PathVariable("userid") Long userid) {
		return userService.getCustomerById(userid);
	}

	// creating a delete mapping that deletes a specified Customer
	@DeleteMapping("/customer/{userid}")
	private void deleteCustomer(@PathVariable("userid") Long userid) {
		userService.delete(userid);
	}

	// creating post mapping that post the Customer detail in the database
	@PostMapping("/customer")
	private Long saveCustomer(@RequestBody Customer customer) {
		userService.saveOrUpdate(customer);
		return customer.getId();
	}

	// creating put mapping that updates the Customer
	@PutMapping("/customer")
	private Customer update(@RequestBody Customer customer) {
		userService.saveOrUpdate(customer);
		return customer;
	}

}
