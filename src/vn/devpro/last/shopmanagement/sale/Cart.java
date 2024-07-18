package vn.devpro.last.shopmanagement.sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.devpro.last.shopmanagement.update.customer.CustomerManagement;
import vn.devpro.last.shopmanagement.update.product.ProductManagement;


public class Cart {
	private int id;
	private int customerId;
	private List<CartProduct> list = new ArrayList<CartProduct>();
	
	public double cartTotal() {
		double total = 0;
		for (CartProduct cp: list) {
			total += cp.total();
		}
		return total;
	}
	public void display() {
		System.out.println("------------------GIO HANG-------------------");
		System.out.println("\tTen khach hang: "+CustomerManagement.getNameById(customerId));
		System.out.println("\tSo dien thoai: "+CustomerManagement.getPhoneById(customerId));
		System.out.println("\tGio hang co "+list.size()+" loai hang hoa");
		System.out.printf("%3s %-30s %-15s %-12s %-15s%n",
				"STT","Ten hang","Don gia","So luong","Thanh tien");
		for (int i=0;i<list.size();i++) {
			System.out.printf("%-3d",i+1);
			list.get(i).display();
		}
		System.out.printf("\t\tThanh tien: %,.2f%n",cartTotal());
	}
	Scanner in = new Scanner(System.in);
	
	
	public Cart() {
		super();
	}
	public Cart(int id, int customerId, List<CartProduct> list) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<CartProduct> getList() {
		return list;
	}
	public void setList(List<CartProduct> list) {
		this.list = list;
	}
	
	public void add() {
		System.out.println("\n--------THEM SAN PHAM VAO GIO HANG----------");
		
		System.out.print("Nhap ma sp (id) muon mua: ");
		int productId = Integer.parseInt(in.nextLine()); 
		
		//Kiem tra xem productId co trong danh sach hang ban hay khong
		int index = ProductManagement.indexOfProduct(productId);
		if (index == -1) {
			System.out.println("San pham khong co trong ds ban, xin chon lai");
			return;
		}
		
		//Co thi nhap so luong can mua
		System.out.print("Nhap so luong muon mua: ");
		double amount = Double.parseDouble(in.nextLine());
		if (amount <= 0) {
			System.out.println("So luong mua phai lon hon 0");
			return;
		}
		
		//Tim xem hang dinh mua co trong gio chua
		int cartIndex = indexOfCartProduct(productId);
		if (cartIndex != -1) { //Hang dinh mua da co trong gio
			amount += list.get(cartIndex).getAmount(); //Cong so luong trong gio voi so luong moi chon them
		}
		
		//Kiem tra tong so luong mua co vuot qua tong so luong dang co ban
		if (amount > ProductManagement.getList().get(index).getAmount()) {
			System.out.println("So luong can mua vuot qua kha nang, xin chon lai");
			return;
		}
		
		//Them hang vao gio: 2 truong hop
		if (cartIndex != -1) { //Hang da co trong gio
			list.get(cartIndex).setAmount(amount); //Set lai so luong moi
		}
		else { //hang chua co trong gio
			list.add(new CartProduct(productId, amount)); //Them hang moi vao gio
		}
		System.out.println("Them san pham moi thanh cong!");
	}
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("\n--------SUA SAN PHAM TRONG GIO HANG----------");
		
		System.out.print("Nhap ma sp muon sua: ");
		int productId=Integer.parseInt(in.nextLine());
		
		int cartIdx = indexOfCartProduct(productId);
		if (cartIdx == -1) {
			System.out.println("San pham ko co trong gio");
			return;
		}
		//Co thi nhap so luong can mua
		System.out.print("Nhap so luong muon mua: ");
		double amount = Double.parseDouble(in.nextLine());
		if (amount <= 0) {
			System.out.println("So luong mua phai lon hon 0");
			return;
		}
		
		//Kiem tra tong so luong mua co vuot qua tong so luong dang co ban
		int index = ProductManagement.indexOfProduct(productId);
		if (amount > ProductManagement.getList().get(index).getAmount()) {
			System.out.println("So luong can mua vuot qua kha nang, xin chon lai");
			return;
		}
		list.get(cartIdx).setAmount(amount);
		System.out.println("Sua thong tin gio hang thanh cong");
	}
	public void remove() {
		// TODO Auto-generated method stub
		System.out.println("\n--------XOA SAN PHAM TRONG GIO HANG----------");
		
		System.out.print("Nhap ma sp muon xoa: ");
		int productId=Integer.parseInt(in.nextLine());
		
		int cartIdx = indexOfCartProduct(productId);
		if (cartIdx == -1) {
			System.out.println("Khong co trong gio");
			return;
		}
		list.remove(cartIdx);
		System.out.println("Xoa san pham trong gio thanh cong!");
	}
	public int indexOfCartProduct(int productId) {
		for (int idx = 0; idx < list.size(); idx++) {
			if (list.get(idx).getProductId() == productId) {
				return idx;
			}
		}
		return -1;
	}
	
}
