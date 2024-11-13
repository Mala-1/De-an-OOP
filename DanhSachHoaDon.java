import java.util.Scanner;
import java.util.Arrays;
public class DanhSachHoaDon {
int n;
HoaDon[] dshd=new HoaDon[0];
public DanhSachHoaDon(){}
public DanhSachHoaDon(int n, HoaDon[] dshd){
    this.n=n;
    this.dshd=dshd;
}
public DanhSachHoaDon(DanhSachHoaDon temp){
    n=temp.n;
    dshd=temp.dshd;
}
void check(HoaDon temp){
    for(int i=0; i<n; i=i+1)
        if(dshd[i]!=temp)
            if(dshd[i]!=null)
                if(dshd[i].getMaHd().equals(temp.getMaHd())){
                    System.out.println("\nMã hoá đơn bị trùng");
                    System.out.print("Nhập lại mã hoá đơn: ");
                    String tmp;
                    Scanner nhap=new Scanner(System.in);
                    tmp=nhap.nextLine();
                    temp.setMaHd(tmp);
                    check(temp);
    }
}
void nhapDanhSachHoaDon(){
    System.out.print("Nhập số lượng hoá đơn: ");
    Scanner nhap=new Scanner(System.in);
    n=nhap.nextInt();
    dshd=new HoaDon[n];
    for(int i=0; i<n; i=i+1){
        
        dshd[i]=new HoaDon();
        dshd[i].nhap();
        check(dshd[i]);
    }
}
void xuatDanhSachHoaDon(){
    System.out.println();
    for(int i=0; i<n; i=i+1){
        System.out.println("------Hoá đơn thứ "+(i+1)+"------");
        dshd[i].xuat(dshd[i]);
    }
}
void themHoaDon(){
    String choice;
    Scanner nhap=new Scanner(System.in);
    System.out.println("\nBạn có muốn thêm hoá đơn không? (Y/N)");
    System.out.print("(Y/N): ");
    choice=nhap.nextLine();
    while(!choice.equals("Y")&&!choice.equals("N")){
        System.out.println("Vui lòng nhập (Y/N)");
        System.out.print("(Y/N): ");
        choice=nhap.nextLine();
    }
    if(choice.equals("N"))
    {
        System.out.println("Bạn lựa chọn không");
        return;
    }
    System.out.print("Nhập số lượng hoá đơn muốn thêm: ");
    int add;
    add=nhap.nextInt();
    for(int i=0; i<add; i=i+1){
        n=dshd.length;
        dshd=Arrays.copyOf(dshd, n+1);
        dshd[n]=new HoaDon();
        dshd[n].nhap();
        check(dshd[n]);
        n=n+1;
    }
}
void xoaTheoMa(){
    String choice;
    Scanner nhap=new Scanner(System.in);
    System.out.println("\nBạn có muốn xoá hoá đơn không? (Y/N)");
    System.out.print("(Y/N): ");
    choice=nhap.nextLine();
    while(!choice.equals("Y")&&!choice.equals("N")){
        System.out.println("Vui lòng nhập (Y/N)");
        System.out.print("(Y/N): ");
        choice=nhap.nextLine();
    }
    if(choice.equals("N")){
        System.out.println("Bạn lựa chọn không");
        return;
    }
    String ma;
    System.out.print("Nhập mã hoá đơn muốn xoá: ");
    ma=nhap.nextLine();
    if(timTheoMa(ma)==-1)
    {
        System.out.println("Không tìm thấy mã hoá đơn muốn xoá");
        return;
    }
    int position=timTheoMa(ma)-1;
    for(int i=position; i<dshd.length-1; i=i+1)
        dshd[i]=dshd[i+1];
    dshd=Arrays.copyOf(dshd, dshd.length-1);
    n=n-1;
}
int timTheoMa(String ma){
    for(int i=0; i<n; i=i+1)
        if(dshd[i].getMaHd().equals(ma))
            return i+1;
    return -1;
}
void timTheoMa(){
    String ma;
    System.out.print("\nNhập mã hoá đơn muốn tìm: ");
    Scanner nhap=new Scanner(System.in);
    ma=nhap.nextLine();  
    for(int i=0; i<n; i=i+1)           
        if(dshd[i].getMaHd().equals(ma)){
            System.out.println("Vị trí của hoá đơn cần tìm là: "+(i+1));
            dshd[i].xuat(dshd[i]);
            return;
        }
    System.out.println("Không tìm thấy hoá đơn");
    }
void timTheoMaKh(){
    String ma;
    System.out.print("\nNhập mã khách hàng muốn tìm hoá đơn: ");
    Scanner nhap=new Scanner(System.in);
    ma=nhap.nextLine();
    HoaDon[] find=new HoaDon[0];
    int dai=0;
    for(int i=0; i<n; i=i+1)
        if(dshd[i].getMaKh().equals(ma)){
            find=Arrays.copyOf(find, dai+1);
            find[dai]=new HoaDon();
            find[dai]=dshd[i];
            dai=dai+1;
        }
    if(dai==0){
        System.out.println("Không tìm thấy hoá đơn có mã khách hàng");
        return;
    }
    System.out.println("Có "+dai+" hoá đơn theo mã khách hàng bạn muốn tìm:");
    for(int i=0; i<dai; i=i+1)
        find[i].xuat(find[i]);
}
void timTheoMaNv(){
    String ma;
    System.out.print("\nNhập mã nhân viên muốn tìm hoá đơn: ");
    Scanner nhap=new Scanner(System.in);
    ma=nhap.nextLine();
    HoaDon[] find=new HoaDon[0];
    int dai=0;
    for(int i=0; i<n; i=i+1)
        if(dshd[i].getMaNv().equals(ma))
        {
            find=Arrays.copyOf(find, dai+1);
            find[dai]=new HoaDon();
            find[dai]=dshd[i];
            dai=dai+1;
        }
    if(dai==0)
    {
        System.out.println("Không tìm thấy hoá đơn theo mã nhân viên");
        return;
    }
    System.out.println("Có "+dai+" hoá đơn theo mã nhân viên bạn muốn tìm");
    for(int i=0; i<dai; i=i+1)
        find[i].xuat(find[i]);
}
void suaTheoMa(){
        String ma;
        Scanner nhap=new Scanner(System.in);
        System.out.print("\nNhập mã của hoá đơn muốn sửa thông tin: ");
        ma=nhap.nextLine();    
        if(timTheoMa(ma)==-1){
            System.out.println("Không tìm thấy mã hoá đơn");
            return;
        }
        int position=timTheoMa(ma);
        System.out.println("\n---------------Menu---------------");
        System.out.println("1. Sửa đổi ngày lập hoá đơn");
        System.out.println("2. Sửa đổi mã nhân viên");
        System.out.println("3. Sửa đổi mã khách hàng");
        System.out.println("4. Sửa đổi tổng tiền");
        System.out.println("5. Thoát");
        System.out.println("----------------------------------");
        System.out.print("Vui lòng nhập lựa chọn của bạn (1->5): ");
        int choice;
        choice=nhap.nextInt();
        nhap.nextLine();
        switch(choice)
            {
            case 1:
            {
                System.out.print("Nhập ngày lập hoá đơn mới: ");
                String ngay;
                ngay=nhap.nextLine();
                dshd[position-1].setNgayLapHd(ngay);
                break;
            }
            case 2:
            {
                System.out.print("Nhập mã nhân viên mới: ");
                String ma_nv;
                ma_nv=nhap.nextLine();
                dshd[position-1].setMaNv(ma_nv);
                break;
            }
            case 3:
            {
                System.out.print("Nhập mã khách hàng mới: ");
                String ma_kh;
                ma_kh=nhap.nextLine();
                dshd[position-1].setMaKh(ma_kh);
                break;
            }
            case 4:
            {
                System.out.print("Nhập tổng tiền mới: ");
                float tong;
                tong=nhap.nextFloat();
                dshd[position-1].setTongTien(tong);
                break;
            }
            case 5:
            {
                System.out.println("Thoát");
                break;
            }
            default:
                System.out.println("Lưa chọn không hợp lệ (1 -> 8)");
            }
    }
void thongKe(){
    System.out.println("\nDanh sách có "+n+" hoá đơn");
}
void menu(DanhSachHoaDon dshd){
    int choice;
    Scanner nhap=new Scanner(System.in);
    do
    {
    System.out.println("\n---------------Menu---------------");
    System.out.println("1. Xuất danh sách hoá đơn");
    System.out.println("2. Thêm hoá đơn");
    System.out.println("3. Xoá hoá đơn theo mã hoá đơn");
    System.out.println("4. Tìm hoá đơn theo mã hoá đơn");
    System.out.println("5. Tìm hoá đơn theo mã nhân viên lập hoá đơn");
    System.out.println("6. Tìm hoá đơn theo mã khách hàng");
    System.out.println("7. Sửa hoá đơn theo mã hoá đơn");
    System.out.println("8. Thống kê số hoá đơn hiện có trong danh sách");
    System.out.println("9. Thoát");
    System.out.println("----------------------------------");
    System.out.print("Vui lòng nhập lựa chọn của bạn (1->9): ");
    choice=nhap.nextInt();
    switch(choice)
            {
            case 1:
            {
                dshd.xuatDanhSachHoaDon();
                break;
            }
            case 2:
            {
                dshd.themHoaDon();
                break;
            }
            case 3:
            {
                dshd.xoaTheoMa();
                break;
            }
            case 4:
            {
               dshd.timTheoMa();
                break;
            }
            case 5:
            {
                dshd.timTheoMaNv();
                break;
            }
            case 6:
            {
                dshd.timTheoMaKh();
                break;
            }
            case 7:
            {
                dshd.suaTheoMa();
                break;
            }
            case 8:
            {
                dshd.thongKe();
                break;
            }
            case 9:
            {
                System.out.println("Bạn chọn thoát");
                break;
            }
            default:
                System.out.println("Lưa chọn không hợp lệ (1 -> 9)");
            }
    }while(choice!=9);
}
public static void main(String[] args){
   DanhSachHoaDon dshd=new DanhSachHoaDon();
   dshd.nhapDanhSachHoaDon();
   dshd.menu(dshd);
}
}

