package vn.devpro.last.shopmanagement.update.product;

import vn.devpro.last.shopmanagement.update.provider.ProviderManagement;
import vn.devpro.last.shopmanagement.update.type.TypeManagement;

public class Product {
	private int id;
	private int providerId;
	private int typeId;
	private String name;
	private double price;
	private double amount;
	
	public void display() {
		System.out.printf("%6d %-25s %-25s %-25s %,15.2f %,12.2f%n",
				this.id,ProviderManagement.getNameById(providerId), TypeManagement.getNameById(typeId),
				this.name,this.price,this.amount);
	}

	public Product() {
		super();
	}

	public Product(int id, int providerId, int typeId, String name, double price, double amount) {
		super();
		this.id = id;
		this.providerId = providerId;
		this.typeId = typeId;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
