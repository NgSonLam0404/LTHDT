package Bai1b;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class HangThucPhamArraylist {
    private ArrayList<HangThucPham> dsHang;

    public HangThucPhamArraylist() {
        dsHang = new ArrayList<>();
    }

    public void nhapHang() {
        Scanner sc = new Scanner(System.in);
        String maHang;
        boolean trungMaHang;
        do {
            System.out.print("Nhap ma hang: ");
            maHang = sc.nextLine();

            // Kiểm tra xem mã hàng đã tồn tại trong danh sách hay chưa
            trungMaHang = false;
            for (HangThucPham htp : dsHang) {
                if (htp.getMaHang().equals(maHang)) {
                    trungMaHang = true;
                    System.out.println("Ma hang da ton tai trong danh sach, vui long nhap lai!");
                    break;
                }
            }
        } while (trungMaHang);

        System.out.print("Nhap ten hang: ");
        String tenHang = sc.nextLine();

        System.out.print("Nhap don gia: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhap ngay san xuat (dd/mm/yyyy): ");
        String ngaySanXuatStr = sc.next();
        LocalDate ngaySanXuat = LocalDate.parse(ngaySanXuatStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Nhap ngay het han (dd/mm/yyyy): ");
        String ngayHetHanStr = sc.next();
        LocalDate ngayHetHan = LocalDate.parse(ngayHetHanStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        HangThucPham htp = new HangThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);
        dsHang.add(htp);

        System.out.println("Da them hang thanh cong!");
    }


    public void xuatHang() {
        if (dsHang.isEmpty()) {
            System.out.println("Danh sach hang rong!");
        } else {
            System.out.println("Danh sach hang:");
            for (HangThucPham htp : dsHang) {
                System.out.println(htp);
            }
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int luaChon = 0;

        do {
            System.out.println("\n== MENU ==");
            System.out.println("1. Nhap hang");
            System.out.println("2. Xuat hang");
            System.out.println("3. Thoat");

            System.out.print("Nhap lua chon cua ban: ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    nhapHang();
                    break;
                case 2:
                    xuatHang();
                    break;
                case 3:
                    System.out.println("Da thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        } while (luaChon != 3);
    }
}
