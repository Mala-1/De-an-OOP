package main;

import java.util.Scanner;

public abstract class DienThoai {
	private String maDT;
	private String tenDT;
	private String hang;
	private float dongia;
	private int soluong;
	private String donvitinh;
	private String hedieuhanh;
	private String mau;
	
	private static Scanner sc = new Scanner(System.in);
	public DienThoai()  {
		
	}

	public DienThoai(String maDT, String tenDT, String hang, float dongia, int soluong, String donvitinh,
			String hedieuhanh, String mau) {
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.hang = hang;
		this.dongia = dongia;
		this.soluong = soluong;
		this.donvitinh = donvitinh;
		this.hedieuhanh = hedieuhanh;
		this.mau = mau;
	}
	
	public DienThoai(DienThoai dienThoai) {
		this.maDT = dienThoai.getMaDT();
		this.tenDT = dienThoai.getTenDT();
		this.hang = dienThoai.getHang();
		this.dongia = dienThoai.getDongia();
		this.soluong = dienThoai.getSoluong();
		this.donvitinh = dienThoai.getDonvitinh();
		this.hedieuhanh = dienThoai.getHedieuhanh();
		this.mau = dienThoai.getMau();
	}

	public String getMaDT() {
		return maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public String getHang() {
		return hang;
	}

	public float getDongia() {
		return dongia;
	}

	public int getSoluong() {
		return soluong;
	}

	public String getDonvitinh() {
		return donvitinh;
	}

	public String getHedieuhanh() {
		return hedieuhanh;
	}

	public String getMau() {
		return mau;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}

	public void setHedieuhanh(String hedieuhanh) {
		this.hedieuhanh = hedieuhanh;
	}

	public void setMau(String mau) {
		this.mau = mau;
	}

	public void nhap() {
		System.out.println("Nhập mã điện thoại: ");
		this.maDT = sc.nextLine();
		
//		System.out.println("Nhập tên: ");
//		this.tenDT = sc.nextLine();
//		
//		System.out.println("Nhập hãng: ");
//		this.hang = sc.nextLine();
		
		System.out.println("Nhập đơn giá: ");
		this.dongia = sc.nextFloat();
		sc.nextLine();
		
//		System.out.println("Nhập số lượng: ");
//		this.soluong = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.println("Nhập đơn vị tính: ");
//		this.donvitinh = sc.nextLine();
//		
//		System.out.println("Nhập hệ điều hành: ");
//		this.hedieuhanh = sc.nextLine();
//		
//		System.out.println("Nhập màu: ");
//		this.mau = sc.nextLine();
	}

	public void xuat() {
		System.out.println("Mã điện thoại: " + this.maDT
		+ "\nTên: " + this.tenDT
		+"\nHãng: " + this.hang
		+"\nĐơn giá: " + this.dongia
		+"\nSố lượng: " + this.soluong
		+"\nĐơn vị tính: " + this.donvitinh
		+"\nHệ điều hành: " + this.hedieuhanh
		+"\nMàu: " + this.mau);
	}
	
	
}
