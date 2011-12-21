package mock;

public class User {

	private String userId;
	private int count = 0;
	private ICoupon coupon;
	

	public User(String userId) {
		this.userId = userId;
	}

	public int getCouponCount() {
		return count;
	}

	public void addCoupon(ICoupon coupon) {
		this.coupon = coupon;
		this.count +=1;
		
	}

	public ICoupon getLastOccupiedCoupon() {
		
		return this.coupon;
	}

}
