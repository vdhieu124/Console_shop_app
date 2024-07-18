package vn.devpro.last.shopmanagement.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import vn.devpro.last.shopmanagement.sale.Cart;
import vn.devpro.last.shopmanagement.update.customer.CustomerManagement;


public class OrderManagement {
	private static List<Cart> carts = new ArrayList<Cart>();
	private static Map<String, Double> mPnameToTotal = new HashMap<String, Double>();

	public static List<Cart> getCarts() {
		return carts;
	}

	public static void setCarts(List<Cart> carts) {
		OrderManagement.carts = carts;
	}
	
	
	public static Map<String, Double> getmPnameToTotal() {
		return mPnameToTotal;
	}

	public static void setmPnameToTotal(Map<String, Double> mPnameToTotal) {
		OrderManagement.mPnameToTotal = mPnameToTotal;
	}


	//hien thi danh sach cac don hang, tinh tong doanh thu
	//tim kiem gio hang, hien thi chi tiet gio hang neu tim thay
	static Scanner in = new Scanner(System.in);
	public static void orderManagement() {
		do {
			System.out.println("--------------QUAN LY DON HANG-----------------");
			System.out.println("Chon chuc nang quan ly");
			System.out.println("\t1. Hien thi ds don hang");
			System.out.println("\t2. Xem tong doanh thu tu cac don hang");
			System.out.println("\t3. Tim kiem don hang");
			System.out.println("\t4. Tong tien thu duoc theo san pham");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban? ");
			int chon = Integer.parseInt(in.nextLine());
			
			switch(chon) {
			case 1: displayCarts(); break;
			case 2: displayTotalMoney(); break;
			case 3: searchCart(); break;
			case 4: displayTotalMoneyByProduct();break;
			case 0: return;
			default: System.out.println("Lua chon khog hop le!");
			}
		} while (true);
		
		
	}

	private static void displayTotalMoneyByProduct() {
		// TODO Auto-generated method stub
		System.out.println("-----------DOANH THU THEO SAN PHAM-----------");
		System.out.printf("%3s %-30s %-15s%n","STT","Ten SP","Doanh thu");
		int stt=1;
		for (Map.Entry<String, Double> e : mPnameToTotal.entrySet()) {
			System.out.printf("%3d %-30s %,15.2f%n",stt++,e.getKey(),e.getValue());
		}
		
	}

	private static void displayCarts() {
		// TODO Auto-generated method stub
		System.out.println("-----------DANH SACH DON HANG-----------");
		System.out.printf("%3s %-11s %-30s %-15s%n","STT","Ma don","Ten KH","Tong tien hang");
		int stt=1;
		for (Cart cart:carts) {
			System.out.printf("%3d %-11d %-30s %,15.2f%n",stt++,cart.getId(),
					CustomerManagement.getNameById(cart.getCustomerId()),cart.cartTotal());
			
		}
	}
	public static double totalMoney() {
		double total = 0;
		for (Cart cart:carts) {
			total += cart.cartTotal();
		}
		return total;
	}

	private static void displayTotalMoney() {
		// TODO Auto-generated method stub
		System.out.printf("\nTong doanh thu: %,.2f%n",totalMoney());
	}

	private static void searchCart() {
		// TODO Auto-generated method stub
		System.out.println("-------------------SEARCH------------------");
		System.out.print("Nhap ma don hang: ");
		int cartId = Integer.parseInt(in.nextLine());
		boolean result = false;
		for (Cart cart:carts) {
			if(cart.getId() == cartId) {
				System.out.println("Chi tiet gio hang: ");
				cart.display();
				result = true;
			}
		}
		if (result == false) {
			System.out.println("Khong tim thay ket qua nao!");
		}
	}
}
