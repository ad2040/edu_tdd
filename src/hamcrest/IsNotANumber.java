package hamcrest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class IsNotANumber extends TypeSafeMatcher<Double> {

	@Override
	protected boolean matchesSafely(Double item) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void describeTo(Description description) {
		// TODO Auto-generated method stub
		
	}


}
