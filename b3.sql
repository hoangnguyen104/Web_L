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


DROP TABLE IF EXISTS Student;
CREATE TABLE `Student`(
     Id		                    TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	 Student_Name				VARCHAR(50) NOT NULL,
     Subject_Name		      	VARCHAR(50) NOT NULL,
     Point_Student				TINYINT
);

SELECT * FROM Student;

INSERT INTO Student (Student_Name, Subject_Name, Point_Student)
VALUES				('Name1',	'Sql', 		'7'),
					('Name2',	'Java', 	'8'),
                    ('Name3',	'Java', 	'9'),
                    ('Name4',	'Sql', 		'5'),
                    ('Name5',	'Java', 	'4'),
                    ('Name6',	'Spring', 	'5'),
                    ('Name7',	'Java', 	'8'),
                    ('Name8',	'Spring', 	'8'),
					('Name9',	'Sql', 	'5'),
                    ('Name10',	'Spring', 	'4'),
                    ('Name11',	'Sql', 	'5'),
                    ('Name12',	'Spring', 	'8'),
                    ('Name13',	'Sql', 	'8')
                    ;

select sum(Point_Student) as TongDiem
FROM Student;

select max(Point_Student) as MaxScore
FROM Student;
select min(Point_Student) as MinScore
FROM Student;

select AVG(Point_Student) as AVGScore
FROM Student;

select max(Point_Student) 
FROM Student
where Subject_Name = 'Sql';

select max(Point_Student) 
FROM Student
where Subject_Name = 'Java';

select max(Point_Student) 
FROM Student
where Subject_Name = 'Spring';