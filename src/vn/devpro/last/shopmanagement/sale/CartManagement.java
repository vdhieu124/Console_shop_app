package vn.devpro.last.shopmanagement.sale;

import java.util.Scanner;

import vn.devpro.last.shopmanagement.order.OrderManagement;
import vn.devpro.last.shopmanagement.update.customer.Customer;
import vn.devpro.last.shopmanagement.update.customer.CustomerManagement;


public class CartManagement {
	public static int autoId = 1;
	static Scanner in = new Scanner(System.in);
	public static void cartManagement() {
		Cart cart = new Cart();
		System.out.println("\nChao mung quy khach den mua hang!");
		do {
			System.out.println("Chon thao tac voi gio hang");
			System.out.println("\t1. Xem thong tin gio hang");
			System.out.println("\t2. Them hang hoa vao gio");
			System.out.println("\t3. Sua so luong hang trong gio");
			System.out.println("\t4. Xoa hang hoa khoi gio");
			System.out.println("\t5. Huy gio hang");
			System.out.println("\t6. Thanh toan");
			System.out.println("\t0. Thoat");
			
			System.out.println("Lua chon cua ban? ");
			int chon = Integer.parseInt(in.nextLine());
			switch(chon) {
			case 1:
				cart.display(); break;
			case 2:
				cart.add(); break;
			case 3: 
				cart.update(); break;
			case 4:
				cart.remove(); break;
			case 5:
				cart = new Cart();
				System.out.println("Da huy gio hang!");
				break;
			case 6:
				if (payment(cart)) {
					cart = new Cart();//xoa gio hang sau khi thanh toan
				}
				break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while(true);
	}
	private static boolean payment(Cart cart) {
		// TODO Auto-generated method stub
		if (cart == null || cart.getList().size() <= 0) {
			System.out.println("Ban chua mua hang!");
			return false;
		}
		System.out.println("-----------------------THANH TOAN---------------------------");
		//Cap nhat thong tin khach hang
		System.out.print("Nhap ma (id) khach hang: ");
		int customerId = Integer.parseInt(in.nextLine());
		//Kiem tra khach hang co trong ds luu hay chua
		int index = CustomerManagement.indexOfCustomer(customerId);
		String customerName = null, customerPhone = null;
		if (index == -1) {
			System.out.print("Nhap ho ten khach hang: ");
			customerName = in.nextLine();
			if (customerName.trim().length() <= 0) {
				System.out.println("Ten khach hang khong de trong!");
				return false;
			}
			System.out.print("Nhap sdt khach hang: ");
			customerPhone = in.nextLine();
			if (customerPhone.trim().length() <= 0) {
				System.out.println("So dien thoai khong de trong!");
				return false;
			}
			//Them khach hang vao danh sach khach hang
			customerId = CustomerManagement.autoId++;
			CustomerManagement.getList().add(new Customer(customerId, customerName, customerPhone));
		} else {
			customerName = CustomerManagement.getList().get(index).getName();
		}
		
		//cap nhat thong tin gio hang
		cart.setId(autoId++);
		cart.setCustomerId(customerId);
		//hien thi lai gio hang cho khach xem
		cart.display();
		//luu gio hang vao danh sach
		OrderManagement.getCarts().add(cart);
		//luu doanh thu theo tung san pham
		for (int i = 0; i < cart.getList().size(); i++) {
			CartProduct cartProduct = cart.getList().get(i);
			if (OrderManagement.getmPnameToTotal().get(cartProduct.getNameById()) == null) {
				OrderManagement.getmPnameToTotal().put(cartProduct.getNameById(), cartProduct.total());
			} else
				OrderManagement.getmPnameToTotal().put(cartProduct.getNameById(), OrderManagement.getmPnameToTotal().get(cartProduct.getNameById()) + cartProduct.total());			
		}
		//Xoa gio hang
		System.out.println("Thanh toan gio hang thanh cong!");
		return true;
	}
}
