package com.ilegra.engagerace.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();
    
    @SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
    	SessionFactory factory = null;
    	
    	try {
    		// Create the SessionFactory from hibernate.cfg.xml
    		Configuration c= new Configuration();
    		c.configure();
    		factory = c.buildSessionFactory();
    	} catch (Throwable ex) {
    		// Make sure you log the exception, as it might be swallowed
    		System.err.println("Initial SessionFactory creation failed." + ex);
    		ex.printStackTrace();
    	}
    	
    	return factory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
} 