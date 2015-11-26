import java.util.HashMap;


public class Login {
	
	private boolean hasError = false;
	private String loginError = "You need enter a username and password combination!";
	private String faultyLogin = "Wrong username or password combination!";
	private String currentError = null;
	
	private HashMap<String, String> users;
	
	public Login() {
		 this.users = new HashMap<String, String>();
		 this.users.put("admin", "root");
	}
	
	public boolean Login(User user) {
		if(user.Valid()) {
			return Validate(user);
		}
		this.hasError = true;
		this.currentError = loginError;
		return false;
	}
	
	private boolean Validate(User user) {

		if(this.users.containsKey(user.GetUsername()) && this.users.get(user.GetUsername()) == user.GetPassword()) {
			this.hasError = false;
			this.currentError = null;
			return true;
		}
		
		this.hasError = true;
		this.currentError = faultyLogin;
		return false;
	}
	
	public boolean HasError() {
		return this.hasError && this.currentError != null;
	}
	
	public String GetError() {
		return this.currentError;
	}
	
	public String GetLoginError() {
		return this.loginError;
	}
	
	public String GetFaultyLogin() {
		return this.faultyLogin;
	}
}
