import java.util.*;
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? s.length(): i);
        }
        int min = Integer.MAX_VALUE;
        for(char key: map.keySet()){
            min = Math.min(min, map.get(key));
        }
        return min == s.length() ? -1 : min;
    }
	public static void main(String [] args){
		FirstUniqueCharacter fuc = new FirstUniqueCharacter();
		System.out.println(fuc.firstUniqChar("leetcode"));
		System.out.println(fuc.firstUniqChar("loveleetcode"));
		System.out.println(fuc.firstUniqChar("aabbcc"));
		
	}
}