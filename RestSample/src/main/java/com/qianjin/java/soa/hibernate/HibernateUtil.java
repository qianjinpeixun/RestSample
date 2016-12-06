package com.qianjin.java.soa.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;

import com.qianjin.java.soa.model.ProductList;


public class HibernateUtil {
	private static final Logger logger = Logger.getLogger(HibernateUtil.class);

	public static SessionFactory factory;

	private HibernateUtil() {
	}

	public static synchronized SessionFactory getSessionFactory() {

		if (factory == null) {
			logger.info("factory is null, begin to create factory!");
			try {
				Configuration configuration = new Configuration();
				// configuration.configure();
				configuration.addAnnotatedClass(ProductList.class);
				//configuration.setProperty("hibernate.connection.datasource","java:jboss/datasources/NeuralTestDS");
				//configuration.setProperty("hibernate.connection.datasource","java:comp/env/jdbc/testdb");
				configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
				configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:testdb");
				configuration.setProperty("hibernate.connection.username", "sa");
				configuration.setProperty("hibernate.connection.password", "");
				configuration.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
				configuration.setProperty("hibernate.show_sql", "true");
				ServiceRegistry serviceRegistry;
				serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				factory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("getting connection happen error!",e);
			}
			logger.info("Connected to Mysql success!");
		}
		return factory;
	}

	
}
