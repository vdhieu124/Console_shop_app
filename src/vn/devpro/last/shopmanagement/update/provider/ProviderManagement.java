package vn.devpro.last.shopmanagement.update.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class ProviderManagement {
	static Scanner in = new Scanner(System.in);
	private static ArrayList<Provider> list = new ArrayList<Provider>();

	public static ArrayList<Provider> getList() {
		return list;
	}

	public static void setList(ArrayList<Provider> list) {
		ProviderManagement.list = list;
	}
	public static int autoId = 1;
	public static void init() {
		list.add(new Provider(autoId++, "Toshiba","Ha Noi"));
		list.add(new Provider(autoId++, "LG","Ha Nam"));
		list.add(new Provider(autoId++, "Hitachi","Ha Tinh"));
		list.add(new Provider(autoId++, "Samsung","Ca Mau"));
		list.add(new Provider(autoId++, "DS Global","Phu Quoc"));
	}
	public static void providerUpdate() {
		
		do {
			System.out.println("\n==================CAP NHAT THONG TIN NCC===================");
			System.out.println("Cac chuc nang");
			System.out.println("\t1. Xem danh sach NCC");
			System.out.println("\t2. Them NCC moi");
			System.out.println("\t3. Sua thong tin NCC");
			System.out.println("\t4. Xoa NCC");
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
		System.out.println("\t\tDANH SACH NHA CUNG CAP");
		System.out.printf("%5s %-30s %-30s%n","ID", "Name","Address");
		for (Provider p:list) {
			p.display();
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n=====THEM PROVIDER=====");
		System.out.print("\tNhap ten nha cung cap: ");
		String name = in.nextLine();
		System.out.print("\tNhap dia chi nha cung cap: ");
		String addr = in.nextLine();
		if(name == null || name.trim().length() == 0) {
			System.out.println("\tTen ncc khong de trong!");
			return;
		}
		if(addr == null || addr.trim().length() == 0) {
			System.out.println("\tDia chi ncc khong de trong!");
			return;
		}
		//kiem tra ten
		if (checkName(name)) {
			System.out.println("\tDa ton tai!");
			return;
		}
		//them vao ds
		Provider newProvider = new Provider(autoId++, name, addr);
		list.add(newProvider);
		System.out.println("Successful!");
	}

	private static boolean checkName(String name) {
		for (Provider p:list) {
			if (p.getName().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}

	private static void edit() {
		// TODO Auto-generated method stub
		System.out.println("\n--------------SUA PROVIDER-----------");
		System.out.print("Nhap id nha cung cap: ");
		int id = Integer.parseInt(in.nextLine());
		int idx = indexOfProvider(id);
		if (idx == -1) {
			System.out.println("Nha cung cap khong ton tai");
			return;
		}
		System.out.print("\tNhap ten nha cung cap: ");
		String name = in.nextLine();
		System.out.print("\tNhap dia chi nha cung cap: ");
		String addr = in.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\tTen nha cung cap khong dc de trong");
			return;
		}
		if (addr == null || addr.trim().length() == 0) {
			System.out.println("\tDia chi khong dc de trong");
			return;
		}
		if(checkName(name)) {
			System.out.println("\tTen da ton tai");
			return;
		}
		list.get(idx).setName(name);
		list.get(idx).setAddress(addr);
		System.out.println("\tSua thanh cong");		
	}

	public static int indexOfProvider(int id) {
		for (int idx = 0; idx < list.size(); idx++) {
			if (list.get(idx).getId() ==id) {
				return idx;
			}
		}
		return -1;
	}

	private static void remove() {
		// TODO Auto-generated method stub
		System.out.println("\n---------------XOA PROVIDER------------");
		System.out.print("Nhap id nha cung cap: ");
		int id = Integer.parseInt(in.nextLine());
		int idx = indexOfProvider(id);
		if (idx == -1) {
			System.out.println("nha cung cap khong tonn tai");
			return;
		}

		list.remove(idx);
		System.out.println("\tXoa thanh cong");
	}

	private static void sort() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<Provider>() {
            @Override
            public int compare(Provider provider1, Provider provider2) {
                return provider1.getName().compareTo(provider2.getName());
            }
        });
	}
	public static String getNameById(int id) {
		for (Provider p:list) {
			if (p.getId() == id) {
				return p.getName();
			}
		}
		return null;
	}
}
