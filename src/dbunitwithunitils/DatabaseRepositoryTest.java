package dbunitwithunitils;

import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;

@RunWith(UnitilsJUnit4TestClassRunner.class)
@DataSet("Seller.xml")
public class DatabaseRepositoryTest {

	@Test
	public void testFindById() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		Repository repository = new DatabaseRepository();
		Seller actualSeller = repository.findById("nam");
		assertPropertyLenientEquals("id", "nam", actualSeller);
	}

	@Test
	@ExpectedDataSet
	public void testAddNewSeller() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		Seller newSeller = new Seller("park", "박은주", "park@gmail.com");
		Repository repository = new DatabaseRepository();
		repository.add(newSeller);

	}
	/*
	 * 
	 * @Test public void testAddNewSellerDataSet() throws Exception { Seller
	 * newSeller = new Seller("yoo", "유태연", "yoo@gmail.com"); Repository
	 * repository = new DatabaseRepository(); repository.add(newSeller);
	 * 
	 * // IDataSet currentDBdataSet = //
	 * databaseTester.getConnection().createDataSet(); // ITable actualTable =
	 * currentDBdataSet.getTable("seller");
	 * 
	 * ITable actualTable1 = databaseTester.getConnection().createQueryTable(
	 * "seller", "select * from seller");
	 * 
	 * IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File(
	 * "src\\dbunit\\Expected_Seller.xml")); ITable expectedTable =
	 * expectedDataSet.getTable("seller");
	 * 
	 * System.out.println(expectedTable.getRowCount());
	 * 
	 * // Assertion.assertEquals(new SortedTable(expectedTable), actualTable);
	 * Assertion.assertEquals(expectedTable, actualTable1); }
	 * 
	 * @Test public void testAddNewSellerDataSetWithExcel() throws Exception {
	 * Seller newSeller = new Seller("yoo", "유태연", "yoo@gmail.com"); Repository
	 * repository = new DatabaseRepository(); repository.add(newSeller);
	 * 
	 * // IDataSet currentDBdataSet = //
	 * databaseTester.getConnection().createDataSet(); // ITable actualTable =
	 * currentDBdataSet.getTable("seller");
	 * 
	 * ITable actualTable1 = databaseTester.getConnection().createQueryTable(
	 * "seller", "select * from seller ");
	 * 
	 * IDataSet expectedDataSet = new XlsDataSet(new File(
	 * "src\\dbunit\\Expected_Seller.xlsx")); ITable expectedTable =
	 * expectedDataSet.getTable("seller");
	 * 
	 * System.out.println(expectedTable.getRowCount());
	 * 
	 * // Assertion.assertEquals(new SortedTable(expectedTable), actualTable);
	 * Assertion.assertEquals(expectedTable, actualTable1); }
	 * 
	 * @Test public void testQueryDataSet() throws DataSetException, Exception {
	 * Seller newSeller = new Seller("yoo", "유태연", "yoo@gmail.com"); Repository
	 * repository = new DatabaseRepository(); repository.add(newSeller);
	 * 
	 * ITable actualTable = databaseTester.getConnection().createQueryTable(
	 * "seller", "select * from seller");
	 * 
	 * QueryDataSet dataSet = new QueryDataSet(databaseTester.getConnection());
	 * dataSet.addTable("seller", "select * from seller "); ITable expectedTable
	 * = dataSet.getTable("seller");
	 * 
	 * System.out.println(expectedTable.getRowCount());
	 * 
	 * // Assertion.assertEquals(new SortedTable(expectedTable), actualTable);
	 * // Assertion.assertEquals(expectedTable, actualTable);
	 * 
	 * assertLenientEquals(expectedTable, actualTable);
	 * 
	 * }
	 * 
	 * @Test public void testDatabaseOperationRefresh() throws
	 * DatabaseUnitException, SQLException, Exception { IDataSet dataSet = new
	 * XlsDataSet(new File( "src\\dbunit\\Expected_Seller.xlsx"));
	 * 
	 * DatabaseOperation.REFRESH.execute(databaseTester.getConnection(),
	 * dataSet); ITable actualTable = dataSet.getTable("seller");
	 * 
	 * QueryDataSet expectedDataSet = new QueryDataSet(
	 * databaseTester.getConnection()); expectedDataSet.addTable("seller",
	 * "select * from seller "); ITable expectedTable =
	 * expectedDataSet.getTable("seller");
	 * 
	 * // assertLenientEquals(expectedTable,actualTable);
	 * Assertion.assertEquals(expectedTable, actualTable);
	 * 
	 * }
	 * 
	 * @Test public void testDatabaseOperationRefreshWithUnitils() throws
	 * DatabaseUnitException, SQLException, Exception { IDataSet dataSet = new
	 * XlsDataSet(new File( "src\\dbunit\\Expected_Seller.xlsx"));
	 * 
	 * DatabaseOperation.REFRESH.execute(databaseTester.getConnection(),
	 * dataSet); ITable actualTable = dataSet.getTable("seller");
	 * 
	 * QueryDataSet expectedDataSet = new QueryDataSet(
	 * databaseTester.getConnection()); expectedDataSet.addTable("seller",
	 * "select * from seller "); ITable expectedTable =
	 * expectedDataSet.getTable("seller");
	 * 
	 * // assertLenientEquals(expectedTable,actualTable);
	 * Assertion.assertEquals(expectedTable, actualTable);
	 * 
	 * }
	 */

}
