package codeura.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codeura.com.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findOneByCid(String customerId);

	Customer findById(int i);

	
}

