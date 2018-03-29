package Youtube.Youtube.webservice;

public class UsersWebService {

	private String user;
	private String pw;
	public UsersWebService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsersWebService(String user, String pw) {
		super();
		this.user = user;
		this.pw = pw;
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
	
	
}
