package Leetcode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length==0)
			return "";
		int index=0;int minlength=1000000;
		for (int i = 0; i < strs.length; i++) {
			String string = strs[i];
			if (string.length()<minlength) {
				minlength=string.length();
				index=i;
			}
		}
		String compString=strs[index];
		String compString2=compString;
		boolean checkflag=true;
		for (int i = minlength; i >0; i--) {
			checkflag=true;
			compString2=compString.substring(0,i);
			for (int j = 0; j < strs.length; j++) {
				String string = strs[j];
				if (!string.substring(0, i).equals(compString2)){
					checkflag=false;
					break;
				}
			}
			if (checkflag==true) break;
			
		}
		if (checkflag==false)
			return "";
		else return compString2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix commonPrefix=new LongestCommonPrefix();
		String[] strings = {"abe","abcd","abcde","abcdef"};
		String string=commonPrefix.longestCommonPrefix(strings);
		System.out.println(string);
	}

}
