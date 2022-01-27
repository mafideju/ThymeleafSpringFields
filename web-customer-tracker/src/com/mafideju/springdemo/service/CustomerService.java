package com.mafideju.springdemo.service;

import java.util.List;

import com.mafideju.springdemo.entity.Customer;
import com.mafideju.springdemo.utils.SortUtils;

public interface CustomerService {

	public List<Customer> getCustomers(int sortField);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String searchName);

}
