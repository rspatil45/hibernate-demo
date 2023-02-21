package com.rspatil45.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rspatil45.hibernate_demo.entity.Song;
import com.rspatil45.hibernate_demo.utils.Hibernateutils;

public class UpdateApp {
	
	public static void main(String[] args) {
		
    	Session session = null;    	     	
    	SessionFactory sessionFactory = Hibernateutils.getSessionFactoryMySQL();    	    	
    	 
    	session = sessionFactory.openSession();
    	// if we are making any changes then object should be inside transaction
    	Song song = new Song();
    	song.setId(3);
    	song.setSongName("hum rahe ya");
    	
    	session.beginTransaction();
    	// the value we haven't set are by default null, so table value will be replaced with null 
    	session.update(song);
    	// better approach of update is given below

    	Song s2 =  session.get(Song.class, 2);    	
    	//session.update(s2); //optional, if we don't write it, it will work    	
    	session.getTransaction().commit();    	 	   	    
    	session.close(); 
    	
    	s2.setSongName("Dushamn na kare oh");
    	
    	Session newSession = sessionFactory.openSession();
    	newSession.beginTransaction();
    	Song song2 = newSession.get(Song.class, 2);
    	//newSession.update(s2);// exception : A different object with the same identifier value was already associated with the session song2
    	newSession.merge(s2);
    	newSession.getTransaction().commit();
    	
    	
	}

}
