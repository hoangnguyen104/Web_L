Create database Testing_System_Assignment_1;
use Testing_System_Assignment_1;
CREATE TABLE Department (
    DepartmentID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(30) NOT NULL
);

CREATE TABLE Position (
    PositionID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE Key
);

CREATE TABLE Account (
    AccountID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(30) NOT NULL UNIQUE KEY,
    Username VARCHAR(30) NOT NULL UNIQUE KEY,
    FullName VARCHAR(30),
    DepartmentID INT UNSIGNED not null,
    PositionID INT UNSIGNED not null,
    CreateDate DATETIME Default Now(),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);


 Create	table `Group`(
	GroupID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName NVARCHAR(50) not null UNIQUE KEY,
    CreatorID int UNSIGNED,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);

CREATE TABLE GroupAccount (
    GroupID INT UNSIGNED not NULL,
    AccountID INT UNSIGNED not NULL,
    JoinDate DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID, AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY (AccountID) REFERENCES Account(AccountID)
);

CREATE TABLE TypeQuestion (
    TypeID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName ENUM('Essay', 'Multiple-Choice') not NULL UNIQUE key
);

CREATE TABLE CategoryQuestion (
    CategoryID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName NVARCHAR(50) NOT NULL UNIQUE KEY
);

CREATE TABLE Question (
    QuestionID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content NVARCHAR(50) NOT NULL,
    CategoryID INT UNSIGNED not NULL,
    TypeID INT UNSIGNED not NULL,
    CreatorID INT UNSIGNED not NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);

CREATE TABLE Answer (
    AnswerID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content NVARCHAR(100) NOT NULL,
    QuestionID INT UNSIGNED not NULL,
    isCorrect BIT DEFAULT 1,
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

CREATE TABLE Exam (
    ExamID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` CHAR(10) NOT NULL,
    Title NVARCHAR(50) NOT NULL,
    CategoryID INT UNSIGNED not NULL,
    Duration INT UNSIGNED not NULL,
    CreatorID INT UNSIGNED not NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);

CREATE TABLE ExamQuestion (
    ExamID INT UNSIGNED not NULL,
    QuestionID INT UNSIGNED not NULL,
    PRIMARY KEY (ExamID, QuestionID),
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID),
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

-- insert du lieu
INSERT INTO Department(DepartmentName)  
VALUES 
(N'Marketing'), 
(N'Sale'), 
(N'Bảo vệ'), 
(N'Nhân sự'), 
(N'Kỹ thuật'), 
(N'Tài chính'), 
(N'Phó giám đốc'), 
(N'Giám đốc'), 
(N'Thư kí'),
(N'Bán hàng');
SELECT * FROM Department;

INSERT INTO Position (PositionName )  
VALUES  	 	 	 	 	
('Dev'), 
('Test'), 
('Scrum Master'), 
('PM'); 

INSERT INTO `Account` (Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUES
('Email1@gmail.com',  'Username1',  'Fullname1',  5, 1, '2025-11-05'),
('Email2@gmail.com',  'Username2',  'Fullname2',  1, 2, '2025-11-05'),
('Email3@gmail.com',  'Username3',  'Fullname3',  7, 2, '2025-5-07'),
('Email4@gmail.com',  'Username4',  'Fullname4',  3, 4, '2025-7-08'),
('Email5@gmail.com',  'Username5',  'Fullname5',  4, 4, '2025-8-10'),
('Email6@gmail.com',  'Username6',  'Fullname6',  6, 3, '2025-9-05'),
('Email7@gmail.com',  'Username7',  'Fullname7',  2, 2, DEFAULT),
('Email8@gmail.com',  'Username8',  'Fullname8',  8, 1, '2025-10-07'),
('Email9@gmail.com',  'Username9',  'Fullname9',  9, 2, '2025-04-07'),
('Email10@gmail.com', 'Username10', 'Fullname10', 10, 1, '2025-03-09');
 SELECT * FROM `Account`;
 
INSERT INTO `Group` (GroupName, CreatorID, CreateDate)
VALUES
('Testing System',  5,  '2025-11-05'),
('Development',     1,  '2025-10-07'),
('VTI Sale 01',     2,  '2025-09-09'),
('VTI Sale 02',     3,  DEFAULT),
('VTI Sale 03',     4,  '2025-08-28'),
('VTI Creator',     6,  '2025-04-06'),
('VTI Marketing 01',7,  DEFAULT),
('Management',      8,  '2025-05-08'),
('Chat with love',  9,  '2025-06-09'),
('VTI Ai',        10, '2025-07-10');

INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate)
VALUES
(1,  1,  '2025-11-10'),
(2,  2,  '2025-11-11'),
(3,  3,  '2025-11-12'),
(4,  4,  '2025-11-13'),
(5,  5,  '2025-11-14'),
(6,  6,  '2025-11-15'),
(7,  7,  '2025-12-16'),
(8,  8,  '2025-12-17'),
(9,  9,  '2025-12-18'),
(10, 10, '2025-12-19');

INSERT INTO TypeQuestion(TypeName)  
VALUES  	 	 	 	 	 	
('Essay'),  
('Multiple-Choice');  

INSERT INTO CategoryQuestion (CategoryName)
VALUES
('Java'),
('ASP.NET'),
('ADO.NET'),
('SQL'),
('Postman'),
('Ruby'),
('Python'),
('C++'),
('C Sharp'),
('PHP');

INSERT INTO Question (Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES
('Câu hỏi về Java',     1, 1,  1, '2026-3-05'),
('Câu Hỏi về PHP',      10,2,  2, '2026-4-05'),
('Hỏi về C#',           9, 2,  3, '2026-5-06'),
('Hỏi về Ruby',         6, 1,  4, '2026-5-06'),
('Hỏi về Postman',      5, 1,  5, '2026-6-06'),
('Hỏi về ADO.NET',      3, 2,  6, '2026-6-06'),
('Hỏi về ASP.NET',      2, 1,  7, '2026-8-06'),
('Hỏi về C++',          8, 1,  8, '2026-9-07'),
('Hỏi về SQL',          4, 2,  9, '2026-10-07'),
('Hỏi về Python',       7, 1, 10, '2026-11-07');

INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES
('Trả lời 01', 1, 0),
('Trả lời 02', 2, 0),
('Trả lời 03', 3, 0),
('Trả lời 04', 4, 1),
('Trả lời 05', 5, 1),
('Trả lời 06', 6, 1),
('Trả lời 07', 7, 0),
('Trả lời 08', 8, 0),
('Trả lời 09', 9, 1),
('Trả lời 10',10, 1);

INSERT INTO Exam (Code, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES
('VTIQ001', 'Đề thi C#',       1,  60, 5, '2027-04-05'),
('VTIQ002', 'Đề thi PHP',      10, 60, 1, '2027-04-05'),
('VTIQ003', 'Đề thi C++',      9, 120, 2, '2027-04-07'),
('VTIQ004', 'Đề thi Java',     6,  60, 3, '2027-04-08'),
('VTIQ005', 'Đề thi Ruby',     5, 120, 4, '2027-04-10'),
('VTIQ006', 'Đề thi Postman',  3,  60, 6, '2027-04-05'),
('VTIQ007', 'Đề thi SQL',      2,  60, 7, '2027-04-05'),
('VTIQ008', 'Đề thi Python',   8,  60, 8, '2027-04-07'),
('VTIQ009', 'Đề thi ADO.NET',  4,  90, 9, '2027-04-07'),
('VTIQ010', 'Đề thi ASP.NET',  7,  90,10, '2027-04-08');

INSERT INTO ExamQuestion (ExamID, QuestionID)
VALUES
(1,  5),
(2, 6),
(3,  4),
(4,  3),
(5,  7),
(6, 10),
(7,  2),
(8, 1),
(9,  9),
(10, 8);

-- ex2
-- Question 2: Lấy ra tất cả các phòng ban 
SELECT * from Department;

-- Question 3: Lấy ra id của phòng ban "Sale" 
SELECT DepartmentID
from Department
where DepartmentName = 'Sale';

-- Question 4: Lấy ra thông tin account có full name dài nhất 
SELECT *
FROM Account
ORDER BY length(FullName) DESC
limit 1;

-- Question 5: Lấy ra thông tin account có full 
-- name dài nhất và thuộc phòng ban có id  = 3 
INSERT INTO `Account` (Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUES
('Email1@gmail11.com',  'Username11',  'Fullname11',  3, 1, '2025-11-05');

SELECT *
FROM Account
where DepartmentID = 3
and length(FullName) = (select max(length(FullName)) from Account );

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019 
select GroupName
from `Group`
where CreateDate < '2019-12-20';

select * from `Group`;
INSERT INTO `Group` (GroupName, CreatorID, CreateDate)
VALUES
('A1',  6,  '2018-11-05');

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời 
select QuestionID  
from Answer
GROUP BY QuestionID
HAVING count(QuestionID) >=4;


INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES
('Trả lời 11', 1, 0),
('Trả lời 12', 1, 1),
('Trả lời 13', 1, 0),
('Trả lời 14', 1, 1);

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút 
-- và được tạo trước ngày 20/12/2019 

INSERT INTO Exam (Code, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES
('VTIQ014', 'Đề thi C#',       1,  40, 5, '2017-04-05'),
('VTIQ015', 'Đề thi PHP',      10, 60, 1, '2018-04-05'),
('VTIQ016', 'Đề thi C++',      9, 120, 2, '2016-04-07');

SELECT * from Exam;

select `Code`
from Exam
where Duration >=60 and CreateDate < '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất 
SELECT * from `Group`;

select GroupName,CreateDate
from`Group`
ORDER BY CreateDate
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2 

select DepartmentID, count(DepartmentID) as Total_Emp
from `Account`
GROUP BY  DepartmentID
HAVING DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o" 
INSERT INTO `Account` (Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUES
('Email13@gmail.com',  'Dao1',  'DAo',  5, 1, '2025-11-05');

select * 
from `Account`
WHERE left(Fullname,1) = "D" and right(Fullname,1) = 'o';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019  
select * from Exam;

delete from Exam
where CreateDate < '2019-12-20'
and ExamID > 0;

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi" 
select * from Question;

delete from Question
WHERE substring_index(Content,' ',2) = 'câu hỏi' and QuestionID > 0;

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" 
-- và email thành loc.nguyenba@vti.com.vn 
select * from `Account`;
Update `Account`
set Fullname = "Nguyễn Bá Lộc",  
	Email = 'loc.nguyenba@vti.com.vn'
where AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4 
SELECT * from GroupAccount;

Update GroupAccount
set AccountID = 5
where GroupID = 4
