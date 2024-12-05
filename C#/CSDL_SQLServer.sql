-- tạo cơ sở dữ liệu
CREATE DATABASE StoreCircleK;
GO

-- Sử dụng cơ sở dữ liệu
USE StoreCircleK;
GO

-- tạo bảng Supplier
CREATE TABLE SUPPLIER (
    MaNCC INT PRIMARY KEY IDENTITY(1,1),
    TenNCC VARCHAR(100) NOT NULL,
    DiaChi VARCHAR(255),
    SDT VARCHAR(15),
    Email VARCHAR(100)
);
Go 

-- tạo bảng Category
CREATE TABLE CATEGORY (
    MaNhom INT PRIMARY KEY IDENTITY(1,1),
    TenNhom VARCHAR(100) NOT NULL
);
Go 

-- tạo bảng Product
CREATE TABLE PRODUCT (
    MaSP INT PRIMARY KEY IDENTITY(1,1),
    TenSP VARCHAR(100) NOT NULL,
    DonGia DECIMAL(10, 2) NOT NULL,
    HanSuDung DATE,
    NoiSanXuat VARCHAR(100),
    MaNhom INT,
    MaNCC INT,
    FOREIGN KEY (MaNhom) REFERENCES CATEGORY(MaNhom),
    FOREIGN KEY (MaNCC) REFERENCES SUPPLIER(MaNCC)
);
Go 

-- tạo bảng Job_Title
CREATE TABLE JOB_TITLE (
    MaCV INT PRIMARY KEY IDENTITY(1,1),
    TenCV VARCHAR(100) NOT NULL
);
Go 

CREATE TABLE EMPLOYEE (
    MaNV INT PRIMARY KEY IDENTITY(1,1),
    HoTen VARCHAR(100) NOT NULL,
    GioiTinh CHAR(3) CHECK (GioiTinh IN ('Nam', 'Nu')) NOT NULL,
    NgaySinh DATE,
    DiaChi VARCHAR(255),
    SDT VARCHAR(15),
    MaCV INT,
    FOREIGN KEY (MaCV) REFERENCES JOB_TITLE(MaCV)
);
Go

-- tạo bảng Account 
CREATE TABLE USER_ACCOUNT (
    MaNV INT PRIMARY KEY,
    TenDangNhap VARCHAR(50) NOT NULL,
    MatKhau VARCHAR(50) NOT NULL,
    FOREIGN KEY (MaNV) REFERENCES EMPLOYEE(MaNV)
);
Go 

-- tạo bảng Customer
CREATE TABLE CUSTOMER (
    MaKH INT PRIMARY KEY IDENTITY(1,1),
    HoTen VARCHAR(100) NOT NULL,
    SDT VARCHAR(15) NOT NULL,
    SoLanMua INT DEFAULT 0
);
Go

-- tạo bảng FeedBack
CREATE TABLE FEEDBACK (
    MaPH INT PRIMARY KEY IDENTITY(1,1),
    MaKH INT,
    NgayPhanHoi DATE NOT NULL,
    NoiDung VARCHAR(255),
    SoDiemDanhGia INT CHECK (SoDiemDanhGia BETWEEN 1 AND 5),
    FOREIGN KEY (MaKH) REFERENCES CUSTOMER(MaKH)
);
Go

-- tạo bảng Invoice 
CREATE TABLE INVOICE (
    MaHD INT PRIMARY KEY IDENTITY(1,1),
    MaKH INT,
    NgayLap DATE NOT NULL,
    TongSoTien DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (MaKH) REFERENCES CUSTOMER(MaKH)
);
Go

-- tạo bảng Promotion
CREATE TABLE PROMOTION (
    MaKM INT PRIMARY KEY IDENTITY(1,1),
    NoiDung VARCHAR(255) NOT NULL,
    ThoiGianBatDau DATE,
    ThoiGianKetThuc DATE,
    DoiTuongApDung VARCHAR(100),
    MucGiamGia DECIMAL(5, 2) NOT NULL
);
Go

-- thêm dữ liệu vào bảng Supplier
INSERT INTO SUPPLIER (TenNCC, DiaChi, SDT, Email) VALUES
	('Vinamilk', '10 Tan Trao, Phuong Tan Pha, Quan 7, Tp.HCM', '02854155555', 'vinamilk@gmail.com'),
	('Coca-Cola', 'Xa lo Ha Noi, Phuong Linh Trung, Tp.Thu Đuc', '1900555584', 'cocacola@gmail.com'),
	('PepsCo', N'88 Đuong Le Van Viet, Phuong Hiep Phu, Quan 9, Tp.HCM', '02862890000', 'pepsico@gmail.com'),
	('Acecook Viet Nam', 'Lo II-3, Đuong số II, Khu Cong Nghiep Tan Binh, Quan Tan Phu, Tp.HCM', NULL, 'acecook@gmail.com');


-- thêm dữ liệu vào bảng Category
INSERT INTO CATEGORY (TenNhom)
VALUES 
    ('Đo uong'),
    ('Đo an');

-- thêm dữ liệu vào bảng Product
INSERT INTO PRODUCT (TenSP, DonGia, HanSuDung, NoiSanXuat, MaNhom, MaNCC)
VALUES 
    ('Sua tuoi 100% Vinamilk', 30000, '2025-04-12', 'Trang trai bo sua tai Viet Nam', 1, 1),
    ('Yomilk', 20000, '2025-03-13', 'Trang trai bo sua tai Viet Nam', 1, 1),
    ('Fanst', 12000, '2024-12-04', 'Nha may Coca - Cola tai Viet Nam', 1, 2),
	('7UP', 10000, '2025-01-05', 'Nha may của Suntory PepsiCo Viet Nam', 1, 3),
	('Pho Nhip Song', 9000, '2025-01-22', 'Nha may cua Acecook Viet Nam', 2, 4),
	('My Hao Hao', 4000, '2025-03-19', 'Nha may cua Acecook Viet Nam', 2, 4);

-- thêm dữ liệu vào bảng Job_Title
INSERT INTO JOB_TITLE (TenCV)
VALUES 
    ('Nhan vien ban hang'),
    ('Quan ly cua hang'),
    ('Nhan Vien Don Dep');

-- thêm dữ liệu vào bản Employee
INSERT INTO EMPLOYEE (HoTen, GioiTinh, NgaySinh, DiaChi, SDT, MaCV)
VALUES 
    ('Nguyen Vu Triet ', 'Nam', '2005-05-02', 'Bu To, Phuoc tan, Phu Rieng, Binh Phuoc', '0367182578', 1),
    ('Bui Thi Thu Thao', 'Nu', '2005-07-11', 'Thon 1, Đuc Lieu, Bu Đang, Binh Phuoc', '0934567890', 2),
    ('Truong Thanh Long', 'Nam', '2005-03-28', 'Thon 1, Đuc Lieu, Bu Đang, Binh Phuoc', '0922334455', 1),
	('Nguyen Thi Phuong Anh', 'Nu', '2005-05-19', 'Thôn 2, Nghia Trung, Bu Đang, Binh Phuoc', '0933334651', 3);

-- thêm dữ liệu vào bảng User_Account
INSERT INTO USER_ACCOUNT (MaNV, TenDangNhap, MatKhau)
VALUES 
    (1, 'nguyenvutriet', 'pw01'),
    (2, 'thuthao', 'pw02'),
    (3, 'thanhlong', 'pw03'),
	(4, 'phuonganh', 'pw04');

-- thêm dữ liệu vào bảng Customer
INSERT INTO CUSTOMER ( HoTen, SDT, SoLanMua)
VALUES 
    ('Mai Thi Hue', '0909998887', 10),
    ( 'Phan Tran Huyen Trang', '0912349876', 2),
    ( 'Pham Ngoc Nam', '0923456789', 5),
	('Le Minh Quan', '0998772116', 1);

-- thêm dữ liệu vào bảng Feedback
INSERT INTO FEEDBACK (MaKH, NgayPhanHoi, NoiDung, SoDiemDanhGia)
VALUES 
    ( 1 , '2024-12-01', 'San pham rat ngon, se tiep tuc ung ho!', 5),
    ( 3, '2024-12-05', 'Yomilk rat ngon, sẽ ung ho!', 4),
	( 4, '2024-12-25', 'Cua hang trang tri đep!', 4);

-- thêm dữ liệu vào bảng Invoice
INSERT INTO INVOICE ( MaKH, NgayLap, TongSoTien)
VALUES 
    ( 1, '2024-11-19', 234000),
    ( 2, '2024-11-20', 25000),
    ( 3, '2024-11-25', 36000),
    ( 4, '2024-11-28', 51000),
    (2,'2024-11-21', 20000),
	(4,'2024-11-26', 13000);

-- thêm dữ liệu vào bản Promotion
INSERT INTO PROMOTION (NoiDung, ThoiGianBatDau, ThoiGianKetThuc, DoiTuongApDung, MucGiamGia)
VALUES 
    ('Giam gia 10% cho cac looi đo uong', '2024-11-01', '2024-12-01', 'Đo uong', 10.00),
    ('Mua 5 goi my hao hao đuoc tang ve xem concert Adele o Munich', '2024-11-18', '2024-11-19', null, 0.00),
	('Giam 5% cho cac loai đo an', '2024-11-18', '2024-11-25', 'Đo an', 5.00);







