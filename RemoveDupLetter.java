import java.util.*;
public class RemoveDupLetter {
	public String removeDuplicateLetters(String s) {
		int [] letter = new int[26];
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			letter[c-'a']++;
		}
		if(s.length()<1) return "";
		int pos = 0;
		for(int i = 0; i<s.length();i++){
			char c = s.charAt(i);
			if(c < s.charAt(pos)) pos = i;//make sure pos is the smallest
			if(--letter[c-'a']==0) break;//has to dynamically check if the letter exists in the later string!! bbacc case
		}
		return s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));//remove the current letter in the later string
	}
	public static void main(String args[]){
		RemoveDupLetter rdl = new RemoveDupLetter();
		System.out.println(rdl.removeDuplicateLetters("bbacc"));
	}
}