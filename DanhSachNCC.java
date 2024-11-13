package DanhSach_DoiTuong;
import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
public class DanhSachNCC
{
    private NhaCungCap[] dsncc;
    public DanhSachNCC()
    {
        dsncc=new NhaCungCap[0];
    }
    public DanhSachNCC(NhaCungCap[] dsncc)
    {
        this.dsncc=dsncc;
    }
    public boolean trungMaNcc(String maNCC)
    {
        for (NhaCungCap ds : dsncc)
        {
            if (ds != null && ds.getMaNCC().equals(maNCC)) {
                return true;
            }
        }
        return false;
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng nhà cung cấp: ");
        int n = sc.nextInt();
        sc.nextLine();
        dsncc = new NhaCungCap[n];
        for (int i = 0; i < n; i++) {
            NhaCungCap ncc = new NhaCungCap();
            do {
                ncc.nhap();
                if (trungMaNcc(ncc.getMaNCC())) {
                    System.out.println("Mã nhà cung cấp này đã bị trùng vui lòng nhập lại !!!");
                }
            } while (trungMaNcc(ncc.getMaNCC()));

            dsncc[i] = ncc;
        }
    }
    public void themkNCC()
    {
        Scanner sc=new Scanner(System.in);
        int n=dsncc.length;
        int k;
        while(true)
        {
            System.out.print("Bạn có muốn thêm nhà cung cấp không? (Y/N) : ");
            String choice=sc.nextLine();
            if(choice.equals("Y"))
            {
                do {
                    System.out.print("Nhập số lượng nhà cung cấp : ");
                    k=sc.nextInt();
                    sc.nextLine();
                    if(k<0)
                    {
                        System.out.println("Vui lòng nhập lại !!!");
                    }
                }while(k<0);
                dsncc=Arrays.copyOf(dsncc,n+k);
                for(int i=0;i<k;i++)
                {
                        NhaCungCap ncc=new NhaCungCap();
                        do {
                            ncc.nhap();
                            if(trungMaNcc(ncc.getMaNCC()))
                            {
                                System.out.println("Mã nhà cung cấp đã bị trùng vui lòng nhập lại !!!");
                            }
                        }while(trungMaNcc(ncc.getMaNCC()));
                        dsncc[n+i]=ncc;
                }
            }
            else if(choice.equals("N"))
            {
                System.out.println("Cảm ơn bạn !!!");
                break;
            }
            else
            {
                System.out.println("Vui lòng nhập (Y/N) !!!");
            }
        }
    }
    public void xoaMotNCC()
    {
        int n=dsncc.length;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp muốn xóa : ");
        String xoaMa=sc.nextLine();
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(dsncc[i].getMaNCC().equals(xoaMa))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            for(int i=index;i<n-1;i++)
            {
                dsncc[i]=dsncc[i+1];
            }
            dsncc=Arrays.copyOf(dsncc,n-1);
        }
        else
        {
            System.out.println("Không tìm thấy vị trí cần xóa !!!");
        }
    }
    public void timMaNCC()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp cần tìm kiếm : ");
        String maTim=sc.nextLine();
        int n=dsncc.length;
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(dsncc[i].getMaNCC().equals(maTim))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            System.out.println("Vị trí của nhà cung cấp là : " + index);
            dsncc[index].xuat();
        }
        else
        {
            System.out.println("Không tìm thấy vị trí trong danh sách");
        }
    }
    public void suaNCC()
    {
        Scanner sc=new Scanner(System.in);
        int n=dsncc.length;
        int index=-1;
        System.out.print("Nhập mã nhà cung cấp cần sửa đổi : ");
        String find=sc.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dsncc[i].getMaNCC().equals(find))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            int choice;
            do
            {
                System.out.println("---------------Menu---------------");
                System.out.println("1. Sửa đổi tên nhà cung cấp");
                System.out.println("2. Sửa đổi số điện thoại nhà cung cấp");
                System.out.println("3. Sửa đổi địa chỉ nhà cung cấp");
                System.out.println("4. Thoát");
                System.out.println("----------------------------------");
                System.out.print("Vui lòng nhập lựa chọn của bạn (1->4) : ");
                choice=sc.nextInt();
                sc.nextLine();
                switch(choice)
                {
                    case 1:
                    {
                        System.out.print("Nhập tên mới cho nhà cung cấp : ");
                        String newName=sc.nextLine();
                        dsncc[index].setTenNCC(newName);
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Nhập số điện thoại mới cho nhà cung cấp : ");
                        String newPhone=sc.nextLine();
                        dsncc[index].setSdtNCC(newPhone);
                        break;
                    }
                    case 3:
                    {
                        System.out.print("Nhập địa chỉ mới cho nhà cung cấp : ");
                        String newAdd=sc.nextLine();
                        dsncc[index].setDiachiNCC(newAdd);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Tạm biệt bạn !!!");
                        break;
                    }
                    default:
                        System.out.println("Lưa chọn của bạn không hơp lệ vui lòng chọn (1->4)");
                }
            }while(choice!=4);
        }
        else
        {
            System.out.println("Không tìm thấy mã nhà cung cấp cần sửa đổi !!!");
        }
    }
    public void timKiemTen()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Vui lòng nhập tên nhà cung cấp cần tim kiếm : ");
        String findTen=sc.nextLine();
        int index=-1;
        for(int i=0;i<dsncc.length;i++)
        {
            if(dsncc[i].getTenNCC().equals(findTen))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            System.out.println("Vị trí của tên nhà cung cấp cần tìm là : " + index);
            System.out.println("--Thông tin của nhà cung cấp--");
            dsncc[index].xuat();
        }
    }
    public void thongKeNCC()
    {
        int d=0;
        for(int i=0;i<dsncc.length;i++)
        {
            d++;
        }
        System.out.println("Có "+d+" nhà cung cấp trong danh sách");
    }
    public void timKiemGanDung()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Vui lòng nhập tên cần tìm kiếm : ");
        String findName=sc.nextLine().toLowerCase();
        boolean found=false;
        for(int i=0;i<dsncc.length;i++)
        {
            if(dsncc[i].getTenNCC().toLowerCase().contains(findName))
            {
                System.out.println("Vị trí của tên cần tìm là : " + i);
                System.out.println("--Thông tin của nhà cung cấp--");
                dsncc[i].xuat();
                found=true;
            }
        }
        if(!found)
        {
            System.out.println("Không tìm thấy nhà cung cấp cần tìm !!!");
        }
    }
    public void xuat()
    {
        for(int i=0;i< dsncc.length;i++)
        {
            System.out.println("------Nhà cung cấp thứ "+(i+1)+"------");
            dsncc[i].xuat();
        }
    }
    public static void main(String[] args)
    {
        DanhSachNCC ds=new DanhSachNCC();
        ds.nhap();
        ds.xuat();
        ds.themkNCC();
        ds.xuat();
        ds.xoaMotNCC();
        ds.xuat();
        ds.timMaNCC();
        ds.suaNCC();
        ds.xuat();
        ds.timKiemTen();
        ds.thongKeNCC();
        ds.timKiemGanDung();
    }
}
