package Youtube.Youtube.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Youtube.Yotube.entity.Canali;
import Youtube.Yotube.entity.Users;
import Youtube.Yotube.entity.Video;
import Youtube.Youtube.Connessione.Connessione;

public class GestioneUtenti {
	
	public static Users findUsers(Users u) {
		SessionFactory sf= Connessione.getSessionFactory();
		Session ss = null;
		Transaction tx = null;
		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			Query query = ss.createQuery("from Users utente where utente.users = :stringa");
			query.setParameter("stringa", u.getUser());
			u = (Users) query.uniqueResult();
			tx.commit();
		}
		catch(Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			ss.close();
			sf.close();
			return u;
		}
	}
	
	public static void registrazioneUtente(Users u) {
		
		SessionFactory sf= Connessione.getSessionFactory();
		Session ss = null;
		Transaction tx =null;
		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			Query query = ss.createQuery("SELECT utente FROM Users utente WHERE utente.user = :users");
			query.setParameter("users",u.getUser());
			List<Users> utenti = (List<Users>) query.list();
			if(utenti.isEmpty()) {
				ss.save(u);
			}
			else {//da fare
			}
			tx.commit();
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally {
			ss.close();
			sf.close();
		}
	}
	
	public static void rimuoviUtente(Users u) {
		SessionFactory sf = Connessione.getSessionFactory();
		Session ss= sf.openSession();
		Transaction tx = null;
		try {
			tx = ss.beginTransaction();
			Query query1 = ss.createQuery("from Users utente where utente.user = :stringa");
			query1.setParameter("stringa", u.getUser());
			u = (Users) query1.uniqueResult();
			Query query = ss.createQuery("Select u.canale From Users u where u.id = :id");
			query.setParameter("id", u.getId());
			List<Canali> c = (List<Canali>) query.list();
			if(!c.isEmpty()) {
				ss.delete(c);
			}
			ss.delete(u);
			tx.commit();
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally {
			ss.close();
			sf.close();
		}
	}
	
	public static void sottoscrizioneCanale(Users u, Canali c) {
		SessionFactory sf = Connessione.getSessionFactory();
		Session ss= sf.openSession();
		Transaction tx = null;
		try { 
			tx = ss.beginTransaction();
			
			c.setLikes(c.getLikes()+1);
			c.getUtenti().add(u);
			ss.update(c);
			
			List<Canali> list = u.getCanaliLike();
			list.add(c);
			u.setCanaliLike(list);
			ss.update(u);
			tx.commit();
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally {
			ss.close();
			sf.close();
		}
	}
	
	public static void rimuoviSottoscrizioneCanale(Users u, Canali c) {
		SessionFactory sf = Connessione.getSessionFactory();
		Session ss= sf.openSession();
		Transaction tx = null;
		try {
			tx = ss.beginTransaction();
						
			//Query query1 = ss.createQuery("select utente from Users utente where utente.id = :id1");
			//query1.setParameter("id1", u.getId());
			//u = (Users) query1.uniqueResult();
			//Query query2 = ss.createQuery("select canale from Canali canale where canale.id =:id2");
			//query2.setParameter("id2", c.getId());
			//c = (Canali) query2.uniqueResult();
			//c.setLikes(c.getLikes()-1);
			u.getCanaliLike().remove(c);
			c.getUtenti().remove(u);
			ss.update(c);
			ss.update(u);
			
			
			tx.commit();
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally {
			ss.close();
			sf.close();
		}
	}
	
	
	public static void aggiungiLikeVideo(Users u, Video v) {
		SessionFactory sf = Connessione.getSessionFactory();
		Session ss= sf.openSession();
		Transaction tx = null;
		try {
			tx = ss.beginTransaction();
			v.setNum(v.getNum()+1);
			v.getUtenti().add(u);
			ss.update(v);
			u.getVideosLike().add(v);
			ss.update(u);
			
			tx.commit();
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally {
			ss.close();
			sf.close();
		}
	}
	
	public static void rimuoviLikeVideo(Users u, Video v) {
		SessionFactory sf = Connessione.getSessionFactory();
		Session ss= sf.openSession();
		Transaction tx = null;
		try {
			tx = ss.beginTransaction();
			
			v.setNum(v.getNum()-1);
			v.getUtenti().remove(u);
			u.getVideosLike().remove(v);
			tx.commit();
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally {
			ss.close();
			sf.close();
		}
	}
	
	public static Canali visualizzaCanale(Users u) {
		SessionFactory sf = Connessione.getSessionFactory();
		Session ss= sf.openSession();
		Transaction tx = null;
		Canali c = new Canali();
		try {
			tx = ss.beginTransaction();
			c = u.getCanale();
			tx.commit();
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally {
			ss.close();
			sf.close();
			return c;
		}
	}

}


