use Testing_System_Assignment_1;
create or replace view vw_AccountList as
 select * from account;
 
 -- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
create or replace view vw_MaxAccountGroup as
	select AccountID
	from GroupAccount
	GROUP BY AccountID
	HAVING count(GroupID) = (select count(GroupID)
							from GroupAccount
							GROUP BY AccountID
							ORDER BY count(GroupID) desc
							limit 1);  
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi
create or REPLACE view vw_QuestionContentLong as
select * 
from question
where length(Content) > 300;

drop view vw_QuestionContentLong;

-- STORE PROCEDURE
-- tao 1 sp lay danh phong ban
DROP PROCEDURE IF EXISTS sp_name;

DELIMITER $$
CREATE PROCEDURE sp_name()
	BEGIN
		select * from account;
	END$$
DELIMITER ;

call sp_name()

-- tao 1 sp co account id = 2

DROP PROCEDURE IF EXISTS sp_accountId()
DELIMITER $$
CREATE PROCEDURE sp_accountId(in in_AccountID TINYINT)
	BEGIN
		select * from account
        where AccountID = in_AccountID;
	END$$
DELIMITER ;

call sp_accountId(5);


DROP PROCEDURE IF EXISTS sp_InsertAccount;
DELIMITER $$

CREATE PROCEDURE sp_InsertAccount(
    IN p_Email VARCHAR(30),
    IN p_Username VARCHAR(30),
    IN p_FullName VARCHAR(30),
    IN p_DepartmentID INT,
    IN p_PositionID INT,
    IN p_CreateDate DATETIME
)
	BEGIN
		INSERT INTO account(Email, Username, FullName, DepartmentID, PositionID, CreateDate)
		VALUES (p_Email, p_Username, p_FullName, p_DepartmentID, p_PositionID, p_CreateDate);
	END$$

DELIMITER ;

CALL sp_InsertAccount(
    'emailtest',
    'aaaa',
    'fullnametest',
    5,
    1,
    NOW()
);

-- 
DROP PROCEDURE IF EXISTS sp_Department;
DELIMITER $$
CREATE PROCEDURE sp_Department (in in_DepartmentName varchar(30))
	BEGIN
		select a.Username from Department d
        join account a
        on d.DepartmentID = a.DepartmentID
        where d.DepartmentName = in_DepartmentName;
	END$$
DELIMITER ;

call sp_Department('Marketing');

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
create or replace view vw_DepartmentSale as
	select a.FullName
	from account a
	join department d
	on a.DepartmentID = d.DepartmentID
	where d.DepartmentName = "Sale";

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất

create or replace view vw_DepartmentMaxAccount as
	with cte_DepartmentMaxAccount as (
		select DepartmentName,count(a.AccountID) total,
		max(count(a.AccountID)) over() max_total
		from Department d
		join account a
		on d.DepartmentID = a.DepartmentID
		group by DepartmentName
	)
	select DepartmentName
	from cte_DepartmentMaxAccount
	where total = max_total;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
create or REPLACE view vw_QsNguyenCreate as
	select q.Content
	from Question q
	join account a  
	on q.CreatorID = a.AccountID
	where a.FullName like 'Nguyễn%';