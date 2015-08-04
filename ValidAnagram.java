import java.util.*;
public class ValidAnagram  {
    public boolean isAnagram(String s, String t) {
        char [] schar=s.toCharArray();
		char [] tchar=t.toCharArray();
		Arrays.sort(schar);
		Arrays.sort(tchar);
		String temp1=new String(schar);
		String temp2=new String(tchar);
		return temp1.equals(temp2);
    }
	public static void main(String args[]){
		ValidAnagram va= new ValidAnagram();
		String str1="anagram";
		String str2="nagaram";
		System.out.println(va.isAnagram(str1,str2));
	}
}