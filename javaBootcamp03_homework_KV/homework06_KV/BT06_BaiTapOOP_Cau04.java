/**
 * Cybersoft - Java Bootcamp 03
 * Bài tập Buổi 08 Bài tập hướng đối tượng
 * Câu 04
 * Deadline: 03/08/2023
 * Author: Vũ Kim Khôi
 */
package homework06_KV;

public class BT06_BaiTapOOP_Cau04 {
	public static void main(String[] args) {
		
		//-----Câu 04-----
		System.out.println("-----Câu 04-----");
		Account firstAccount = new Account(0001, "Le Hoang C", 1000000);
		Account secondAccount = new Account(0002, "Truong Huynh E");
		
		// In thông tin 2 tài khoản
		System.out.println(firstAccount.toString());
		System.out.println(secondAccount.toString());
		
		// Nạp tiền cho tài khoản 2
		System.out.println("----------");
		secondAccount.moneyDeposit(1000085);
		System.out.println(secondAccount.toString());
		
		// Rút tiền tài khoản 2
		System.out.println("----------");
		secondAccount.moneyWidthdraw(30);
		System.out.println(secondAccount.toString());
		
		// Rút quá số dư 1.000.100
		System.out.println("----------");
		secondAccount.moneyWidthdraw(1000200);
		System.out.println(secondAccount.toString());
		
		// Đáo hạn tài khoản 2
		System.out.println("----------");
		secondAccount.accountMaturity();
		System.out.println(secondAccount.toString());
		
		// Chuyển tiền từ tài khoản 2 sang tài khoản 1 (phí cho tài khoản 2: 5đ)
		System.out.println("----------");
		secondAccount.moneyTransfer(103.5, firstAccount);
		System.out.println(firstAccount.toString());
		System.out.println(secondAccount.toString());
		
		// Chuyển quá số dư của tài khoản 2: 1,034,995đ
		System.out.println("----------");
		secondAccount.moneyTransfer(1500000, firstAccount);
		System.out.println(secondAccount.toString());
	}
}
