package uet.jcia.shop.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import uet.jcia.shop.is.entities.Address;
import uet.jcia.shop.is.entities.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	private Session crtSession;
	private Transaction crtTransaction;
	
	public CustomerDAOImpl() {
		
	}
	
	public Session getCrtSession() {
		return crtSession;
	}
	
	public void setCrtSession(Session crtSession) {
		this.crtSession = crtSession;
	}

	public Transaction getCrtTransaction() {
		return crtTransaction;
	}

	public void setCrtTransaction(Transaction crtTransaction) {
		this.crtTransaction = crtTransaction;
	}
	
	public Session openCrtSession() {
		crtSession = HibernateUtils.getSessionFactory().openSession();
		return crtSession;
	}
	
	public Session openCrtSessionAndTransaction() {
		
		crtSession = HibernateUtils.buildSessionFactory().openSession();
		crtTransaction = crtSession.beginTransaction();
		return crtSession;
	}
	
	public void closeCrtSession() {
		crtTransaction.commit();
		crtSession.close();
	}
	
	@SuppressWarnings({"unchecked", "deprecation"})
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		List<Customer> cuss = (List<Customer>) getCrtSession().createQuery("from Customer").list();
		closeCrtSession();
		return cuss;
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		String hql = "from Customer where customerId = '" + customerId + "'";
		System.out.println(hql);
		Customer cus = (Customer) getCrtSession().createQuery(hql).uniqueResult();
		System.out.println(cus);
		closeCrtSession();
		return cus;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		String hql = "from Customer where email = '" + email + "'";
		Customer cus = (Customer) getCrtSession().createQuery(hql).uniqueResult();
		closeCrtSession();
		return cus;
	}

	@Override
	public boolean addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		getCrtSession().save(customer);
		closeCrtSession();
		return true;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		getCrtSession().delete(customer);
		closeCrtSession();
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		getCrtSession().update(customer);
		closeCrtSession();
		return false;
	}

	@Override
	public Address getDefaultAddress(Customer customer) {
		// TODO Auto-generated method stub
		AddressDAOImpl addressDAO = new AddressDAOImpl();
		Integer addressId = customer.getAddressId();
		Address address = addressDAO.getAddressById(addressId);
		return address;
	}

	@Override
	public boolean setDefaultAddress(Customer customer, Address address) {
		// TODO Auto-generated method stub
		Set<Address> adds = customer.getAddresses();
		for(Address p: adds) {
			if(address.getAddressId() == p.getAddressId()) {
				customer.setAddressId(address.getAddressId());
				updateCustomer(customer);
				return true;
			}
			else continue;
		}
		return false;
	}

	@Override
	public List<Address> getListAddresses(Customer customer) {
		// TODO Auto-generated method stub
		List<Address> adds = new ArrayList<>();
		adds.addAll(customer.getAddresses());
		return adds;
	}

}
