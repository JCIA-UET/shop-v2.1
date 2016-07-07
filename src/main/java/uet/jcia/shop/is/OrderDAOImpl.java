package uet.jcia.shop.is;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import uet.jcia.shop.is.entities.Customer;
import uet.jcia.shop.is.entities.Order;

public class OrderDAOImpl implements OrderDao {

	private final SessionFactory sessioinFactory = HibernateUtils.getSessionFactory();

	@SuppressWarnings("finally")
	@Override
	public List<Order> getAllOrder() {
		Session session = sessioinFactory.openSession();
		session.beginTransaction();
		List<Order> listOrder = null;

		try {
			String cHql = "from Order";
			listOrder = (List<Order>) session.createCriteria(Order.class).list();
			if (listOrder == null) {
				session.close();
				return null;
			}
			for (Order order : listOrder) {
				Hibernate.initialize(order.getCustomer());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null)
				session.close();
			return listOrder;
		}

	}

	@SuppressWarnings("finally")
	@Override
	public Order getOrderById(Integer orderId) {
		Session session = sessioinFactory.openSession();
		session.beginTransaction();
		Order order = null;
		try {
			order = (Order) session.get(Order.class, orderId);
			if (order == null) {
				session.close();
				return null;
			}
			Hibernate.initialize(order.getCustomer());
			// Hibernate.initialize(order.getOrderItems());
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null)
				session.close();
			return order;
		}

	}

	@SuppressWarnings("finally")
	@Override
	public boolean addNewOrder(Order order, Customer customer) {
		Session session = sessioinFactory.openSession();
		session.beginTransaction();
		if (customer == null)
			return false;
		try {
			order.setCustomer(customer);
			session.save(order);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		} finally {
			if (session != null)
				session.close();
			return true;
		}

	}

	@SuppressWarnings("finally")
	@Override
	public boolean deleteOrder(int orderId) {
		Session session = sessioinFactory.openSession();
		session.beginTransaction();
		try {
			session.delete(this.getOrderById(orderId));
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		} finally {
			if (session != null)
				session.close();
			return true;
		}

	}

	@SuppressWarnings("finally")
	@Override
	public boolean updateOrder(Order order) {
		Session session = sessioinFactory.openSession();
		session.beginTransaction();
		if (order == null)
			return false;
		try {
			session.update(order);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		} finally {
			if (session != null)
				session.close();
			return true;
		}

	}

	@Override
	public Double getTotal(Order order) {
		// TODO Auto-generated method stub
		return order.getTotal();
	}

	@SuppressWarnings("finally")
	@Override
	public List<Order> getListOrderByCustomerId(int customer_id) {
		Session session = sessioinFactory.openSession();
		session.beginTransaction();
		List<Order> result = null;
		try {
			String hql = "select o from Order o , Customer c Where c.customerId = :customer_id";
			result = (List<Order>) session.createQuery(hql).setParameter("customer_id", customer_id).list();
			if (result == null) {
				session.close();
				return null;
			}
			for (Order order : result) {
				Hibernate.initialize(order.getCustomer());
			}
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

		finally {
			if (session != null)
				session.close();
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<Order> getListOrderByDate(Date date) {
		Session session = sessioinFactory.openSession();
		session.beginTransaction();
		List<Order> result = null;
		try {

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		} finally {
			if (session != null)
				session.close();
			return result;
		}
	}

}
