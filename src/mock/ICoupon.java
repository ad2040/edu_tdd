package mock;

public interface ICoupon {
	
	public String getUserId();
	public boolean isValid();
	public int getDiscountPercent();
	public boolean isApplicable(Item item);
	public void doExpire();

}
