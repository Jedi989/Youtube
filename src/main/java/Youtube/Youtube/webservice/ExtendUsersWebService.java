package Youtube.Youtube.webservice;

import javax.jws.*;

@WebService
public class ExtendUsersWebService extends UsersWebService {
	
	private String name;
	private String lName;
	private String user;
	private String pw;
	
	public ExtendUsersWebService() {
		super();
	}

	public ExtendUsersWebService(String name, String lName, String user, String pw) {
		super();
		this.name = name;
		this.lName = lName;
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
	
	

}
