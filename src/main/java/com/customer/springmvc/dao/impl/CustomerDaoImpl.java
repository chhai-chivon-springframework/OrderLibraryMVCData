package com.customer.springmvc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.springmvc.dao.CustomerDao;
import com.customer.springmvc.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Customer saveCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		return customer;

	}

	public Customer findCustomerFullData(Long custId) {
		Customer customer = sessionFactory.getCurrentSession().get(Customer.class, custId);
		customer.getPaymentMethod().size();
		return customer;
	}

	public void deleteCustomer(Customer customer) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Customer WHERE customerId = " + customer.getCustomerId())
				.executeUpdate();

	}

	public Customer updateCustomer(Customer customer) {
		return null;
	}

	public Customer findCustomerAddressData(Long custId) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, custId);
	}

	public Customer getCustomer(Integer custId) {
		Customer customer = sessionFactory.getCurrentSession().get(Customer.class, custId);
		return customer;
	}

	public Customer findCustomer(Customer customer) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> listCustomers() {
		return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

}
