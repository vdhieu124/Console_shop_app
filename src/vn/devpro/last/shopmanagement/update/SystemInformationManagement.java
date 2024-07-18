package vn.devpro.last.shopmanagement.update;

import java.util.Scanner;

import vn.devpro.last.shopmanagement.update.customer.CustomerManagement;
import vn.devpro.last.shopmanagement.update.product.ProductManagement;
import vn.devpro.last.shopmanagement.update.provider.ProviderManagement;
import vn.devpro.last.shopmanagement.update.type.TypeManagement;


public class SystemInformationManagement {
	public static void execute() {
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("\n===================CAP NHAT THONG TIN HE THONG====================");
			System.out.println("Cac chuc nang cap nhat he thong");
			System.out.println("\t1. Cap nhat thong tin nha cung cap");
			System.out.println("\t2. Cap nhat thong tin chung loai");
			System.out.println("\t3. Cap nhat thong tin san pham");
			System.out.println("\t4. Cap nhat thong tin khach hang");
			
			System.out.println("\t0. Thoat");
			
			System.out.print("Lua chon chuc nang: ");
			int chon = Integer.parseInt(in.nextLine());
			switch(chon) {
			case 1:
				ProviderManagement.providerUpdate();
				break;
			case 2:
				TypeManagement.typeUpdate();
				break;
			case 3:
				ProductManagement.productUpdate();
				break;
			case 4:
				CustomerManagement.customerUpdate();
				break;
			case 0:
				return;
			default: System.out.println("Lua chon khong hop le!");
			}
		} while (true);	
	}
}
