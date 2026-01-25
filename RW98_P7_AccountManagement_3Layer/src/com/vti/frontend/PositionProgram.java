package com.vti.frontend;

import com.vti.backend.presentationlayer.PositionController;
import com.vti.ultis.ScannerUltis;

public class PositionProgram {
	private PositionController positionController;

	public PositionProgram() {
		super();
		positionController = new PositionController();
	}

	public void menuPosition() throws Exception {
		while (true) {
			System.out.println("+--------------------------------------+");
			System.out.println("|          QUẢN LÝ POSITION             |");
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
				getAllPosition();
				break;
			case 2:
				findPositionById();
				break;
			case 3:
				checkExist();
				break;
			case 4:
				creatNewPosition();
				break;
			case 5:
				updatePosition();
				break;
			case 6:
				deletePosition();
				break;
			case 7:
				return;
			default:
				System.out.println("Nhập lại!");
			}
		}
	}
}
