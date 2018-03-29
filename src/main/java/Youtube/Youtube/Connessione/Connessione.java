package Youtube.Youtube.Connessione;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connessione {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory = new Configuration().configure().buildSessionFactory();
    }

}

