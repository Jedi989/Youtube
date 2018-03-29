package Youtube.Yotube.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "canali")
public class Canali implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7560818683984694892L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Nome")
	private String nameCanale;

	@Column(name = "Iscrizioni")
	private int likes;

	// relazione utente-canale registrato
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente")
	private Users proprietario;

	// mappatura video dei canali
	@OneToMany(mappedBy = "idCanale")
	private List<Video> videos = new ArrayList<>();

	// mappatura canali seguiti da
	//@OneToMany(mappedBy = "canaliSeguiti")
	@ManyToMany(mappedBy = "canaliLike")
	private List<Users> utenti = new ArrayList<>();

	public Canali() {
		super();
	}

	public Canali(String nameCanale, int likes, Users proprietario, List<Video> videos,
			List<Users> utenti) {
		super();
		this.nameCanale = nameCanale;
		this.likes = likes;
		this.proprietario = proprietario;
		this.videos = videos;
		this.utenti = utenti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameCanale() {
		return nameCanale;
	}

	public void setNameCanale(String nameCanale) {
		this.nameCanale = nameCanale;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Users getProprietario() {
		return proprietario;
	}

	public void setProprietario(Users proprietario) {
		this.proprietario = proprietario;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Users> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Users> utenti) {
		this.utenti = utenti;
	}

}
