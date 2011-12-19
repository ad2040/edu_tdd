package dbunitwithunitils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseRepository implements Repository {
	
	
	private final String driver= "org.apache.derby.jdbc.EmbeddedDriver";
	private final String clientDriver= "org.apache.derby.jdbc.ClientDriver";
	
	private final String url = "jdbc:derby://localhost:1527/sellerdb;create=true;user=nam;pass=nam";
//	private final String protocol= "jdbc:derby:";
//	private final String dbName = "shopdb";
	private Connection con;
	
	
	public DatabaseRepository() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class.forName(clientDriver).newInstance();
		con = DriverManager.getConnection(url);
	}

	@Override
	public Seller findById(String id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Seller seller  = null;
		
		try{
			String query = "select id, name, email from seller where id =?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			
			System.out.println(stmt);
			rs = stmt.executeQuery();
			if(!rs.next()){
				throw new SQLException("No Data Found");
			}
			seller = new Seller(rs.getString(1), rs.getString(2), rs.getString(3));
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			stmt.close();
			con.close();
		}
				
		return seller;
	}

	@Override
	public void add(Seller seller) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			String query = "insert into seller values(?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, seller.getId());
			stmt.setString(2, seller.getName());
			stmt.setString(3, seller.getEmail());

			stmt.executeUpdate();
			stmt.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			stmt.close();
			con.close();
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
