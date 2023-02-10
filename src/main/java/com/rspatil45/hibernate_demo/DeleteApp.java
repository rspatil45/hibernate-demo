package com.rspatil45.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rspatil45.hibernate_demo.entity.Song;
import com.rspatil45.hibernate_demo.utils.Hibernateutils;

public class DeleteApp {
	
	public static void main(String[] args) {
		Session session = null;
		SessionFactory sessionFactory = Hibernateutils.getSessionFactory();    	    	
    	 
    	session = sessionFactory.openSession();
   	
    	session.beginTransaction();
    	
    	Song song = session.get(Song.class, 1);
    	session.delete(song);
    	
    	session.getTransaction().commit();    		    	
    
    	session.close(); 
	}	

}
