/* 1.1.Lấy danh sách tất cả sản phẩm */
SELECT *
FROM Products;

/* 1.2.Chỉ lấy các thông tin về mã sản phẩm, tên sản phẩm, giá nhập, 
 * giá niêm yết (giá bán), số lượng, % giảm giá của các sản phẩm */
SELECT ProductCode "Mã Sản Phẩm",
		ProductName "Tên Sản Phẩm",
		UnitCost "Giá Nhập",
		UnitPrice "Giá Niêm Yết",
		Quantity "Số Lượng",
		Discount*100 "Giảm Giá (%)"
FROM Products;

/* 1.3.Lấy mã sản phẩm, tên sản phẩm, giá nhập, giá niêm yết (giá bán)
 * của những sản phẩm có số lượng còn lại > 60 */
SELECT ProductCode "Mã Sản Phẩm",
		ProductName "Tên Sản Phẩm",
		UnitCost "Giá Nhập",
		UnitPrice "Giá Niêm Yết"
FROM Products
WHERE Quantity > 60;

/* 1.4.Lấy 3 sản phẩm mới nhất vừa được thêm vào Hệ thống */
SELECT prd.ProductCode "Mã Sản Phẩm",
		prd.ProductName "Tên Sản Phẩm",
		prd.UnitCost "Giá Nhập",
		prd.UnitPrice "Giá Niêm Yết",
		prd.Quantity "Số Lượng",
		prd.Discount*100 "Giảm Giá (%)"
FROM Products prd
JOIN (SELECT DISTINCT ProductID
		FROM Products
		ORDER BY ProductID DESC
		LIMIT 3) latestThree
ON prd.ProductID = latestThree.ProductID
ORDER BY prd.ProductID DESC;

/* 1.5.Lấy sản phẩm mà tên sản phẩm có chứa chữ 'Samsung' */
SELECT ProductCode "Mã Sản Phẩm",
		ProductName "Tên Sản Phẩm",
		UnitCost "Giá Nhập",
		UnitPrice "Giá Niêm Yết",
		Quantity "Số Lượng",
		Discount*100 "Giảm Giá (%)"
FROM Products
WHERE ProductName LIKE '%Samsung%';

/* 1.6.Lấy các sản phẩm với tên có chứa 'MacBook' và giá niêm yết (giá bán) trên 7,000,000 */
SELECT ProductCode "Mã Sản Phẩm",
		ProductName "Tên Sản Phẩm",
		UnitPrice "Giá Niêm Yết",
		Quantity "Số Lượng",
		Discount*100 "Giảm Giá (%)"
FROM Products
WHERE ProductName LIKE '%MacBook%'
AND UnitPrice > 7000000;

/* 1.7.Lấy các sản phẩm với tên có giá niêm yết (giá bán) từ 8,000,000 đến 10,000,000 */
SELECT ProductCode "Mã Sản Phẩm",
		ProductName "Tên Sản Phẩm",
		UnitPrice "Giá Niêm Yết",
		Quantity "Số Lượng",
		Discount*100 "Giảm Giá (%)"
FROM Products
WHERE UnitPrice BETWEEN 8000000 AND 10000000;

/* 2.1. Lấy mã sản phẩm, tên sản phẩm, giá nhập, giá niêm yết (giá bán),
 * số lượng, tên nhà cung cấp của tất cả sản phẩm */
SELECT prd.ProductCode "Mã Sản Phẩm",
		prd.ProductName "Tên Sản Phẩm",
		prd.UnitCost "Giá Nhập",
		prd.UnitPrice "Giá Niêm Yết",
		prd.Quantity "Số Lượng",
		spl.SupplierName "Tên Nhà Cung Cấp"
FROM Products prd
JOIN Suppliers spl
ON prd.SupplierID = spl.SupplierID
ORDER BY prd.ProductID;

/* 2.2. Lấy mã sản phẩm, tên sản phẩm, giá nhập, giá niêm yết (giá bán), số lượng,
 * mã nhà cung cấp, tên nhà cung cấp, mã loại sản phẩm, tên loại sản phẩm 
 * của những sản phẩm có giá lớn hơn 5.000.000. */
SELECT prd.ProductCode "Mã Sản Phẩm",
		prd.ProductName "Tên Sản Phẩm",
		prd.UnitCost "Giá Nhập",
		prd.UnitPrice "Giá Niêm Yết",
		prd.Quantity "Số Lượng",
		spl.SupplierCode "Mã Nhà Cung Cấp",
		spl.SupplierName "Tên Nhà Cung Cấp",
		cat.CategoryCode "Mã Loại Sản Phẩm",
		cat.CategoryName "Tên Loại Sản Phẩm"
FROM Products prd
JOIN Suppliers spl
ON prd.SupplierID = spl.SupplierID
JOIN ProductCategory cat
ON prd.CategoryID = cat.CategoryID
WHERE prd.UnitPrice > 5000000
ORDER BY prd.ProductID;

/* 2.3.Lấy tất cả sản phẩm là máy tính bảng (tablet) */
SELECT prd.ProductCode "Mã Sản Phẩm",
		prd.ProductName "Tên Sản Phẩm",
		prd.UnitCost "Giá Nhập",
		prd.UnitPrice "Giá Niêm Yết",
		prd.Quantity "Số Lượng",
		cat.CategoryName "Tên Loại Sản Phẩm"
FROM Products prd
JOIN ProductCategory cat
ON prd.CategoryID = cat.CategoryID
WHERE cat.CategoryName = 'Tablet'
ORDER BY prd.ProductID;