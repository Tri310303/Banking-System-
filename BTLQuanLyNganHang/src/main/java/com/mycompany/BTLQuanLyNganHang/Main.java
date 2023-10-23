package com.mycompany.BTLQuanLyNganHang;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LONG
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("=======WELCOME TO OUR BANK=======");
        Scanner sc = new Scanner(System.in);
        KhachHang kh1 = new KhachHang();//Nhap thong tin khach hang
        kh1.nhapThongTin();
        kh1.inThongTin();

        TaiKhoanKhongKyHan tkc = new TaiKhoanKhongKyHan();//Mo tai khoan chinh
        tkc.setChuSoHuu(kh1.getMaSoKhachHang());
        tkc.moTaiKhoan();
        tkc.hienThiTaiKhoan();

        TaiKhoanDangNhap tkdn = new TaiKhoanDangNhap(kh1);//cung cap tai khoan dang nhap
        tkdn.inThongTinTaiKhoan();
        tkdn.doiMatKhau();
        tkdn.kiemTraDangNhap();
        
        KhachHang kh2 = new KhachHang();//them khach hang
        
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        qlkh.themKh(kh1,kh2);
        

        TaiKhoanKyHan tkkh1 = new TaiKhoanKyHan();
        tkkh1.setChuSoHuu(kh1.getMaSoKhachHang());

        TaiKhoanKyHan tkkh2 = new TaiKhoanKyHan();
        tkkh2.setChuSoHuu(kh1.getMaSoKhachHang());

        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        qltk.themTk(tkc, tkkh1, tkkh2);
        

        int choice;
        do {
            System.out.println("\n***** MENU DICH VU *****");
            System.out.println("1. Mo tai khoan co ky han");
            System.out.println("2. Tinh lai tai khoan");
            System.out.println("3. Gui tien (theo khong ky han)");
            System.out.println("4. Rut tien(theo khong ky han)");
            System.out.println("5. Gui tien tai khoan ky han");
            System.out.println("6. Rut tien tai khoan ky han");
            System.out.println("7. Tra cuu khach hang (theo ho ten va ma so khach hang)");
            System.out.println("8. Tra cuu danh sach tai khoan cua mot khach hang(theo ma so khach hang)");
            System.out.println("9. Sap xep danh sach khach hang co tong tien gui giam dan");
            System.out.println("10. Them khach hang");
            System.out.println("11. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    tkkh1.moTaiKhoan();
                    tkkh1.hienThiTaiKhoan();
                    tkkh2.moTaiKhoan();
                    tkkh2.hienThiTaiKhoan();
                    break;
                }
                case 2 -> {
                    System.out.println("Nhap so tai khoan: ");
                    sc.nextLine();
                    String soTk = sc.nextLine();
                    TaiKhoan taiKhoan = qltk.traCuuTaiKhoanTheoSoTk(soTk);
                    if (taiKhoan != null) {
                        System.out.println("Thong tin tai khoan:");
                        taiKhoan.hienThiTaiKhoan();
                        double tienlai = taiKhoan.tinhLai();
                        System.out.println("Tien Lai: " + tienlai);
                    } else {
                        System.out.println("Khong tim thay tai khoan co so tai khoan la " + soTk);
                    }
                    break;
                }
                case 3 -> {
                    tkc.nopTien();
                    tkc.hienThiTaiKhoan();
                }
                case 4 -> {
                    tkc.rutTien();
                    tkc.hienThiTaiKhoan();
                }
                case 5 -> {
                    tkkh1.nopTien();
                    tkkh1.hienThiTaiKhoan();
                }
                case 6 -> {
                    tkkh1.rutTienTruocNgayDaoHan(tkc);
                    tkc.hienThiTaiKhoan();
                }
                case 7 -> {
                    qlkh.traCuuKhachHang();
                }
                case 8 -> {
                    System.out.println("Nhap ma so khach hang: ");
                    sc.nextLine();
                    String maKh = sc.nextLine();
                    qltk.traCuuDanhSachTaiKhoanTheoMaKh(maKh);
                }
                case 9 -> {
                    qlkh.sapXepGiamTheoTien();
                    qlkh.hienThi();
                }
                case 10 -> {
                    kh2.nhapThongTin();
                    kh2.inThongTin();
                    TaiKhoanKhongKyHan tkp = new TaiKhoanKhongKyHan();//Mo tai khoan chinh
                    tkp.setChuSoHuu(kh2.getMaSoKhachHang());
                    tkp.moTaiKhoan();
                    tkp.hienThiTaiKhoan();
                    TaiKhoanDangNhap tkdn2 = new TaiKhoanDangNhap(kh2);//cung cap tai khoan dang nhap
                    tkdn2.inThongTinTaiKhoan();
                }
                case 11 ->
                    System.out.println("Cam on ban da su dung dich vu!");
                default ->
                    System.err.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (choice != 11);
    }
}
