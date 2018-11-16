import java.util.ArrayList;

final class whoEatsWhom{
	
	private String[] who;
	private String[] whom;
	public int totalRules; 
	
	whoEatsWhom(int Capacity) {
		
		who = new String[Capacity];
		whom = new String[Capacity];
		totalRules = 0;
		
	}
	
	public void add(String FullStr) throws Exception {

		if (totalRules == who.length) throw new Exception("Not enougth space in ruleset, allocate more capacity");
		String[] arr = FullStr.split(" ");
		if (arr[1].equals("eats")) {
			who[totalRules] = arr[0];
			whom[totalRules] = arr[2];
			totalRules++;
		} else 
			throw new Exception("Wrong format " + arr[0] + "_" + arr[1] + "_" + arr[2]);
		
	}
	
	//doesThisEatsThat checks if This can eat That with presetted rules
	
	public boolean doesThisEatsThat(String This, String That) {
		
		boolean found = false;
		for (int i = 0; i < who.length; i++) {
			if ((This.equals(who[i]))&&(That.equals(whom[i]))) {
					found = true;
					break;
				}
			
		}
		return found;
		
	}
}



public class ZooDisaster {
	
	public static final String rules[] = {

			"antelope eats grass",
		    "big-fish eats little-fish",
		    "bug eats leaves",
		    "bear eats big-fish",
		    "bear eats bug",
		    "bear eats chicken",
		    "bear eats cow",
		    "bear eats leaves",
		    "bear eats sheep",
		    "chicken eats bug",
		    "cow eats grass",
		    "fox eats chicken",
		    "fox eats sheep",
		    "giraffe eats leaves",
		    "lion eats antelope",
		    "lion eats cow",
		    "panda eats leaves",
		    "sheep eats grass",

	};
	
	
	public static String[] whoEatsWho(final String zoo) {
		
		ArrayList<String> out = new ArrayList<String>();
		ArrayList<String> decompose = new ArrayList<String>();
		
		out.add(zoo);
		
		whoEatsWhom checker = new whoEatsWhom(rules.length);
		for(int i = 0; i<rules.length; i++) {
			try {
				checker.add(rules[i]);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		String[] decomposeS = zoo.split(",");
		for (int i = 0; i<decomposeS.length; i++) {
			decompose.add(decomposeS[i]);
		}
		boolean someoneEaten = true;
		while(someoneEaten) {
			for(int i = 0; i < decompose.size(); i++) {
				someoneEaten = false;
				if ((i > 0) && (checker.doesThisEatsThat(decompose.get(i), decompose.get(i - 1)))) {
						out.add(decompose.get(i) + " eats " + decompose.get(i - 1));
						decompose.remove(i - 1);
						someoneEaten = true;
						break;
					}
				
				if((i < decompose.size() - 1) && (checker.doesThisEatsThat(decompose.get(i), decompose.get(i + 1)))) {
						out.add(decompose.get(i) + " eats " + decompose.get(i + 1));
						decompose.remove(i + 1);
						someoneEaten = true;
						break;
					}
				
			}
		}
		StringBuilder lastRemaining = new StringBuilder(); 
		for (int i = 0; i < decompose.size(); i++) 
			lastRemaining.append(((i!=decompose.size()-1)? decompose.get(i)+"," : decompose.get(i)));
		out.add(lastRemaining.toString());
		
		
		String[] outS = new String[out.size()];
		out.toArray(outS);
		
		return outS;
	}

}