package mock;

import java.util.ArrayList;
import java.util.List;

public class SpyCoupon implements ICoupon {
	
	private List<String> categoryList = new ArrayList();
	private int isApplicableCallCount;
	
	public SpyCoupon(){
		categoryList.add("마우스");
		categoryList.add("모니터");
		categoryList.add("키보드");
	}
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
		
		if(this.categoryList.contains(item.getCategory())){
			return true;
		}
		return false;
	}
	
	public int getIsApplicableCallCount(){
		return this.isApplicableCallCount;
	}

	public void doExpire() {
	}

}
