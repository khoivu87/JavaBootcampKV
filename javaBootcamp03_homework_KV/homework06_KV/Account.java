/**
 * Cybersoft - Java Bootcamp 03
 * Bài tập Buổi 08 Bài tập hướng đối tượng
 * Câu 04
 * Deadline: 03/08/2023
 * Author: Vũ Kim Khôi
 */
package homework06_KV;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	private long soTaiKhoan;
	private String tenTaiKhoan;
	private double soDuKhaDung;
	private final double LAISUAT = 0.035;
	private final double FEE = 5;
	
	public Account() {
		this.soTaiKhoan = 0;
		this.tenTaiKhoan = "";
		this.soDuKhaDung = 0;
	}

	public Account(long soTaiKhoan, String tenTaiKhoan, double soDuKhaDung) {
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.soDuKhaDung = soDuKhaDung;
	}
	
	public Account(long soTaiKhoan, String tenTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.soDuKhaDung = 50;
	}

	public void setSoTaiKhoan(long soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}
	
	public long getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setSoDuKhaDung(double soDuKhaDung) {
		this.soDuKhaDung = soDuKhaDung;
	}

	public double getSoDuKhaDung() {
		return soDuKhaDung;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("vi", "VN"));
		
		return "Số tài khoản: " + soTaiKhoan + ". Tên tài khoản: " + tenTaiKhoan
				+ ". Số dư khả dụng: " + nf.format(soDuKhaDung) + "đ";
	}

	public void moneyDeposit(double amount) {
		this.soDuKhaDung += amount;
	}
	
	public void moneyWidthdraw(double amount) {
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("vi", "VN"));
		
		if(amount > this.soDuKhaDung) {
			System.out.println("Số dư khả dụng: " + nf.format(this.soDuKhaDung) + "đ"
					+ " không đủ để rút " + nf.format(amount) + "đ");
		}else {
			this.soDuKhaDung -= (amount + this.FEE);
		}
	}
	
	public void accountMaturity() {
		this.soDuKhaDung = (this.soDuKhaDung + (this.soDuKhaDung * LAISUAT));
	}
	
	public void moneyTransfer(double amount, Account bAccount) {
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("vi", "VN"));

		if(amount > this.soDuKhaDung) {
			System.out.println("Số dư khả dụng: " + nf.format(this.soDuKhaDung) + "đ"
				+ " không đủ để rút " + nf.format(amount) + "đ");
		}else {
			System.out.println("Đã chuyển thành công " + nf.format(amount) + "đ"
					+ ", phí giao dịch: " + nf.format(FEE) + "đ");
			bAccount.moneyDeposit(amount);
			moneyWidthdraw(amount);
		}
	}
}
