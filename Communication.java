
public class Communication {
	
	private String num1;
	private String num2;
	private int day;
	private int month;
	private int year;
	
	public Communication(String num1, String num2, int day, int month, int year) {
		this.num1 = num1;
		this.num2 = num2;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public void printInfo() {
	System.out.println("Between "+num1 +" --- " +num2);
	System.out.println("on " +year + "/" + month + "/" + day);
	}
	
	public String getNum1() {
		return num1;
	}
	
	public String getNum2() {
		return num2;
	}
	
}
