package com.vti.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
	private ArrayList<CanBo> danhSach;
	private Scanner scanner;

	public QLCB() {
		danhSach = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	// a) Thêm mới cán bộ
	public void themCanBo() {
		System.out.println("Chọn loại cán bộ:");
		System.out.println("1. Công nhân");
		System.out.println("2. Kỹ sư");
		System.out.println("3. Nhân viên");
		int choice = Integer.parseInt(scanner.nextLine());

		System.out.print("Họ tên: ");
		String hoTen = scanner.nextLine();

		System.out.print("Tuổi: ");
		int tuoi = Integer.parseInt(scanner.nextLine());

		System.out.print("Giới tính: ");
		String gioiTinh = scanner.nextLine();

		System.out.print("Địa chỉ: ");
		String diaChi = scanner.nextLine();

		switch (choice) {
		case 1:
			System.out.print("Bậc (1-10): ");
			int bac = Integer.parseInt(scanner.nextLine());
			danhSach.add(new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac));
			break;
		case 2:
			System.out.print("Ngành đào tạo: ");
			String nganh = scanner.nextLine();
			danhSach.add(new KySu(hoTen, tuoi, gioiTinh, diaChi, nganh));
			break;
		case 3:
			System.out.print("Công việc: ");
			String congViec = scanner.nextLine();
			danhSach.add(new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec));
			break;
		default:
			System.out.println("Lựa chọn không hợp lệ!");
		}
	}
}
