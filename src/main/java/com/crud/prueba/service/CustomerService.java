package com.crud.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.prueba.model.Customer;
import com.crud.prueba.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	// getting all User record by using the method findaAll() of CrudRepository
	public List<Customer> getAllCustomer() {		
		return customerRepository.findAll();
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Optional<Customer> getCustomerById(Long id) {
		return customerRepository.findById(id);
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Customer customer) {
		customerRepository.save(customer);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(Long id) {
		customerRepository.deleteById(id);
	}

	// updating a record
	public void update(Customer customer, int userid) {
		customerRepository.save(customer);
	}

}
