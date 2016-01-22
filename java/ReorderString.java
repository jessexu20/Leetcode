import java.util.*;
public class ReorderString{
	public static String order(String str, String dic){
		HashMap<Integer,Character> map = new HashMap<>();
		for(int i = 0; i < dic.length(); i++){
			char c = dic.charAt(i);
			map.put(map.size(),c);
		}
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> number = new HashMap<>();
		for(char c : map.values())
			number.put(c,0);
		for(int i = 0; i < str.length();i++){
			char c = str.charAt(i);
			if(number.containsKey(c))
				number.put(c,number.get(c)+1);
			else sb.append(c);
		}
		StringBuilder prev = new StringBuilder();
		for(int i = 0; i < map.size();i++){
			int cnt = number.get(map.get(i));
			while(cnt>0){
				prev.append(map.get(i));
				cnt--;
			}
		}
		return prev.append(sb).toString();
	}
	public static void main(String args[]){
		System.out.println(ReorderString.order("aaannabxxbb","can"));
	}
}