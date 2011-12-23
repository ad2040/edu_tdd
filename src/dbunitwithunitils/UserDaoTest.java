package dbunitwithunitils;

import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.*;
import org.unitils.database.DatabaseUnitils;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;

@RunWith(UnitilsJUnit4TestClassRunner.class)
@DataSet("Seller.xml")
public class UserDaoTest {

	@TestDataSource
	private DataSource dataSource;
	private UserDao dao;

	@Before
	public void setUp() throws SQLException {
		this.dao = new UserDao();
		dao.setDataSource(dataSource);
	}

	@Test
	@ExpectedDataSet("Expected_Seller.xml")
	public void testAdd() throws SQLException {
		Seller seller = new Seller("park", "박은주", "park@gmail.com");
		dao.add(seller);

		// Seller expectedSeller=dao.findById("park");
		// assertPropertyLenientEquals("id","park",expectedSeller);
	}

	@Test
	public void testFindById() throws SQLException {

		Seller expectedSeller = dao.findById("nam");
		assertPropertyLenientEquals("id", "nam", expectedSeller);
	}
	
	@Test
	@ExpectedDataSet("Expected_Seller.xml")
	public void testAddAndFindById() throws SQLException{
		Seller seller = new Seller("park", "박은주", "park@gmail.com");
		dao.add(seller);
	}

}
