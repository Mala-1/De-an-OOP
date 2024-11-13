import java.util.Scanner;
public class NhanVien {
    private String manv;
    private String honv;
    private String tennv;
    private float luong;
    private String chucvu;
    private String sdtnv;
    private String socancuoc;
    private String diachinv;
    public NhanVien(){}
    public NhanVien(String manv, String honv, String tennv, float luong, String chucvu, String sdtnv, String socancuoc, String diachinv){
        this.manv=manv;
        this.honv=honv;
        this.tennv=tennv;
        this.luong=luong;
        this.chucvu=chucvu;
        this.sdtnv=sdtnv;
        this.socancuoc=socancuoc;
        this.diachinv=diachinv;
    }
    public NhanVien(NhanVien nhanviena){
        manv=nhanviena.manv;
        honv=nhanviena.honv;
        tennv=nhanviena.tennv;
        luong=nhanviena.luong;
        chucvu=nhanviena.chucvu;
        sdtnv=nhanviena.sdtnv;
        socancuoc=nhanviena.socancuoc;
        diachinv=nhanviena.diachinv;
    }
    void nhap(){
        Scanner nhap=new Scanner(System.in);
        System.out.println("\nHãy Nhập Thông Tin Nhân Viên: ");
        System.out.print("Mã Nhân Viên: ");
        manv=nhap.nextLine();
        System.out.print("Họ Nhân Viên: ");
        honv=nhap.nextLine();
        System.out.print("Tên Nhân Viên: ");
        tennv=nhap.nextLine();
        System.out.print("Lương: ");
        luong=nhap.nextFloat();
        nhap.nextLine();
        System.out.print("Chức Vụ: ");
        chucvu=nhap.nextLine();
        System.out.print("Số Điện Thoại: ");
        sdtnv=nhap.nextLine();
        System.out.print("Số Căn Cước: ");
        socancuoc=nhap.nextLine();
        System.out.print("Địa chỉ: ");
        diachinv=nhap.nextLine();
        System.out.println("------------------------------");
    }
    @Override public String toString() {
        return "Nhân Viên(" +
                "Mã NV: " + manv  +
                "; Họ NV: " + honv +
                "; Tên NV: " + tennv +
                "; Lương: " + luong +
                "; Chức vụ:" + chucvu +
                "; SDT: " + sdtnv +
                "; Số CCCD: " + socancuoc +
                "; Địa chỉ: " + diachinv +
                ")";
    }
    public void xuat(NhanVien nhanvien){
        System.out.println(nhanvien);   
    }
    String getMaNv(){
        return manv;
    }
    String getHoNv(){
        return honv;
    }
    String getTenNv(){
        return tennv;
    }
    float getLuong(){
        return luong;
    }
    String getChucVu(){
        return chucvu;
    }
    String getSdtNv(){
        return sdtnv;
    }
    String getSoCanCuoc(){
        return socancuoc;
    }
    String getDiaChiNv(){
        return diachinv;
    }
    void setMaNv(String manv){
        this.manv=manv;
    }
    void setHoNv(String honv){
        this.honv=honv;
    }
    void setTenNv(String tennv){
        this.tennv=tennv;
    }
    void setLuong(float luong){
        this.luong=luong;
    }
    void setChucVu(String chucvu){
        this.chucvu=chucvu;
    }
    void setSdtNv(String sdtnv){
        this.sdtnv=sdtnv;
    }
    void setSoCanCuoc(String socancuoc){
        this.socancuoc=socancuoc;
    }
    void setDiaChiNv(String diachinv){
        this.diachinv=diachinv;
    }
}
