package jp.co.taka0206.customerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.taka0206.customerapp.domain.Customer;
import jp.co.taka0206.customerapp.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
