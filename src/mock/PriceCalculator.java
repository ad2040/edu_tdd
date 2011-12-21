package mock;

public class PriceCalculator {
	
	public int getOrderPrice(Item item, ICoupon coupon){
		if(coupon.isValid() && coupon.isApplicable(item)){
			return (int)( item.getPrice()*getDiscountRate(coupon.getDiscountPercent()));
		}
		return item.getPrice();
	}

	private double getDiscountRate(int discountPercent) {
		System.out.println(discountPercent);
		return (100-discountPercent)/100d;
	}

}
