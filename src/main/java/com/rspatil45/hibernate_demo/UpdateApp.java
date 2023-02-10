package com.rspatil45.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rspatil45.hibernate_demo.entity.Song;
import com.rspatil45.hibernate_demo.utils.Hibernateutils;

public class UpdateApp {
	
	public static void main(String[] args) {
		
    	Session session = null;    	     	
    	SessionFactory sessionFactory = Hibernateutils.getSessionFactory();    	    	
    	 
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
    	s2.setSongName("Dushamn na kare");
    	session.update(s2);
    	
    	session.getTransaction().commit();
    	
    	

    	
    
    	session.close(); 
	}

}
