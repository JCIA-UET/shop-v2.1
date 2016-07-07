package uet.jcia.shop.service;

import java.util.List;

import javax.jws.WebService;

import uet.jcia.shop.is.AddressDAOImpl;
import uet.jcia.shop.is.CustomerDAOImpl;
import uet.jcia.shop.is.OrderDAOImpl;
import uet.jcia.shop.is.entities.Address;
import uet.jcia.shop.is.entities.Customer;
import uet.jcia.shop.is.entities.Order;

@WebService
public class UserImpl implements User{
	private AddressDAOImpl addressDAO = new AddressDAOImpl();
	private CustomerDAOImpl customerDAO = new CustomerDAOImpl();
	private OrderDAOImpl orderDAO = new OrderDAOImpl();
	

	@Override
	public Customer getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		Customer cus = null;
		cus = customerDAO.getCustomerById(customerId);
		return cus;
	}

	@Override
	public String getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> cusList = null;
		cusList = customerDAO.getAllCustomer();
		return cusList.toString();
	}
	
	@Override
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		List<Address> addsList = null;
		addsList = addressDAO.getAllAddress();
		return addsList;
	}

	@Override
	public List<Address> getAddressesByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		List<Address> addsList = null;
		addsList.addAll(customer.getAddresses());
		return addsList;
	}

	@Override
	public List<Order> getOrdersList(Customer customer) {
		// TODO Auto-generated method stub
		List<Order> ordsList = null;
		ordsList = orderDAO.getListOrderByCustomerId(customer.getCustomerId());
		return ordsList;
	}

	@Override
	public Address getAddressById(Integer addressId) {
		// TODO Auto-generated method stub
		Address address = null;
		address = addressDAO.getAddressById(addressId);
		return address;
	}

	@Override
	public void addNewAddress(Address address) {
		// TODO Auto-generated method stub
		addressDAO.addNewAddress(address);
	}

	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		addressDAO.updateAddress(address);
	}

	@Override
	public void deleteAddress(Address address) {
		// TODO Auto-generated method stub
		addressDAO.deleteAddress(address);
	}

	@Override
	public void addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.addNewCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(customer);
	}

}
