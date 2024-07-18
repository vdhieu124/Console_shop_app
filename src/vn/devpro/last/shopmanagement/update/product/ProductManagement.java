package vn.devpro.last.shopmanagement.update.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import vn.devpro.last.shopmanagement.update.provider.ProviderManagement;
import vn.devpro.last.shopmanagement.update.type.TypeManagement;


public class ProductManagement {
	private static List<Product> list = new ArrayList<Product>();

	static Scanner in = new Scanner(System.in);
	public static List<Product> getList() {
		return list;
	}

	public static void setList(List<Product> list) {
		list = list;
	}
	
	public static int autoId = 1;
	public static void init() {
		list.add(new Product(autoId++,3, 1, "Quan jean den", 12500000, 10));
		list.add(new Product(autoId++,2, 2, "Ao somi ke caro", 22000000, 20));
		list.add(new Product(autoId++,1, 3, "Mu luoi trai", 4000000, 25));
		list.add(new Product(autoId++,4, 3, "Kinh ram thoi trang", 50500000, 10));
		list.add(new Product(autoId++,5, 2, "Giay adidas grand court", 3000000, 30));
	}
	
	public static void productUpdate() {
		
		do {
			System.out.println("\n==================CAP NHAT THONG TIN SAN PHAM===================");
			System.out.println("Cac chuc nang");
			System.out.println("\t1. Xem danh sach san pham");
			System.out.println("\t2. Them san pham moi");
			System.out.println("\t3. Sua thong tin hang hoa");
			System.out.println("\t4. Xoa hang hoa");
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
		System.out.println("\n----------------DANH SACH HANG HOA--------------------");
		System.out.printf("%6s %-25s %-25s %-25s %-15s %-12s%n","id","Nha cung cap","ten loai","ten hang","gia tien","so luong");
		for(Product p: list) {
			p.display();
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n----------------THEM SAN PHAM--------------------");
		System.out.print("\tChon nha cung cap: ");
		int providerId = Integer.parseInt(in.nextLine());
		
		if(ProviderManagement.indexOfProvider(providerId) == -1) {
			System.out.println("\tMa nha cung cap ko hop le");
			return;
		}
		System.out.print("\tChon chung loai: ");
		int typeId = Integer.parseInt(in.nextLine());
		
		if(TypeManagement.indexOfType(typeId) == -1) {
			System.out.println("\tMa chung loai ko hop le");
			return;
		}
		System.out.print("\tNhap ten loai hang: ");
		String name = in.nextLine();
		if(name == null || name.trim().length() == 0) {
			System.out.println("\tTen loai hang khong de trong!");
			return;
		}
		System.out.print("\tNhap don gia: ");
		double price = Double.parseDouble(in.nextLine());
		if (price < 0) {
			System.out.println("Don gia >0 !!!!");
			return;
		}
		
		System.out.print("\tNhap so/khoi luong: ");
		double amount = Double.parseDouble(in.nextLine());
		if (amount < 0) {
			System.out.println("So luong >0 !!!!");
			return;
		}
		
		list.add(new Product(autoId++, providerId, typeId, name, price, amount));
		System.out.println("\tThem san pham moi thanh cong!");
	}

	private static void edit() {
		// TODO Auto-generated method stub
		System.out.println("\n------------------SUA SAN PHAM---------------");
		System.out.print("Nhap id san pham: ");
		int id = Integer.parseInt(in.nextLine());
		int idx = indexOfProduct(id);
		if (idx == -1) {
			System.out.println("San pham khong ton tai");
			return;
		}
		//co trong ds thi sua
		do {
			System.out.println("\n-----------Sua thong tin san pham-------------");
			System.out.println("Chon thong tin can sua");
			System.out.println("\t1. Sua ma (id) nha cung cap");
			System.out.println("\t2. Sua ma (id) chung loai");
			System.out.println("\t3. Sua ten hang");
			System.out.println("\t4. Sua so luong");
			System.out.println("\t5. Sua gia");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(in.nextLine());
			switch(chon) {
			case 1:
				System.out.print("\tChon nha cung cap: ");
				int providerId = Integer.parseInt(in.nextLine());
				
				if(ProviderManagement.indexOfProvider(providerId) == -1) {
					System.out.println("\tproviderId ko hop le");
					return;
				}
				list.get(idx).setProviderId(providerId);
				System.out.println("Sua thanh cong");
				break;
			case 2:
				System.out.print("\tChon chung loai: ");
				int typeId = Integer.parseInt(in.nextLine());
				
				if(TypeManagement.indexOfType(typeId) == -1) {
					System.out.println("\tTypeId ko hop le");
					return;
				}
				list.get(idx).setTypeId(typeId);
				System.out.println("Sua thanh cong");
				break;
			case 3:
				System.out.print("\tNhap ten loai hang: ");
				String name = in.nextLine();
				if(name == null || name.trim().length() == 0) {
					System.out.println("\tTen loai hang khong de trong!");
					return;
				}
				list.get(idx).setName(name);
				System.out.println("Sua thanh cong");
				break;
			case 4:
				System.out.print("\tNhap so/khoi luong: ");
				double amount = Double.parseDouble(in.nextLine());
				if (amount < 0) {
					System.out.println("So luong >0 !!!!");
					return;
				}
				list.get(idx).setAmount(amount);
				System.out.println("Sua thanh cong");
				break;
			case 5:
				System.out.print("\tNhap don gia: ");
				double price = Double.parseDouble(in.nextLine());
				if (price < 0) {
					System.out.println("Don gia >0 !!!!");
					return;
				}
				list.get(idx).setPrice(price);
				System.out.println("Sua thanh cong");
				break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le!");
			}
		} while(true);
	}

	private static void remove() {
		// TODO Auto-generated method stub
		System.out.println("\n---------------XOA SAN PHAM------------");
		System.out.print("Nhap id san pham: ");
		int id = Integer.parseInt(in.nextLine());
		int idx = indexOfProduct(id);
		if (idx == -1) {
			System.out.println("San pham khong ton tai");
			return;
		}
		
		list.remove(idx);
		System.out.println("\tXoa thanh cong");
	}
	
	private static void sort() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return product1.getName().compareTo(product2.getName());
            }
        });
	}

	public static int indexOfProduct(int id) {
		for (int idx = 0; idx < list.size(); idx++) {
			if (list.get(idx).getId() ==id) {
				return idx;
			}
		}
		return -1;
	}
	public static Product getProductById(int id) {
		for (Product p: list) {
			if (p.getId() == id)
				return p;
		}
		return null;
	}
}
