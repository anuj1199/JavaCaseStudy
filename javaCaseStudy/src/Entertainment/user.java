package Entertainment;

public class user {

	
		String username;
		String pass;
		String email;
		
		public user()
		{
		
		}
		
		public String getUserName() {
			return username;
		}

		public void setUserName(String username) {
			this.username = username;
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

		public user(String username, String pass, String email) {
			super();
			this.username = username;
			this.pass = pass;
			this.email = email;
		}
}
