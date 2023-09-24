CREATE DATABASE Inventory;

CREATE TABLE Suppliers(
	SupplierID INT NOT NULL AUTO_INCREMENT,
	SupplierCode varchar(50) NOT NULL,
	SupplierName varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY(SupplierID)
);

CREATE TABLE ProductCategory(
	CategoryID INT NOT NULL AUTO_INCREMENT,
	CategoryCode varchar(100) NOT NULL,
	CategoryName varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY(CategoryID)
);

CREATE TABLE Products(
	ProductID INT NOT NULL AUTO_INCREMENT,
	SupplierID INT NOT NULL,
	CategoryID INT NOT NULL,
	ProductCode varchar(255) NOT NULL,
	ProductName varchar(255) NOT NULL UNIQUE,
	UnitCost DECIMAL(10,2) NOT NULL,
	UnitPrice DECIMAL (10,2) NOT NULL,
	Quantity INT NOT NULL DEFAULT 1,
	Discount DOUBLE(8,2) NOT NULL DEFAULT 0,
	PRIMARY KEY(ProductID),
	FOREIGN KEY(SupplierID) REFERENCES Suppliers(SupplierID),
	FOREIGN KEY(CategoryID) REFERENCES ProductCategory(CategoryID)
);

INSERT INTO Suppliers VALUES
(1, 'APL-001', 'APPLE'),
(2, 'ACR-002', 'ACER'),
(3, 'ASU-003', 'ASUS'),
(4, 'DLL-004', 'DELL'),
(5, 'HP-005', 'HEWLETT-PACKARD'),
(6, 'LNV-006','LENOVO'),
(7, 'MSI-007', 'MICRO-STAR INTERNATIONAL'),
(8, 'SSG-008', 'SAMSUNG'),
(9, 'RZR-009', 'RAZER');

INSERT INTO ProductCategory VALUES
(1, 'CAT-001', 'Laptop'),
(2, 'CAT-002', 'Tablet'),
(3, 'CAT-003', 'Keyboard'),
(4, 'CAT-004', 'Mouse')

INSERT INTO Products VALUES
(1, 2, 1, 'PRD-001', 'ACER Aspire 3 A315 59 314F', 13490000, 8690000, 4, 0.35),
(2, 2, 1, 'PRD-002', 'ACER Aspire 3 A314 35 C3KS', 6990000, 5690000, 10, 0.18),
(3, 2, 1, 'PRD-003', 'ACER Aspire 3 A314 35 P3G9', 7990000, 6190000, 3, 0.22),
(4, 3, 1, 'PRD-004', 'ASUS Vivobook X515MA', 7890000, 6490000, 70, 0.17),
(5, 3, 1, 'PRD-005', 'ASUS Vivobook X415EA', 11490000, 8990000, 50, 0.21),
(6, 4, 1, 'PRD-006', 'DELL Inspiron 15 3520', 13690000, 11790000, 15, 0.13),
(7, 4, 1, 'PRD-007', 'DELL Vostro 15 3520', 14790000, 12790000, 60, 0.15),
(8, 1, 1, 'PRD-008', 'MacBook Air 13 Inch 2016', 6500000, 6000000, 30, 0.08),
(9, 1, 1, 'PRD-009', 'MacBook Air 13 Inch M1 2020', 18990000, 18990000, 22, 0),
(10, 1, 1, 'PRD-010', 'MacBook Pro 13 Inch M2 2022', 30490000, 29890000, 13, 0.02),
(11, 8, 2, 'PRD-011', 'Samsung Galaxy Tab A8 2022', 6990000, 5990000, 10, 0.14),
(12, 8, 2, 'PRD-012', 'Samsung Galaxy Tab S7 FE 4G', 13990000, 9390000, 60, 0.32),
(13, 8, 2, 'PRD-013', 'Samsung Galaxy Tab S9 WiFi', 19990000, 18990000, 61, 0.05),
(14, 7, 1, 'PRD-014', 'MSI Modern 14 C11M', 11990000, 9490000, 55, 0.2),
(15, 6, 1, 'PRD-015', 'Lenovo IdeaPad 1 15AMN7', 12690000, 10000000, 35, 0.22),
(16, 9, 3, 'PRD-016', 'Razer BlackWidow', 3200000, 1920000, 20, 0.4),
(17, 9, 4, 'PRD-017', 'Razer DeathAdder Essential', 750000, 410000, 22, 0.45),
(18, 9, 3, 'PRD-018', 'Razer Huntsman Tournament Edition', 3550000, 2130000, 40, 0.4),
(19, 9, 4, 'PRD-019', 'Razer Abyssus Lite', 590000, 450000, 15, 0.23),
(20, 9, 3, 'PRD-020', 'Razer BlackWidow V3', 3640000, 2180000, 55, 0.4)
