package hamcrest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;
import static org.hamcrest.text.IsEqualIgnoringCase.*;
import static org.hamcrest.text.IsEqualIgnoringWhiteSpace.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Test;

public class HamcrestTest {
	
	@Test
	public void testArrary(){
		assertThat("start date : " , "2011/01/01", is("201/01/01"));
	}

	@Test
	public void testInt(){
		int i = 100;
		assertThat(i, is(equalTo(100)));
		assertThat(i, is(1000));
	}
	
	 @Test
	  public void allOfExampleShowsAllMatchersMustAllBeTrue() throws Exception {
	    assertThat("Hello", is(allOf(notNullValue(), instanceOf(String.class), equalTo("Hello"))));
	  }

	  @Test
	  public void allOfExampleShowsFailingIfOneMatcherDoesNotMatch() throws Exception {
	    assertThat("Hello", is(not(allOf(notNullValue(), instanceOf(Integer.class)))));
	  }

	  @Test
	  public void anyExampleChecksThatClassIsOfSameType() throws Exception {
	    assertThat(new Person("aa"), is(any(Object.class)));
	  }

	  @Test
	  public void anyExampleShowsStringIsAlsoAnObject() throws Exception {
	    assertThat("Hello", is(any(Object.class)));
	  }

	  @Test
	  public void anyOfExampleReturnsTrueIfOneMatches() throws Exception {
	    assertThat("Hello", is(anyOf(nullValue(), instanceOf(String.class), equalTo("Goodbye"))));
	  }

	  @Test
	  public void anyOfExampleFailingIfAllMatchersAreFalse() throws Exception {
	    assertThat("Hello", is(not(anyOf(nullValue(), instanceOf(Integer.class), equalTo("Goodbye")))));
	  }

	  @Test
	  public void anythingExampleAlwaysReturnsTrue() throws Exception {
	    assertThat("Hello", is(anything()));
	  }

	  // Feels very esoteric and not for typical usage used to override the description
	  @Test
	  public void describedAsExample() throws Exception {
	    Matcher< ?> matcher = describedAs("My Description", anything());
	    Description description = new StringDescription().appendDescriptionOf(matcher);
	    assertThat("My Description", is(description.toString()));
	  }

	  @Test
	  public void equalToExampleAddingTwoPlusTwo() throws Exception {
	    assertThat(2 + 2, is(equalTo(4)));
	  }

	  @Test
	  public void instanceOfExampleForString() throws Exception {
	    assertThat("Hello", is(instanceOf(String.class)));
	  }

	  @Test
	  public void isExampleShortCutForIsInstanceOfClass() throws Exception {
	    assertThat("Hello", is(String.class));
	    assertThat("Hello", instanceOf(String.class));
	  }

	  @Test
	  public void isExampleShortCutAsJustSyntacticSugarUsedThreeTimes() throws Exception {
	    assertThat("Hello", is(is(is(notNullValue()))));
	  }

	  @Test
	  public void isExampleShortCutForIsEqualTo() throws Exception {
	    assertThat("Hello", is("Hello"));
	    assertThat("Hello", equalTo("Hello"));
	  }

	  @Test
	  public void notExampleJustInvertsExpression() throws Exception {
	    assertThat("Hello", is(not(instanceOf(Integer.class))));
	  }

	  @Test
	  public void notNullValueExampleForString() throws Exception {
	    assertThat("Hello", is(notNullValue()));
	  }

	  @Test
	  public void notNullValueExampleForAClass() throws Exception {
	    assertThat("Hello", is(notNullValue(Object.class)));
	  }

	  @Test
	  public void nullValueExampleWithANull() throws Exception {
	    assertThat(null, is(nullValue()));
	  }

	  @Test
	  public void nullValueExampleWithANullType() throws Exception {
	    Integer nothing = null;
	    assertThat(nothing, is(nullValue(Integer.class)));
	  }

	  @Test
	  public void sameInstanceExample() throws Exception {
	    Object object = new Object();
	    Object sameObject = object;
	    assertThat(object, is(sameInstance(sameObject)));
	  }
	  
	  
	  
	//Hamcrest with Collections and Arrays:
	  static final String[] array = { "A", "B", "C" };
	  static final List<String> list = Arrays.asList(array);
	 
	  @Test
	  public void oneThingInArray () {
	    assertThat(array, hasItemInArray("C"));
	  }
	 
	  @Test
	  public void arrayOfItemsInList () {
	  String[] expected = { "A", "B", "C" };
	    assertThat(list, hasItems(expected));
	  }
	 
	  @Test
	  public void itemInAList () {
	    assertThat(list, hasItem("A"));
	  }
	 
	  @Test
	  public void itemsInAList () {
	    assertThat(list, hasItems("A", "C"));
	  }
	  
	  @Test
	  public void testEveryItem(){
		  assertThat( Arrays.asList("1x", "2x", "3x", "4z"), everyItem(endsWith("x")) );
	  }
	  
	  @Test
	  public void testEveryItem1(){
		  assertThat( Arrays.asList("1x", "2x", "3x", "4z"), hasItem(containsString("x")) );
	  }
	  
	  
	  
	  //text
	  static final String tempStr = "hello world";
	  @Test
	  public void testContainsString(){
		  assertThat( tempStr, containsString("hello"));
	  }
	  
	  @Test
	  public void testStartsWith(){
		  assertThat( tempStr, startsWith("h"));
	  }
	  
	  @Test
	  public void testEndsWith(){
		  assertThat( tempStr, endsWith("d"));
	  }
	  
	  @Test
	  public void testEqualToIgnoringCase(){
		  assertThat( tempStr, equalToIgnoringCase("Hello World"));
	  }
	  
	  @Test
	  public void testEqualToIgnoringWhiteSpace(){
		  assertThat( tempStr, equalToIgnoringWhiteSpace("hello  worl d "));
	  }
	  


		
	
}
