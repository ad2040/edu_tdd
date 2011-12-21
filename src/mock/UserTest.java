package mock;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testAddCoupon() {
		User user = new User("nam");
		assertThat("쿠폰수령전", user.getCouponCount(), is(0));

		ICoupon coupon = new DummyCoupon();

		user.addCoupon(coupon);
		assertThat("쿠폰수령전", user.getCouponCount(), is(1));
	}

	

	@Test
	public void testGetLastOccupiedCoupon() {
		User user = new User("nam");
		ICoupon eventCoupon = new StubCoupon();
		user.addCoupon(eventCoupon);

		ICoupon lastCoupon = user.getLastOccupiedCoupon();

		assertThat("쿠폰 할인율", lastCoupon.getDiscountPercent(), is(7));
		assertThat("쿠폰 이름", lastCoupon.getName(), is("10월 VIP 고객 감사쿠폰"));
	}

	@Test
	public void testGetOrderPrice_할인율이적용되는아이템() {
		PriceCalculator calculator = new PriceCalculator();
		// 아이템(이름, 카테고리, 가격)
		Item item = new Item("sun-mouse", "마우스", 10000);
		ICoupon coupon = new StubCoupon();
		assertThat("아이템 가격", calculator.getOrderPrice(item, coupon), is(9300));
	}

	@Test
	public void testIsApplicable() {
		Item item = new Item("sun-monitor", "모니터", 200000);
		ICoupon coupon = new FakeCoupon();
		assertThat("아이템 할인 가능", coupon.isApplicable(item), is(true));
	}

	@Test
	public void testIsApplicable_할인대상조회횟수() {
		Item item = new Item("sun-monitor", "모니터", 200000);
		ICoupon coupon = new SpyCoupon();
		assertThat("아이템 할인 가능", coupon.isApplicable(item), is(true));

		int methodCallCount = ((SpyCoupon) coupon).getIsApplicableCallCount();
		assertThat("호출된 회수", methodCallCount, is(1));
	}

}
