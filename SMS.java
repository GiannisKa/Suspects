
public class SMS extends Communication {

	private String text;
	
	public SMS(String num1, String num2, int day, int month, int year, String text) {
		super(num1, num2, day, month, year);
		this.text = text;
	}
	
	public void printInfo() {
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " +text);
	}
	
	public String getText() {
		return text;
	}
}
