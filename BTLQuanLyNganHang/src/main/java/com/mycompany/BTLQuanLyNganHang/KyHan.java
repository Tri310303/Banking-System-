/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BTLQuanLyNganHang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author LONG
 */
public enum KyHan {
    MOT_TUAN(7, Calendar.DAY_OF_YEAR, 2) {
        @Override
        public double tinhLai(double soTien) {
            return (soTien * this.getLaiSuat()) / (4 * 1200);
        }
    },
    MOT_THANG(1, Calendar.MONTH, 5.5) {
        @Override
        public double tinhLai(double soTien) {
            return (soTien * this.getLaiSuat()) / 1200;
        }
    },
    SAU_THANG(6, Calendar.MONTH, 7.5) {
        @Override
        public double tinhLai(double soTien) {
            return (soTien * this.getLaiSuat()) / (6 * 1200);
        }
    },
    MOT_NAM(1, Calendar.YEAR, 7.9) {
        @Override
        public double tinhLai(double soTien) {
            return (soTien * this.getLaiSuat()) / 100;
        }
    };

    private final int khoangTg;
    private final int loaiKyHan;
    private double laiSuat;

    private KyHan(int ktq, int loai, double ls) {
        this.khoangTg = ktq;
        this.loaiKyHan = loai;
        this.laiSuat = ls;
    }

    public Calendar tinhDaoHan() {
        Calendar c = new GregorianCalendar();
        c.add(this.loaiKyHan, this.khoangTg);
        return c;
    }

    public abstract double tinhLai(double soTien);

    /**
     * @return the laiSuat
     */
    public double getLaiSuat() {
        return laiSuat;
    }

    /**
     * @param laiSuat the laiSuat to set
     */
    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

}
