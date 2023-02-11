package com.rspatil45.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import com.rspatil45.hibernate_demo.entity.Song;
import com.rspatil45.hibernate_demo.utils.Hibernateutils;

/**
 * Hello world!
 *
 */
public class CreateApp 
{
	public static final Logger logger = (Logger)LoggerFactory.logger(CreateApp.class);
    public static void main( String[] args )
    {    	
    	    	
    	Session session = null;
    	try {
    	//Session factory is like datasource, connection is managed by session factory
    	//(for one database you should create one session factory)    
    	//if you have different databases you can create different session factory.     	
    	SessionFactory sessionFactory = Hibernateutils.getSessionFactoryMySQL();    	    	
    	// initialize the session object 
    	session = sessionFactory.openSession();
    	
        Song s1 = new Song();        
        s1.setSongName("ye sham mastani");
        s1.setArtist("rsp");
        session.beginTransaction(); //without transaction hibernate will not work
        session.save(s1);
        session.getTransaction().commit();
        
    	}catch(Exception e)
    	{
    		logger.error(e.getMessage());    		
    	}finally {
    		session.close(); //not using it can create connection leak issue
		}
        
    }
}
