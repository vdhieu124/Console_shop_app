package vn.devpro.last.shopmanagement.update.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class TypeManagement {
	static Scanner in = new Scanner(System.in);
	private static ArrayList<Type> list = new ArrayList<Type>();

	public static ArrayList<Type> getList() {
		return list;
	}

	public static void setList(ArrayList<Type> list) {
		TypeManagement.list = list;
	}
	public static int autoId = 1;
	public static void init() {
		list.add(new Type(autoId++, "Somi","Tay dai nam"));
		list.add(new Type(autoId++, "Vay","Chan vay den"));
		list.add(new Type(autoId++, "Ao phong","Trang tinh khoi"));
		list.add(new Type(autoId++, "Ao thun","Co dan tot"));
		list.add(new Type(autoId++, "Quan Jean","Thoi trang moi"));
	}
	public static void typeUpdate() {
		
		do {
			System.out.println("\n==============CAP NHAT THONG TIN CHUNG LOAI===============");
			System.out.println("Cac chuc nang");
			System.out.println("\t1. Xem danh sach chung loai");
			System.out.println("\t2. Them chung loai moi");
			System.out.println("\t3. Sua thong tin chung loai");
			System.out.println("\t4. Xoa chung loai");
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
		System.out.println("\t\tDANH SACH CHUNG LOAI");
		System.out.printf("%5s %-30s %-30s%n","ID", "Name","Description");
		for (Type t:list) {
			t.display();
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n=====THEM TYPE=====");
		System.out.print("\tNhap ten chung loai: ");
		String name = in.nextLine();
		System.out.print("\tNhap mo ta: ");
		String desc = in.nextLine();
		if(name == null || name.trim().length() == 0) {
			System.out.println("\tTen chung loai khong de trong!");
			return;
		}
		if(desc == null || desc.trim().length() == 0) {
			System.out.println("\tMo ta khong de trong!");
			return;
		}
		//kiem tra ten
		if (checkName(name)) {
			System.out.println("\tDa ton tai!");
			return;
		}
		//them vao ds
		Type newType = new Type(autoId++, name, desc);
		list.add(newType);
		System.out.println("Successful!");
	}

	private static boolean checkName(String name) {
		for (Type t:list) {
			if (t.getName().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}

	private static void edit() {
		// TODO Auto-generated method stub
		System.out.println("\n--------------SUA TYPE-----------");
		System.out.print("Nhap id chung loai: ");
		int id = Integer.parseInt(in.nextLine());
		int idx = indexOfType(id);
		if (idx == -1) {
			System.out.println("Chung loai khong ton tai");
			return;
		}
		System.out.print("\tNhap ten chung loai: ");
		String name = in.nextLine();
		System.out.print("\tNhap mo ta: ");
		String desc = in.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\tTen chung loai khong dc de trong");
			return;
		}
		if (desc == null || desc.trim().length() == 0) {
			System.out.println("\tMo ta khong dc de trong");
			return;
		}
		if(checkName(name)) {
			System.out.println("\tTen da ton tai");
			return;
		}
		list.get(idx).setName(name);
		list.get(idx).setDescription(desc);
		System.out.println("\tSua thanh cong");		
	}

	public static int indexOfType(int id) {
		for (int idx = 0; idx < list.size(); idx++) {
			if (list.get(idx).getId() ==id) {
				return idx;
			}
		}
		return -1;
	}

	private static void remove() {
		// TODO Auto-generated method stub
		System.out.println("\n---------------XOA TYPE------------");
		System.out.print("Nhap id chung loai: ");
		int id = Integer.parseInt(in.nextLine());
		int idx = indexOfType(id);
		if (idx == -1) {
			System.out.println("Chung loai khong tonn tai");
			return;
		}

		list.remove(idx);
		System.out.println("\tXoa thanh cong");
	}

	private static void sort() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<Type>() {
            @Override
            public int compare(Type type1, Type type2) {
                return type1.getName().compareTo(type2.getName());
            }
        });
	}
	public static String getNameById(int id) {
		for (Type t:list) {
			if (t.getId() == id) {
				return t.getName();
			}
		}
		return null;
	}
}
