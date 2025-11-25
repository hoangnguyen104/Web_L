use Testing_System_Assignment_1;
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ 
SELECT a.FullName,a.Username,d.DepartmentName
from `Account` a
join department d
on  a.DepartmentID = d.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010  
select * from `Account`
where CreateDate > '2010-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer  
SELECT a.FullName,a.Email,p.PositionName
from `Account` a
join position p
on  a.PositionID = p.PositionID
where p.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT d.DepartmentName,count(a.AccountID)
from account a
join department d
on  a.DepartmentID = d.DepartmentID
group by d.DepartmentName
having count(a.AccountID)>=3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất 
select * from question;
select * from examquestion;

select DISTINCT Content
from question q
join examquestion e
on q.QuestionID = e.QuestionID
where q.QuestionID =
				(SELECT e.QuestionID
				from question q
				join examquestion e
				on q.QuestionID = e.QuestionID
				GROUP BY e.QuestionID
				ORDER BY count(e.QuestionID) DESC
				limit 1);


-- DROP TABLE IF EXISTS Student;
-- CREATE TABLE `Student`(
--      Id		                    TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
-- 	 Student_Name				VARCHAR(50) NOT NULL,
--      Subject_Name		      	VARCHAR(50) NOT NULL,
--      Point_Student				TINYINT
-- );

-- SELECT * FROM Student;

-- INSERT INTO Student (Student_Name, Subject_Name, Point_Student)
-- VALUES				('Name1',	'Sql', 		'7'),
-- 					('Name2',	'Java', 	'8'),
--                     ('Name3',	'Java', 	'9'),
--                     ('Name4',	'Sql', 		'5'),
--                     ('Name5',	'Java', 	'4'),
--                     ('Name6',	'Spring', 	'5'),
--                     ('Name7',	'Java', 	'8'),
--                     ('Name8',	'Spring', 	'8'),
-- 					('Name9',	'Sql', 	'5'),
--                     ('Name10',	'Spring', 	'4'),
--                     ('Name11',	'Sql', 	'5'),
--                     ('Name12',	'Spring', 	'8'),
--                     ('Name13',	'Sql', 	'8')
--                     ;

-- select sum(Point_Student) as TongDiem
-- FROM Student;

-- select max(Point_Student) as MaxScore
-- FROM Student;
-- select min(Point_Student) as MinScore
-- FROM Student;

-- select AVG(Point_Student) as AVGScore
-- FROM Student;

-- select max(Point_Student) 
-- FROM Student
-- where Subject_Name = 'Sql';

-- select max(Point_Student) 
-- FROM Student
-- where Subject_Name = 'Java';

-- select max(Point_Student) 
-- FROM Student
-- where Subject_Name = 'Spring';

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question

select CategoryID,count(QuestionID) as Total_Question
from Question
GROUP BY CategoryID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam  
select QuestionID,count(ExamID) 
from ExamQuestion
group by QuestionID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
select * from Answer;
with cte_MaxAnswer as(
	select count(AnswerID) MaxAnswer from Answer group by QuestionID ORDER BY count(AnswerID) desc limit 1 
    ) 
select QuestionID from Answer
group by QuestionID
having count(AnswerID) = (select MaxAnswer from cte_MaxAnswer);

-- Question 9: Thống kê số lượng account trong mỗi group
select GroupID, count(AccountID) as total_account
from GroupAccount  
group by GroupID;

-- Question 10: Tìm chức vụ có ít người nhất 
WITH cte AS (
    SELECT 
        p.PositionName,
        COUNT(a.PositionID) AS total,
        MIN(COUNT(a.PositionID)) OVER () AS min_total
    FROM Position p
    JOIN `Account` a ON p.PositionID = a.PositionID
    GROUP BY p.PositionName
)
SELECT PositionName
FROM cte
WHERE total = min_total;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

SELECT 
    d.DepartmentName,
    SUM(CASE WHEN p.PositionName = 'Dev' THEN 1 ELSE 0 END) AS Dev_Count,
    SUM(CASE WHEN p.PositionName = 'Test' THEN 1 ELSE 0 END) AS Test_Count,
    SUM(CASE WHEN p.PositionName = 'Scrum Master' THEN 1 ELSE 0 END) AS ScrumMaster_Count,
    SUM(CASE WHEN p.PositionName = 'PM' THEN 1 ELSE 0 END) AS PM_Count
FROM Account a
JOIN Position p 
    ON p.PositionID = a.PositionID
JOIN Department d
    ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentName;


-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...

select q.Content,c.CategoryName,t.TypeName,a.FullName,ans.Content as answer
from Question q
join TypeQuestion t
on t.TypeID = q.TypeID
join  `Account` a
on a.AccountID = q.CreatorID
join CategoryQuestion c
on c.CategoryID = q.CategoryID
join Answer ans
on ans.QuestionID = q.QuestionID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm

select TypeName,count(q.QuestionID)
from Question q
join TypeQuestion t
on q.TypeID = t.TypeID
group by TypeName;

-- Question 14:Lấy ra group không có account nào

select GroupName 
from  `Group` g
left join GroupAccount  ga
on g.GroupID = ga.GroupID
WHERE ga.GroupID IS NULL;

-- Question 15: Lấy ra group không có account nào
-- Question 16: Lấy ra question không có answer nào
select q.Content 
from question q
left join  Answer a
on q.QuestionID = a.QuestionID
where a.QuestionID is null;

-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
-- b) Lấy các account thuộc nhóm thứ 2
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau

select * from GroupAccount 
where GroupID = 1
union
select * from GroupAccount 
where GroupID = 2;

-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
-- b) Lấy các group có nhỏ hơn 7 thành viên
-- c) Ghép 2 kết quả từ câu a) và câu b)
select * 
from GroupAccount
group by GroupID
having count(AccountID) > 5
union 
select * 
from GroupAccount
group by GroupID
having count(AccountID) < 7