package vn.devpro.last.shopmanagement.update.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CustomerManagement {
	static Scanner in = new Scanner(System.in);
	private static ArrayList<Customer> list = new ArrayList<Customer>();

	public static ArrayList<Customer> getList() {
		return list;
	}

	public static void setList(ArrayList<Customer> list) {
		CustomerManagement.list = list;
	}
	public static int autoId = 1;
	public static void init() {
		list.add(new Customer(autoId++, "Duy Hieu","0356899451"));
		list.add(new Customer(autoId++, "Mai Nguyen","0784561233"));
		list.add(new Customer(autoId++, "Thuy Trang","0368991245"));
		list.add(new Customer(autoId++, "Hau Vuong","0986233148"));
		list.add(new Customer(autoId++, "Phuc Tue","0166982756"));
	}
	public static void customerUpdate() {
		
		do {
			System.out.println("\n==============CAP NHAT THONG TIN KHACH HANG===============");
			System.out.println("Cac chuc nang");
			System.out.println("\t1. Xem danh sach khach hang");
			System.out.println("\t2. Them khach hang moi");
			System.out.println("\t3. Sua thong tin khach hang");
			System.out.println("\t4. Xoa khach hang");
			System.out.println("\t5. Sap xep theo ten");
			
			System.out.println("\t0. Thoat");
			
			System.out.print("Lua chon chuc nang: ");
			int chon = Integer.parseInt(in.nextLine());
			switch(chon) {
			case 1:
				display();
				break;
			case 2:
				add();
				break;
			case 3:
				edit();
				break;
			case 4:
				remove();
				break;
			case 5:
				sort();
				System.out.println("List has sorted...!");
				break;
			case 0:
				return;
			default: System.out.println("Lua chon khong hop le!");
			}
		} while(true);
	}

	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("\t\tDANH SACH KHACH HANG");
		System.out.printf("%5s %-30s %-15s%n","ID", "Name","Phone");
		for (Customer c:list) {
			c.display();
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n=====THEM CUSTOMER=====");
		System.out.print("\tNhap ten khach: ");
		String name = in.nextLine();
		System.out.print("\tNhap so dien thoai: ");
		String phone = in.nextLine();
		if(name == null || name.trim().length() == 0) {
			System.out.println("\tTen khach khong de trong!");
			return;
		}
		if(phone == null || phone.trim().length() == 0) {
			System.out.println("\tSo dien thoai khong de trong!");
			return;
		}
		//kiem tra ten
		if (checkName(name)) {
			System.out.println("\tDa ton tai!");
			return;
		}
		//them vao ds
		Customer newCustomer = new Customer(autoId++, name, phone);
		list.add(newCustomer);
		System.out.println("Successful!");
	}

	private static boolean checkName(String name) {
		for (Customer c:list) {
			if (c.getName().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}

	private static void edit() {
		// TODO Auto-generated method stub
		System.out.println("\n--------------SUA CUSTOMER-----------");
		System.out.print("Nhap id khach hang: ");
		int id = Integer.parseInt(in.nextLine());
		int idx = indexOfCustomer(id);
		if (idx == -1) {
			System.out.println("Khach hang khong ton tai");
			return;
		}
		System.out.print("\tNhap ten khach hang: ");
		String name = in.nextLine();
		System.out.print("\tNhap so dien thoai: ");
		String phone = in.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\tTen khach khong dc de trong");
			return;
		}
		if (phone == null || phone.trim().length() == 0) {
			System.out.println("\tSO dien thoai khong dc de trong");
			return;
		}
		if(checkName(name)) {
			System.out.println("\tTen da ton tai");
			return;
		}
		list.get(idx).setName(name);
		list.get(idx).setPhone(phone);
		System.out.println("\tSua thanh cong");		
	}

	public static int indexOfCustomer(int id) {
		for (int idx = 0; idx < list.size(); idx++) {
			if (list.get(idx).getId() ==id) {
				return idx;
			}
		}
		return -1;
	}

	private static void remove() {
		// TODO Auto-generated method stub
		System.out.println("\n---------------XOA CUSTOMER------------");
		System.out.print("Nhap id khach hang: ");
		int id = Integer.parseInt(in.nextLine());
		int idx = indexOfCustomer(id);
		if (idx == -1) {
			System.out.println("Khach hang khong tonn tai");
			return;
		}

		list.remove(idx);
		System.out.println("\tXoa thanh cong");
	}

	private static void sort() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer customer1, Customer customer2) {
                return customer1.getName().compareTo(customer2.getName());
            }
        });
	}
	public static String getNameById(int id) {
		for (Customer c:list) {
			if (c.getId() == id) {
				return c.getName();
			}
		}
		return null;
	}

	public static String getPhoneById(int id) {
		// TODO Auto-generated method stub
		for (Customer c:list) {
			if (c.getId() == id) {
				return c.getPhone();
			}
		}
		return null;
	}
}
