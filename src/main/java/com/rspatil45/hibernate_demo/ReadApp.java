package com.rspatil45.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rspatil45.hibernate_demo.entity.Song;
import com.rspatil45.hibernate_demo.utils.Hibernateutils;

public class ReadApp {
	public static void main(String[] args) {
		
    		
    	Session session = null;    	     	
    	SessionFactory sessionFactory = Hibernateutils.getSessionFactoryMySQL();    	    	
    	 
    	session = sessionFactory.openSession();
    	   	
    	// it fetch actual object, if object not found then return null
    	Song song = session.get(Song.class,5);
    	System.out.println(song);
    	
    	
    	//load provide proxy object, fetch actual object when needed ,if not found then return ObjectNotFoundException    	 	
//    	Song song2 = session.load(Song.class, 5);        
//        System.out.println(song2);
        
        session.close();
		
	}
}
