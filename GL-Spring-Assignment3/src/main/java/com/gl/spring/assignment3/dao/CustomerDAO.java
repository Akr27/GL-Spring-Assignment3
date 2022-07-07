package com.gl.spring.assignment3.dao;
import com.gl.spring.assignment3.model.*;
import java.util.*;

public interface CustomerDAO {
	public int save(Customer customer);
	
	public int update(Customer customer);
	
	public Customer get(Integer cust_ID);
	
	public int delete(Integer cust_ID);
	
	public List<Customer> list();
	
	
}
