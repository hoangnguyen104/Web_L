CREATE DATABASE Fresher;
use Fresher;
CREATE TABLE Trainee (
    TraineeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name VARCHAR(50) NOT NULL,
    Birth_Date DATETIME NOT NULL DEFAULT NOW(),
    Gender ENUM('MALE', 'FEMALE', 'UNKNOWN') NOT NULL,
    ET_IQ INT NOT NULL,
    ET_Gmath INT NOT NULL,
    ET_English INT NOT NULL,
    Training_Class VARCHAR(20) NOT NULL,
    Evaluation_Notes VARCHAR(20)
);
INSERT INTO Trainee
(Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes)
VALUES
('Nguyễn Văn A', '2000-05-12', 'MALE', 18, 17, 40, 'VTI001', 'DHBKHN'),
('Trần Thị B', '2001-03-22', 'FEMALE', 15, 16, 45, 'VTI001', 'DHQGHN'),
('Lê Văn C', '1999-11-05', 'MALE', 20, 20, 48, 'VTI002', 'HVBCVT'),
('Phạm Thu D', '2002-07-18', 'FEMALE', 12, 14, 35, 'VTI002', 'DHBKHN'),
('Hoàng Đình E', '2001-01-09', 'MALE', 17, 15, 42, 'VTI003', 'DHCNHN'),
('Đỗ Minh F', '2000-12-30', 'UNKNOWN', 10, 13, 30, 'VTI003', 'HVKTQS'),
('Bùi Thị G', '2002-02-14', 'FEMALE', 19, 18, 47, 'VTI004', 'DHQGHN'),
('Vũ Văn H', '1999-08-25', 'MALE', 16, 12, 38, 'VTI004', 'DHBKHN'),
('Ngô Hải I', '2001-10-11', 'MALE', 14, 17, 44, 'VTI005', 'HUMG'),
('Nguyễn Đình J', '2001-8-12', 'FEMALE', 13, 11, 32, 'VTI006', 'NEU'),
('Trương Thúy K', '2011-08-20', 'FEMALE', 15, 8, 28, 'VTI005', 'TLU'),
('Phan Văn L', '2007-02-03', 'MALE', 19, 5, 36, 'VTI006', 'HUST'),
('Huy Ngô M', '2003-04-06', 'UNKNOWN', 16, 17, 41, 'VTI005', 'HNUE');

-- Question 3: Insert 1 bản ghi mà có điểm ET_IQ =30. Sau đó xem kết quả.
INSERT INTO Trainee
(Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes)
VALUES
('Nguyễn  X', '2002-02-22', 'MALE', 30, 17, 40, 'VTI003', 'DGH');

SELECT * from Trainee
where ET_IQ =30;

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào,
-- và sắp xếp theo ngày sinh. Điểm ET_IQ >=12, ET_Gmath>=12, ET_English>=20
SELECT * from Trainee
where ET_IQ >=12 and  ET_Gmath>=12 and ET_English>=20
ORDER BY day(Birth_Date);

-- Question 5: Viết lệnh để lấy ra thông tin thực tập sinh có tên bắt đầu bằng chữ N 
-- và kết thúc bằng chữ C
SELECT * from Trainee
where Full_Name like 'N%C';

-- Question 6: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có ký thự thứ 2 là chữ G
SELECT * from Trainee
where Full_Name like '_G%';

-- Question 7: Viết lệnh để lấy ra thông tin thực tập sinh
-- mà tên có 10 ký tự và ký tự cuối cùng là C
SELECT * from Trainee
where Full_Name like '%C' and length(Full_Name) = 10;

-- Question 8: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, 
-- lọc bỏ các tên trùng nhau.
SELECT DISTINCT Full_Name from Trainee;

-- Question 9: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, 
-- sắp xếp các tên này theo thứ tự từ A-Z.

SELECT DISTINCT Full_Name from Trainee
ORDER BY LEFT(SUBSTRING_INDEX(Full_Name, ' ', -1), 1);

-- Question 10: Viết lệnh để lấy ra thông tin thực tập sinh có tên dài nhất

SELECT * FROM Trainee
ORDER BY LENGTH(Full_Name) DESC
LIMIT 1;


-- Question 11: Viết lệnh để lấy ra ID, Fullname và Ngày sinh thực tập sinh có tên dài nhất

SELECT TraineeID,Fullname,Birth_Date
FROM Trainee
ORDER BY LENGTH(Full_Name) DESC
LIMIT 1;

-- Question 12: Viết lệnh để lấy ra Tên, và điểm IQ, Gmath, English thực tập sinh có tên dài nhất

SELECT Fullname,ET_IQ,ET_Gmath,ET_English
FROM Trainee
ORDER BY LENGTH(Full_Name) DESC
LIMIT 1;

-- Question 13 Lấy ra 5 thực tập sinh có tuổi nhỏ nhất

SELECT *
FROM Trainee
ORDER BY year(Birth_Date) DESC
LIMIT 5;

-- Question 14: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là
-- những người thỏa mãn số điểm như sau:
-- ∙ ET_IQ + ET_Gmath>=20
-- ∙ ET_IQ>=8
-- ∙ ET_Gmath>=8
-- ∙ ET_English>=18

SELECT * from Trainee
where ET_IQ >=8 and  ET_Gmath>=8 and ET_English>=18 and ET_IQ + ET_Gmath>=20;

-- Question 15: Xóa thực tập sinh có TraineeID = 5

delete from Trainee
where TraineeID = 5;

-- Question 16: Xóa thực tập sinh có tổng điểm ET_IQ, ET_Gmath <=15

delete from Trainee
where ET_IQ + ET_Gmath <=15;

-- Question 17: Xóa thực tập sinh quá 30 tuổi.

DELETE FROM Trainee
WHERE TIMESTAMPDIFF(YEAR, Birth_Date, CURDATE()) > 30;

-- Question 18: Thực tập sinh có TraineeID = 3 được chuyển sang lớp " VTI003". Hãy cập nhật
-- thông tin vào database.

update Trainee
set Training_Class = "VTI003"
where TraineeID = 3;

-- Question 19: Do có sự nhầm lẫn khi nhập liệu nên thông tin của học sinh số 10 đang bị sai, 
-- hãy cập nhật lại tên thành “LeVanA”, điểm ET_IQ =10, điểm ET_Gmath =15, điểm ET_English = 30.

update Trainee
set  Full_Name = "LeVanA",ET_IQ = 10,ET_Gmath =15,ET_English = 30
where TraineeID = 10;

-- Question 20: Đếm xem trong lớp VTI001  có bao nhiêu thực tập sinh.

select count(*) 
from Trainee
where Training_Class = 'VTI001';

-- Question 21: Đếm xem trong lớp VTI001  có bao nhiêu thực tập sinh.

select count(*) 
from Trainee
where Training_Class = 'VTI001';

-- Question 22: Đếm tổng số thực tập sinh trong lớp VTI001 và VTI003 có bao nhiêu thực tập sinh

select count(*) 
from Trainee
where Training_Class in ('VTI001', 'VTI003');

-- Question 23: Lấy ra số lượng các thực tập sinh theo giới tính: Male, Female, Unknown.

select Gender,count(*) 
from Trainee
group by Gender;

-- Question 24: Lấy ra lớp có lớn hơn 5 thực tập viên

select Training_Class,count(*) 
from Trainee
group by Training_Class
having count(*) > 5 ;

-- Question 25: Lấy ra lớp có lớn hơn 5 thực tập viên

select Training_Class,count(*) 
from Trainee
group by Training_Class
having count(*) > 5;

-- Question 26: Lấy ra trường có ít hơn 4 thực tập viên tham gia khóa học

select Evaluation_Notes,count(*) 
from Trainee
group by Evaluation_Notes
having count(*) < 4;

-- Question 27: Bước 1: Lấy ra danh sách thông tin ID, Fullname, lớp thực tập viên có lớp 'VTI001'
-- Bước 2: Lấy ra danh sách thông tin ID, Fullname, lớp thực tập viên có lớp 'VTI002'
-- Bước 3: Sử dụng UNION để nối 2 kết quả ở bước 1 và 2

select  TraineeID,Full_Name
from Trainee
where Training_Class = 'VTI001'
Union
select  TraineeID,Full_Name
from Trainee
where Training_Class = 'VTI002';