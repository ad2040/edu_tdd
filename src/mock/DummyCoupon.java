package mock;

public class DummyCoupon implements ICoupon {

	public String getName() {
		return null;
	}

	public boolean isValid() {
		return false;
	}

	public int getDiscountPercent() {
		return 0;
	}

	public boolean isApplicable(Item item) {
		return false;
	}

	public void doExpire() {
	}

	@Override
	public int getIsApplicableCallCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
