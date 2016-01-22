package Leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1)
            return "";
        if(strs.length==1)
            return strs[0];
        int index=0;
        for(int i=0; i<strs.length;i++){
            if(strs[index].length()>strs[i].length()) index=i;
        }
        String temp=strs[index];
        int j =temp.length();
        for(int i =0;i<strs.length&&j>=0;i++){
            while(!temp.substring(0,j).equals(strs[i].substring(0,j))) j--;
        }
        return temp.substring(0,j);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix commonPrefix=new LongestCommonPrefix();
		String[] strings = {"abcd","b"};
		String string=commonPrefix.longestCommonPrefix(strings);
		System.out.println(string);
	}

}
