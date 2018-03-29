package Youtube.Youtube.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Youtube.Yotube.entity.*;
import Youtube.Youtube.Connessione.Connessione;

public class GestioneCanali {
	
public static void creazioneCanale(Users u, Canali c) {
		
		SessionFactory sf= Connessione.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tx =null;
		try {
			tx = ss.beginTransaction();
			Query query1 = ss.createQuery("from Users utente where utente.users = :stringa");
			query1.setParameter("stringa", u.getUser());
			u = (Users) query1.uniqueResult();
			if(u.getCanale() == null) {
				u.setCanale(c);
				ss.update(u);
				c.setProprietario(u);
				ss.save(c);
			}
			else {
				System.out.println("L'Utente possiede già un canale");
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

	public static Canali getCanalePiuSeguito() {
		SessionFactory sf= Connessione.getSessionFactory();
		Session ss = sf.openSession();
		Canali c = new Canali();
		Transaction tx =null;
		try {
			tx = ss.beginTransaction();
			Query query = ss.createQuery("from Canali canale where canale.likes = (select max(canale2.likes) from Canali canale2)");
			c = (Canali) query.uniqueResult();
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

	public static List<Video> getVideo(Canali c){
			SessionFactory sf= Connessione.getSessionFactory();
			Session ss = sf.openSession();
			List<Video> list = null;
			Transaction tx =null;
			try {
				tx = ss.beginTransaction();
				Query query = ss.createQuery("Select canale.videos from Canali canale where canale.id = :id");
				query.setParameter("id", c.getId());
				list = (List<Video>) query.list();
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
				return list;
			}
	}
	
	
}