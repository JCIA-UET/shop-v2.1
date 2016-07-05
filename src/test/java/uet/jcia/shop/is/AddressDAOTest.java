package uet.jcia.shop.is;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import uet.jcia.shop.is.entities.Address;
import uet.jcia.shop.is.entities.Customer;

public class AddressDAOTest {
	public static void main(String[] args) {
		AddressDAOImpl addressDAO = new AddressDAOImpl();
		CustomerDAOImpl customerDAO = new CustomerDAOImpl();
		customerDAO.setCrtSession(HibernateUtils.buildSessionFactory().openSession());
		addressDAO.setCrtSession(HibernateUtils.buildSessionFactory().openSession());
		
		
//		Customer cus1 = new Customer("a", "a", "a", "a", "a", new Date());
//		Customer cus2 = new Customer("b", "b", "b", "b", "b", new Date());
//		
//		customerDAO.addNewCustomer(cus1);
//		customerDAO.addNewCustomer(cus2);
//		Set<Address> setAddress = new HashSet();
		Customer cus1 = customerDAO.getCustomerById(30);
		Customer cus2 = customerDAO.getCustomerById(31);
		
		Address add1 = addressDAO.getAddressById(46);
		Address add2 = addressDAO.getAddressById(48);
		Address add3 = new Address("c", "c", "c", cus1);
		
		//addressDAO.addNewAddress(add3);
		System.out.println(cus1.getAddresses());
		System.out.println(customerDAO.setDefaultAddress(cus1, add2));
//		
//		Address add1 = new Address("a", "a", "adasda", cus1);
//		Address add2 = new Address("a", "a", "adasda", cus1);
//		Address add3 = new Address("a", "a", "adasda", cus2);
//		Address add4 = new Address("a", "a", "adasda", cus2);
//		//cus1.setAddresses(setAddress);		
//		addressDAO.addNewAddress(add1);
//		addressDAO.addNewAddress(add2);
//		addressDAO.addNewAddress(add2);
//		addressDAO.addNewAddress(add2);
		
//		System.out.println("--------------");
//		
//		Customer customer = customerDAO.getCustomerById(26);
//		Address add1 = new Address("a", "a", "adasda", customer);
//		addressDAO.addNewAddress(add1);
//		System.out.println("--------------");
//				
//		customerDAO.setDefaultAddress(customer, add1);
//		customerDAO.updateCustomer(customer);
//		System.out.println("--------------");
//		
//		//Address add4 = new Address("d", "d", "jrujel", cus2);
//		Address add2 = new Address("b", "b", "djhgak", customer);
//		addressDAO.addNewAddress(add2);
//		
//		customerDAO.addAddressToCustomer(customer, add2);
//		customerDAO.updateCustomer(customer);
		

		
		
	}
}
