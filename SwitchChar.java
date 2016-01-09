import java.util.*;
public class SwitchChar{
	public int[] switchChar(String src, String dst){
		int [] result = new int [2];
		HashMap<Character, Integer> map = new HashMap<>();
		HashMap<Character, Integer> back = new HashMap<>();
		HashMap<String, Integer> pair = new HashMap<>();
		for(int i = 0; i < src.length(); i++){
			char s = src.charAt(i);
			char t = dst.charAt(i);
			if(s==t) continue;
			String cur = s + "->" + t;
			String rev = t + "->" + s;
			if(map.containsKey(t)){
				result[0] = map.get(t);
				result[1] = i;
			}
			map.put(s,i);
			if(back.containsKey(s)){
				result[0] = i;
				result[1] = back.get(s);
			}
			back.put(t,i);
			if(pair.containsKey(rev)){
				result[0] = pair.get(rev);
				result[1] = i;
				break;
			}
			pair.put(cur,i);
		}
		System.out.println(map);
		return result;
	}
	public static void main(String args[]){
		SwitchChar sc = new SwitchChar();
		int [] result = sc.switchChar("dbcde","ebcda");
		System.out.println(result[0]+"\t"+result[1]);
	}
}