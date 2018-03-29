package Youtube.Yotube.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="video")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "URL")
	private String name;
	
	@Column(name = "Likes")
	private int num;
	
	//mappatura video dei canali
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_canale")
	private Canali idCanale;
	
	//mappatura utenti che mettono like ai video
	@ManyToMany(mappedBy = "videosLike")
	private List<Users> utenti = new ArrayList<>();

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(String name, int num, Canali idCanale, List<Users> utenti) {
		super();
		this.name = name;
		this.num = num;
		this.idCanale = idCanale;
		this.utenti = utenti;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Canali getIdCanale() {
		return idCanale;
	}

	public void setIdCanale(Canali idCanale) {
		this.idCanale = idCanale;
	}

	public List<Users> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Users> utenti) {
		this.utenti = utenti;
	}

	
}
