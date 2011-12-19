package hamcrest;






import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


import org.junit.Test;

public class IsMapContainingValueTest  {


	@Test
    public void testHasReadableDescription() {
        assertThat("map containing [ANYTHING->\"a\"]",containsString("a"));
    }
	
	@Test
    public void testDoesNotMatchEmptyMap() {
        Map<String,Integer> map = new HashMap<String,Integer>();
        assertThat(map, hasValue(0));   
    }
	@Test
    public void testMatchesSingletonMapContainingValue() {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("a", 1);
        assertThat(map, hasKey("a"));
    }
	@Test
    public void testMatchesMapContainingValue() {
        Map<String,Integer> map = new TreeMap<String,Integer>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        
        assertThat("aa",map, hasValue(4));   
        assertThat(map, hasValue(3));
        //assertThat("map was [<a=1>, <b=2>, <c=3>]", hasValue(4), map);      
    }
	
	
	@Test
	public void testBeTheSamePerson(){
		Person me = new Person("Rafael");
		Person theOther = new Person("Rafael");
		
		assertThat(me,is(theOther));
	}
	
	@Test
	public void testHaveFixedSizeNumbers(){
		List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
				
		assertThat(number.size(), is(equalTo(5)));
	}

}
