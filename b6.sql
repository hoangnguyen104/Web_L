use Testing_System_Assignment_1;

drop TRIGGER if EXISTS trg_bf_Insert_Account;
DELIMITER $$   
	CREATE TRIGGER trg_bf_Insert_Account
	before insert on `account`
    for each row
	BEGIN   
		declare v_count_Account int DEFAULT 0;
		select count(*) into v_count_Account from account;
		if(v_count_Account >= 8) then 
			signal SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cant add more Dep';
        end if;
	END$$  
DELIMITER ;

INSERT INTO `Account` (Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUES
('Email100@gmail.com',  'Username100',  'Fullname100',  5, 1, '2025-11-05');

drop TRIGGER if EXISTS trg_bf_Delete_Account;
DELIMITER $$   
	CREATE TRIGGER trg_bf_Delete_Account
	before delete on `account`
    for each row
	BEGIN   
		if(old.Username = 'Admin') then 
			signal SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cant delete';
        end if;
	END$$  
DELIMITER ;

-- khi nhan vien chuyen phong ban luu htong tin vao bang khac
drop TRIGGER if EXISTS trg_af_Update_Account_Department;
DELIMITER $$   
	CREATE TRIGGER trg_af_Update_Account_Department
	after update on `account`
    for each row
	BEGIN   
		declare v_DepartmentName VARCHAR(30);
		declare v_NewDepartmentName VARCHAR(30);
        select DepartmentName into v_NewDepartmentName from department where DepartmentID = new.DepartmentID;
		select DepartmentName into v_DepartmentName from department where DepartmentID = old.DepartmentID;
        insert into log_Dep_Change_Account(AccountID,NewDepartmentName,OldDepartmentName,Username,ChangeDate)
        VALUES (old.AccountID,v_NewDepartmentName,v_DepartmentName,old.Username,now());
        
	END$$  
DELIMITER ;

SHOW TRIGGERS;

drop table log_Dep_Change_Account;
CREATE TABLE log_Dep_Change_Account (
	ID int  UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    AccountID INT UNSIGNED ,
    NewDepartmentName VARCHAR(30) NOT NULL,
    OldDepartmentName VARCHAR(30) NOT NULL,
    Username VARCHAR(30) NOT NULL ,
    ChangeDate DATETIME Default Now()
);

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
drop TRIGGER if EXISTS trg_bf_Insert_Group_BF1Y;
DELIMITER $$   
	CREATE TRIGGER trg_bf_Insert_Group_BF1Y
	before insert on `group`
    for each row
	BEGIN   
		IF NEW.CreateDate < DATE_SUB(CURDATE(), INTERVAL 1 YEAR) THEN 
			signal SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cant add more Dep';
        end if;
	END$$  
DELIMITER ;

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"

drop TRIGGER if EXISTS trg_bf_Insert_account_DPMSale;
DELIMITER $$   
	CREATE TRIGGER trg_bf_Insert_account_DPMSale
	before insert on `account`
    for each row
	BEGIN   
		DECLARE v_DepName VARCHAR(50);

		SELECT DepartmentName 
		INTO v_DepName
		FROM Department
		WHERE DepartmentID = NEW.DepartmentID;

		IF v_DepName = 'Sale' THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
        end if;
	END$$  
DELIMITER ;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS trg_bf_Insert_GroupAccount_Limit5;
DELIMITER $$
CREATE TRIGGER trg_bf_Insert_GroupAccount_Limit5
BEFORE INSERT ON GroupAccount
FOR EACH ROW
BEGIN
    DECLARE v_count INT;
    
    SELECT COUNT(*) INTO v_count
    FROM GroupAccount
    WHERE GroupID = NEW.GroupID;
    
    IF v_count >= 5 THEN
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'This group already max';
    END IF;
END$$

DELIMITER ;


-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

drop trigger if exists trg_bf_Insert_ExamQuestion_Max10;
DELIMITER $$
CREATE TRIGGER trg_bf_Insert_ExamQuestion_Max10
BEFORE INSERT ON ExamQuestion
FOR EACH ROW
BEGIN
    DECLARE v_count INT;
    
    SELECT COUNT(*) INTO v_count
    FROM ExamQuestion
    WHERE ExamID = NEW.ExamID;
    
    IF v_count >= 10 THEN
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'This exam already max';
    END IF;
END$$
DELIMITER ;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó
drop TRIGGER if EXISTS trg_bf_Delete_Account_EmailAdmin;
DELIMITER $$   
	CREATE TRIGGER trg_bf_Delete_Account_EmailAdmin
	before delete on `account`
    for each row
	BEGIN   
		if(old.Email = 'admin@gmail.com') then 
			signal SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cant delete';
        end if;
	END$$  
DELIMITER ;

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

drop TRIGGER if EXISTS trg_bf_Insert_Account_DepartmentID;
DELIMITER $$   
	CREATE TRIGGER trg_bf_Insert_Account_DepartmentID
	before insert on `account`
    for each row
	BEGIN   
		if(new.DepartmentID is null) then 
			set new.DepartmentID = 1;
        end if;
	END$$  
DELIMITER ;

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
drop TRIGGER if EXISTS trg_bf_Insert_Answer_Max4Answer2CR;
DELIMITER $$   
	CREATE TRIGGER trg_bf_Insert_Answer_Max4Answer2CR
	before insert on Answer
    for each row
	BEGIN   
		declare v_countans int;
        declare v_countcr int;
        select count(*) into v_countans
        from Answer
        WHERE QuestionID = NEW.QuestionID;

		if(v_countans >= 4 ) then 
			signal SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cant delete';
        end if;
        
        SELECT COUNT(*) INTO v_countcr
		FROM Answer
		WHERE QuestionID = NEW.QuestionID
		AND isCorrect = 1;
        
		IF NEW.isCorrect = 1 AND v_countcr >= 2 THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Each question can have max 2 correct answers';
		END IF;
	END$$  
DELIMITER ;
