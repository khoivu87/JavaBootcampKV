/**
 * Cybersoft - Java Bootcamp 03
 * Bài tập Buổi 08 Bài tập hướng đối tượng
 * Câu 01 & 02
 * Deadline: 03/08/2023
 * Author: Vũ Kim Khôi
 */
package homework06_KV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BT06_BaiTapOOP__Cau01_02_VuKimKhoi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//-----Câu 01 & 02-----
		double delta = 0;
		List<Double> xNums = new ArrayList<Double>();
		
		//Phương trình 01: x^2 - 3x - 4
		Equation fEquation = new Equation(1, -3, -4);
		
		System.out.println("----------");
		delta = fEquation.calcDelta();
		xNums = fEquation.calcXNum(delta);
		
		System.out.println("Delta: " + delta);
		resultPrint(xNums); //4 & -1 ;
		
		//Phương trình 02: x^2 + 5x + 6 nhập a, b, c từ bàn phím
		System.out.println("----------");
		Equation sEquation = new Equation();
		sEquation = equationCreate(scan, sEquation);
		
		System.out.println("----------");
		delta = sEquation.calcDelta();
		xNums = sEquation.calcXNum(delta);
		
		System.out.println("Delta: " + delta);
		resultPrint(xNums); // -2 & -3;
		
		scan.close();
	}
	
	/*
	 * Câu 01 & 02
	 * Hàm cho phép người dùng nhập 3 số a, b, c từ bàn phím
	 */
	public static String[] numUserInput(Scanner scan) {
		String input = "";
		String[] numVar = new String[]{"số A", "số B", "số C"};
		String[] outputs = new String[numVar.length];
		
		for(int i=0; i<numVar.length; i++) {
			// Nhập 3 số a, b, c
			do {
				System.out.print("Xin nhập " + numVar[i] + ": ");
				input = scan.nextLine();
			}while(input.equals("") || input.isBlank() || input.isEmpty()
					|| input.chars().allMatch(Character::isAlphabetic)
					|| !input.matches("\\d+"));
			
			outputs[i] = input;
		}
		
		return outputs;
	}
	
	/*
	 * Câu 01 & 02
	 * Hàm xuất thông tin kết quả phương trình
	 */
	public static void resultPrint(List<Double> xNums) {
		System.out.println("-----Kết quả phương trình-----");
		for(int i=0; i<xNums.size(); i++) {
			System.out.println("x" + (i+1) + ": " + xNums.get(i));
		}
	}
	
	/*
	 * Câu 01 & 02
	 * Hàm cho phép người dùng tạo MỘT phương trình
	 * Gọi hàm numUserInput để người dùng nhập thông tin từ bàn phím
	 * Return: Equation equation (1 object phương trình)
	 */
	public static Equation equationCreate(Scanner scan, Equation equation) {
		String[] info = numUserInput(scan);
		equation = new Equation();
		
		equation.setaNum(Double.parseDouble(info[0]));
		equation.setbNum(Double.parseDouble(info[1]));
		equation.setcNum(Double.parseDouble(info[2]));
		
		return equation;
	}
}
