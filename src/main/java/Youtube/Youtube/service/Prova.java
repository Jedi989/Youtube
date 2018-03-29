package Youtube.Youtube.service;

import Youtube.Yotube.entity.*;
import Youtube.Youtube.Connessione.Connessione;

import javax.persistence.*;

import org.hibernate.*;
import org.hibernate.Query;
public class Prova {
	public static void main(String args[]) {
		Canali c = new Canali();
		Video v = new Video();
		Users u = new Users ();
		u.setId(2);
		u.setUser("Gianni");
		c.setId(2);
		c.setNameCanale("aaa");
		c.setLikes(0);
		v.setId(1);
		v.setName("mi piacciono i porno");
		v.setNum(0);
		
		
		GestioneVideo.rimuoviVideo(c, v);
		//System.out.println(c.getId() + "\t" + c.getNameCanale());
	
	}

}
