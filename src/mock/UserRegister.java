package mock;

public class UserRegister {

	private String password;
	private String userId;

	public void savePassword(String userId, String password) {
		this.userId  = userId;
		this.password = password;
		
	}
	
	public String getPassword(String userId){
		return this.password;
	}

}
