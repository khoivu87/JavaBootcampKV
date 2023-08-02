/**
 * Cybersoft - Java Bootcamp 03
 * Bài tập Buổi 08 Bài tập hướng đối tượng
 * Deadline: 03/08/2023
 * Author: Vũ Kim Khôi
 */
package homework05_KV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BT05_BaiTapHuongDoiTuong_VuKimKhoi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student stu = new Student();
		Student[] stuList;
		
		//----------Câu 01----------
		// Tạo & nhập thông tin MỘT sinh viên
		stu = stuCreate(scan, stu);
		
		// Xuất thông tin MỘT sinh viên
		oneStuPrint(stu);
		
		//----------Câu 02----------
		// Tạo & nhập thông tin NHIỀU sinh viên
		stuList = stuListCreate(scan);
		
		// Xuất thông tin NHIỀU sinh viên
		mStudentPrint(stuList);
		
		// In ra sinh viên có điểm trung bình cao nhất
		findStuMaxAvg(stuList);
		
		// In ra danh sách sinh viên xếp loại Yếu
		badStuList(stuList);
		
		// Tìm sinh viên theo tên nhập từ bàn phím
		findStudentByName(stuList, scan);
		
		// Tìm sinh viên theo MSSV nhập từ bàn phím
		findStudentByCode(stuList, scan);
		
		// Xóa sinh viên theo MSSV nhập từ bàn phím
		deleteStudentByCode(stuList, scan);
	}
	
	/*
	 * Hàm cho phép người dùng nhập thông tin SV từ bàn phím
	 * Không nhận blank/ empty, số âm hoặc lớn hơn 10
	 */
	public static String[] userInput(Scanner scan) {
		String input = "";
		String[] stuVar = new String[]{"tên sinh viên", "mã sinh viên",
				"điểm Toán", "điểm Lý", "điểm Hóa"};
		String[] outputs = new String[stuVar.length];
		
		for(int i=0; i<stuVar.length; i++) {
			// Nhập tên & mã số sinh viên
			if(i<=1) {
				do {
					System.out.print("Xin nhập " + stuVar[i] + ": ");
					input = scan.nextLine();
					
				}while(input.equals("") || input.isBlank() || input.isEmpty());
			}else {
				// Nhập điểm Toán/ Lý/ Hóa
				do {
					System.out.print("Xin nhập " + stuVar[i] + ": ");
					input = scan.nextLine();
					
				}while(input.equals("") || input.isBlank() || input.isEmpty()
						|| input.chars().allMatch(Character::isAlphabetic)
						|| Double.parseDouble(input) < 0
						|| Double.parseDouble(input) > 10);
			}
			
			outputs[i] = input;
		}
		
		return outputs;
	}
	
	/*
	 * Hàm xuất thông tin 01 sinh viên
	 */
	public static void oneStuPrint(Student stu) {
		System.out.println("Sinh viên: " + stu.getStuName()
				+ ". MSSV: " + stu.getStuCode()
				+ ". Toán: " + stu.getStuMath()
				+ ". Lý: " + stu.getStuPhysic()
				+ ". Hóa: " + stu.getStuChem()
				+ ". ĐTB: " + stu.getStuAvg() 
				+ ". Xếp loại: " + stu.getStuGrade());
	}
	
	/*
	 * Hàm xuất thông tin nhiều sinh viên
	 */
	public static void mStudentPrint(Student[] stuList) {
		for(Student stu:stuList) {
			oneStuPrint(stu);
		}
	}
	
	/*
	 * Hàm cho phép người dùng tạo MỘT sinh viên
	 * Gọi hàm userInput để người dùng nhập thông tin từ bàn phím
	 * Return: Student stu (1 object sinh viên)
	 */
	public static Student stuCreate(Scanner scan, Student stu) {
		String[] info = userInput(scan);
		stu = new Student();
		double stuAvg = 0;
		String stuGrade = "";
		
		stu.setStuName(info[0]);
		stu.setStuCode(info[1]);
		stu.setStuMath(Double.parseDouble(info[2]));
		stu.setStuPhysic(Double.parseDouble(info[3]));
		stu.setStuChem(Double.parseDouble(info[4]));
		
		stuAvg = calcStuAvg(stu.getStuMath(), stu.getStuPhysic(), stu.getStuChem());
		stuGrade = convertStuGrade(stuAvg);
		
		stu.setStuAvg(stuAvg);
		stu.setStuGrade(stuGrade);
		
		return stu;
	}
	
	/*
	 * Hàm cho phép người dùng tạo và nhập thông tin NHIỀU sinh viên
	 * Input từ bàn phím: Tên, Mã SV, Điểm Toán & Lý & Hóa
	 */
	public static Student[] stuListCreate(Scanner scan) {
		String input = "";
		int listSize = 0;
		Student[] stuList;
		
		// Nhập số lượng sinh viên muốn tạo
		System.out.println("------------------");
		do {
			System.out.print("Bạn muốn tạo bao nhiêu sinh viên: ");
			input = scan.nextLine();
		}while(input.equals("") || input.isBlank() || input.isEmpty()
				|| input.chars().allMatch(Character::isAlphabetic)
				|| Integer.parseInt(input) <= 0);
		
		listSize = Integer.parseInt(input);
		stuList = new Student[listSize];
		
		for(int i=0; i<stuList.length; i++) {
			System.out.println("------------------");
			stuList[i] = stuCreate(scan, stuList[i]);
		}
		System.out.println("--------------------");
		
		return stuList;
	}
	
	/*
	 * Hàm tính điểm trung bình Toán & Lý & Hóa
	 */
	public static double calcStuAvg(double mMath, double mPhysic, double mChem) {
		double stuAvg = 0;
		
		stuAvg = (mMath + mPhysic + mChem)/3;
		
		return stuAvg;
	}
	
	/*
	 * Hàm xếp loại sinh viên theo điểm trung bình
	 */
	public static String convertStuGrade(double mAvg) {
		String stuGrade = "";
		
		if(mAvg >= 9) {
			stuGrade = "Xuất sắc";
		}else if(mAvg < 9 && mAvg >= 8) {
			stuGrade = "Giỏi";
		}else if(mAvg < 8 && mAvg >= 7) {
			stuGrade = "Khá";
		}else if(mAvg < 7 && mAvg >= 6) {
			stuGrade = "Trung bình - Khá";
		}else if(mAvg < 6 && mAvg >= 5) {
			stuGrade = "Trung bình";
		}else {
			stuGrade = "Yếu";
		}
		
		return stuGrade;
	}
	
	/*
	 * Hàm in ra SV có điểm trung bình cao nhất
	 */
	public static void findStuMaxAvg(Student[] stuList) {
		Student maxAvgStu = new Student();
		String maxStuName = "", maxStuCode = "", maxStuGrade = "";
		double maxStuMath = 0, maxStuPhysic = 0, maxStuChem = 0;
		double maxStuAvg = stuList[0].getStuAvg();
		
		for(Student stu:stuList) {
			if(maxStuAvg <= stu.getStuAvg()) {
				maxStuName = stu.getStuName();
				maxStuCode = stu.getStuCode();
				maxStuMath = stu.getStuMath();
				maxStuPhysic = stu.getStuPhysic();
				maxStuChem = stu.getStuChem();
				maxStuAvg = stu.getStuAvg();
				maxStuGrade = stu.getStuGrade();
			}
		}
		
		maxAvgStu.setStuName(maxStuName);
		maxAvgStu.setStuCode(maxStuCode);
		maxAvgStu.setStuMath(maxStuMath);
		maxAvgStu.setStuPhysic(maxStuPhysic);
		maxAvgStu.setStuChem(maxStuChem);
		maxAvgStu.setStuAvg(maxStuAvg);
		maxAvgStu.setStuGrade(maxStuGrade);
		
		System.out.println("----------Sinh viên có điểm TB cao nhất----------");
		System.out.println("Họ tên: " + maxAvgStu.getStuName()
			+ ". Điểm trung bình: " + maxAvgStu.getStuAvg()
			+ ". Xếp loại: " + maxAvgStu.getStuGrade());
	}
	
	/*
	 * Hàm in ra các sinh viên xếp hạng yếu
	 */
	public static void badStuList(Student[] stuList) {
		List<Student> badStus = new ArrayList<Student>();
		
		for(int i=0; i<stuList.length; i++) {
			if(stuList[i].getStuGrade().equals("Yếu")) {
				badStus.add(stuList[i]);
			}
		}
		
		System.out.println("----------Danh sách sinh viên yếu----------");
		if(badStus.isEmpty()) {
			System.out.println("Không có sinh viên yếu !!!!!!");
		}else {
			for(Student stu:badStus) {
				System.out.println("Sinh viên: " + stu.getStuName()
				+ ". ĐTB: " + stu.getStuAvg() + ". Xếp loại: " + stu.getStuGrade());
			}
		}
	}
	
	/*
	 * Hàm tìm & in ra sinh viên theo tên nhập từ bàn phím
	 */
	public static void findStudentByName(Student[] stuList, Scanner scan) {
		String stuName = "";
		Student findStu = null;
		
		System.out.println("--------------------");
		do {
			System.out.print("Tên sinh viên muốn tìm: ");
			stuName = scan.nextLine();
		}while(stuName.equals("") || stuName.isBlank() || stuName.isEmpty());
		
		
		for(Student stu:stuList) {
			if(stu.getStuName().equals(stuName)) {
				findStu = new Student();
				findStu.setStuName(stu.getStuName());
				findStu.setStuCode(stu.getStuCode());
				findStu.setStuMath(stu.getStuMath());
				findStu.setStuPhysic(stu.getStuPhysic());
				findStu.setStuChem(stu.getStuChem());
				findStu.setStuAvg(stu.getStuAvg());
				findStu.setStuGrade(stu.getStuGrade());
			}
		}
		
		if(Objects.isNull(findStu)) {
			System.out.println("Không tìm thấy sinh viên có tên " + stuName + " !!!");
		}else {
			System.out.println("----------Sinh viên đã được tìm thấy----------");
			System.out.println("Họ tên: " + findStu.getStuName()
				+ ". Điểm trung bình: " + findStu.getStuAvg()
				+ ". Xếp loại: " + findStu.getStuGrade());
		}
	}
	
	/*
	 * Hàm tìm & in ra sinh viên theo tên nhập từ bàn phím
	 */
	public static void findStudentByCode(Student[] stuList, Scanner scan) {
		String stuCode = "";
		Student findStuCode = null;
		
		System.out.println("--------------------");
		do {
			System.out.print("Mã số của sinh viên muốn tìm: ");
			stuCode = scan.nextLine();
		}while(stuCode.equals("") || stuCode.isBlank() || stuCode.isEmpty());
		
		
		for(Student stu:stuList) {
			if(stu.getStuCode().equals(stuCode)) {
				findStuCode = new Student();
				findStuCode.setStuName(stu.getStuName());
				findStuCode.setStuCode(stu.getStuCode());
				findStuCode.setStuMath(stu.getStuMath());
				findStuCode.setStuPhysic(stu.getStuPhysic());
				findStuCode.setStuChem(stu.getStuChem());
				findStuCode.setStuAvg(stu.getStuAvg());
				findStuCode.setStuGrade(stu.getStuGrade());
			}
		}
		
		if(Objects.isNull(findStuCode)) {
			System.out.println("Không tìm thấy sinh viên có mã số " + stuCode + " !!!");
		}else {
			System.out.println("----------Sinh viên đã được tìm thấy----------");
			System.out.println("Họ tên: " + findStuCode.getStuName()
				+ ". MSSV: " + findStuCode.getStuCode()
				+ ". Điểm trung bình: " + findStuCode.getStuAvg()
				+ ". Xếp loại: " + findStuCode.getStuGrade());
		}
	}
	
	/*
	 * Hàm xóa 1 sinh viên theo mã
	 */
	public static void deleteStudentByCode(Student[] stuList, Scanner scan) {
		String stuCode = "";
		List<Student> updatedStuList = new ArrayList<Student>(Arrays.asList(stuList));
		
		System.out.println("--------------------");
		do {
			System.out.print("Mã số của sinh viên muốn xóa: ");
			stuCode = scan.nextLine();
		}while(stuCode.equals("") || stuCode.isBlank() || stuCode.isEmpty());
		
		for(Student stu:stuList) {
			if(stu.getStuCode().equals(stuCode)) {
				updatedStuList.remove(stu);
			}
		}
		
		if(updatedStuList.size() == stuList.length) {
			System.out.println("Không tìm thấy sinh viên có mã số " + stuCode + " !!!");
		}else {
			System.out.println("----------Danh sách sinh viên đã cập nhật----------");
			for(Student stu:updatedStuList) {
				System.out.println("Họ tên: " + stu.getStuName()
					+ ". MSSV: " + stu.getStuCode()
					+ ". Điểm trung bình: " + stu.getStuAvg()
					+ ". Xếp loại: " + stu.getStuGrade());
			}
		}
	}
}
