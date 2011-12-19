package unitils;

import java.util.Date;

import org.hamcrest.Matcher;

public class Book {

	private String name;
	private String auther;
	private int price;
	private Date inputDate;
	private String issueDate;

	public Book(String name, String auther, int price) {
		this.name = name;
		this.auther = auther;
		this.price = price;
	}

	public Book(String string, Object object, int price, Date inputDate) {
		this.name = name;
		this.auther = auther;
		this.price = price;
		this.inputDate = inputDate;
	}
	
	public Book(String string, Object object, int price, Date inputDate ,String issueDate) {
		this.name = name;
		this.auther = auther;
		this.price = price;
		this.inputDate = inputDate;
		this.issueDate = issueDate;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String getAuther() {
		// TODO Auto-generated method stub
		return this.auther;
	}

	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	
	

	

}
