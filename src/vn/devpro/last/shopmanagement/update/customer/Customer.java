package vn.devpro.last.shopmanagement.update.customer;

public class Customer {
	private int id;
	private String name;
	private String phone;
	
	public void display() {
		System.out.printf("%5d %-30s %-15s%n",this.id, this.name, this.phone);
	}

	public Customer() {
		super();
	}

	public Customer(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
