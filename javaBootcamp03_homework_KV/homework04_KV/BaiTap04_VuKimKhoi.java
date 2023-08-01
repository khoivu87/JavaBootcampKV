/**
 * Cybersoft - Java Bootcamp 03
 * Bài tập Buổi 07 - Deadline: 02/08/2023
 * Author: Vũ Kim Khôi
 */
package homework04_KV;

import java.util.Scanner;

public class BaiTap04_VuKimKhoi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] userNums;
		
		userNums = userNumsInput(scan);
		
		qAOptionSelect(scan, userNums);

	}
	
	/*
	 * Người dùng nhập vào n số nguyên và lưu trong mảng
	 */
	public static int[] userNumsInput(Scanner scan) {
		int size;
		int[] userNums;
		String input;
		
		do {
			System.out.print("Bạn muốn nhập bao nhiêu số nguyên? Vui lòng ghi rõ: ");
			input = scan.nextLine();
		}while(input.equals("") || input.isBlank() || input.isEmpty()
				|| input.chars().allMatch(Character::isAlphabetic)
				|| Integer.parseInt(input) <= 0);
		
		size = Integer.parseInt(input);
		userNums = new int[size];
		
		for(int i=0; i<userNums.length; i++) {
			do {
				System.out.print("Nhập số nguyên thứ " + (i+1) + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty()
					|| input.chars().allMatch(Character::isAlphabetic));
			
			userNums[i] = Integer.parseInt(input);
		}
		
		return userNums;
	}
	
	/*
	 * Câu a - Menu chọn các option từ b đến k
	 */
	public static void qAOptionSelect(Scanner scan, int[] inputNums) {
		String input = "";
		
		do {
			System.out.print("Vui lòng chọn chức năng muốn thực hiện (b đến k): ");
			input = scan.nextLine();
		}while(input.equals("") || input.isBlank() || input.isEmpty());
		
		switch(input) {
			case "b":
				qBSumPositiveOpt(inputNums);
				break;
			case "c":
				qCSumOddOpt(inputNums);
				break;
			case "d":
				qDCountPositiveOpt(inputNums);
				break;
			case "e":
				qEMinNumsOpt(inputNums);
				break;
			case "f":
				qFMinPositiveOpt(inputNums);
				break;
			case "g":
				qGLastEvenOpt(inputNums);
				break;
			case "h":
				qHFirstEvenOpt(inputNums);
				break;
			case "i":
				qIFirstPrimeOpt(inputNums);
				break;
			case "j":
				qJLastRealPositiveOpt(inputNums);
				break;
			case "k":
				qKMinEvenOpt(inputNums);
				break;
			default:
				qAOptionSelect(scan, inputNums);
				break;
		}
	}
	
	/*
	 * Câu b - Tính tổng các số dương
	 */
	public static void qBSumPositiveOpt(int[] inputNums) {
		int sumPositive = 0;
		
		System.out.println("-----Câu b-----");
		
		for(int num:inputNums) {
			sumPositive += findPositive(num);
		}
		
		System.out.println("Tổng các số dương trong mảng: " + sumPositive);
	}
	
	/*
	 * Tìm số dương
	 */
	public static int findPositive(int inputNum) {
		if(inputNum > 0) {
			return inputNum;
		}
		
		return 0;
	}
	
	/*
	 * Câu c - Tính tổng các số lẻ
	 */
	public static void qCSumOddOpt(int[] inputNums) {
		int sumOdd = 0;
		
		System.out.println("-----Câu c-----");
		
		for(int num:inputNums) {
			if(findOdd(num) != 0) {
				sumOdd += num;
			}
		}
		
		System.out.println("Tổng các số lẻ trong mảng: " + sumOdd);
	}
	
	/*
	 * Tìm số lẻ
	 */
	public static int findOdd(int inputNum) {
		if(inputNum%2 != 0) {
			return inputNum;
		}
		
		return 0;
	}
	
	/*
	 * Câu d - Đếm số dương
	 */
	public static void qDCountPositiveOpt(int[] inputNums) {
		int countPositive = 0;
		
		System.out.println("-----Câu d-----");
		
		for(int num:inputNums) {
			if(findPositive(num) != 0) {
				countPositive ++;
			}
		}
		
		System.out.println("Có " + countPositive + " số dương trong mảng.");
	}
	
	/*
	 * Câu e - Tìm số nhỏ nhất trong mảng
	 */
	public static void qEMinNumsOpt(int[] inputNums) {
		int minNum = inputNums[0];
		
		System.out.println("-----Câu e-----");
		
		for(int num:inputNums) {
			minNum = findMinNum(num, minNum);
		}
		
		System.out.println("Số nhỏ nhất trong mảng là: " + minNum);
	}
	
	/*
	 * Tìm số nhỏ nhất
	 */
	public static int findMinNum(int inputNum, int minNum) {
		if(minNum > inputNum) {
			minNum = inputNum;
		}
		
		return minNum;
	}
	
	/*
	 * Câu f - Tìm số dương nhỏ nhất trong mảng
	 */
	public static void qFMinPositiveOpt(int[] inputNums) {
		int minPositive = findFirstPositive(inputNums);
		
		System.out.println("-----Câu f-----");
		
		for(int num:inputNums) {		
			if(findPositive(num) != 0) {
				minPositive = findMinNum(num, minPositive);
			}
		}
		
		System.out.println("Số dương nhỏ nhất trong mảng là: " + minPositive);
	}
	
	/*
	 * Tìm số dương đầu tiên
	 */
	public static int findFirstPositive(int[] inputNums) {
		int fPositive = 0;
		
		for(int num:inputNums) {
			if(num > 0) {
				fPositive = num;
				break;
			}
		}
		
		return fPositive;
	}
	
	/*
	 * Câu g - Tìm số chẵn cuối cùng trong mảng số nguyên
	 * Nêu không có số chẵn thì trả về -1
	 */
	public static void qGLastEvenOpt(int[] inputNums) {
		int lastEven = 0;
		
		System.out.println("-----Câu g-----");
		
		lastEven = findLastEven(inputNums);		
		if(lastEven == -1) {
			System.out.println(lastEven + ": không tìm thấy số chẵn");
		}else {
			System.out.println("Số chẵn cuối cùng là: " + lastEven);
		}
	}
	
	/*
	 * Tìm số chẵn cuối cùng
	 */
	public static int findLastEven(int[] inputNums) {
		int lastEven = 0;
		
		for(int i=(inputNums.length)-1; i>=0; i--) {
			if(inputNums[i]%2 == 0) {
				lastEven = inputNums[i];
				break;
			}else {
				lastEven = -1;
			}
		}
		
		return lastEven;
	}
	
	/*
	 * Câu h - Tìm số chẵn đầu tiên trong mảng số nguyên
	 * Nếu không có số chẵn thì trả về -1
	 */
	public static void qHFirstEvenOpt(int[] inputNums) {
		int firstEven = 0;
		
		System.out.println("-----Câu h-----");
		
		firstEven = findFirstEven(inputNums);		
		if(firstEven == -1) {
			System.out.println(firstEven + ": không tìm thấy số chẵn");
		}else {
			System.out.println("Số chẵn đầu tiên là: " + firstEven);
		}
	}
	
	/*
	 * Tìm số chẵn đầu tiên
	 */
	public static int findFirstEven(int[] inputNums) {
		int fEven = 0;
		
		for(int num:inputNums) {
			if(num%2 == 0) {
				fEven = num;
				break;
			}else {
				fEven = -1;
			}
		}
		
		return fEven;
	}
	
	/*
	 * Câu i - Tìm số nguyên tố đầu tiên trong mảng (prime number) số nguyên
	 * Trả về -1 nếu không tìm thấy số nguyên tố
	 * Ex: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
	 */
	public static void qIFirstPrimeOpt(int[] inputNums) {
		int firstPrime = 0;
		
		System.out.println("-----Câu i-----");
		
		firstPrime = findFirstPrime(inputNums);		
		if(firstPrime == -1) {
			System.out.println(firstPrime + ": không tìm thấy số nguyên tố");
		}else {
			System.out.println("Số nguyên tố đầu tiên là: " + firstPrime);
		}
	}
	
	/*
	 * Tìm số nguyên tố đầu tiên
	 */
	public static int findFirstPrime(int[] inputNums) {
		int fPrime = 0;
		
		for(int num:inputNums) {
			if(isPrime(num)) {
				fPrime = num;
				break;
			}else {
				fPrime = -1;
			}
		}
		
		return fPrime;
	}
	
	/*
	 * Check có phải số nguyên tố hay không
	 */
	public static boolean isPrime(int inputNum) {
		
		if(inputNum <= 1) {
			return false;
		}else {
			for(int i=2; i<=Math.sqrt(inputNum); i++) {
				if(inputNum%i == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/*
	 * Câu j - Tìm số dương cuối trong mảng số thực
	 * Nếu tìm không thấy số dương thì trả về -1
	 */
	public static void qJLastRealPositiveOpt(int[] inputNums) {
		double lastRealPositive = 0;
		
		System.out.println("-----Câu j-----");
		
		lastRealPositive = findLastRealPositive(inputNums);
		
		if(lastRealPositive == -1) {
			System.out.println(lastRealPositive + ": không tìm thấy số thực dương");
		}else {
			System.out.println("Số thực cuối cùng là: " + lastRealPositive);
		}
	}
	
	/*
	 * Tìm số dương trong mảng số thực
	 */
	public static double findLastRealPositive(int[] inputNums) {
		double lastRealPositive = 0;
		
		for(int i=(inputNums.length)-1; i>=0; i--) {
			if(inputNums[i] > 0) {
				lastRealPositive = Double.valueOf(inputNums[i]);
				break;
			}else {
				lastRealPositive = -1;
			}
		}
		
		return lastRealPositive;
	}
	
	
	/*
	 * Câu k - Tìm số chẵn nhỏ nhất trong mảng số nguyên
	 * Nếu không có số chẵn thì trả về -1
	 */
	public static void qKMinEvenOpt(int[] inputNums) {
		int minEven = findFirstEven(inputNums);
		int temp = -1;
		
		System.out.println("-----Câu k-----");
		
		for(int num:inputNums) {		
			if(findEven(num) != 0) {
				minEven = findMinNum(num, minEven);
				temp = 0;
			}
		}
		
		if(temp == -1) {
			System.out.println(temp + ": không tìm thấy số chẵn");
		}else {
			System.out.println("Số chẵn nhỏ nhất trong mảng là: " + minEven);
		}
	}
	
	/*
	 * Tìm số chẵn
	 */
	public static int findEven(int inputNum) {
		if(inputNum%2 == 0) {
			return inputNum;
		}
		
		return 0;
	}
 }
