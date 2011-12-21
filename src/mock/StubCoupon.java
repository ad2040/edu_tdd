package mock;

public class StubCoupon implements ICoupon {

	public String getName() {
		return "10월 VIP 고객 감사쿠폰";
	}

	public boolean isValid() {
		return true;
	}

	public int getDiscountPercent() {
		return 7;
	}

	public boolean isApplicable(Item item) {
		return true;
	}

	public void doExpire() {
	}

	@Override
	public int getIsApplicableCallCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
