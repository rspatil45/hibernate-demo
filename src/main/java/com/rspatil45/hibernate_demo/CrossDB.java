package com.rspatil45.hibernate_demo;

import org.hibernate.Session;

import com.rspatil45.hibernate_demo.entity.Song;
import com.rspatil45.hibernate_demo.utils.Hibernateutils;

public class CrossDB {

	public static void main(String[] args) {
		Session sessionMySQL = Hibernateutils.getSessionFactoryMySQL().openSession();
		Session sessionSQLServer = Hibernateutils.getSessionFactorySQLServer().openSession();
		
		try {			
		Song song = sessionMySQL.get(Song.class, 1);
		
		sessionSQLServer.beginTransaction();
		sessionSQLServer.saveOrUpdate(song);
		sessionSQLServer.getTransaction().commit();
				
		sessionMySQL.close();
		sessionSQLServer.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sessionMySQL.close();
			sessionSQLServer.close();
		}
	}
			
}
