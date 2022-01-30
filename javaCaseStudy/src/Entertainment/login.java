package Entertainment;

public class login {

	
	
	String name;
	String pass;
	String email;
	
	public login()
	{
	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public login(String name, String pass, String email) {
		super();
		this.name = name;
		this.pass = pass;
		this.email = email;
	}
	
	
}
