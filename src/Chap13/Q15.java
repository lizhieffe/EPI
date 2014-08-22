package Chap13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q15 {
	public String[][] pairUsers(ArrayList<User> users) {
		ArrayList<Pair> result = new ArrayList<Pair>();
		if (users == null || users.size() <= 1)
			return null;
		
		HashMap<String, String> tmp = new HashMap<String, String>();
		
		for (User user : users) {
			
			String[] interests = new String[user.interest.size()];
			for (int i = 0; i < interests.length; i ++)
				interests[i] = user.interest.get(i);
			Arrays.sort(interests);
			
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < interests.length; i ++)
				builder.append(interests[i]);
			
			String allInterests = builder.toString();
			
			if (tmp.containsKey(allInterests)) {
				result.add(new Pair(tmp.get(allInterests), user.id));
				tmp.remove(allInterests);
			}
			else
				tmp.put(allInterests, user.id);
		}
		
		String[][] output = new String[result.size()][2];
		for (int i = 0; i < output.length; i ++) {
			output[i][0] = result.get(i).user1;
			output[i][1] = result.get(i).user2;
		}
		
		return output;
	}
	
	class Pair {
		String user1;
		String user2;
		Pair (String user1, String user2) {
			this.user1 = user1;
			this.user2 = user2;
		}
	}
}
