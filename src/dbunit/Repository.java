package dbunit;

import java.sql.SQLException;

public interface Repository {

	Seller findById(String id) throws SQLException;
	void add(Seller seller) throws SQLException;
	void update(Seller seller) throws SQLException;
	void remove(Seller seller) throws SQLException;


}
