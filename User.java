package section1Project;
import java.util.*;

public class User {
	private String userName;
	private final String userId;
	private String userPassword;
	private String userEmail;
	private static Random random = new Random();
	
	public User(String userName, String userPassword, String userEmail) {
		super();
		this.userName = userName;
		this.userId = String.valueOf(random.nextInt(1000000));
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	
}
