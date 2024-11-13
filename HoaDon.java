import java.util.Scanner;
public class HoaDon {
    private String mahd;
    private String ngaylaphd;
    private String manv;
    private String makh;
    private float tongtien;
    void nhap(){
        Scanner nhap=new Scanner(System.in);
        System.out.println("\nHãy Nhập Thông Tin Hoá Đơn: ");
        System.out.print("Nhập mã hoá đơn: ");
        mahd=nhap.nextLine();
        System.out.print("Nhập ngày lập hoá đơn: ");
        ngaylaphd=nhap.nextLine();
        System.out.print("Nhập mã nhân viên lập hoá đơn: ");
        manv=nhap.nextLine();
        System.out.print("Nhập mã khách hàng: ");
        makh=nhap.nextLine();
        System.out.print("Nhap tổng tiền: ");
        tongtien=nhap.nextFloat();
        System.out.println("------------------------------");
    }
    public String toString() {
        return "Hoá Đơn (" +
                "Mã HD: " + mahd +
                "; Ngày lập HD: " + ngaylaphd +
                "; Mã NV: " + manv +
                "; Mã KH: " + makh +
                "; Tổng Tiền: " + tongtien +
                ") ";
    }
    public void xuat(HoaDon hoadon){
        System.out.println(hoadon);   
    }
    public HoaDon(){}
    public HoaDon(String mahd, String ngaylaphd, String manv, String makh, float tongtien){
        this.mahd=mahd;
        this.ngaylaphd=ngaylaphd;
        this.manv=manv;
        this.makh=makh;
        this.tongtien=tongtien;
    }
    public HoaDon(HoaDon hoadona){
        mahd=hoadona.mahd;
        ngaylaphd=hoadona.ngaylaphd;
        manv=hoadona.manv;
        makh=hoadona.makh;
        tongtien=hoadona.tongtien;
    }
    String getMaHd(){
        return mahd;
    }
    String getNgayLapHd(){
        return ngaylaphd;
    }
    String getMaNv(){
        return manv;
    }
    String getMaKh(){
        return makh;
    }
    float getTongTien(){
        return tongtien;
    }
    void setMaHd(String mahd){
        this.mahd=mahd;
    }
    void setNgayLapHd(String ngaylaphd){
        this.ngaylaphd=ngaylaphd;
    }
    void setMaNv(String manv){
        this.manv=manv;
    }
    void setMaKh(String makh){
        this.makh=makh;
    }
    void setTongTien(float tongtien){
        this.tongtien=tongtien;
    }
}
