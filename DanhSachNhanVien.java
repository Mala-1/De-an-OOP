import java.util.Scanner;
import java.util.Arrays;
public class DanhSachNhanVien {
    private int n;
    private NhanVien[] dsnv=new NhanVien[0];
    public DanhSachNhanVien(){
    }
    public DanhSachNhanVien(int n, NhanVien[] dsnv){
        this.n=n;
        this.dsnv=dsnv;
    }
    public DanhSachNhanVien(DanhSachNhanVien dsnvtemp){
        n=dsnvtemp.n;
        dsnv=dsnvtemp.dsnv;
    }    
    void check(NhanVien temp){
        for(int i=0; i<n; i=i+1)
        if(dsnv[i]!=null)
        if(dsnv[i]!=temp)
        if(dsnv[i].getMaNv().equals(temp.getMaNv())){
            String tmp;
            Scanner nhap=new Scanner(System.in);
            System.out.println("\nMã nhân viên bị trùng");
            System.out.print("Nhập lại mã: ");
            tmp=nhap.nextLine();
            temp.setMaNv(tmp);
            check(temp);
        }
    }
    void nhapdsnv(){
        System.out.print("Nhập số lượng nhân viên: ");
        Scanner nhap=new Scanner(System.in);
        n=nhap.nextInt();
        dsnv=new NhanVien[n];
        for(int i=0; i<n; i=i+1){
            dsnv[i]=new NhanVien();
            dsnv[i].nhap();
            check(dsnv[i]);
        }
    }
    void xuatdsnv(){
        System.out.print("\n");
        for(int i=0; i<n; i=i+1){
            System.out.println("------Nhân viên thứ "+(i+1)+"------");
            dsnv[i].xuat(dsnv[i]);            
        }
    }
    void them(){
        System.out.println("\nBạn có muốn thêm nhân viên không? (Y/N)");
        System.out.print("(Y/N): ");
        String choice;
        Scanner nhap=new Scanner(System.in);
        choice=nhap.nextLine();
        while(!choice.equals("Y")&&!choice.equals("N")){
           System.out.println("\nVui lòng nhập (Y/N)");
           System.out.print("(Y/N): ");
           choice=nhap.nextLine();
        }
        if(choice.equals("N")){
            System.out.println("Bạn lựa chọn không");
            return;
        }
        System.out.print("Nhập số lượng nhân viên muốn thêm: ");
        int add;
        add=nhap.nextInt();
        for(int i=0; i<add; i=i+1){
            n=dsnv.length;
            dsnv = Arrays.copyOf(dsnv, n+1);
            dsnv[n]=new NhanVien();
            dsnv[n].nhap();
            check(dsnv[n]);
            n=n+1;
        }
    }
    void xoaTheoMa(){
        System.out.println("\nBạn có muốn xoá nhân viên không? (Y/N)");
        String choice;
        Scanner nhap=new Scanner(System.in);
        System.out.print("(Y/N): ");
        choice=nhap.nextLine();
        while(!choice.equals("Y")&&!choice.equals("N")){
           System.out.println("\nVui lòng nhập (Y/N)");
           System.out.print("(Y/N): ");
           choice=nhap.nextLine();
        }
        if(choice.equals("N")){
            System.out.println("Bạn lựa chọn không");
            return;
        }
        String ma;
        System.out.print("\nNhập mã nhân viên muốn xoá: ");
        ma=nhap.nextLine();        
        if(timTheoMa(ma)!=-1)
        {
            int position=timTheoMa(ma)-1;
            for(int i=position; i<dsnv.length-1; i=i+1)
                dsnv[i]=dsnv[i+1];
            dsnv = Arrays.copyOf(dsnv,dsnv.length-1);
            n=n-1;
        }
        else
            System.out.print("Không tìm thấy mã muốn xoá\n");
    }
    void timTheoMa(){
        String ma;
        System.out.print("\nNhập mã nhân viên muốn tìm: ");
        Scanner nhap=new Scanner(System.in);
        ma=nhap.nextLine();  
        for(int i=0; i<n; i=i+1)           
            if(dsnv[i].getMaNv().equals(ma)){
                System.out.println("Vị trí của nhân viên cần tìm là: "+(i+1));
                dsnv[i].xuat(dsnv[i]);
                return;
            }
        System.out.println("Không tìm thấy mã nhân viên");
    }
    int timTheoMa(String check){
        for(int i=0; i<n; i=i+1)           
            if(dsnv[i].getMaNv().equals(check))
                return i+1;
        return -1;
    }
    void timTheoHo(){
        NhanVien[] findname=new NhanVien[0];
        String ho;
        System.out.print("\nNhập họ muốn tìm: ");
        Scanner nhap=new Scanner(System.in);
        ho=nhap.nextLine();
        int dai=0;
        for(int i=0; i<n; i=i+1)
            if((dsnv[i].getHoNv()).indexOf(ho, 0)!=-1)
            {
                findname=Arrays.copyOf(findname, dai+1);
                findname[dai]=new NhanVien();
                findname[dai]=dsnv[i];
                dai=dai+1;
            }
        if(dai==0){
            System.out.println("Không tìm thấy họ nhân viên");
            return;
        }
        System.out.println("Có "+dai+" nhân viên theo họ bạn muốn tìm:");
        for(int i=0; i<dai; i=i+1)
            findname[i].xuat(findname[i]);
    }
    void timTheoTen(){
        NhanVien[] findname=new NhanVien[0];
        String ten;
        System.out.print("\nNhập tên muốn tìm: ");
        Scanner nhap=new Scanner(System.in);
        ten=nhap.nextLine();
        int dai=0;
        for(int i=0; i<n; i=i+1)
            if((dsnv[i].getTenNv()).indexOf(ten, 0)!=-1)
            {
                findname=Arrays.copyOf(findname, dai+1);
                findname[dai]=new NhanVien();
                findname[dai]=dsnv[i];
                dai=dai+1;
            }
        if(dai==0){
            System.out.println("Không tìm thấy tên nhân viên");
            return;
        }
        System.out.println("Có "+dai+" nhân viên theo tên bạn muốn tìm:");
        for(int i=0; i<dai; i=i+1)
            findname[i].xuat(findname[i]);
    }   
    void suaTheoMa(){
        String ma;
        Scanner nhap=new Scanner(System.in);
        System.out.print("\nNhập mã của nhân viên muốn sửa thông tin: ");
        ma=nhap.nextLine();    
        if(timTheoMa(ma)==-1){
            System.out.println("Không tìm thấy mã nhân viên");
            return;
        }
        int position=timTheoMa(ma);
        System.out.println("---------------Menu---------------");
        System.out.println("1. Sửa đổi họ nhân viên");
        System.out.println("2. Sửa đổi tên nhân viên");
        System.out.println("3. Sửa đổi lương");
        System.out.println("4. Sửa đổi chức vụ");
        System.out.println("5. Sửa đổi số điện thoại nhân viên");
        System.out.println("6. Sửa đổi số căn cước");
        System.out.println("7. Sửa đổi địa chỉ");
        System.out.println("8. Thoát");
        System.out.println("----------------------------------");
        System.out.print("Vui lòng nhập lựa chọn của bạn (1->8): ");
        int choice;
        choice=nhap.nextInt();
        nhap.nextLine();
        switch(choice)
            {
            case 1:
            {
                System.out.print("Nhập họ mới cho nhân viên: ");
                String ho;
                ho=nhap.nextLine();
                dsnv[position-1].setHoNv(ho);
                break;
            }
            case 2:
            {
                System.out.print("Nhập tên mới cho nhân viên: ");
                String ten;
                ten=nhap.nextLine();
                dsnv[position-1].setTenNv(ten);
                break;
            }
            case 3:
            {
                System.out.print("Nhập lương mới cho nhân viên: ");
                float lg;
                lg=nhap.nextFloat();
                dsnv[position-1].setLuong(lg);
                break;
            }
            case 4:
            {
                System.out.print("Nhập chức vụ mới cho nhân viên: ");
                String cv;
                cv=nhap.nextLine();
                dsnv[position-1].setChucVu(cv);
                break;
            }
            case 5:
            {
                System.out.print("Nhập số điện thoại mới cho nhân viên: ");
                String sdt;
                sdt=nhap.nextLine();
                dsnv[position-1].setSdtNv(sdt);
                break;
            }
            case 6:
            {
                System.out.print("Nhập số căn cước mới cho nhân viên: ");
                String scc;
                scc=nhap.nextLine();
                dsnv[position-1].setSoCanCuoc(scc);
                break;
            }
            case 7:
            {
                System.out.print("Nhập địa chỉ mới cho nhân viên: ");
                String dc;
                dc=nhap.nextLine();
                dsnv[position-1].setDiaChiNv(dc);
                break;
            }
            case 8:
            {
                System.out.println("Thoát");
                break;
            }
            default:
                        System.out.println("Lưa chọn không hợp lệ (1 -> 8)");
            }
    }
    void thongKe(){
        System.out.println("\nCó "+n+" nhân viên trong danh sách");
    }
    void menu(DanhSachNhanVien dsnv){
    int choice;
    Scanner nhap=new Scanner(System.in);
    do
    {
    System.out.println("\n---------------Menu---------------");
    System.out.println("1. Xuất danh sách nhân viên");
    System.out.println("2. Thêm nhân viên");
    System.out.println("3. Xoá nhân viên theo mã nhân viên");
    System.out.println("4. Tìm nhân viên theo mã nhân viên");
    System.out.println("5. Tìm nhân viên theo họ nhân viên");
    System.out.println("6. Tìm nhân viên theo tên nhân viên");
    System.out.println("7. Sửa thông tin nhân viên theo mã nhân viên");
    System.out.println("8. Thống kê số nhân viên hiện có trong danh sách");
    System.out.println("9. Thoát");
    System.out.println("----------------------------------");
    System.out.print("Vui lòng nhập lựa chọn của bạn (1->9): ");
    choice=nhap.nextInt();
    switch(choice)
            {
            case 1:
            {
                dsnv.xuatdsnv();
                break;
            }
            case 2:
            {
                dsnv.them();
                break;
            }
            case 3:
            {
                dsnv.xoaTheoMa();
                break;
            }
            case 4:
            {
                dsnv.timTheoMa();
                break;
            }
            case 5:
            {
                dsnv.timTheoHo();
                break;
            }
            case 6:
            {
                dsnv.timTheoTen();
                break;
            }
            case 7:
            {
                dsnv.suaTheoMa();
                break;
            }
            case 8:
            {
                dsnv.thongKe();
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
        DanhSachNhanVien ds1=new DanhSachNhanVien();
        ds1.nhapdsnv();
        ds1.menu(ds1);
}
}
