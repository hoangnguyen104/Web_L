package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class DepartmentProgram {
	private DepartmentController departmentController;

	public DepartmentProgram() throws FileNotFoundException, IOException {
		super();
		departmentController = new DepartmentController();

	}

	public void menuDepartment() throws Exception {
		while (true) {
			System.out.println("+--------------------------------------+");
			System.out.println("|        QUẢN LÝ DEPARTMENT             |");
			System.out.println("+--------------------------------------+");
			System.out.println("| 1. Hiển thị danh sách                |");
			System.out.println("| 2. Tìm theo ID                      |");
			System.out.println("| 3. Kiểm tra tồn tại                 |");
			System.out.println("| 4. Tạo mới                          |");
			System.out.println("| 5. Cập nhật                         |");
			System.out.println("| 6. Xóa                              |");
			System.out.println("| 7. Quay lại                         |");
			System.out.println("+--------------------------------------+");

			int choose = ScannerUltis.inputIntPositive();

			switch (choose) {
			case 1:
				getAllDepartment();
				break;
			case 2:
				findDepartmentById();
				break;
			case 3:
				checkExist();
				break;
			case 4:
				creatNewDepartment();
				break;
			case 5:
				updateDepartment();
				break;
			case 6:
				deleteDepartment();
				break;
			case 7:
				return;
			default:
				System.out.println("Nhập lại!");
			}
		}
	}

	public void getAllDepartment() throws ClassNotFoundException {
		List<Department> listDepartments = departmentController.getAllDepartment();
		System.out.println("+-----------+--------------------------------------+");
		System.out.format("|    %-7s|      %-32s|%n", "ID", "Department Name");

		System.out.println("+-----------+--------------------------------------+");

		for (Department department : listDepartments) {
			System.out.format("|    %-7d|      %-32s|%n", department.getId(), department.getName());
		}

		System.out.println("+-----------+--------------------------------------+");
	}

	public void findDepartmentById() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào id phong ban cần tìm kiếm");
		int idFind = ScannerUltis.inputIntPositive();
		Department department = departmentController.getDepartmentByID(idFind);
		if (department != null) {
			System.out.println("+-----------+--------------------------------------+");
			System.out.format("|    %-7s|      %-32s|%n", "ID", "Department Name");
			System.out.println("+-----------+--------------------------------------+");
			System.out.format("|    %-7d|    %-34s|%n", department.getId(), department.getName());
			System.out.println("+-----------+--------------------------------------+");
		} else {
			System.out.println("Không tìm thấy phòng ban");
		}

	}

	public void creatNewDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập tên phòng ban mới");
		String name = ScannerUltis.inputString();
		boolean result = departmentController.createNewDepartment(name);

		if (result) {
			System.out.println("Tạo phòng ban thành công!");
		} else {
			System.out.println("Phòng ban đã tồn tại, không thể tạo mới!");
		}

	}

	public void checkExist() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập tên phòng để check:");
		String name = ScannerUltis.inputString();
		boolean isExist = departmentController.checkExist(name);

		if (isExist) {
			System.out.println("Phòng ban ĐÃ tồn tại");
		} else {
			System.out.println("Phòng ban KHÔNG tồn tại");
		}
	}

	public void updateDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập id phòng ban để update");
		int id = ScannerUltis.inputInt();
		System.out.println("Mời bạn nhập tên phòng ban mới");
		String name = ScannerUltis.inputString();
		boolean result = departmentController.updateDepartment(id, name);
		if (result) {
			System.out.println("Update phòng ban thành công!");
		} else {
			System.out.println("Không tìm thấy phòng ban để update!");
		}
	}

	public void deleteDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập tên phòng ban cần xóa");
		String name = ScannerUltis.inputString();
		boolean result = departmentController.deleteDepartment(name);
		if (result) {
			System.out.println("Xóa phòng ban thành công!");
		} else {
			System.out.println("Không tìm thấy phòng ban để xóa!");
		}
	}

}
