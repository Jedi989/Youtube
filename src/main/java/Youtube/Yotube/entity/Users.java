package Youtube.Yotube.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "utenti")
public class Users implements Serializable {

	private static final long serialVersionUID = 1575663110886937350L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Nome")
	private String name;
	
	@Column(name = "Cognome")
	private String lName;
	
	@Column(name = "User_name")
	private String user;
	
	@Column(name = "Pass_word")
	private String pw;
	
	//mappatura utente canale
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "proprietario")
	private Canali canale;
	
	//mappatura utente segue canali
	@ManyToMany
	@JoinTable(
			name= "registrazione_canale",
			joinColumns= @JoinColumn(name = "id_Utente", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name= "id_Canale", referencedColumnName = "id"))
	private List<Canali> canaliLike = new ArrayList<>();
	
	//mapputa utente like
	 @ManyToMany
	 @JoinTable(
			 name= "utenti_video",
			 joinColumns = @JoinColumn(name="id_Utente", referencedColumnName = "id"),
	 		 inverseJoinColumns = @JoinColumn(name = "id_Video", referencedColumnName = "id"))
	private List<Video> videosLike = new ArrayList<>();

	public Users() {
		super();
	}

	public Users(String name, String lName, String user, String pw, Canali canale,
			List<Canali> canaliLike, List<Video> videosLike) {
		super();
		this.name = name;
		this.lName = lName;
		this.user = user;
		this.pw = pw;
		this.canale = canale;
		this.canaliLike = canaliLike;
		this.videosLike = videosLike;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Canali getCanale() {
		return canale;
	}

	public void setCanale(Canali canale) {
		this.canale = canale;
	}

	public List<Canali> getCanaliLike() {
		return canaliLike;
	}

	public void setCanaliLike(List<Canali> canaliLike) {
		this.canaliLike = canaliLike;
	}

	public List<Video> getVideosLike() {
		return videosLike;
	}

	public void setVideosLike(List<Video> videosLike) {
		this.videosLike = videosLike;
	}
}


