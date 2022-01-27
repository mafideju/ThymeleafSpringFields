package com.mafideju.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mafideju.springdemo.entity.Customer;
import com.mafideju.springdemo.utils.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int sortField) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String fieldName = null;
		
		switch (sortField) {
			case SortUtils.FIRST_NAME: 
				fieldName = "firstName";
				break;
			case SortUtils.LAST_NAME:
				fieldName = "lastName";
				break;
			case SortUtils.EMAIL:
				fieldName = "email";
				break;
			default:
				fieldName = "firstName";
		}
		
		String queryString = "from Customer order by " + fieldName;
		
		Query<Customer> query = session.createQuery(queryString, Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomer(String searchName) {

        Session currentSession = sessionFactory.getCurrentSession();
        
        Query query = null;
        
        if (searchName != null && searchName.trim().length() > 0) {
            
        	query = currentSession.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
        	query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        	
        }
        else {
            
            query = currentSession.createQuery("from Customer", Customer.class);            
        }
        
        List<Customer> customers = query.getResultList();
                    
        return customers;	
        
	}

}
