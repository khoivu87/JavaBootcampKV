/**
 * Cybersoft - Java Bootcamp 03
 * Bài tập Buổi 08 Bài tập hướng đối tượng
 * Câu 03
 * Deadline: 03/08/2023
 * Author: Vũ Kim Khôi
 */
package homework06_KV;

import java.util.Scanner;

public class BT06_BtaiTapOOP_Cau03_VuKimKhoi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//-----Câu 03-----
		System.out.println("-----Câu 03-----");
		SimpleStudent firstStu = new SimpleStudent(1, "Nguyen Van A", 8, 9);
		SimpleStudent secondStu = new SimpleStudent(2, "Tran Thi B", 9, 7);
		SimpleStudent thirdStu = new SimpleStudent();
		
		thirdStu = simpleStuCreate(scan, thirdStu);
		
		System.out.println("----------");
		studentPrint(firstStu);
		studentPrint(secondStu);
		studentPrint(thirdStu);
		
		scan.close();
	}
	
	/*
	 * Câu 03
	 * Hàm cho phép người dùng nhập thông tin SV từ bàn phím
	 * Không nhận blank/ empty, số âm hoặc lớn hơn 10
	 */
	public static String[] stuUserInput(Scanner scan) {
		String input = "";
		String[] stuVar = new String[]{"mã sinh viên", "họ tên", "điểm Lý thuyết", "điểm Thực hành"};
		String[] outputs = new String[stuVar.length];
		
		for(int i=0; i<stuVar.length; i++) {
			// Nhập tên & mã số sinh viên
			if(i==1) {
				do {
					System.out.print("Xin nhập " + stuVar[i] + ": ");
					input = scan.nextLine();
					
				}while(input.equals("") || input.isBlank() || input.isEmpty());
			}else {
				// Nhập điểm Lý Thuyết, điểm Thực Hành
				do {
					System.out.print("Xin nhập " + stuVar[i] + ": ");
					input = scan.nextLine();
				}while(input.equals("") || input.isBlank() || input.isEmpty()
						|| input.chars().allMatch(Character::isAlphabetic)
						|| !input.matches("\\d+")
						|| Float.parseFloat(input) < 0
						|| Float.parseFloat(input) > 10);
			}
			
			outputs[i] = input;
		}
		
		return outputs;
	}
	
	/*
	 * Câu 03
	 * Hàm xuất thông tin 01 sinh viên
	 */
	public static void studentPrint(SimpleStudent stu) {
		System.out.println(stu.toString());
	}
	
	/*
	 * Câu 03
	 * Hàm cho phép người dùng tạo MỘT sinh viên
	 * Gọi hàm stuUserInput để người dùng nhập thông tin từ bàn phím
	 * Return: SimpleStudent stu (1 object sinh viên)
	 */
	public static SimpleStudent simpleStuCreate(Scanner scan, SimpleStudent stu) {
		String[] info = stuUserInput(scan);
		stu = new SimpleStudent();
		
		stu.setStuCode(Integer.parseInt(info[0]));
		stu.setStuName(info[1]);
		stu.setStuTheoScore(Float.parseFloat(info[2]));
		stu.setStuPracScore(Float.parseFloat(info[3]));
		
		return stu;
	}
}
