import java.util.ArrayList;

public class Registry {

	ArrayList<Communication> comms = new ArrayList<Communication>();
	ArrayList<Suspect> suspects = new ArrayList<Suspect>();

	public void addSuspect(Suspect aSuspect) {
		suspects.add(aSuspect);
	}
	
	public void addCommunication(Communication aCommunication){
		comms.add(aCommunication);
		Suspect s1 = findSuspectViaNumber(aCommunication.getNum1());
		Suspect s2 = findSuspectViaNumber(aCommunication.getNum2());
		s1.makeConnection(s2);
		s2.makeConnection(s1);
	}
	
	private Suspect findSuspectViaNumber(String num) {
		for(Suspect i:suspects){
			ArrayList<String> Numbers = new ArrayList<String>();
			Numbers = i.getPhoneNumbers();
			for(String n:Numbers) {
				if(n == num) return i;
			}
		}
		return null;
	}
	
	public Suspect getSuspectWithMostPartners() {
		Suspect maxSuspect = null;
		int maxNums=-1;
		for(Suspect s:suspects) {
			int i = s.getPartners().size();
			if(i >= maxNums) {
				maxNums = i;
				maxSuspect = s;
			}
		}
	return maxSuspect;
	}	
	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
		PhoneCall longestCall=null;
		int duration=-1;
		for(Communication i:comms) {
			if(i instanceof PhoneCall && ((i.getNum1() == number1 && i.getNum2() == number2)
					|| (i.getNum1() == number2 && i.getNum2()==number1))) {
				PhoneCall j = (PhoneCall)i;
				if(j.getDuration()>duration) {
					longestCall=j;
					duration = j.getDuration();
				}
			}
		}
		
		return longestCall;
	}
	
	public ArrayList<SMS> getMessagesBetween(String number1, String number2){
		ArrayList<SMS> messages = new ArrayList<SMS>();
		for(Communication i:comms) {
			if(i instanceof SMS && ((i.getNum1() == number1 && i.getNum2() == number2)
					|| (i.getNum1() == number2 && i.getNum2()==number1))) {
				SMS j = (SMS) i;
				if(j.getText().contains("Bomb") || j.getText().contains("Explosives") ||
						j.getText().contains("Attack") || j.getText().contains("Gun"))
					messages.add(j);
			}
		}
		
		return messages;
	}
	
	public void printSuspectsFromCountry(String country) {
		for(Suspect i:suspects) {
			if(i.getCountry()==country)
				System.out.println(i.getName() +"(" +i.getNickname() +")");
		}
	}
}

