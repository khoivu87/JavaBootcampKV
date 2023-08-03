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

public class Equation {
	private double aNum;
	private double bNum;
	private double cNum;
	
	public Equation(double aNum, double bNum, double cNum) {
		super();
		this.aNum = aNum;
		this.bNum = bNum;
		this.cNum = cNum;
	}
	
	public Equation() {
		
	}

	public void setaNum(double aNum) {
		this.aNum = aNum;
	}
	
	public double getaNum() {
		return aNum;
	}
	
	public void setbNum(double bNum) {
		this.bNum = bNum;
	}
	
	public double getbNum() {
		return bNum;
	}
	
	public void setcNum(double cNum) {
		this.cNum = cNum;
	}
	
	public double getcNum() {
		return cNum;
	}
	
	public double calcDelta() {
		double delta = 0;
		
		//D = b^2 - 4ac
		delta = Math.pow(this.bNum, 2) - (4 * this.aNum * this.cNum);
		
		return delta;
	}
	
	public List<Double> calcXNum(double delta) {
		List<Double> xNums = new ArrayList<Double>();
		double x1, x2;
		
		if(delta > 0) {
			// [-b +- sqrt(delta)] / 2a
			x1 = (-this.bNum + Math.sqrt(delta)) / (2 * this.aNum);
			x2 = (-this.bNum - Math.sqrt(delta)) / (2 * this.aNum);
			
			xNums.add(x1);
			xNums.add(x2);
		}else if (delta == 0) {
			// -b / 2a
			x1 = (-this.bNum) / (2 * this.aNum);
			x2 = (-this.bNum) / (2 * this.aNum);
			
			xNums.add(x1);
			xNums.add(x2);
		}else {
			// x could not be found/ imaginary
			x1 = -1;
			x2 = -1;
			
			xNums.add(x1);
			xNums.add(x2);
		}
		
		return xNums;
	}
}
