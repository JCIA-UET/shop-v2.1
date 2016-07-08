package uet.jcia.shop.is;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
    
    private static SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
    	if (sessionFactory == null) {
    		Configuration configuration = new Configuration().configure();
        	ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        	registry.applySettings(configuration.getProperties());
        	ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
        	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	}
    	return sessionFactory;
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
