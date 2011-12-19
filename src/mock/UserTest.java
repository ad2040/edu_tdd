package mock;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void testAddCoupon(){
		User user = new User("nam");
		assertThat("쿠폰수령전", user.getCouponCount(), is(0));
		
		ICoupon coupon = new dummyCoupon();
		
		user.addCoupon(coupon);
		assertThat("쿠폰수령전", user.getCouponCount(), is(1));
	}

}
