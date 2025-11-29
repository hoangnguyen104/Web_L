use Testing_System_Assignment_1;
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó

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

-- Question 2: Tạo store để in ra số lượng account trong mỗi group

DROP PROCEDURE IF EXISTS sp_CountAccount;
DELIMITER $$
CREATE PROCEDURE sp_CountAccount ()
	BEGIN
		select g.GroupName,count(ga.AccountID)
        from GroupAccount ga
        join `group` g
        on ga.GroupID = g.GroupID
        group by g.GroupName;
	END$$
DELIMITER ;

call sp_CountAccount;

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại

DROP PROCEDURE IF EXISTS sp_TypeQs;
DELIMITER $$
CREATE PROCEDURE sp_TypeQs()
	BEGIN
		SELECT tq.TypeName,
		COUNT(q.QuestionID) AS TotalQuestion
		FROM TypeQuestion tq
		LEFT JOIN Question q
        ON tq.TypeID = q.TypeID
        AND MONTH(q.CreateDate) = MONTH(CURDATE())
        AND YEAR(q.CreateDate) = YEAR(CURDATE())
		GROUP BY tq.TypeName;
	END$$
DELIMITER ;

call sp_TypeQs;

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất

DROP PROCEDURE IF EXISTS sp_TypeQsMaxqs;
DELIMITER $$
CREATE PROCEDURE sp_TypeQsMaxqs(out TypeID_out int)
	BEGIN
		with cte as(
        select TypeID,
        count(QuestionID) as countqs,
        max(count(QuestionID)) over() as countmaxqs
        from Question
        GROUP BY TypeID
        )
		SELECT TypeID
        INTO TypeID_out
		FROM cte
		where countqs = countmaxqs;
	END$$
DELIMITER ;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

call sp_TypeQsMaxqs(@a);
select TypeName
from TypeQuestion
where TypeID = @a;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào

DROP PROCEDURE IF EXISTS sp_SearchGroupOrUser;
DELIMITER $$
CREATE PROCEDURE sp_SearchGroupOrUser(IN search_str VARCHAR(50))
BEGIN
    SELECT GroupID, GroupName
    FROM `Group`
    WHERE GroupName LIKE CONCAT('%', search_str, '%')
	Union
    SELECT AccountID, Username
    FROM Account
    WHERE Username LIKE CONCAT('%', search_str, '%');
END$$
DELIMITER ;

CALL sp_SearchGroupOrUser('test');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công

DROP PROCEDURE IF EXISTS sp_InsertAccountCustom;
DELIMITER $$
CREATE PROCEDURE sp_InsertAccountCustom(
    IN in_fullname VARCHAR(50),
    IN in_email VARCHAR(50)
)
BEGIN
    DECLARE p_Username VARCHAR(50);
    DECLARE p_DepartmentID INT;
    DECLARE p_PositionID INT;

    SET p_Username = SUBSTRING_INDEX(in_email, '@', 1);
    SET p_DepartmentID = 1;
    SET p_PositionID = 1;

    INSERT INTO account(Email, Username, FullName, DepartmentID, PositionID, CreateDate)
    VALUES (in_email, p_Username, in_fullname, p_DepartmentID, p_PositionID, NOW());

    SELECT 'Tạo tài khoản thành công!' AS Message, in_fullname AS FullName, p_Username AS Username;
END$$
DELIMITER ;

CALL sp_InsertAccountCustom('Nguyễn Văn B', 'vanb@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS sp_GetLongestQs;
DELIMITER $$
CREATE PROCEDURE sp_GetLongestQs(IN in_Typeqs enum('Essay' , 'Multiple-Choice'))
BEGIN
	with cte as(
    select q.*,tq.TypeName,
    length(q.Content) leng,max(length(q.Content)) over(PARTITION BY tq.TypeName) maxlength
    from TypeQuestion tq
    join Question q 
    on tq.TypeID = q.TypeID
    )
    select *
    from cte 
    where TypeName = in_Typeqs and leng = maxlength;
END$$
DELIMITER ;

call sp_GetLongestQs('Essay');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_DeleteExam;
DELIMITER $$
CREATE PROCEDURE sp_DeleteExam(IN in_ExamID INT)
BEGIN
    DELETE FROM Exam
    WHERE ExamID = in_ExamID;
END$$
DELIMITER ;

CALL sp_DeleteExam(3);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
DROP PROCEDURE IF EXISTS SP_DeleteExamBefore3Year;
DELIMITER $$
CREATE PROCEDURE SP_DeleteExamBefore3Year()
BEGIN
	
END$$
DELIMITER ;
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS SP_DeleteDepartment;
DELIMITER $$
CREATE PROCEDURE SP_DeleteDepartment(in in_dpm varchar(50))
BEGIN
	
    update Department d
    join `account` a
    on d.DepartmentID = a.DepartmentID
    set a.DepartmentID = 1
    where d.DepartmentName = in_dpm;
    
    DELETE FROM Department
    WHERE DepartmentName = in_dpm;
END$$
DELIMITER ;


-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
-- nay

DROP PROCEDURE IF EXISTS SP_MonthQs;
DELIMITER $$
CREATE PROCEDURE SP_MonthQs()
BEGIN
   select month(CreateDate),count(QuestionID)
   from question
   where year(CreateDate) = year(curdate())
   GROUP BY month(CreateDate);
END$$
DELIMITER ;
call SP_MonthQs();
-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
-- tháng")

