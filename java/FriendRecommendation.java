package google;

import java.util.*;
class Friend{
	String name;
	List<Friend> friends;
	Friend(String str){
		name = str;
		friends = new ArrayList<>();
	}
}
public class FriendRecommendation {
	public List<Friend> friendRecommendation(Friend node) {
		HashMap<Friend, Integer> connection = new HashMap<>();
		for (Friend n : node.friends) {
			for (Friend rec : n.friends) {
				if (!connection.containsKey(rec))
					connection.put(rec, 0);
				connection.put(rec, connection.get(rec) + 1);
			}
		}
		System.out.println(connection);
		HashMap<Integer, List<Friend>> map = new HashMap<>();
		int max = 0;
		for (Friend n : connection.keySet()) {
			int val = connection.get(n);
			max = Math.max(val, max);
			if (!map.containsKey(val))
				map.put(val, new ArrayList<Friend>());
			map.get(val).add(n);
		}
		return map.get(max);
	}
	public static void main(String args[]){
		FriendRecommendation recommendation = new FriendRecommendation();
		Friend a = new Friend("a");
		Friend b = new Friend("b");
		Friend c = new Friend("c");
		Friend d = new Friend("d");
		Friend e = new Friend("e");
		a.friends.add(b);
		a.friends.add(c);
		b.friends.add(d);
		b.friends.add(e);
		c.friends.add(d);
		for(Friend f: recommendation.friendRecommendation(a))
			System.out.println(f.name);
	}
}
