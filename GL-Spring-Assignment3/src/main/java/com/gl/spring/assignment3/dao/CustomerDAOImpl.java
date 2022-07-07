package com.gl.spring.assignment3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import com.gl.spring.assignment3.model.Customer;

@SuppressWarnings("unused")
public class CustomerDAOImpl implements CustomerDAO {

	private JdbcTemplate jdbcTemplate;

	public CustomerDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Customer c) {
		String sql = "INSERT INTO customers (first_name,last_name,email) VALUES(?,?,?)";
		return jdbcTemplate.update(sql, c.getFirstName(), c.getLastName(), c.getEmail());

	}

	@Override
	public int update(Customer c) {
		String sql = "UPDATE customers SET first_name=?,last_name=?,email=?";
		return jdbcTemplate.update(sql, c.getFirstName(), c.getLastName(), c.getEmail());
	}

	@Override
	public Customer get(Integer id) {
		String sql="SELECT * FROM customers WHERE cust_ID= "+id;
		
		ResultSetExtractor<Customer> extractor = new ResultSetExtractor<Customer>() {
			@Override
			public Customer extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					String firstName=rs.getString("firstName");
					String lastName=rs.getString("lastName");
					String email=rs.getString("email");
					
					return new Customer(id,firstName,lastName,email);
					
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql,extractor);
		
	}

	@Override
	public int delete(Integer id) {
		String sql="DELETE FROM customers WHERE cust_ID="+id;
		return jdbcTemplate.update(sql);
		
	}

	@Override
	public List<Customer> list() {
		String sql="SELECT * FROM customers";
		List<Customer> listContact = jdbcTemplate.query(sql, new RowMapper<Customer>() {
			 
	        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Customer aContact = new Customer();
	 
	            aContact.setCust_ID(rs.getInt("cust_ID"));
	            aContact.setFirstName(rs.getString("firstName"));
	            aContact.setLastName(rs.getString("lasttName"));
	            aContact.setEmail(rs.getString("email"));
	 
	            return aContact;
	        }
	 
	    });
	 
	    return listContact;
		

	}

}
