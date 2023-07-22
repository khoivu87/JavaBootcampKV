/**
 * Cybersoft - Java Bootcamp 03
 * Bài tập Buổi 05 - Deadline: 21/07/2023
 * Author: Vũ Kim Khôi
 */
package homework02_KV;

import java.util.Scanner;

/**
 * 
 */
public class BaiTap02_VuKimKhoi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//-----Bài 01 start-----
		System.out.println("-----Bài 01-----");
		q1IsDivideByFive(scan);
		//-----Bài 01 end-----
		
		//-----Bài 02 start-----
		System.out.println("-----Bài 02-----");
		q2StudentInfo(scan);
		//-----Bài 02 end-----
		
		//-----Bài 03 start-----
		System.out.println("-----Bài 03-----");
		q3SumOfTwo(scan);
		//-----Bài 03 end-----
		
		//-----Bài 04 start-----
		System.out.println("-----Bài 04-----");
		q4BasicCalculator(scan);
		//-----Bài 04 end-----
		
		//-----Bài 05 start-----
		System.out.println("-----Bài 05-----");
		q5IsEvenOrOdd(scan);
		//-----Bài 05 end-----
		
		//-----Bài 06 start-----
		System.out.println("-----Bài 06-----");
		q6AnimalSounds(scan);
		//-----Bài 06 end-----
		
		//-----Bài 07 start-----
		System.out.println("-----Bài 07-----");
		q7LinearEquation(scan);
		//-----Bài 07 end-----
		
		//-----Bài 08 start-----
		System.out.println("-----Bài 08-----");
		q8QuadraticEquation(scan);
		//-----Bài 08 end-----
		
		scan.close();
	}
	
	/*
	 * Bài 01 - Kiểm tra số chia hết cho 5
	 */
	public static void q1IsDivideByFive(Scanner scan) {
		int inFive;
		
		do {
			System.out.print("Nhập một số bất kỳ: ");
			inFive = scan.nextInt();
		}while(inFive < 0);

		int unit = inFive%10;
		
		switch(unit) {
			case 0: case 5:
				System.out.println(inFive + " chia hết cho 5");
				break;
			default:
				System.out.println(inFive + " không chia hết cho 5");
				break;
		}
		scan.nextLine();
	}
	
	/*
	 * Bài 02 - Nhập Họ tên, tuổi, giới tính, MSSV và in ra console
	 */
	public static void q2StudentInfo(Scanner scan) {
		String name, gender, stuNumber;
		int age;
		
		do {
			System.out.print("Vui lòng nhập họ & tên: ");
			name = scan.nextLine().trim();
		}while(name == "" || name == null);
		
		do {
			System.out.print("Bạn bao nhiêu tuổi: ");
			age = scan.nextInt();
		}while(age <= 0 || age > 100);
		scan.nextLine();
		
		do {
			System.out.print("Giới tính của bạn (Nam/Nữ/Khác): ");
			gender = scan.nextLine();
		}while(gender == "" || gender == null || 
				(!"Nam".equals(gender) && !"Nữ".equals(gender) && !"Khác".equals(gender)));
		
		do {
			System.out.print("Xin nhập mã số sinh viên: ");
			stuNumber = scan.nextLine();
		}while(stuNumber == "" || stuNumber == null);
		
		System.out.println("-----Thông tin sinh viên-----");
		System.out.println("Sinh viên: " + name + ". Tuổi: " + age);
		System.out.println("Giới tính: " + gender + ". Mã số sinh viên: " + stuNumber);
	}
	
	/*
	 * Bài 03 - Tổng 2 số nguyên a & b nhập từ bàn phím
	 */
	public static void q3SumOfTwo(Scanner scan) {
		int sum, aNum, bNum;
		
		do {
			System.out.print("Nhập số a: ");
			aNum = scan.nextInt();
		}while(aNum < 0);
		
		do {
			System.out.print("Nhập số b: ");
			bNum = scan.nextInt();
		}while(bNum < 0);
		
		sum = Math.addExact(aNum, bNum);
		
		System.out.println("Tổng 2 số " + aNum + " và " + bNum + " là: " + sum);
	}
	
	/*
	 * Bài 04 Tổng 4 số nguyên a, b, c, d
	 */
	public static void q4BasicCalculator(Scanner scan) {
		int aNum, bNum, cNum, dNum;
		double sumOfFour, subOfFour, mulAb, divCd, resultOfFour;
		
		do {
			System.out.print("Nhập số a: ");
			aNum = scan.nextInt();
		}while (aNum < 0);
		
		do {
			System.out.print("Nhập số b: ");
			bNum = scan.nextInt();
		}while (bNum < 0);
		
		do {
			System.out.print("Nhập số c: ");
			cNum = scan.nextInt();
		}while (cNum < 0);
		
		do {
			System.out.print("Nhập số d: ");
			dNum = scan.nextInt();
		}while (dNum < 0);
		
		sumOfFour = aNum + bNum + cNum + dNum;
		subOfFour = aNum - bNum - cNum - dNum;
		mulAb = aNum * bNum;
		divCd = cNum * dNum;
		resultOfFour = aNum - bNum + cNum + dNum;
		
		System.out.println("Tổng của a, b, c, d: " + sumOfFour);
		System.out.println("Hiệu của a, b, c, d: " + subOfFour);
		System.out.println("Tích của a, b: " + mulAb);
		System.out.println("Tích của c, d: " + divCd);
		System.out.println("Kết quả a-b+c+d: " + resultOfFour);
	}
	
	/*
	 * Bài 05 - Kiểm tra số n là chẵn hay lẻ
	 */
	public static void q5IsEvenOrOdd(Scanner scan) {
		int inNum;
		
		do {
			System.out.print("Vui lòng nhập số n: ");
			inNum = scan.nextInt();
		}while(inNum < 0);
		
		
		if(inNum%2 == 0) {
			System.out.println(inNum + " là số chẵn");
		}else if(inNum%2 != 0) {
			System.out.println(inNum + " là số lẻ");
		}else {
			System.out.println("Số nhập vào không hợp lệ");
		}
		
		scan.nextLine();
	}
	
	/*
	 * Bài 06 - xuất ra tiếng kêu của các con vật
	 * Input: chó, mèo, chuột, ngựa
	 */
	public static void q6AnimalSounds(Scanner scan) {
		String animal;
		
		do {
			System.out.print("Vui lòng chọn loài vật (chó/mèo/chuột/ngựa): ");
			animal = scan.nextLine().trim();
		}while(animal == "" || animal == null
				|| (!"chó".equals(animal) && !"mèo".equals(animal) 
						&& !"chuột".equals(animal) && !"ngựa".equals(animal)));
		
		switch(animal) {
			case "chó":
				System.out.println("Chó kêu: gâu gâu gâu");
				break;
			case "mèo":
				System.out.println("Mèo kêu: meo meo meo");
				break;
			case "chuột":
				System.out.println("Chuột kêu: chít chít chít");
				break;
			case "ngựa":
				System.out.println("Ngựa kêu: Hí hí hí");
				break;
			default:
				System.out.println("Không tìm thấy loài vật này");
				break;
		}
		
	}
	/*
	 * Bài 07 - giải phương trình bậc nhất ax + b = 0
	 * a, b do người dùng nhập từ màn hình
	 */
	public static void q7LinearEquation(Scanner scan) {
		double aNum, bNum, xNum;
		String input;
		
		//Nhập aNum, không cho phép user nhập blank/ empty/ text
		do {
			System.out.print("Nhập số a: ");
			input = scan.nextLine();
		}while(input.equals("") || input.isBlank() || input.isEmpty()
				|| input.chars().allMatch(Character::isAlphabetic));
		
		aNum = Double.parseDouble(input);
		
		//Nhập bNum, không cho phép user nhập blank/ empty/ text
		do {
			System.out.print("Nhập số b: ");
			input = scan.nextLine();
		}while(input.equals("") || input.isBlank() || input.isEmpty()
				|| input.chars().allMatch(Character::isAlphabetic));
		
		bNum = Double.parseDouble(input);
		
		xNum = -(bNum/aNum);
		
		System.out.println("x = " + xNum);
	}
	
	/*
	 * Bài 08 - trình giải phương trình sau ax2 + b = 0
	 * a, b do người dùng nhập từ màn hình
	 */
	public static void q8QuadraticEquation(Scanner scan) {
		double aNum, bNum, xNum, xNum2;
		String input;
		
		//Nhập aNum, không cho phép user nhập blank/ empty/ text
		do {
			System.out.print("Nhập số a: ");
			input = scan.nextLine();
		}while(input.equals("") || input.isBlank() || input.isEmpty()
				|| input.chars().allMatch(Character::isAlphabetic));
		
		aNum = Double.parseDouble(input);
		
		//Nhập bNum, không cho phép user nhập blank/ empty/ text
		do {
			System.out.print("Nhập số b: ");
			input = scan.nextLine();
		}while(input.equals("") || input.isBlank() || input.isEmpty()
				|| input.chars().allMatch(Character::isAlphabetic));
		
		bNum = Double.parseDouble(input);
		
		//Tính x1, x2
		xNum = Math.sqrt(Math.abs(-bNum/aNum));
		xNum2 = -Math.sqrt(Math.abs(-bNum/aNum));
		
		System.out.println("x1 = " + xNum + ", x2 = " + xNum2);
	}
}