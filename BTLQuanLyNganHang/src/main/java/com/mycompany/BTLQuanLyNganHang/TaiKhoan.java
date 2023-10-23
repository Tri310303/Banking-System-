/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BTLQuanLyNganHang;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author LONG
 */
public abstract class TaiKhoan {

    protected static final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    protected String soTk;
    protected String tenTk;
    protected double soTien;
    protected Calendar ngayTao;
    protected String chuSoHuu;

    public TaiKhoan(String soTk, String tenTk, double soTien, KhachHang maSoKhachHang) {
        this.soTk = soTk;
        this.tenTk = tenTk;
        this.soTien = soTien;
        ngayTao = Calendar.getInstance();
        this.chuSoHuu = KhachHang.maSoKhachHang;
    }

    public TaiKhoan() {
        ngayTao = Calendar.getInstance();
    }

    public String getSoTk() {
        return soTk;
    }

    public void setSoTk(String soTk) {
        this.soTk = soTk;
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public Calendar getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Calendar ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    public void moTaiKhoan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tai khoan: ");
        this.soTk = sc.nextLine();
        System.out.print("Nhap ten tai khoan: ");
        this.tenTk = sc.nextLine();
        System.out.print("Nhap so tien: ");
        this.soTien = sc.nextDouble();
        this.ngayTao = Calendar.getInstance();
    }

    public void hienThiTaiKhoan() {
        System.out.printf("So tai khoan: %s\n", this.getSoTk());
        System.out.printf("Ten tai khoan: %s\n", this.getTenTk());
        System.out.printf("So tien: %,.1f VND\n", this.getSoTien());
        System.out.printf("Ma khach hang: %s\n", this.getChuSoHuu());
        System.out.printf("Ngay tao tai khoan: %s\n", f.format(this.getNgayTao().getTime()));
    }

    public abstract boolean isDaoHan();

    public void nopTien(double soTien) {
        if (this.isDaoHan()) {
            this.soTien += soTien;
        }
    }

    public void rutTien(double soTien) {
        if (this.isDaoHan() && this.soTien >= soTien) {
            this.soTien -= soTien;
        }
    }

    public void nopTien() {
    }

    public void rutTien() {
    }

    public abstract double tinhLai();
}
