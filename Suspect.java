import java.util.ArrayList;

public class Suspect {
	
	private String name;
	private String nickname;
	private String nativeCountry;
	private String activityCity;
	ArrayList<String> PhoneNumbers = new ArrayList<String>();
	ArrayList<Suspect> Partners = new ArrayList<Suspect>();
	
	
	
	public Suspect(String name, String nickname, String nativeCountry, String activityCity) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.nativeCountry = nativeCountry;
		this.activityCity = activityCity;
	}

	public void addNumber(String number) {
		PhoneNumbers.add(number);
	}
	
	public void makeConnection(Suspect aSuspect) {
		if(!this.isConnectedTo(aSuspect)) {
			Partners.add(aSuspect);
		}
	}
	
	public boolean isConnectedTo(Suspect aSuspect) {
		for(Suspect i:Partners)
			if(i==aSuspect) {
				return true;
			}
		return false;
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect) {
		ArrayList<Suspect> commonPartners = new ArrayList<Suspect>();
		for(Suspect i:Partners) {
			if(aSuspect.isConnectedTo(i))
				commonPartners.add(i);
		}
		return commonPartners;
	}
	
	public void printPartners() {
		System.out.println(name +"'s partners" );
		for(Suspect i:Partners) {
			if(nativeCountry==i.getNativeCountry()) 
				System.out.println(i.getName() +", " +i.getNickname() +" *");
			else 
				System.out.println(i.getName() +", " +i.getNickname());
		}
		System.out.println("-----------------------------");
	}
	
	public String getNativeCountry() {
		return nativeCountry;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public ArrayList<String> getPhoneNumbers() {
		return PhoneNumbers;
	}
	
	public ArrayList<Suspect> getPartners(){
		return Partners;
	}
	public void printData() {
		System.out.println(name +", " +nickname);
		System.out.println(nativeCountry);
		System.out.println(activityCity);
		for(String i:PhoneNumbers)
			System.out.println(i);
		for(Suspect j:Partners)
			System.out.println(j.getName());
		System.out.println("------------------------");
	}
	
	public String getCountry() {
		return nativeCountry;
	}
}

