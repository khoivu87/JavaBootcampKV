/**
 * Cybersoft - Java Bootcamp 03
 * Bài tập Buổi 08 Bài tập hướng đối tượng
 * Câu 03
 * Deadline: 03/08/2023
 * Author: Vũ Kim Khôi
 */
package homework06_KV;

public class SimpleStudent {
	private int maSinhVien;
	private String hoTen;
	private float diemLyThuyet;
	private float diemThucHanh;
	
	public SimpleStudent() {
		this.maSinhVien = 0;
		this.hoTen = "";
		this.diemLyThuyet = 0;
		this.diemThucHanh = 0;
	}

	public SimpleStudent(int stuCode, String stuName, float stuTheoScore, float stuPracScore) {
		super();
		this.maSinhVien = stuCode;
		this.hoTen = stuName;
		this.diemLyThuyet = stuTheoScore;
		this.diemThucHanh = stuPracScore;
	}

	public void setStuCode(int stuCode) {
		this.maSinhVien = stuCode;
	}
	
	public int getStuCode() {
		return maSinhVien;
	}

	public void setStuName(String stuName) {
		this.hoTen = stuName;
	}

	public String getStuName() {
		return hoTen;
	}

	public void setStuTheoScore(float stuTheoScore) {
		this.diemLyThuyet = stuTheoScore;
	}

	public float getStuTheoScore() {
		return diemLyThuyet;
	}

	public void setStuPracScore(float stuPracScore) {
		this.diemThucHanh = stuPracScore;
	}

	public float getStuPracScore() {
		return diemThucHanh;
	}

	public float calcAvg() {
		float stuAvg = 0;
		
		stuAvg = (this.diemLyThuyet + this.diemThucHanh) / 2;
		
		return stuAvg;
	}

	@Override
	public String toString() {
		return "Mã sinh viên: " + maSinhVien + ". Họ & tên: " + hoTen + ". Điểm lý thuyết: " + diemLyThuyet
				+ ". Điểm thực hành: " + diemThucHanh + ", Điểm trung bình: " + calcAvg();
	}
}
