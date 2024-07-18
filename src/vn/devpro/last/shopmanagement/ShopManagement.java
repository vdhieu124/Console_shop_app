package vn.devpro.last.shopmanagement;

import java.util.Scanner;

import vn.devpro.last.shopmanagement.order.OrderManagement;
import vn.devpro.last.shopmanagement.sale.CartManagement;
import vn.devpro.last.shopmanagement.update.SystemInformationManagement;
import vn.devpro.last.shopmanagement.update.customer.CustomerManagement;
import vn.devpro.last.shopmanagement.update.product.ProductManagement;
import vn.devpro.last.shopmanagement.update.provider.ProviderManagement;
import vn.devpro.last.shopmanagement.update.type.TypeManagement;

public class ShopManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProviderManagement.init();
		TypeManagement.init();
		ProductManagement.init();
		CustomerManagement.init();
		Scanner in = new Scanner(System.in);
		// TODO Auto-generated method stub
		do {
			System.out.println("\n================QUAN LY SHOP==================");
			System.out.println("Cac chuc nang quan ly");
			System.out.println("\t1. Cap nhat thong tin he thong");
			System.out.println("\t2. Quan ly phien giao dich");
			System.out.println("\t3. Quan ly don hang va doanh thu");
			System.out.println("\t0. Thoat");
			
			System.out.print("Lua chon chuc nang: ");
			int chon = Integer.parseInt(in.nextLine());
			switch(chon) {
			case 1:
				SystemInformationManagement.execute();
				break;
			case 2:
				CartManagement.cartManagement();
				break;
			case 3:
				OrderManagement.orderManagement();
				break;
			case 0:
				System.out.println("Thoat khoi ung dung!");
				System.exit(0);
			default: System.out.println("Lua chon khong hop le!");
			}
			
		} while (true);
	}

}
