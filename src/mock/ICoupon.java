package mock;

public interface ICoupon {
	public String getName();                   //쿠폰 이름
	public boolean isValid();                    // 쿠폰 유효 여부 확인
	public int getDiscountPercent();           // 할인율
	public boolean isApplicable(Item item);  // 해당 아이템에 적용 가능 여부
	public void doExpire();                      // 사용할 수 없는 쿠폰으로 만듦
	int getIsApplicableCallCount();
}
