package uet.jcia.shop.is;

import java.util.List;

import uet.jcia.shop.is.entities.*;

public interface CustomerDAO {
	List<Customer> getAllCustomer();
	Customer getCustomerById(Integer customerId);
	Customer getCustomerByEmail(String email);
	Address getDefaultAddress(Customer customer);
	boolean setDefaultAddress(Customer customer, Address address);
	List<Address> getListAddresses(Customer customer);
	boolean addNewCustomer(Customer customer);
	boolean deleteCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	
}
