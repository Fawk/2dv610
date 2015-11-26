
public class User {
	private String username;
	private String password;
	
	public User(String user, String pass) {
		this.username = user;
		this.password = pass;
	}
	
	public String GetUsername() {
		return this.username;
	}
	
	public String GetPassword() {
		return this.password;
	}
	
	public boolean Valid() {
		return (this.username != "" && this.password != "");
	}
}
