package com.rspatil45.hibernate_demo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rspatil45.hibernate_demo.entity.Song;

public class Hibernateutils {

	// semi-depricated way of maintaing only one copy of SessionFactory object
	private static SessionFactory sessionFactoryMySQL = null;
	private static SessionFactory sessionFactorySQLServer = null;

	public static SessionFactory getSessionFactoryMySQL() {

		try {
			if (sessionFactoryMySQL == null) {
				// create configuration
				Configuration configuration = new Configuration();
				 configuration.configure("hibernate.cfg.xml");
//				configuration.configure(); // "hibernate.cfg.xml" is standard hibernate configuration file name, if your
											// file name is same then you don't need to specify it.
				// if you are using spring you don't need to manually add your class to
				// configuration
				configuration.addAnnotatedClass(Song.class);
				sessionFactoryMySQL = configuration.buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not able to create session factory object");
		}
		return sessionFactoryMySQL;
	}

	public static SessionFactory getSessionFactorySQLServer() {

		try {
			if (sessionFactorySQLServer == null) {
				Configuration configuration = new Configuration();
				 configuration.configure("hibernate2.cfg.xml");
				configuration.addAnnotatedClass(Song.class);
				sessionFactorySQLServer = configuration.buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not able to create session factory object");
		}

		return sessionFactorySQLServer;

	}
}
