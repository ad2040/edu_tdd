package mock;

import java.util.ArrayList;
import java.util.List;

public class FakeCoupon implements ICoupon {
	
	private List<String> categoryList = new ArrayList();
	
	public FakeCoupon(){
		categoryList.add("마우스");
		categoryList.add("모니터");
		categoryList.add("키보드");
	}

	public String getName() {
		return "10월 VIP 고객 감사쿠폰";
	}

	public boolean isValid() {
		return true;
	}

	public int getDiscountPercent() {
		return 7;
	}

	@Override
	public boolean isApplicable(Item item) {
		if(this.categoryList.contains(item.getCategory())){
			return true;
		}
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
