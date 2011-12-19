package dbunit;

import java.sql.SQLException;

public interface Repository {
	
	public Seller findById(String id) throws SQLException;
	public void add(Seller seller) throws SQLException;
	public void update(Seller seller);
	public void remove(Seller seller);
	

}
