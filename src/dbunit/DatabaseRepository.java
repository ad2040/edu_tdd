package dbunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseRepository implements Repository {

	private final String clientDriver= "org.apache.derby.jdbc.ClientDriver";

	private final String url = "jdbc:derby://localhost:1527/Sellerdb;create=true;user=nam;pass=nam";
	private Connection con;


	public DatabaseRepository() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class.forName(clientDriver).newInstance();
		con = DriverManager.getConnection(url);
		con.commit();
	}

	@Override
	public Seller findById(String id) throws SQLException {
		String query = "select id, name, email from seller where id = ?";
		try (PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (!rs.next()) throw new SQLException("No Data Found");
				return new Seller(rs.getString("id"), rs.getString("name"), rs.getString("email"));
			}
		}
	}

	@Override
	public void add(Seller seller) throws SQLException {
		String query = "insert into seller values(?, ?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, seller.getId());
			stmt.setString(2, seller.getName());
			stmt.setString(3, seller.getEmail());
			stmt.executeUpdate();
		}
	}

	@Override
	public void update(Seller seller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Seller seller) {
		// TODO Auto-generated method stub

	}

}
