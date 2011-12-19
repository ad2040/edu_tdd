package dbunit;

public class Seller {

	private String email;
	private String name;
	private String id;

	public Seller(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getEmail(){
		return this.email;
	}

}
