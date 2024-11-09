package main;

import java.util.Arrays;
import java.util.Scanner;

public class DanhSachDienThoai {
	private DienThoai[] dsdt;
	
	public DanhSachDienThoai() {
		dsdt = new DienThoai[0];
	}
	
	public DanhSachDienThoai(DienThoai[] dsdt) {
		this.dsdt = dsdt;
	}
	
	public DanhSachDienThoai(DanhSachDienThoai dsdt) {
		this.dsdt = dsdt.getDsdt();
	}

	public DienThoai[] getDsdt() {
		return dsdt;
	}

	public void setDsdt(DienThoai[] dsdt) {
		this.dsdt = dsdt;
	}
	
	public void nhap_1_DienThoai() {
		Scanner sc = new Scanner(System.in);
		// Tao them 1 phan tu trong danh sach
		int n = dsdt.length;
		dsdt = Arrays.copyOf(dsdt, n + 1);
		System.out.println("---Nhập điện thoại---");
		System.out.println("1. Nhập điện thoại thông minh."
						+ "\n2.Nhập điện thoại phím.");
		int luaChon = sc.nextInt();
		switch (luaChon) {
			case 1: {
				dsdt[n] = new DienThoaiThongMinh();
				dsdt[n].nhap();
				break;
			}
			case 2: {
				dsdt[n] = new DienThoaiPhim();
				dsdt[n].nhap();
				break;
			}
		}
	}
	
	public void nhap_n_DienThoai() {
		Scanner sc = new Scanner(System.in);
		//Nhập số lượng cần thêm
		System.out.println("Nhap so luong: ");
		int n = sc.nextInt();
		dsdt = Arrays.copyOf(dsdt, dsdt.length + n);
		
		for(int i = dsdt.length - n; i < dsdt.length; i++) {
			System.out.println("---Nhập điện thoại---");
			System.out.println("1. Nhập điện thoại thông minh."
							+ "\n2.Nhập điện thoại phím.");
			int luaChon = sc.nextInt();
			switch (luaChon) {
				case 1: {
					dsdt[i] = new DienThoaiThongMinh();
					dsdt[i].nhap();
					break;
				}
				case 2: {
					dsdt[i] = new DienThoaiPhim();
					dsdt[i].nhap();
					break;
				}
			}
		}
	}
	
	public void xuatDS() {
		for(int i = 0; i < dsdt.length; i++) {
			System.out.println("-----------------");
			dsdt[i].xuat();
		}
	}
	
	public void xoa_maDT() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã điện thoại cần xóa: ");
		String maDT = sc.nextLine();
		int index = this.timKiem_maDT1_index(maDT);
		for(int i = index; i < dsdt.length - 1; i++) {
			dsdt[i] = dsdt[i + 1];
		}
		dsdt = Arrays.copyOf(dsdt, dsdt.length - 1);
	}
	
	public void xoa_maDT(String maDT) {
		int index = this.timKiem_maDT1_index(maDT);
		for(int i = index; i < dsdt.length - 1; i++) {
			dsdt[i] = dsdt[i + 1];
		} 
		dsdt = Arrays.copyOf(dsdt, dsdt.length - 1);
	}
	
	public DienThoai timKiem_maDT() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---Tìm Kiếm---");
		System.out.println("Nhập mã điện thoại cần tìm: ");
		String maDT = sc.nextLine();
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i].getMaDT().equals(maDT)) {
				return dsdt[i];
			}
		}
		return null;
	}
	
	public DienThoai timKiem_maDT(String maDT) {
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i].getMaDT().equals(maDT)) {
				return dsdt[i];
			}
		}
		return null;
	}
	
	public int timKiem_maDT1_index(String maDT) {
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i].getMaDT().equals(maDT)) {
				return i;
			}
		}
		return -1;
	}
	
	public void thongKe_loai() {
		int dttm = 0;
		int dtp = 0;
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i] instanceof DienThoaiThongMinh) {
				dttm++;
			}
			else {
				dtp++;
			}
		}
		System.out.println("---Thống kê theo loại điện thoại---");
		System.out.println("Điện thoại thông minh \t Điện thoại phím");
		System.out.println("\t" + dttm + "\t\t\t" + dtp);
	}
	
	public void thongKe_gia() {
		float muc1 = 5;
		float muc2 = 10;
		int gia_muc1 = 0;
		int gia_muc1_muc2 = 0;
		int gia_muc2 = 0;
		for(int i = 0; i < dsdt.length; i++) {
			float donGia = dsdt[i].getDongia();
			if(donGia < muc1) {
				gia_muc1++;
			}else if(donGia > muc1 && donGia < muc2){
				gia_muc1_muc2++;
			}else if(donGia > muc2) {
				gia_muc2++;
			}
		}
		System.out.println("---Thống kê theo giá---");
		System.out.println("Giá dưới " + muc1 + ": " + gia_muc1);
		System.out.println("Giá từ " + muc1 + " đến " + muc2 + ": " + gia_muc1_muc2);
		System.out.println("Giá trên " + muc2 + ": " + gia_muc2);
		

	}
	
	
	

	public static void main(String[] args) {
		DanhSachDienThoai dsdt = new DanhSachDienThoai();
		
		dsdt.nhap_1_DienThoai();
		dsdt.xuatDS();
		
		dsdt.nhap_n_DienThoai();
		dsdt.xuatDS();
		
		System.out.println("\nđây là tìm kiếm");
		DienThoai tk = dsdt.timKiem_maDT();
		tk.xuat();
		
		dsdt.thongKe_loai();
		dsdt.thongKe_gia();
		
		
		
	}
	
	
}
