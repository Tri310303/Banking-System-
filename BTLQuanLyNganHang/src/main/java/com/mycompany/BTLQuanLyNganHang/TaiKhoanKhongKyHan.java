/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BTLQuanLyNganHang;

import java.util.Scanner;

/**
 *
 * @author LONG
 */
public class TaiKhoanKhongKyHan extends TaiKhoan {

    public TaiKhoanKhongKyHan() {
    }

    public TaiKhoanKhongKyHan(String soTk, String tenTk, double soTien, KhachHang maSoKhachHang) {
        super(soTk, tenTk, soTien, maSoKhachHang);
    }

    @Override
    public double getSoTien() {
        return soTien;
    }

    @Override
    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    @Override
    public void moTaiKhoan() {
        System.out.print("===Mo Tai Khoan===\n");
        super.moTaiKhoan();
    }

    @Override
    public void hienThiTaiKhoan() {
        System.out.print("===Tai Khoan Khong Ky Han===\n");
        super.hienThiTaiKhoan();
    }

    @Override
    public void nopTien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tien nap: ");
        double soTienNap = sc.nextDouble();
        soTien += soTienNap;
        System.out.println("Nap tien thanh cong.");
    }

    @Override
    public void rutTien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tien muon rut: ");
        double soTienRut = sc.nextDouble();
        if (soTienRut > soTien) {
            System.out.println("So tien rut vuot qua so du trong tai khoan.");
        } else {
            soTien -= soTienRut;
            System.out.println("Rut tien thanh cong!");
        }
    }

    public void chuyenTien(double soTienNap) {
        soTien += soTienNap;
    }

    @Override
    public double tinhLai() {
        double lai = (this.soTien * 0.2) / 1200;
        System.out.println("Lai suat la: 0.2%/nam");
        System.out.println("Lai la: " + lai);
        return lai;
    }

    @Override
    public boolean isDaoHan() {
        // Đối với tài khoản không kỳ hạn, luôn luôn là true
        return true;
    }

}
