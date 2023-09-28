/* I.1.Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên */
SELECT tgv.Magv "Mã số giảng viên",
		tgv.Hotengv "Họ tên giảng viên", 
		tkh.Tenkhoa Khoa
FROM TBLGiangVien tgv JOIN TBLKhoa tkh
ON tgv.Makhoa = tkh.Makhoa;

/* I.2.Đưa ra thông tin gồm mã số, họ tênvà tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’ */
SELECT tgv.Magv "Mã số",
		tgv.Hotengv "Họ tên",
		tkh.Tenkhoa Khoa
FROM TBLGiangVien tgv JOIN TBLKhoa tkh
ON tgv.Makhoa = tkh.Makhoa
WHERE tkh.Tenkhoa = "Dia ly va QLTN";

/* I.3.Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’ */
SELECT Count(tsv.Masv) "Tổng số sinh viên CNSH"
FROM TBLSinhVien tsv JOIN TBLKhoa tkh
ON tsv.Makhoa = tkh.Makhoa
WHERE tkh.Tenkhoa = "Cong nghe Sinh hoc";

/* I.4.Đưa ra danh sách gồm mã số, họ tênvà tuổi của các sinh viên khoa ‘TOAN’ */
SELECT tsv.Masv "Mã số sinh viên",
		tsv.Hotensv "Họ tên sinh viên",
		CASE
			WHEN (YEAR(NOW())- tsv.Namsinh) IS NULL THEN 18
			ELSE (YEAR(NOW())- tsv.Namsinh)
		END "Tuổi"
FROM TBLSinhVien tsv JOIN TBLKhoa tkh
ON tsv.Makhoa = tkh.Makhoa
WHERE tkh.Tenkhoa = "Toan";

/* I.5.Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’ */
SELECT Count(tgv.Magv) "Tổng số giảng viên CNSH"
FROM TBLGiangVien tgv JOIN TBLKhoa tkh
ON tgv.Makhoa = tkh.Makhoa
WHERE tkh.Tenkhoa = "Cong nghe Sinh hoc";

/* I.6.Cho biết thông tin về sinh viên không tham gia thực tập */
SELECT tsv.Masv "Mã số sinh viên",
		tsv.Hotensv "Họ tên sinh viên"
FROM TBLSinhVien tsv
WHERE tsv.Masv NOT IN (SELECT thd.Masv
						FROM TBLHuongDan thd);
						
/* I.7.Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa */
SELECT tkh.Makhoa "Mã khoa", 
		tkh.Tenkhoa "Tên khoa", 
		COUNT(tkh.MaKhoa) "Số giảng viên"
FROM TBLKhoa tkh JOIN TBLGiangVien tgv
ON tkh.Makhoa = tgv.Makhoa
GROUP BY tkh.MaKhoa;

/* I.8.Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le van son’ đang theo học */
SELECT tkh.Dienthoai "Số điện thoại", tkh.Tenkhoa "Tên khoa"
FROM TBLSinhVien tsv JOIN TBLKhoa tkh
ON tsv.Makhoa = tkh.Makhoa
WHERE tsv.Hotensv = "Le Van Son";

/* II.1.Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn */
SELECT tdt.Madt "Mã đề tài",
		tdt.Tendt "Tên đề tài"
FROM TBLDeTai tdt JOIN TBLHuongDan thd
ON tdt.Madt = thd.Madt
JOIN TBLGiangVien tgv
ON thd.Magv = tgv.Magv
WHERE tgv.Hotengv = "Tran Son";

/* II.2.Cho biết tên đề tài không có sinh viên nào thực tập */
SELECT tdt.Madt  "Mã đề tài",
		tdt.Tendt "Tên đề tài"
FROM TBLDeTai tdt
WHERE tdt.Madt NOT IN (SELECT thd.Madt
						FROM TBLHuongDan thd);

/* II.3.Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên. */				
SELECT DISTINCT tgv.Magv "Mã số giảng viên",
		tgv.Hotengv "Tên giảng viên",
		tkh.Tenkhoa "Tên khoa"
FROM TBLGiangVien tgv JOIN TBLKhoa tkh
ON tgv.Makhoa = tkh.Makhoa
JOIN TBLHuongDan thd
ON tgv.Magv = thd.Magv
WHERE thd.Magv IN (SELECT thd.Magv
					FROM TBLHuongDan thd
					GROUP BY thd.Magv
					HAVING COUNT(*) >=3);
					
/* II.4.Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất */
SELECT Madt "Mã đề tài",
		Tendt "Tên đề tài",
		Kinhphi "Kinh phí"
FROM TBLDeTai
WHERE Kinhphi = (SELECT MAX(Kinhphi)
				 FROM TBLDeTai);
				 
/* II.5.Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập */
SELECT DISTINCT tdt.Madt "Mã đề tài",
		tdt.Tendt "Tên đề tài"
FROM TBLDeTai tdt JOIN TBLHuongDan thd
ON tdt.Madt = thd.Madt
WHERE tdt.Madt IN (SELECT thd.Madt
					FROM TBLHuongDan thd
					GROUP BY thd.Madt
					HAVING COUNT(*) > 2);

/* II.6.Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’ */
SELECT tsv.Masv "Mã số sinh viên",
		tsv.Hotensv "Tên sinh viên",
		thd.KetQua "Điểm"
FROM TBLSinhVien tsv JOIN TBLKhoa tkh
ON tsv.Makhoa = tkh.Makhoa
JOIN TBLHuongDan thd
ON tsv.Masv = thd.Masv
WHERE tkh.Tenkhoa = "Dia ly va QLTN";

/* II.7.Đưa ra tên khoa, số lượng sinh viên của mỗi khoa */
SELECT tkh.Tenkhoa "Tên khoa",
		COUNT(tsv.Masv) "Số lượng sinh viên"
FROM TBLKhoa tkh JOIN TBLSinhVien tsv
ON tkh.Makhoa = tsv.Makhoa
GROUP BY tkh.Tenkhoa
ORDER BY COUNT(tsv.Masv) DESC;

/* II.8.Cho biết thông tin về các sinh viên thực tập tại quê nhà */
SELECT tsv.Masv "Mã số sinh viên",
		tsv.Hotensv "Tên sinh viên",
		tsv.Quequan "Quê quán",
		tdt.Noithuctap "Nơi thực tập"
FROM TBLSinhVien tsv JOIN TBLHuongDan thd
ON tsv.Masv = thd.Masv
JOIN TBLDeTai tdt
ON thd.Madt = tdt.Madt
WHERE tsv.Quequan = tdt.Noithuctap;

/* II.9.Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập */
SELECT tsv.Masv "Mã số sinh viên",
		tsv.Hotensv "Tên sinh viên",
		thd.KetQua "Kết quả"
FROM TBLSinhVien tsv JOIN TBLHuongDan thd
ON tsv.Masv = thd.Masv
WHERE thd.KetQua IS NULL;

/* II.10.Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0 */
SELECT tsv.Masv "Mã số sinh viên",
		tsv.Hotensv "Tên sinh viên",
		thd.KetQua "Kết quả"
FROM TBLSinhVien tsv JOIN TBLHuongDan thd
ON tsv.Masv = thd.Masv
WHERE thd.KetQua = 0;