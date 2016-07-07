package uet.jcia.shop.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import uet.jcia.shop.is.entities.Address;
import uet.jcia.shop.is.entities.Customer;
import uet.jcia.shop.is.entities.Order;

@WebService
public interface User {
	@WebMethod
	Address getAddressById(Integer addressId);
	
	@WebMethod
	List<Address> getAllAddresses();
	
	@WebMethod
	void addNewAddress(Address address);
	
	@WebMethod
	void updateAddress(Address address);
	
	@WebMethod
	void deleteAddress(Address address);
	
	@WebMethod
	Customer getCustomerById(Integer customerId);
	
	@WebMethod
	String getAllCustomer();
	
	@WebMethod
	void addNewCustomer(Customer customer);
	
	@WebMethod
	void updateCustomer(Customer customer);
	
	@WebMethod
	void deleteCustomer(Customer customer);
	
	@WebMethod
	List<Address> getAddressesByCustomer(Customer customer);
	
	@WebMethod
	List<Order> getOrdersList(Customer customer);
}
