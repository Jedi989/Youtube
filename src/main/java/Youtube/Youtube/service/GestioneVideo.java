package Youtube.Youtube.service;

import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

import Youtube.Yotube.entity.*;
import Youtube.Youtube.Connessione.Connessione;

public class GestioneVideo {
	
	public static void addVideoCanale(Canali c, Video v) {
		SessionFactory sf= Connessione.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tx =null;
		try {
			tx = ss.beginTransaction();
			Query query1 =ss.createQuery("select canale from Canali canale where canale.nameCanale = :name");
			query1.setParameter("name", c.getNameCanale());
			c = (Canali) query1.uniqueResult();
			v.setIdCanale(c);
			v.setNum(0);
			ss.save(v);
			c.getVideos().add(v);
			ss.update(c);
			
			
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
	
	public static void rimuoviVideo(Canali c, Video v) {
		SessionFactory sf= Connessione.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tx =null;
		try {
			tx = ss.beginTransaction();
			Query query = ss.createQuery("select video from Video video where video.id = :id");
			query.setParameter("id", v.getId());
			ss.delete(v);
			Query query2 =ss.createQuery("select canale from Canali canale where canale.id = :id");
			query2.setParameter("id", c.getId());
			c.getVideos().remove(v);
			ss.update(c);
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
	
	public static Video getVideoPiuLike () {
		SessionFactory sf= Connessione.getSessionFactory();
		Session ss = sf.openSession();
		Video v = new Video();
		Transaction tx =null;
		try {
			tx = ss.beginTransaction();
			Query query = ss.createQuery("select video from Video video where video.num = max(video.num)");
			v = (Video) query.uniqueResult();
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
			return v;
		}
			
	}
	
	
	
}
