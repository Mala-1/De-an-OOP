package main;

import java.util.Scanner;

public class DienThoaiThongMinh extends DienThoai{
	private String dungluongluutru;
	
	public DienThoaiThongMinh() {
		
	}
	
	public DienThoaiThongMinh(String maDT, String tenDT, String hang, float dongia, int soluong, String donvitinh,
			String hedieuhanh, String mau, String dungluongluutru) {
		super(maDT, tenDT, hang, dongia, soluong, donvitinh, hedieuhanh, mau);
		this.dungluongluutru = dungluongluutru;
	}
	

	public String getDungluongluutru() {
		return dungluongluutru;
	}

	public void setDungluongluutru(String dungluongluutru) {
		this.dungluongluutru = dungluongluutru;
	}

	public void setDungLuongLuuTru(String dungLuongLuuTru) {
		this.dungluongluutru = dungLuongLuuTru;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		super.nhap();
		
		System.out.println("Nhập dung lượng lưu trữ: ");
		this.dungluongluutru = sc.nextLine();
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Dung lượng lưu trữ: " + this.dungluongluutru);
	}
	
}
