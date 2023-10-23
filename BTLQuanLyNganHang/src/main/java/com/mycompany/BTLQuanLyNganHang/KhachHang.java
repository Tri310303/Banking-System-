package com.mycompany.BTLQuanLyNganHang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LONG
 */
public class KhachHang {

    private static int count = 0; // biến static count
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String queQuan;
    private String soCccd;
    private double soTienGui;
    protected static String maSoKhachHang;

    public KhachHang() {
    }

    public KhachHang(String hoTen, String gioiTinh, Date ngaySinh, String queQuan, String soCccd, double soTienGui, String maSoKhachHang) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.soCccd = soCccd;
        this.soTienGui = soTienGui;
        this.maSoKhachHang = maSoKhachHang;
    }

    public void nhapThongTin() {
        System.out.print("=====Nhap Thong Tin=====\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho va ten khach hang: ");
        String hoTen = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = sc.nextLine();
        System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
        String ngaySinhStr = sc.nextLine();
        Date ngaySinh = null;
        try {
            ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinhStr);
        } catch (ParseException e) {
            System.out.println("Khong nhap dung dinh dang ngay thang!");
        }
        System.out.print("Nhap que quan: ");
        String queQuan = sc.nextLine();
        System.out.print("Nhap so CCCD: ");
        String soCccd = sc.nextLine();
        System.out.print("Nhap so tien gui(toi thieu 50 nghin VND): ");
        double soTienGui = sc.nextDouble();
        while (soTienGui < 50000) {
            System.out.println("So tien gui khong hop le. Vui long nhap lai.");
            System.out.print("Nhap so tien gui (toi thieu 50 nghin VND): ");
            soTienGui = sc.nextDouble();
        }

        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.soCccd = soCccd;
        this.soTienGui = soTienGui;
        count++;
        this.maSoKhachHang = new SimpleDateFormat("ddMMyyyy").format(new Date()) + String.format("%04d", count); // sử dụng biến count để tạo mã số khách hàng
    }

    public void inThongTin() {
        System.out.println("=====Thong Tin Khach Hang=====");
        System.out.println("Ho ten: " + hoTen);
        System.out.println("Gioi tinh: " + gioiTinh);
        if (ngaySinh != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String ngaySinhStr = sdf.format(ngaySinh);
            System.out.println("Ngay sinh: " + ngaySinhStr);
        } else {
            System.out.println("Ngay sinh: null");
        }
        System.out.println("Que quan: " + queQuan);
        System.out.println("So CCCD: " + soCccd);
        System.out.println("So tien gui: " + soTienGui + " VND");
        System.out.println("Ma so khach hang: " + maSoKhachHang);
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSoCccd() {
        return soCccd;
    }

    public void setSoCccd(String soCccd) {
        this.soCccd = soCccd;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public static String getMaSoKhachHang() {
        return maSoKhachHang;
    }

    public static void setMaSoKhachHang(String maSoKhachHang) {
        KhachHang.maSoKhachHang = maSoKhachHang;
    }
}
