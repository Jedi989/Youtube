package Youtube.Youtube.webservice;

import java.util.List;

import javax.jws.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Youtube.Yotube.entity.*;
import Youtube.Youtube.Connessione.Connessione;
import Youtube.Youtube.service.*;

@WebService
public class GestioneImpl implements GestioneWebService {

	
	@Override
	@WebMethod
	public void registrazioneUtente(ExtendUsersWebService u) {
		
		Users uTemp = new Users();
		uTemp.setName(u.getName());
		uTemp.setlName(u.getlName());
		uTemp.setUser(u.getUser());
		uTemp.setPw(u.getPw());		
		GestioneUtenti.registrazioneUtente(uTemp);
		
	}

	@Override
	@WebMethod
	public void rimuoviUtente(UsersWebService u) {
		Users uTemp = new Users();
		uTemp.setUser(u.getUser());
		uTemp.setPw(u.getPw());
		
		GestioneUtenti.rimuoviUtente(uTemp);
		
	}

	@Override
	@WebMethod
	public void sottoscrizioneCanale(UsersWebService u, CanaliWebService c) {
		
		Users uTemp = new Users();
		uTemp.setUser(u.getUser());
		uTemp.setPw(u.getPw());
		Canali cTemp = new Canali();
		cTemp.setNameCanale(c.getName());
		GestioneUtenti.sottoscrizioneCanale(uTemp, cTemp);
		
	}

	@Override
	@WebMethod
	public void rimuoviSottoscrizioneCanale(UsersWebService u, CanaliWebService c) {
		
		Users uTemp = new Users();
		uTemp.setUser(u.getUser());
		uTemp.setPw(u.getPw());
		Canali cTemp = new Canali();
		cTemp.setNameCanale(c.getName());
		GestioneUtenti.rimuoviSottoscrizioneCanale(uTemp, cTemp);
		
	}

	@Override
	@WebMethod
	public void aggiungiLikeVideo(UsersWebService u, VideoWebService v) {
		
		Users uTemp = new Users();
		uTemp.setUser(u.getUser());
		uTemp.setPw(u.getPw());
		
		Video vTemp = new Video();
		vTemp.setName(v.getName());
		GestioneUtenti.aggiungiLikeVideo(uTemp, vTemp);
		
	}

	@Override
	@WebMethod
	public void rimuoviLikeVideo(UsersWebService u, VideoWebService v) {
		
		Users uTemp = new Users();
		uTemp.setUser(u.getUser());
		uTemp.setPw(u.getPw());
		Video vTemp = new Video();
		vTemp.setName(v.getName());
		GestioneUtenti.rimuoviLikeVideo(uTemp, vTemp);
		
	}

	@Override
	@WebMethod
	public Canali visualizzaCanale(UsersWebService u) {
		
		Users uTemp = new Users();
		uTemp.setUser(u.getUser());
		uTemp.setPw(u.getPw());
		return GestioneUtenti.visualizzaCanale(uTemp);
	}
	
	@Override
	@WebMethod
	public void creazioneCanale(ExtendUsersWebService u, CanaliWebService c) 
	{
		Users uTemp = new Users();
		Canali cTemp = new Canali();
		uTemp.setName(u.getName());
		uTemp.setlName(u.getlName());
		uTemp.setUser(u.getUser());
		uTemp.setPw(u.getPw());
		cTemp.setNameCanale(c.getName());
		cTemp.setLikes(0);
		GestioneCanali.creazioneCanale(uTemp, cTemp);
		
	}

	@Override
	@WebMethod
	public Canali getCanalePiuSeguito() {
		return GestioneCanali.getCanalePiuSeguito();
	}

	@Override
	@WebMethod
	public List<Video> getVideo(CanaliWebService c) {
		
		Canali cTemp = new Canali();
		cTemp.setNameCanale(c.getName());
		return GestioneCanali.getVideo(cTemp);
	}
	@Override
	@WebMethod
	public void addVideoCanale(CanaliWebService c, VideoWebService v) {
		
		Canali cTemp = new Canali();
		cTemp.setNameCanale(c.getName());
		Video vTemp = new Video();
		vTemp.setName(v.getName());
		vTemp.setNum(0);
		GestioneVideo.addVideoCanale(cTemp, vTemp);
	}

	@Override
	@WebMethod
	public void rimuoviVideo(CanaliWebService c, VideoWebService v) {
		
		Canali cTemp = new Canali();
		cTemp.setNameCanale(c.getName());
		Video vTemp = new Video();
		vTemp.setName(v.getName());
		GestioneVideo.rimuoviVideo(cTemp, vTemp);
	}

	@Override
	@WebMethod
	public Video getVideoPiuLike() {
		return 	GestioneVideo.getVideoPiuLike();
	}


}
