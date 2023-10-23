/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BTLQuanLyNganHang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LONG
 */
public class QuanLyKhachHang {

    private List<KhachHang> ds = new ArrayList<>();

    public void themKh(KhachHang... a) {
        this.getDs().addAll(Arrays.asList(a));
    }

    public List<KhachHang> getDs() {
        return ds;
    }

    public void setDs(List<KhachHang> ds) {
        this.ds = ds;
    }

    public void traCuuKhachHang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten khach hang: ");
        String HoTen = sc.nextLine();
        System.out.print("Nhap ma so khach hang: ");
        String MaSo = sc.nextLine();
        boolean timThay = false;
        for (KhachHang khachHang : ds) {
            String hoTen = khachHang.getHoTen();
            if (khachHang.getMaSoKhachHang().equals(MaSo) && hoTen != null && khachHang.getHoTen().equals(HoTen)) {
                khachHang.inThongTin();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay khach hang nao voi ma so " + " " + MaSo + " va ho ten la " + HoTen);
        }
    }

    public void hienThi() {
        System.out.println("Danh sach khach hang giam dan theo so tien gui:");
        for (KhachHang kh : ds) {
            kh.inThongTin();
        }
    }

    public void sapXepGiamTheoTien() {
        this.getDs().sort((t1, t2) -> {
            double tien1 = t1.getSoTienGui();
            double tien2 = t2.getSoTienGui();
            return -(tien1 > tien2 ? 1 : (tien1 < tien2 ? -1 : 0));
        });
    }
}
