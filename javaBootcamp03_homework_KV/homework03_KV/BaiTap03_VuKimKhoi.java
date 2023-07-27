/**
 * Cybersoft - Java Bootcamp 03
 * Bài tập Buổi 06 - Deadline: 29/07/2023
 * Author: Vũ Kim Khôi
 */
package homework03_KV;

import java.util.Scanner;

public class BaiTap03_VuKimKhoi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//-----Bài 01 start-----
		System.out.println("-----Bài 01-----");
		int maxNum = 0;
		
		maxNum = q1MaxNum(scan);
		
		System.out.println("Số lớn nhất: " + maxNum);
		//-----Bài 01 end-----
		
		//-----Bài 02 start-----
		System.out.println("-----Bài 02-----");
		q2EvenOrOdd(scan);
		//-----Bài 02 end-----
		
		//-----Bài 03 start-----
		System.out.println("-----Bài 03-----");
		int sumThree = 0;
		
		sumThree = q3SumOfThree(scan);
		
		System.out.println("Tổng của 3 số là: " + sumThree);
		//-----Bài 03 end-----
		
		//-----Bài 04 start-----
		System.out.println("-----Bài 04-----");
		
		q4SimpleCalculator(scan);

		//-----Bài 04 end-----
		
		//-----Bài 05 start-----
		System.out.println("-----Bài 05-----");
		String youngestStu = "";
		
		youngestStu = q5YoungestStu(scan);
		
		System.out.println("Sinh viên trẻ nhất là: " + youngestStu);
		//-----Bài 05 end-----
		
		
		//-----Bài 06 start-----
		System.out.println("-----Bài 06-----");
		String listEvenAndOdd = "";
		
		listEvenAndOdd = q6ListEvenAndOdd(scan);
		
		System.out.println("----------\n" + listEvenAndOdd);
		//-----Bài 06 end-----
		
		//-----Bài 07 start-----
		System.out.println("-----Bài 07-----");
		String youngestMOfficer = "";
		
		youngestMOfficer = q7YoungestOfficer(scan);
		
		System.out.println("Cán bộ nam trẻ nhất là: " + youngestMOfficer);
		//-----Bài 07 end-----
		
		
		//-----Bài 08-----
		System.out.println("-----Bài 08-----");
		String farthestStu = "";
		
		farthestStu = q8FarthestStu(scan);
		System.out.println(farthestStu);
	}
	
	/*
	 * Bài 01 - Tìm số lớn nhất trong 3 số a, b, c do người dùng nhập vào
	 * Input: số người dùng nhập từ bàn phím, không nhận empty/ blank hay text
	 * Return: số lớn maxNum
	 */
	public static int q1MaxNum(Scanner scan) {
		int[]inNum = new int[3];
		int maxNum = 0;
		String input;
		
		for(int i=0; i<inNum.length; i++) {
			do {
				System.out.print("Nhập số thứ " + (i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isEmpty() || input.isBlank()
					|| input.chars().allMatch(Character::isAlphabetic));
			
			inNum[i] = Integer.parseInt(input);
			
			if(inNum[i] > maxNum) {
				maxNum = inNum[i];
			}
		}
		
		return maxNum;
	}
	
	/*
	 * Bài 02 - Kiểm tra số người dùng nhập là chẵn hay lẻ
	 * Input: số người dùng nhập từ bàn phím, không nhận empty/ blank/ text hay số âm
	 * Output: in ra console kết quả số chẵn hay số lẻ
	 */
	public static void q2EvenOrOdd(Scanner scan) {
		int inNum;
		String input;
		
		do {
			System.out.print("Vui lòng nhập một số: ");
			input = scan.nextLine();
		}while(input.equals("") || input.isEmpty() || input.isBlank()
				|| input.chars().allMatch(Character::isAlphabetic)
				|| Integer.parseInt(input) < 0);
		
		inNum = Integer.parseInt(input);
		
		if(inNum%2 == 0) {
			System.out.println(inNum + " là số chẵn");
		}else if(inNum%2 != 0) {
			System.out.println(inNum + " là số lẻ");
		}else {
			System.out.println("Số nhập vào không hợp lệ");
		}
	}
	
	/*
	 * Bài 03 - Tính tổng 3 số người dùng nhập vào
	 * Input: 3 số nhập từ bàn phím, không nhận empty/ blank/ text
	 * Return: tổng 3 số sum (int)
	 */
	public static int q3SumOfThree(Scanner scan) {
		int sum = 0;
		int[]userNum = new int[3];
		String userInput;
		
		for(int i=0; i<userNum.length; i++) {
			do {
				System.out.print("Nhập số thứ " + (i+1) + ": ");
				userInput = scan.nextLine();
			}while(userInput.equals("") || userInput.isEmpty() || userInput.isBlank()
					|| userInput.chars().allMatch(Character::isAlphabetic));
			
			userNum[i] = Integer.parseInt(userInput);
			
			sum += userNum[i];
		}
		
		return sum;
	}
	
	/*
	 * Bài 04 - Cộng/ trừ/ nhân/ chia số nguyên khác 0
	 * Input: người dùng chọn option từ bàn phím: 1 - cộng, 2 - trừ, 3 - nhân, 4 - chia
	 * Return: kết quả phép tính xuất ra console
	 */
	public static void q4SimpleCalculator(Scanner scan) {
		double calResult = 0;
		int calNum1, calNum2 = 0, cal;
		int isContinue = 0;
		String keyInput, calPrint = "";
		
		boolean isRunning = false;
		
		do {
			//Nhập số 1
			do {
				System.out.print("Nhập số 1: ");
				keyInput = scan.nextLine();
			}while(keyInput.equals("") || keyInput.isEmpty() || keyInput.isBlank()
					|| keyInput.chars().allMatch(Character::isAlphabetic)
					|| Integer.parseInt(keyInput) < 0);
			
			calNum1 = Integer.parseInt(keyInput);
			
			// Chọn phép tính
			do {
				System.out.print("Phép tính (1-cộng, 2-trừ, 3-nhân, 4-chia): ");
				keyInput = scan.nextLine();
			}while(keyInput.equals("") || keyInput.isEmpty() || keyInput.isBlank()
					|| keyInput.chars().allMatch(Character::isAlphabetic)
					|| (Integer.parseInt(keyInput) != 1 && Integer.parseInt(keyInput) != 2
					    && Integer.parseInt(keyInput) != 3 && Integer.parseInt(keyInput) != 4));
			
			cal = Integer.parseInt(keyInput);
			
			//Nhập số 2
			do {
				System.out.print("Nhập số 2: ");
				keyInput = scan.nextLine();
			}while(keyInput.equals("") || keyInput.isEmpty() || keyInput.isBlank()
					|| keyInput.chars().allMatch(Character::isAlphabetic)
					|| Integer.parseInt(keyInput) < 0);
			
			calNum2 = Integer.parseInt(keyInput);
			
			//Tính toán kết quả
			switch(cal) {
				case 1:	
					calPrint = calNum1 + "+" + calNum2;
					calResult = calNum1 + calNum2;
					break;
				case 2:
					calPrint = calNum1 + "-" + calNum2;
					calResult = calNum1 - calNum2;
					break;
				case 3:
					calPrint = calNum1 + "*" + calNum2;
					calResult = calNum1 * calNum2;
					break;
				case 4:
					calPrint = calNum1 + "/" + calNum2;
					calResult = calNum1 / calNum2;
					break;
				default:
					calResult = -1;
					break;
			}

			System.out.println("Kết quả: " + calPrint + " = " + calResult);
			System.out.println("----------");
			
			//Hỏi người dùng có muốn tiếp tục xài máy tính
			do {
				System.out.print("Bạn có muốn tiếp tục (0-không, 1-có): ");
				keyInput = scan.nextLine();
			}while(keyInput.equals("") || keyInput.isBlank() || keyInput.isEmpty()
					|| keyInput.chars().allMatch(Character::isAlphabetic));
			
			isContinue = Integer.parseInt(keyInput);
			
			switch(isContinue) {
				case 0:
					isRunning = false;
					System.out.println("Máy tính kết thúc!");
					break;
				case 1:
					isRunning = true;
					break;
				default:
					isRunning = true;
					break;
			}
		}while(isRunning == true);
	}
	
	/*
	 * Bài 05 - Xuất tên & năm sinh của sinh viên trẻ nhất
	 * Input: tên & năm sinh của 3 sinh viên từ bàn phím
	 * Return: String stuInfo: tên & năm sinh của sinh viên trẻ nhất
	 */
	public static String q5YoungestStu(Scanner scan) {
		String youngestStu = "", input = "", stuInfo = "";
		String[] stuNames = new String[3];
		int maxYear = 0;
		int[] stuYears = new int[3];
		
		
		for(int i=0; i<stuNames.length; i++) {
			// Nhập tên của 3 sinh viên
			do {
				System.out.print("Nhập tên sinh viên thứ " + (i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty());
			
			stuNames[i] = input;
			
			// Nhập năm sinh của 3 sinh viên
			do {
				System.out.print("Năm sinh của sinh viên thứ " + (i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty()
					|| input.chars().allMatch(Character::isAlphabetic)
					|| Integer.parseInt(input) < 0);
			
			stuYears[i] = Integer.parseInt(input);
			
			System.out.println("----------");
			
			//Tìm năm sinh nhỏ nhất và tên sinh viên tương ứng
			if(maxYear < stuYears[i]) {
				maxYear = stuYears[i];
				youngestStu = stuNames[i];
			}
		}
		
		stuInfo = youngestStu + ", năm sinh: " + maxYear;
		
		return stuInfo;
	}
	
	/*
	 * Bài 06 - Bao nhiêu số lẻ & bao nhiêu số chẵn
	 * Input: 3 số nguyên nhập từ bàn phím
	 * Return: String listEvenAndOdd - danh sách số chẵn & lẻ
	 */
	public static String q6ListEvenAndOdd(Scanner scan) {
		String listEvenAndOdd = "", listEven = "", listOdd = "", 
				evenOut = "", oddOut = "", userInput = "";
		int evenCount = 0, oddCount = 0;
		int[] inputNums = new int[3];
		
		for(int i=0; i<inputNums.length; i++) {
			do {
				System.out.print("Nhập số thứ " + (i+1) + ": ");
				userInput = scan.nextLine();
			}while(userInput.equals("") || userInput.isBlank() || userInput.isEmpty()
					|| userInput.chars().allMatch(Character::isAlphabetic)
					|| Integer.parseInt(userInput) < 0);
			
			inputNums[i] = Integer.parseInt(userInput);
			
			if(inputNums[i]%2 == 0) {
				evenCount++;
				listEven += inputNums[i] + ", ";
			}else {
				oddCount++;
				listOdd += inputNums[i] + ", ";
			}
		}
		
		// Bỏ dấu phẩy cuối chuỗi
		listEven = listEven.replaceAll(", $", "");
		listOdd = listOdd.replaceAll(", $", "");
		
		if(evenCount == 0) {
			evenOut = "Có " + evenCount + " số chẵn.";
		}else {
			evenOut = "Có " + evenCount + " số chẵn, cụ thể là: " + listEven;
		}
		
		if(oddCount == 0) {
			oddOut = "Có " + oddCount + " số lẻ.";
		}else {
			oddOut = "Có " + oddCount + " số lẻ, cụ thể là: " + listOdd;
		}
		
		listEvenAndOdd = evenOut + "\n" + oddOut;
 		
		return listEvenAndOdd;
	}
	
	/*
	 * Bài 07 - Tìm và in tên cán bộ nam trẻ nhất
	 * Input: Tên, năm sinh, giới tính nhập từ bàn phím
	 * Return: String officerInfo thông tin cán bộ nam trẻ nhất
	 */
	public static String q7YoungestOfficer(Scanner scan) {
		String youngestOfficer = "", officerGender = "", input = "", officerInfo = "";
		String[] offrNames = new String[3];
		String[] offrGenders = new String[3];
		
		int maxYear = 0;
		int[] offrYears = new int[3];
		
		
		for(int i=0; i<offrNames.length; i++) {
			// Nhập tên của 3 cán bộ
			do {
				System.out.print("Nhập tên cán bộ thứ " + (i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty());
			
			offrNames[i] = input;
			
			// Nhập năm sinh của 3 cán bộ
			do {
				System.out.print("Năm sinh của cán bộ thứ " + (i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty()
					|| input.chars().allMatch(Character::isAlphabetic)
					|| Integer.parseInt(input) < 0);
			
			offrYears[i] = Integer.parseInt(input);
			
			// Nhập giới tính của 3 cán bộ
			do {
				System.out.print("Giới tính của cán bộ thứ " + (i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty()
					|| (!"Nam".equals(input) && !"Nữ".equals(input) && !"Khác".equals(input)));
			
			offrGenders[i] = input;
			
			System.out.println("----------");
			
			//Tìm cán bộ nam -> tìm năm sinh nhỏ nhất -> tìm họ tên & giới tính
			if("Nam".equals(offrGenders[i])) {
				if(maxYear < offrYears[i]) {
					maxYear = offrYears[i];
					youngestOfficer = offrNames[i];
					officerGender = offrGenders[i];
				}
			}
		}
		
		officerInfo = youngestOfficer + ", năm sinh: " + maxYear + ", giới tính: " + officerGender;
		
		return officerInfo;
	}
	
	/*
	 * Bài 08 - Tên sinh viên ở xa trường học nhất
	 * Input: Tên & tọa độ 3 sinh viên nhập từ bàn phím
	 * Return: String stuInfo - thông in sinh viên ở xa trường nhất
	 * Công thức tính khoảng cách giữa 2 điểm: sqrt((x2-x1)^2 + (y2-y1)^2)
	 */
	public static String q8FarthestStu(Scanner scan) {
		String farthestStu = "", input = "";
		int SCHOOL_X = 0, SCHOOL_Y = 0; //Tọa độ x, y của trường (0, 0)
		int STU_NUMS = 3; //Số lượng sinh viên
		double maxDistance = 0;
		
		String[] stuNames = new String[3];
		int[] stuXCoords = new int[STU_NUMS]; //Mảng chứa tọa độ x của 3 sinh viên
		int[] stuYCoords = new int[STU_NUMS]; //Mảng chứa tọa độ y của 3 sinh viên
		double[] stuDistances = new double[3]; //Mảng chứa khoảng cách đến trường của 3 sinh viên
		
		for(int i=0; i<STU_NUMS; i++) {
			//Nhập tên của 3 sinh viên
			do {
				System.out.print("Nhập tên sinh viên thứ " +(i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty());
			
			stuNames[i] = input;
			
			//Nhập tọa độ x của 3 sinh viên
			do {
				System.out.print("Tọa độ x của sinh viên thứ " + (i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty()
					|| input.chars().allMatch(Character::isAlphabetic));
			
			stuXCoords[i] = Integer.parseInt(input);
			
			//Nhập tọa độ y của 3 sinh viên
			do {
				System.out.print("Tọa độ y của sinh viên thứ " + (i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty()
					|| input.chars().allMatch(Character::isAlphabetic));
			
			stuYCoords[i] = Integer.parseInt(input);
			
			//Tính quãng đường từ trường (SCHOOL_X, SCHOOL_Y) đến tọa độ (x, y) của 3 sinh viên
			stuDistances[i] = Math.sqrt( (Math.pow((stuXCoords[i] - SCHOOL_X), 2)) 
					+ (Math.pow((stuYCoords[i] - SCHOOL_Y), 2)));
			
			if(maxDistance < stuDistances[i]) {
				maxDistance = stuDistances[i];
				farthestStu = stuNames[i];
			}
		}
		
		return "Sinh viên xa trường nhất: " + farthestStu + ". Khoảng cách: " + maxDistance;
	}
}
