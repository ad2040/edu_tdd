package mockito;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class MonthlyPayDaoTest {

	@Test
	public void testMonthlyPayDaoMock() {
		MonthlyPayDAOMock mock = new MonthlyPayDAOMock();
		mock.setPay("nam", 0);
		System.out.println(mock.getPay("naam"));
	}

	@Test
	public void iterator_will_return_hello_world() {
		// arrange
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		// act
		String result = i.next() + " " + i.next();
		// assert
		assertThat(result, is("Hello World"));
	}

	@Test
	public void with_arguments() {
		Comparable c = mock(Comparable.class);
		when(c.compareTo("Test")).thenReturn(1);
		assertEquals(1, c.compareTo("Test"));
	}

	@Test
	public void with_unspecified_arguments() {
		Comparable c = mock(Comparable.class);
		when(c.compareTo(anyInt())).thenReturn(-1);
		assertEquals(-1, c.compareTo(5));
	}

	@Test
	public void testMapInterface() {
		Map mapMock = mock(Map.class);
		when(mapMock.get("nam")).thenReturn("Taekil");

		assertThat(mapMock.get("nam").toString(), is("Taekil"));
	}

	@Test
	public void testMapVerify() {
		Map mapMock = mock(Map.class);
		mapMock.put("1", "a");
		mapMock.put("1", "a");
		mapMock.put("2", "b");
		
		
		verify(mapMock, atLeastOnce()).put("1","a");
		verify(mapMock, atLeast(3)).put("1","a");
	}
}
