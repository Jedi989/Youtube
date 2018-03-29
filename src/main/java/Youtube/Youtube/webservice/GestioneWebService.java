package Youtube.Youtube.webservice;

import javax.jws.WebService;

import Youtube.Yotube.entity.*;

import java.util.List;

import javax.jws.WebMethod;

@WebService
public interface GestioneWebService {
	
	@WebMethod
	public void registrazioneUtente(ExtendUsersWebService u); //testato
	
	@WebMethod
	public void rimuoviUtente(UsersWebService u); //testato
	
	@WebMethod
	public void sottoscrizioneCanale(UsersWebService u, CanaliWebService c); 

	@WebMethod
	public void rimuoviSottoscrizioneCanale(UsersWebService u, CanaliWebService c);
	
	@WebMethod
	public void aggiungiLikeVideo(UsersWebService u, VideoWebService v);

	@WebMethod
	public void rimuoviLikeVideo(UsersWebService u, VideoWebService v);
	
	@WebMethod
	public Canali visualizzaCanale(UsersWebService u);
	
	@WebMethod
	public void creazioneCanale(ExtendUsersWebService u, CanaliWebService c);

	@WebMethod
	public Canali getCanalePiuSeguito();

	@WebMethod
	public List<Video> getVideo(CanaliWebService c);
	
	@WebMethod
	public void addVideoCanale(CanaliWebService c, VideoWebService v);

	@WebMethod
	public void rimuoviVideo(CanaliWebService c, VideoWebService v);
	
	@WebMethod
	public Video getVideoPiuLike ();
}
