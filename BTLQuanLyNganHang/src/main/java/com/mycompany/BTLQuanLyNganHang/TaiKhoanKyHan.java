/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BTLQuanLyNganHang;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author LONG
 */
public class TaiKhoanKyHan extends TaiKhoan {

    private Calendar ngayDaoHan;
    private KyHan kyHan;

    public TaiKhoanKyHan() {
    }

    public TaiKhoanKyHan(String soTk, String tenTk, double soTien, KhachHang maSoKhachHang, KyHan kyHan) {
        super(soTk, tenTk, soTien, maSoKhachHang);
        this.kyHan = kyHan;
        this.ngayDaoHan = kyHan.tinhDaoHan();
    }

    @Override
    public void moTaiKhoan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("===Mo Tai Khoan Ky Han===\n");
        super.moTaiKhoan();
        System.out.println("Chon ky han: ");
        System.out.println("1. 1 tuan");
        System.out.println("2. 1 thang");
        System.out.println("3. 6 thang");
        System.out.println("4. 1 nam");
        int kyHanOption = sc.nextInt();

        Calendar ngayDaoHan = null;

        switch (kyHanOption) {
            case 1:
                kyHan = KyHan.MOT_TUAN;
                ngayDaoHan = Calendar.getInstance();
                ngayDaoHan.add(Calendar.WEEK_OF_YEAR, 1);
                break;
            case 2:
                kyHan = KyHan.MOT_THANG;
                ngayDaoHan = Calendar.getInstance();
                ngayDaoHan.add(Calendar.MONTH, 1);
                break;
            case 3:
                kyHan = KyHan.SAU_THANG;
                ngayDaoHan = Calendar.getInstance();
                ngayDaoHan.add(Calendar.MONTH, 6);
                break;
            case 4:
                kyHan = KyHan.MOT_NAM;
                ngayDaoHan = Calendar.getInstance();
                ngayDaoHan.add(Calendar.YEAR, 1);
                break;
            default:
                System.out.println("Khong hop le");
        }

        if (this instanceof TaiKhoanKyHan && ngayDaoHan != null) {
            Date ngayDaoHanDate = ngayDaoHan.getTime();
            ((TaiKhoanKyHan) this).setNgayDaoHan(ngayDaoHan);
        }
    }

    @Override
    public void hienThiTaiKhoan() {
        System.out.print("===Tai Khoan Ky Han===\n");
        super.hienThiTaiKhoan();
        System.out.printf("Ky Han: %s\n", this.getKyHan());
        System.out.printf("Lai Suat Nhan Duoc: %s\n", this.kyHan.getLaiSuat() + "%");
        if (this.getNgayDaoHan() != null) {
            System.out.printf("Ngay Dao Han: %s\n", f.format(this.getNgayDaoHan().getTime()));
        } else {
            System.out.println("Ngay Dao Han: N/A");
        }
    }

    public double rutTienTruocNgayDaoHan(TaiKhoanKhongKyHan tkc) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tien muon rut: ");
        double soTienRut = sc.nextDouble();
        if (soTienRut > soTien) {
            System.out.println("So tien rut vuot qua so du trong tai khoan.");
        } else {
            if (isDaoHan()) {
                soTien -= soTienRut;
                System.out.println("Rut tien thanh cong.");
            } else {
                double tienLai = (soTien * 0.2) / 1200;
                double tongTienRutLai = soTienRut + tienLai;
                soTien -= soTienRut;
                System.out.print("so tien con lai trong tai khoan ky han khi rut truoc ngay dao han la:");
                System.out.println(soTien);
                tkc.chuyenTien(tongTienRutLai);
                System.out.print("tai khoan chinh cua quy khach da duoc nap them:" + tongTienRutLai + "\n");
                return tkc.soTien;
            }

        }
        return 0;
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
    public boolean isDaoHan() {
        Calendar c = new GregorianCalendar();
        boolean v1 = this.getNgayDaoHan().get(Calendar.YEAR) == c.get(Calendar.YEAR);
        boolean v2 = this.getNgayDaoHan().get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR);

        return v1 && v2;
    }

    @Override
    public double tinhLai() {
        double lai = this.kyHan.tinhLai(this.soTien);
        System.out.println("Lai suat la: " + this.kyHan.getLaiSuat() + "%");
        System.out.println("Lai la: " + lai);
        return 0;
    }

    public KyHan getKyHan() {
        return kyHan;
    }

    public void setKyHan(KyHan kyHan) {
        this.kyHan = kyHan;
    }

    /**
     * @return the ngayDaoHan
     */
    public Calendar getNgayDaoHan() {
        return ngayDaoHan;
    }

    /**
     * @param ngayDaoHan the ngayDaoHan to set
     */
    public void setNgayDaoHan(Calendar ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

}
