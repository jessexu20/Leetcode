import java.util.*;
public class SwitchVowel {
	public String swap(String str){
		StringBuilder sb= new StringBuilder(str);
		int i = 0, j = sb.length()-1;
		while(i<j){
			if(!check(sb.charAt(i)))
				i++;
			if(!check(sb.charAt(j)))
				j--;
			if(check(sb.charAt(i)) && check(sb.charAt(j))){
				char temp= sb.charAt(i);
				sb.setCharAt(i,sb.charAt(j));
				sb.setCharAt(j,temp);
				i++;j--;
			}
		}
		return sb.toString();
	}
	public boolean check(char c){
		if(c=='a' || c == 'e' || c=='i'|| c == 'o' || c=='u')
			return true;
		else return false;
	}
	public static void main(String args[]){
		SwitchVowel sv= new SwitchVowel();
		System.out.println(sv.swap("bcd"));
	}
}