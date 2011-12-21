package mock;

public class Item {

	private int price;
	private String category;
	private String name;

	public Item(String name, String category, int price) {
		this.name = name;
		this.category = category;
		this.price = price;
		
	}

	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	
	public String getCategory(){
		return this.category;
	}

}
