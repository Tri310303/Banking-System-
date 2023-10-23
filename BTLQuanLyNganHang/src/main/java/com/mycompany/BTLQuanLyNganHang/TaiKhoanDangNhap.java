/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BTLQuanLyNganHang;

import java.util.Random;
import java.util.*;
import java.security.SecureRandom;

/**
 *
 * @author LONG
 */
import java.util.Random;
import java.util.Scanner;

public class TaiKhoanDangNhap {

    private final String username;
    private String password;

    public TaiKhoanDangNhap(KhachHang maSoKhachHang) {
        this.username = KhachHang.maSoKhachHang;
        this.password = taoMatKhauNgauNhien();
    }

    private String taoMatKhauNgauNhien() {
        Random random = new Random();
        String password = "";
        for (int i = 0; i < 6; i++) {
            password += String.valueOf(random.nextInt(10));
        }
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void inThongTinTaiKhoan() {
        System.out.println("======= Tai Khoan Dang Nhap =======");
        System.out.println("Thong tin tai khoan dang nhap:");
        System.out.println("Ten dang nhap: " + this.username);
        System.out.println("Mat khau: " + this.password);
    }

    public void doiMatKhau() {
        Scanner sc = new Scanner(System.in);
        System.out.println("/--------/Doi Mat Khau/-------/");
        boolean passwordCorrect = false;
        while (!passwordCorrect) {
            System.out.print("Nhap mat khau cu: ");
            String oldPassword = sc.nextLine();
            if (oldPassword.equals(this.password)) {
                passwordCorrect = true;
                System.out.print("Nhap mat khau moi (6 so): ");
                String newPassword = sc.nextLine();
                this.password = newPassword;
                System.out.println("Doi mat khau thanh cong!");
            } else {
                System.out.println("Mat khau cu khong chinh xac. Vui long nhap lai!");
            }
        }
    }

    public boolean kiemTraDangNhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Dang Nhap =====");
        int count = 0;
        while (count < 5) {
            System.out.print("Nhap ten dang nhap (ma so khach hang): ");
            String inputUsername = sc.nextLine();
            System.out.print("Nhap mat khau: ");
            String inputPassword = sc.nextLine();
            if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
                System.out.println("Dang nhap thanh cong!");
                return true;
            } else {
                System.out.println("Ten dang nhap hoac mat khau khong dung.");
                count++;
            }
        }
        System.out.println("Ban da nhap sai thong tin dang nhap qua nhieu lan, tai khoan cua ban da bi khoa!");
        System.exit(0);
        return false;
    }
}
