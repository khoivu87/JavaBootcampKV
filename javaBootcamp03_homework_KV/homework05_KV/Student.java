package homework05_KV;

public class Student {
	private String stuName;
	private String stuCode;
	private String stuGrade;
	private double stuMath;
	private double stuPhysic;
	private double stuChem;
	private double stuAvg;

	public Student(String stuName, String stuCode, String stuGrade, double stuMath, double stuPhysic,
			double stuChem, double stuAvg) {
		this.stuName = stuName;
		this.stuCode = stuCode;
		this.stuGrade = stuGrade;
		this.stuMath = stuMath;
		this.stuPhysic = stuPhysic;
		this.stuChem = stuChem;
		this.stuAvg = stuAvg;
	}
	
	public Student(String stuName, String stuCode, double stuMath, double stuPhysic, double stuChem) {
		this.stuName = stuName;
		this.stuCode = stuCode;
		this.stuMath = stuMath;
		this.stuPhysic = stuPhysic;
		this.stuChem = stuChem;
	}
	
	public Student() {
		
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	public String getStuName() {
		return stuName;
	}

	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}
	
	public String getStuCode() {
		return stuCode;
	}

	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}
	
	public String getStuGrade() {
		return stuGrade;
	}

	public void setStuMath(double stuMath) {
		this.stuMath = stuMath;
	}
	
	public double getStuMath() {
		return stuMath;
	}

	public void setStuPhysic(double stuPhysic) {
		this.stuPhysic = stuPhysic;
	}

	public double getStuPhysic() {
		return stuPhysic;
	}

	public void setStuChem(double stuChem) {
		this.stuChem = stuChem;
	}

	public double getStuChem() {
		return stuChem;
	}

	public void setStuAvg(double stuAvg) {
		this.stuAvg = stuAvg;
	}

	public double getStuAvg() {
		return stuAvg;
	}
}
