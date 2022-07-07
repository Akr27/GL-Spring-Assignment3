package com.gl.spring.assignment3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.spring.assignment3.dao.CustomerDAO;
import com.gl.spring.assignment3.model.Customer;

@Controller
public class MainController {
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listCustomer(ModelAndView model) {
		List<Customer> listCustomer = customerDAO.list();
		model.addObject("listCustomer",listCustomer(model));
		model.setViewName("index");
		return model;
	} 
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public ModelAndView newCustomer(ModelAndView model) {
		Customer newCustomer = new Customer();
		model.addObject("customer",newCustomer(model));
		model.setViewName("customer_form");
		return model;
	} 
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveCustomer(Customer Customer) {
		if(Customer.getCust_ID()==null) {
			customerDAO.save(Customer);
		}
		else {
		customerDAO.update(Customer);}
		return new ModelAndView("redirect:/");
	} 
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView editCustomer(HttpServletRequest request) {
		Integer cust_ID=Integer.parseInt(request.getParameter("cust_ID"));
		Customer customer = customerDAO.get(cust_ID);
		ModelAndView model = new ModelAndView("customer_form");
		model.addAllObjects("customer",customer);
		
		return model;
	} 
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam Integer cust_ID) {
		customerDAO.delete(cust_ID);
		return new ModelAndView("redirect:/");
	}
	
	

}
