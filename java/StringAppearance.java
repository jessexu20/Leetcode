import java.util.*;
public class StringAppearance{
	public int appear(String a, String b){
		Set<Character> set = new HashSet();
		for(int i = 0; i< b.length();i++){
			set.add(b.charAt(i));
		}
		for(int i = 0; i < a.length(); i++){
			if(set.contains(a.charAt(i))) return i;
		}
		return -1;
	}
	public static void main(String args[]){
		StringAppearance sa = new StringAppearance();
		System.out.println(sa.appear("favafa","dafa"));
	}
}