package unitils;

import static org.unitils.reflectionassert.ReflectionAssert.*;
import static org.unitils.reflectionassert.ReflectionComparatorMode.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class UnitilsTest {

	private Book aBook;
	private Book otherBook;

	@Before
	public void setUp() {
		aBook = new Book("����� �������� ��°�?", "�罺����", 9000);
		otherBook = new Book("����� �������� ��°�?", "�罺����", 9000);
	}

	@Test
	public void testBookSameInstance() {
		assertThat(aBook, is(sameInstance(otherBook)));
	}

	@Test
	public void testBookSameContents() {
		Book bBook = aBook;
		assertThat(aBook, is(sameInstance(bBook)));
	}

	@Test
	public void testBookSameInstances() {
		Book bBook = aBook;
		assertThat(aBook, is(bBook));
	}

	@Test
	public void testBookContents() {
		assertThat(otherBook.getName(), is(aBook.getName()));
		assertThat(otherBook.getAuther(), is(aBook.getAuther()));
		assertThat(otherBook.getPrice(), is(aBook.getPrice()));
	}

	@Test
	public void testBookContentsUnitils() {
		assertReflectionEquals("Book ��ü �ʵ� ��", aBook, otherBook);
	}

	@Test
	public void testLenientOrder() {
		List<Integer> myList = Arrays.asList(1, 2, 3);
		assertReflectionEquals(Arrays.asList(3, 2, 1), myList, LENIENT_ORDER);
	}

	@Test
	public void testIgnoreDefaults() {
		Book expectedBook = new Book("NamTaekil", null, 1000);
		Book actualBook = new Book("NamTaekil", "nam", 1000);
		assertReflectionEquals(expectedBook, actualBook, IGNORE_DEFAULTS);
		assertReflectionEquals(actualBook, expectedBook, IGNORE_DEFAULTS);
	}

	@Test
	public void testLenientDates() {
		Book expectedBook = new Book("NamTaekil", null, 1000, new Date(System.currentTimeMillis() + 100));
		Book actualBook = new Book("NamTaekil", "nam", 1000, new Date(System.currentTimeMillis()));
		assertReflectionEquals(expectedBook, actualBook, LENIENT_DATES);
	}

	@Test
	public void testLenientEquals() {
	
		//collection
		List<Integer> bag = Arrays.asList(1, 2, 3);
		assertLenientEquals(Arrays.asList(2, 3, 1), bag);
		//배열
		String[] a = new String[] { "a", "b", "c" };
		String[] b = new String[] { "a", "c", "b" };
		assertLenientEquals(a, b);
        //object
		Book expectedBook = new Book("NamTaekil", null, 1000);
		Book actualBook = new Book("NamTaekil", "nam", 1000);
		assertLenientEquals(expectedBook, actualBook);

	}

	@Test
	public void testPropertyLenientEquals_기본() {
		Book tempBook = new Book("NamTaekil", null, 1000, new Date(System.currentTimeMillis()), "20110101");
		assertPropertyLenientEquals("issueDate","20110101" , tempBook);
	}
	
	@Test
	public void testPropertyLenientEquals_여러개() {
		Book tempBook = new Book("NamTaekil", null, 1000, new Date(System.currentTimeMillis()));
		List<Book> books = Arrays.asList(aBook, tempBook);
		assertPropertyLenientEquals("price", Arrays.asList(1000, 9000), books);
	}

	@Test
	public void testPropertyReplectionEquals_여러개1() {
		Book tempBook = new Book("NamTaekil", null, 1000, new Date(System.currentTimeMillis()));
		List<Book> books = Arrays.asList(aBook, tempBook);
		assertPropertyReflectionEquals("여러개","price", Arrays.asList(1000, 2000), books,LENIENT_ORDER );
	}
}
