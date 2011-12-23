package dbunit;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedDataSet;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import org.unitils.*;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
//import java.sql.*;
//import org.dbunit.
import static org.unitils.reflectionassert.ReflectionAssert.assertLenientEquals;


public class DatabaseRepositoryTest {
	private final String clientDriver= "org.apache.derby.jdbc.ClientDriver";
	private final String url = "jdbc:derby://localhost:1527/Sellerdb;create=true;user=nam;pass=nam";
	private IDatabaseTester databaseTester;
	private Repository repository;

	@Before
	public void setUp() throws SQLException, Exception{
		
		repository = new DatabaseRepository();
		databaseTester = new JdbcDatabaseTester(clientDriver, url);
	    try {
			IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("src\\dbunit\\Seller.xml"));
			DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			//databaseTester.getConnection().close();
		}
	}
	
	@After
	public void tearDown() throws SQLException, Exception{
		databaseTester.getConnection().close();
	}
	
	@Test
	public void testDBConnection(){
		assertThat(databaseTester, is(notNullValue()));
	}
	
	@Ignore@Test
	public void testFindById() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Seller expectedSeller = new Seller("nam", "������", "ad2040@gmail.com");
		Seller expectedSeller1 = new Seller("kim", "����", "kim@gmail.com");
		Seller expectedSeller2 = new Seller("lee", "������", "lee@gmail.com");
		
		
		
		Seller actualSeller = repository.findById("kim");
		
		assertLenientEquals(expectedSeller2, actualSeller);
		
	}
	@Test
	public void testAddNewSeller() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Seller newSeller = new Seller("park", "������", "park@gmail.com");
		repository.add(newSeller);
		
		
		Repository repository1 = new DatabaseRepository();
		Seller resultSeller = repository1.findById("park");
		
		assertLenientEquals(newSeller, resultSeller);
		
		
	}
	/**
	 * �����ͼ��� Table�� ��
	 * @throws Exception
	 */
	@Test
	public void testAddNewSellerTable() throws Exception{
		Seller newSeller = new Seller("yoo", "유태연", "yoo@gmail.com");
		repository.add(newSeller);
		
		IDataSet currentDBdataSet = databaseTester.getConnection().createDataSet();
		ITable actualTable = currentDBdataSet.getTable("seller");
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src\\dbunit\\Expected_Seller.xml"));
		ITable expectedTable = expectedDataSet.getTable("seller");
		
		Assertion.assertEquals(new SortedTable(expectedTable), actualTable);
//		Assertion.assertEquals(expectedTable, actualTable1);
//		assertLenientEquals(expectedTable,actualTable);
	}
	
	/**
	 * �����ͼ��� ���� ��
	 * @throws Exception
	 */
	@Test
	public void testAddNewSellerDataSet() throws Exception{
		Seller newSeller = new Seller("yoo", "유태연", "yoo@gmail.com");
		repository.add(newSeller);
		
		IDataSet currentDBdataSet = databaseTester.getConnection().createDataSet(new String[] {"seller"});
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src\\dbunit\\Expected_Seller.xml"));
		
		Assertion.assertEquals(expectedDataSet, currentDBdataSet);
//		assertLenientEquals(expectedDataSet,currentDBdataSet);
	}
	
	/**
	 * �����Ͽ� ��
	 * @throws Exception
	 */
	@Test
	public void testAddNewSellerDataSetSorted() throws Exception{
		Seller newSeller = new Seller("yoo", "유태연", "yoo@gmail.com");
		repository.add(newSeller);
		
		IDataSet currentDBdataSet = databaseTester.getConnection().createDataSet(new String[] {"seller"});
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src\\dbunit\\Expected_Seller.xml"));
		
		Assertion.assertEquals(new SortedDataSet(expectedDataSet), currentDBdataSet);
	}
	
	/**
	 * SQL�� ���� �ۼ�
	 * @throws DataSetException
	 * @throws Exception
	 */
	@Test
	public void testQueryDataSet() throws DataSetException, Exception{
		Seller newSeller = new Seller("yoo", "유태연", "yoo@gmail.com");
		repository.add(newSeller);
		
		ITable actualTable =databaseTester.getConnection().createQueryTable("seller", "select * from seller");
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src\\dbunit\\Expected_Seller.xml"));
		ITable expectedTable = expectedDataSet.getTable("seller");
		
		Assertion.assertEquals( expectedTable, actualTable);
		//assertLenientEquals(expectedTable,actualTable);
		
	}
	
	@Test
	public void testAddNewSellerDataSetWithExcel() throws Exception{
		Seller newSeller = new Seller("yoo", "유태연", "yoo@gmail.com");
		repository.add(newSeller);
		
		//Seller newSeller1 = new Seller("park", "박은주", "park@gmail.com");
		//repository.add(newSeller1);
		
//		IDataSet currentDBdataSet = databaseTester.getConnection().createDataSet();
//		ITable actualTable = currentDBdataSet.getTable("seller");
		
		ITable actualTable1 = databaseTester.getConnection().createQueryTable("seller", "select * from seller ");
		
		
		
		IDataSet expectedDataSet = new XlsDataSet(new File("src\\dbunit\\Expected_Seller.xlsx"));
		ITable expectedTable = expectedDataSet.getTable("seller");
		
		System.out.println(expectedTable.getRowCount());
		
//		Assertion.assertEquals(new SortedTable(expectedTable), actualTable);
		Assertion.assertEquals(expectedTable, actualTable1);
	}
	
	/**
	 * DatabaseOperation - refresh
	 * @throws DatabaseUnitException
	 * @throws SQLException
	 * @throws Exception
	 */
	@Test
	public void testDatabaseOperationRefresh() throws DatabaseUnitException, SQLException, Exception{
		ITable actualTable = databaseTester.getConnection().createQueryTable("seller", "select * from seller ");
		
		System.out.println(actualTable.getRowCount());
		IDataSet dataSet = new XlsDataSet(new File("src\\dbunit\\Expected_Seller.xlsx"));
		
		
		DatabaseOperation.REFRESH.execute(databaseTester.getConnection(), dataSet);
		ITable refreshActualTable = dataSet.getTable("seller");
		
		QueryDataSet expectedDataSet = new QueryDataSet(databaseTester.getConnection());
		expectedDataSet.addTable("seller", "select * from seller ");
		ITable expectedTable = expectedDataSet.getTable("seller");
		
		System.out.println(expectedDataSet.getTable("seller").getRowCount());
		Assertion.assertEquals(expectedTable, refreshActualTable);
		
		
	}
	
	
	@Test
	public void testDatabaseOperationRefreshWithUnitils() throws DatabaseUnitException, SQLException, Exception{
		IDataSet dataSet = new XlsDataSet(new File("src\\dbunit\\Expected_Seller.xlsx"));
		
		DatabaseOperation.REFRESH.execute(databaseTester.getConnection(), dataSet);
		ITable actualTable = dataSet.getTable("seller");
		
		QueryDataSet expectedDataSet = new QueryDataSet(databaseTester.getConnection());
		expectedDataSet.addTable("seller", "select * from seller ");
		ITable expectedTable = expectedDataSet.getTable("seller");
		
		
		
//		assertLenientEquals(expectedTable,actualTable);
		Assertion.assertEquals(expectedTable, actualTable);
		
		
	}
	
	

}
