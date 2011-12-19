package unitils;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class OrderBooksTest {
	
	@Test
	public void testOrder(){
		Book book = new Book("Java Tdd", "nam", 10000);
		OrderBooks order = new OrderBooks(book);
		assertThat(true,is(order.confirmStockBook()));
	}

}
