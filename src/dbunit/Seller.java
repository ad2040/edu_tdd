package dbunit;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Seller)) return false;
		Seller s = (Seller) o;
		return Objects.equals(id, s.id) && Objects.equals(name, s.name) && Objects.equals(email, s.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, email);
	}

	@Override
	public String toString() {
		return "Seller{id='" + id + "', name='" + name + "', email='" + email + "'}";
	}

}
