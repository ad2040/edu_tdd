package dbunitwithunitils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDao {

	
	private DataSource dataSource;
	private Connection con;

	public void setDataSource(DataSource dataSource) throws SQLException {
		this.dataSource = dataSource;
		con = dataSource.getConnection();
//		System.out.println(con.getMetaData().getDriverName());
		
	}
	
	

	public void add(Seller seller) throws SQLException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		System.out.println(con);
		
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

}
