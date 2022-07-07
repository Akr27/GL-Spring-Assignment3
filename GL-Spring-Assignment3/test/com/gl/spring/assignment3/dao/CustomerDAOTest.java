package com.gl.spring.assignment3.dao;
import com.gl.spring.assignment3.dao.*;
import com.gl.spring.assignment3.model.Customer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class CustomerDAOTest {
	private DriverManagerDataSource dataSource;
	private CustomerDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc.mysql://localhost:3306/customerdb");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		CustomerDAO dao = new CustomerDAO(dataSource);
		
	}
	

	@Test
	void testSave() {
	
		Customer customer = new Customer("John","Smith","john.smith@gmail.com");
		int result=dao.save(customer);
		
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

}
