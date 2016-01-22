import java.util.*;
public class PalindromeChunk{
	int count = 0;
	public int count(String str){
		HashMap<Character, Integer> map = new HashMap();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(map.containsKey(c)){
				map.put(c,map.get(c)+1);
			}
			else map.put(c,1);
		}
		int check = 0;
		for(char c: map.keySet()){
			if(map.get(c)%2!=0)
				check++;
		}
		if(check>1) return 0;
		isPalindrome(str);
		return count;
		
	}
	public void isPalindrome(String str){
		if(str.length()==0 || str.length()==1){
			count++;
			return;
		}
		for(int i = 1; i <= str.length()/2; i++){
			String t = str.substring(0,i);
			if(str.substring(str.length()-t.length()).equals(t)){
				isPalindrome(str.substring(i,str.length()-i));
			}
		}
	}
	public static void main(String args[]){
		PalindromeChunk chunk = new PalindromeChunk();
		System.out.println(chunk.count("vovvvo"));
	}
	
}