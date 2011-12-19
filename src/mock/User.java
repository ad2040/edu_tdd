package mock;

public class User {

	private String userId;
	private int count = 0;

	public User(String userId) {
		this.userId = userId;
	}

	public int getCouponCount() {
		return count;
	}

	public void addCoupon(ICoupon coupon) {
		this.count +=1;
		
	}

}
