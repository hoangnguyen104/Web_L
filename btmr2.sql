CREATE DATABASE VTI_Mark_Management;
USE VTI_Mark_Management;

CREATE TABLE  `Trainee`(
	Trainee_ID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    Age TINYINT UNSIGNED NOT NULL,
    Gender ENUM('MALE','FEMALE','UNKNOWN')
);

CREATE TABLE `Subject` (
	Subject_ID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Subject_Name VARCHAR(50) NOT NULL UNIQUE KEY
);

CREATE TABLE `Trainee_Subject` (
	Trainee_ID TINYINT UNSIGNED NOT NULL,
    Subject_ID TINYINT UNSIGNED NOT NULL,
    Mark TINYINT UNSIGNED NOT NULL,
    Exam_Day DATETIME DEFAULT NOW(),
    PRIMARY KEY (Trainee_ID, Subject_ID),
    FOREIGN KEY (Trainee_ID) REFERENCES `Trainee`(Trainee_ID),
	FOREIGN KEY (Subject_ID) REFERENCES `Subject`(Subject_ID)
);

INSERT INTO trainee (First_Name, Last_Name, Age, Gender) VALUES
('First_Name 1', 'Last_Name1', 18, 'MALE'),
('First_Name 2', 'Last_Name2', 20, 'MALE'),
('First_Name 3', 'Last_Name3', 21, 'FEMALE'),
('First_Name 4', 'Last_Name4', 42, 'FEMALE'),
('First_Name 5', 'Last_Name5', 18, 'UNKNOWN'),
('First_Name 6', 'Last_Name6', 22, 'MALE'),
('First_Name 7', 'Last_Name7', 19, 'MALE'),
('First_Name 8', 'Last_Name8', 15, 'FEMALE'),
('First_Name 9', 'Last_Name9', 30, 'FEMALE'),
('First_Name 10', 'Last_Name10', 29, 'UNKNOWN');

INSERT INTO `subject` (`Subject_Name`) VALUES 
('MySQL'),
('JavaCore'),
('FrontEnd Basic'),
('Spring Framwork'),
('FrontEnd Advance'),
('AI'),
('Mock Project');

INSERT INTO trainee_subject (Trainee_ID, Subject_ID, Mark, Exam_Day) VALUES
(1, 1, 7, '2021-06-10 00:00:00'),
(1, 2, 6, '2021-04-17 00:00:00'),
(2, 3, 8, '2021-09-22 00:00:00'),
(3, 3, 8, '2021-07-07 00:00:00'),
(3, 4, 8, '2021-08-07 00:00:00'),
(4, 4, 9, '2021-01-08 00:00:00'),
(5, 4, 10, '2021-02-25 00:00:00'),
(6, 5, 4, '2021-05-27 00:00:00'),
(7, 5, 10, '2021-06-12 00:00:00'),
(8, 5, 6, '2021-11-16 00:00:00'),
(9, 6, 2, '2021-10-3 00:00:00'),
(10, 7, 3, '2021-12-25 00:00:00');

-- 2. Viết lệnh để
-- a) Lấy tất cả các môn học không có bất kì điểm nào
-- b) Lấy danh sách các môn học có ít nhất 2 điểm

INSERT INTO `subject` (`Subject_Name`) VALUES 
('Test');

select Subject_Name
from `subject` s
left join trainee_subject ts
on s.Subject_ID = ts.Subject_ID
where ts.Subject_ID is null;

select Subject_Name
from `subject` s
join trainee_subject ts
on s.Subject_ID = ts.Subject_ID
GROUP BY Subject_Name
having count(ts.Mark) >= 2;

-- 3. Tạo view có tên là " TraineeInfo" lấy các thông tin về học sinh bao gồm:
-- Trainee_ID, FullName, Age, Gender, Subject_ID, Subject_Name, Mark, Exam_Day


-- 4. Không sử dụng On Update Cascade & On Delete Cascade 
-- a) Tạo trigger cho table Subject có tên là SubjectUpdateID:Khi thay đổi data của cột ID 
-- của table Subject, thì giá trị tương ứng với cột Subject_ID của table trainee_subject 
-- cũng thay đổi theo. 
-- b) Tạo trigger cho table trainee có tên là StudentDeleteID:
-- Khi xóa data của cột ID của table trainee, thì giá trị tương ứng 
-- với cột SubjectID của table trainee_subject cũng bị xóa theo. 


-- 5. Viết 1 Store Procedure có đầu vào parameter trainee_name sẽ xóa tất cả các
-- thông tin liên quan tới học sinh có cùng tên như parameter
-- Trong trường hợp nhập vào name = "*" thì procedure sẽ xóa tất cả các học sinh