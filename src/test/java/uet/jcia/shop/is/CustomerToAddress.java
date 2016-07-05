package uet.jcia.shop.is;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import uet.jcia.shop.is.entities.Address;
import uet.jcia.shop.is.entities.Category;
import uet.jcia.shop.is.entities.Customer;

public class CustomerToAddress {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        
        Customer customer = new Customer(
                "cuong", "bui", "cuong@vnu", "113", "12345", new Date());
        
        Address add1 = new Address("cuong", "bui", "Anh Son, Nghe An", customer);
        Address add2 = new Address("cuong", "bui", "Ha Dong, Ha Noi", customer);
        Address add3 = new Address("cuong", "bui", "Xuan Thuy, Ha Noi", customer);
        Set<Address> addresses = new HashSet<>();
        addresses.add(add1);
        addresses.add(add2);
        addresses.add(add3);
        
        customer.setAddresses(addresses);
        
        session.save(customer);
        
        transaction.commit();
        session.close();
        HibernateUtils.closeSessionFactory();
    }
}
