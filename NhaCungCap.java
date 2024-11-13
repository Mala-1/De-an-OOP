package DanhSach_DoiTuong;
import java.util.Scanner;
public class NhaCungCap
{
    private String maNCC;
    private String tenNCC;
    private String sdtNCC;
    private String diachiNCC;
    public NhaCungCap(){}
    public NhaCungCap(String maNCC, String tenNCC, String sdtNCC, String diachiNCC)
    {
        this.maNCC=maNCC;
        this.tenNCC=tenNCC;
        this.sdtNCC=sdtNCC;
        this.diachiNCC=diachiNCC;
    }
    public NhaCungCap(NhaCungCap copy)
    {
        maNCC=copy.maNCC;
        tenNCC=copy.tenNCC;
        sdtNCC=copy.sdtNCC;
        diachiNCC= copy.diachiNCC;
    }
    public void nhap()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp : ");
        maNCC=sc.nextLine();
        System.out.print("Nhập tên nhà cung cấp : ");
        tenNCC=sc.nextLine();
        System.out.print("Số điện thoại nhà cung cấp : ");
        sdtNCC=sc.nextLine();
        System.out.print("Địa chỉ nhà cung cấp : ");
        diachiNCC=sc.nextLine();
        System.out.println("------------------------------");
    }
    public String getSdtNCC() {
        return sdtNCC;
    }
    public String getDiachiNCC() {
        return diachiNCC;
    }
    public String getMaNCC() {
        return maNCC;
    }
    public String getTenNCC() {
        return tenNCC;
    }
    public void setDiachiNCC(String diachiNCC) {
        this.diachiNCC = diachiNCC;
    }
    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
    public void setSdtNCC(String sdtNCC) {
        this.sdtNCC = sdtNCC;
    }
    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void xuat()
    {
        System.out.println("Mã nhà cung cấp : " + this.maNCC + "\nTên nhà cung cấp : " + this.tenNCC + "\nSố điện thoại nhà cung cấp : " + this.sdtNCC + "\nĐịa chỉ nhà cung cấp : " +this.diachiNCC);
        System.out.println("------------------------------");
    }
    public static void main(String[] args)
    {
        NhaCungCap NC=new NhaCungCap();
        NC.nhap();
        String kq=NC.toString();
        System.out.println(kq);
    }
}