package com.rspatil45.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//create configuration
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Song.class);
    	
    	//we need session factory to create datasource
    	SessionFactory sessionFactory = configuration.buildSessionFactory();    	
    	
    	// initialize the session object 
    	Session session = sessionFactory.openSession();
    	
        Song s1 = new Song();
        s1.setId(1);
        s1.setSongName("Rim Zim Gire");
        s1.setArtist("rahul");
        session.beginTransaction(); //without transaction hibernate will not work
        session.save(s1);
        session.getTransaction().commit();
    }
}
