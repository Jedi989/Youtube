package Youtube.Youtube.webservice;

import javax.jws.*;

@WebService
public class CanaliWebService {

	private String name;

	public CanaliWebService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CanaliWebService(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
