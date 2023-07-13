/**
 * 
 */
package homework_KV;

import java.util.Arrays;
import java.util.Scanner;

public class BaiTap01_VuKimKhoi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//-----Bài 01 start-----
		int mNum, nNum, maxNum;
		
		System.out.println("-----Bài 01-----");
		do {
			System.out.print("Nhập số m: ");
			mNum = scan.nextInt();
		}while(mNum < 0);
		
		do {
			System.out.print("Nhập số n: ");
			nNum = scan.nextInt();
		}while(nNum < 0);
		
		maxNum = q1MaxSoNguyen(mNum, nNum);
		
		System.out.println("Số nguyên lớn nhất: " + maxNum);
		scan.nextLine();
		//-----Bài 01 end-----
		
		
		//-----Bài 02 & 03 start-----
		int fNum, sNum, tNum, sortOpt;
		int[]numArray;
		
		System.out.println("-----Bài 02 & 03-----");
		do {
			System.out.print("Nhập số thứ nhất: ");
			fNum = scan.nextInt();
		}while(fNum < 0);
		
		do {
			System.out.print("Nhập số thứ hai: ");
			sNum = scan.nextInt();
		}while(sNum < 0);
		
		do {
			System.out.print("Nhập số thứ ba: ");
			tNum = scan.nextInt();
		}while(tNum < 0);
		
		do {
			System.out.print("Vui lòng chọn thứ tự sắp xếp (1-ASC; 2-DESC): ");
			sortOpt = scan.nextInt();
		}while(sortOpt < 1 || sortOpt > 2);
		
		switch(sortOpt) {
			case 1: 
				numArray = q2AscSoNguyen(fNum, sNum, tNum);
				for(int i=0; i<numArray.length; i++) {
					System.out.println("Số thứ " + (i+1) + ": " + numArray[i]);
				}
				break;
			case 2: 
				numArray = q3DescSoNguyen(fNum, sNum, tNum);
				for(int i=0; i<numArray.length; i++) {
					System.out.println("Số thứ " + (i+1) + ": " + numArray[i]);
				}
				break;
			default: 
				System.out.println("Lỗi logic");
		}
		scan.nextLine();
		//-----Bài 02 & 03 end-----
		
		//-----Bài 04 start-----
		int readNum;
		
		System.out.println("-----Bài 04-----");
		do {
			System.out.print("Vui lòng nhập số có hai chữ số (10-99): ");
			readNum = scan.nextInt();
		}while(readNum < 10 || readNum > 99);
		
		q4ReadNum(readNum);
		scan.nextLine();
		//-----Bài 04 end-----
		
		//-----Bài 05 start-----
		String user;
		
		System.out.println("-----Bài 05-----");
		
		System.out.print("Vui lòng chọn ai đang sử dựng máy (B-Bố; H-Mẹ, A-Anh trai; E-Em gái): ");
		user = scan.nextLine().toUpperCase();
		
		q5GreetUser(user);
		//-----Bài 05 end-----
		
		scan.close();
	}
	
	/*
	 * Bài 01 - tìm số nguyên lớn nhất
	 */
	public static int q1MaxSoNguyen(int mNum, int nNum) {
		int maxNNum = 0;
		
		if(mNum < 0 || nNum < 0) {
			maxNNum = -1;
		}else {
			if(mNum > nNum) {
				maxNNum = mNum;
			}else if(mNum < nNum) {
				maxNNum = nNum;
			}else {
				maxNNum = 0;
			}
		}
		
		return maxNNum;
	}
	
	/*
	 * Bài 02 - sắp xếp 3 số theo thứ tự tăng dần
	 * Dùng biến temp để kiếm số lớn nhất và đổi vị trí trong mảng
	 */
	public static int[] q2AscSoNguyen(int fNum, int sNum, int tNum) {
		int[]numArray = {fNum, sNum, tNum};
		
		for(int i=0; i<numArray.length; i++) {
			for(int j=i+1; j<numArray.length; j++) {
				int temp = 0;
				
				if(numArray[i] > numArray[j]) {
					temp = numArray[i];
					numArray[i] = numArray[j];
					numArray[j] = temp;
				}
			}
		}

		return numArray;
	}
	
	/*
	 * Bài 03 - sắp xếp 3 số theo thứ tự giảm dần
	 * Dùng biến temp để kiếm số bé nhất và đổi vị trí trong mảng
	 */
	public static int[] q3DescSoNguyen(int fNum, int sNum, int tNum) {
		int[]numArray = {fNum, sNum, tNum};
		
		for(int i=0; i<numArray.length; i++) {
			for(int j=i+1; j<numArray.length; j++) {
				int temp = 0;
				
				if(numArray[i] < numArray[j]) {
					temp = numArray[i];
					numArray[i] = numArray[j];
					numArray[j] = temp;
				}
			}
		}

		return numArray;
	}
	
	public static int[] q2AscSoNguyenOpt2(int fNum, int sNum, int tNum) {
		int[]numArray = new int[]{fNum, sNum, tNum};
		Arrays.sort(numArray);

		return numArray;
	}
	
	/*
	 * Bài 04 cách đọc số nguyên có 2 chữ số
	 */
	public static void q4ReadNum(int inNum) {
		int fDigit = inNum/10;
		int sDigit = inNum%10;
		String rFDigit = "", rSDigit = "";
		
//		System.out.println("Hàng chục: " + fDigit);
//		System.out.println("Hàng đơn vị: " + sDigit);
		
		switch(fDigit) {
			case 1: 
				rFDigit = "Mười";
				break;
			case 2:
				rFDigit = "Hai mươi";
				break;
			case 3:
				rFDigit = "Ba mươi";
				break;
			case 4:
				rFDigit = "Bốn mươi";
				break;
			case 5:
				rFDigit = "Năm mươi";
				break;
			case 6:
				rFDigit = "Sáu mươi";
				break;
			case 7:
				rFDigit = "Bảy mươi";
				break;
			case 8:
				rFDigit = "Tám mươi";
				break;
			case 9:
				rFDigit = "Chín mươi";
				break;
		}
		
		switch(sDigit) {
			case 0:
				rSDigit = "";
				break;
			case 1: 
				rSDigit = "một";
				break;
			case 2:
				rSDigit = "hai";
				break;
			case 3:
				rSDigit = "ba";
				break;
			case 4:
				rSDigit = "bốn";
				break;
			case 5:
				rSDigit = "lăm";
				break;
			case 6:
				rSDigit = "sáu";
				break;
			case 7:
				rSDigit = "bảy";
				break;
			case 8:
				rSDigit = "tám";
				break;
			case 9:
				rSDigit = "chín";
				break;
		}
		
		System.out.println("Cách đọc: " + rFDigit + " " + rSDigit);
	}
	
	/*
	 * Bài 05 chương trình "Chào hỏi" thành viên gia đình
	 */
	public static void q5GreetUser(String input) {
		switch(input) {
			case"B":
				System.out.println("Kính chào bố vĩ đại");
				break;
			case"H":
				System.out.println("Kính chào mẹ yêu dấu");
				break;
			case"A":
				System.out.println("Chào anh trai phong độ");
				break;
			case"E":
				System.out.println("Chào em gái mưa đáng iu");
				break;
			default:
				System.out.println("Ai vại? Ra chỗ khác chơi đi nà, tui kêu công an giờ!");
		}
	}
}
