
public class PhoneCall extends Communication {
	
	
	int duration;

	public PhoneCall(String num1, String num2, int day, int month, int year, int duration) {
		super(num1, num2, day, month, year);
		this.duration = duration;
	}
	
	public void printInfo() {
		System.out.println("This phone call has the following info");
		super.printInfo();
		System.out.println("Duration: " +duration);
		
	}
	
	public int getDuration() {
		return duration;
	}
}
