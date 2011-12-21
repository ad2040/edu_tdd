package mock;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UserAnonymousTest {

	public ICoupon iCoupon;

	@Before
	public void setUp() {
		final List<String> categoryList = new ArrayList();
		categoryList.add("마우스");
		categoryList.add("모니터");
		categoryList.add("키보드");
		iCoupon = new ICoupon() {

			private int isApplicableCallCount;

			@Override
			public String getName() {
				return "10월 VIP 고객 감사쿠폰";
			}

			@Override
			public boolean isValid() {
				return true;
			}

			@Override
			public int getDiscountPercent() {
				return 7;
			}

			@Override
			public boolean isApplicable(Item item) {
				isApplicableCallCount++;
				if (categoryList.contains(item.getCategory())) {
					return true;
				}
				return false;
			}

			@Override
			public void doExpire() {
			}

			public int getIsApplicableCallCount() {
				return this.isApplicableCallCount;
			}
		};

	}

	@Test
	public void testAddCoupon() {
		User user = new User("nam");
		assertThat("쿠폰수령전", user.getCouponCount(), is(0));

		ICoupon coupon = iCoupon;
		;

		user.addCoupon(coupon);
		assertThat("쿠폰수령전", user.getCouponCount(), is(1));
	}

	@Test
	public void testAddCoupon_익멸클래스사용() {
		User user = new User("nam");
		assertThat("쿠폰수령전", user.getCouponCount(), is(0));

		user.addCoupon(iCoupon);
		assertThat("쿠폰수령전", user.getCouponCount(), is(1));
	}

	@Test
	public void testGetLastOccupiedCoupon() {
		User user = new User("nam");
		ICoupon eventCoupon = iCoupon;
		;
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
		assertThat("아이템 가격", calculator.getOrderPrice(item, iCoupon), is(9300));
	}

	@Test
	public void testIsApplicable() {
		Item item = new Item("sun-monitor", "키보드", 200000);
		assertThat("아이템 할인 가능", iCoupon.isApplicable(item), is(true));
	}

	@Test
	public void testIsApplicable_할인대상조회횟수() {
		Item item = new Item("sun-monitor", "모니터", 200000);
		assertThat("아이템 할인 가능", iCoupon.isApplicable(item), is(true));

		// iCoupon.g
		 int methodCallCount =iCoupon.getIsApplicableCallCount();
		// int methodCallCount =iCoupon.
	 assertThat("호출된 회수", methodCallCount, is(1));
	}

}
