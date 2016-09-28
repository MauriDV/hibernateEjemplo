package hibernateEjemplo;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Principal {
		
	public static void main(String[] args){
		final SessionFactory sf;
		
		{
		    try 
		    { 
		    	sf = new Configuration().configure().buildSessionFactory();
		    } catch (HibernateException he) 
		    { 
		        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
		        throw new ExceptionInInitializerError(he); 
		    } 
		}
		
		
		Album x = new Album(2,"ejemplo 2");
		System.out.println(getAll(sf).get(0).getTitle());
		insertAlbum(sf,x);
		System.out.println(getAll(sf).get(1).getTitle());
				
	}
	
	public static List<Album> getAll(SessionFactory sf){
		Session s = sf.openSession();
		List<Album> l = new LinkedList<Album>();
		l = s.createQuery("FROM Album").list();
		return l;
	}
	
	public static void insertAlbum(SessionFactory sf,Album a){
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(a);
		s.getTransaction().commit();
		s.close();
	}
}