package uet.jcia.shop.is;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import uet.jcia.shop.is.entities.Address;
import uet.jcia.shop.is.entities.Customer;

public class AddressDAOImpl implements AddressDAO{
	private Session crtSession;
	private Transaction crtTransaction;
	
	public AddressDAOImpl() {

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
		crtSession = HibernateUtils.getSessionFactory().getCurrentSession();
		crtTransaction = crtSession.beginTransaction();
		return crtSession;
	}
	
	public void closeCrtSession() {
		crtTransaction.commit();
		crtSession.close();
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Address> getAllAddress() {
		openCrtSessionAndTransaction();
		List<Address> adds = (List<Address>) getCrtSession().createQuery("from Address").list();
		closeCrtSession();
		return adds;
	}

	@Override
	public Address getAddressById(Integer addressId) {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		String hql = "from Address where addressId = '" + addressId +"'";
		Address result = (Address) getCrtSession().createQuery(hql).uniqueResult();
		closeCrtSession();
		return result;
	} 

	@Override
	public boolean addNewAddress(Address address) {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		getCrtSession().save(address);
		closeCrtSession();
		return true;
	}

	@Override
	public boolean deleteAddress(Address address) {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		getCrtSession().delete(address);
		closeCrtSession();
		return true;
	}

	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		openCrtSessionAndTransaction();
		getCrtSession().update(address);
		closeCrtSession();
		return true;
	}

	@Override
	public Customer getCustomer(Address address) {
		// TODO Auto-generated method stub
		return address.getCustomer();
	}
	

}
