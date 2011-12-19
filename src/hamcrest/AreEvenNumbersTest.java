package hamcrest;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static hamcrest.AreEvenNumbers.*;

public class AreEvenNumbersTest {
	@Test
	public void testHaveOnlyEvenNumbers(){
		List<Integer> numbers  = Arrays.asList(2, 4, 6, 8, 10);
		assertThat(numbers, is(evenNumbers()));
	}
	
	@Test
	public void testNotHaveOddNumbers(){
		List<Integer> numbers  = Arrays.asList(1,2, 4, 6, 8, 10);
		assertThat(numbers, is(evenNumbers()));
	}

}
