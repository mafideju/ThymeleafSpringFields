package com.mafideju.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mafideju.springdemo.entity.Customer;
import com.mafideju.springdemo.service.CustomerService;
import com.mafideju.springdemo.utils.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model, @RequestParam(required=false) String sort) {

		List<Customer> customers = null;
		
		if (sort != null) {
			int sortField = Integer.parseInt(sort);
			System.out.println("IF SORT>>>" + sort);
			customers = customerService.getCustomers(sortField);
		} else {
			System.out.println("ELSE SORT>>>" + sort);
			customers = customerService.getCustomers(SortUtils.FIRST_NAME);
		}
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		
		Customer customer = new Customer();
	
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect://customer/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getCustomer(id);
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		customerService.deleteCustomer(id);
		
		return "redirect://customer/list";
	}
	
    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName, Model theModel) {
        
        List<Customer> customers = customerService.searchCustomers(searchName);
                
        theModel.addAttribute("customers", customers);
        
        return "list-customers";        
    }
}
