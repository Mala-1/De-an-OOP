package main;

import java.util.Arrays;
import java.util.Scanner;

public class DanhSachCTPN {
	private ChiTietPhieuNhap[] dsctpn;

	public DanhSachCTPN() {
		this.dsctpn = new ChiTietPhieuNhap[0];
	}
	
	public DanhSachCTPN(ChiTietPhieuNhap[] ctpn) {
		this.dsctpn = ctpn;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng chi tiết phiếu nhập: ");
		int n = sc.nextInt();
		dsctpn = new ChiTietPhieuNhap[n];
		for(int i = 0; i < n; i++) {
			dsctpn[i] = new ChiTietPhieuNhap();
			dsctpn[i].nhap();
		}
	}
	
	
	public void them_K_CTPN() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng cần thêm: ");
		int k = sc.nextInt();
		int n = dsctpn.length;
		Arrays.copyOf(dsctpn, n + k);
		for(int i = n; i < dsctpn.length; i++) {
			dsctpn[n] = new ChiTietPhieuNhap();
			dsctpn[n].nhap();
		}
	}
	
	public int timKiemCTPN() {		// Mã phiếu nhập + mã điện thoại
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã phiếu nhập và mã điện thoại: ");
		String maPN = sc.nextLine();
		String maDT = sc.nextLine();
		for(int i = 0; i < this.dsctpn.length; i++) {
			if(dsctpn[i].getMaPN().equals(maPN) && dsctpn[i].getMaDT().equals(maDT)) {
				return i;
			}
		}
		return -1;
	}
	
	public void xoaCTPN() {
		Scanner sc = new Scanner(System.in);
		System.out.println("------Xóa chi tiết phiếu nhập------");
		System.out.println("Nhập mã phiếu nhập và mã điện thoại: ");
		if(timKiemCTPN() != -1) {
			for(int i = this.timKiemCTPN(); i < dsctpn.length - 1; i++) {
				dsctpn[i] = dsctpn[i + 1];
			}
			Arrays.copyOf(dsctpn, dsctpn.length - 1);
		}
		else {
			System.out.println("Không tìm thấy chi tiết phiếu nhập!");
		}
	}
	
	
}
