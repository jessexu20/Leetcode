package leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
	    boolean []bool = new boolean[s.length()+1];
	    bool[0]=true;
	    for(int i =0;i<s.length();i++){
	        for(int j =i+1;j<=s.length();j++){
	            String temp = s.substring(i,j);
	            bool[j]=bool[j] || (bool[i] && wordDict.contains(temp));// remember if it succeed before...keep it to true
	        }
	    }
	    return bool[s.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set <String>set=new HashSet<String>();
		set.add("lee");
		set.add("t");
		set.add("code");
		WordBreak wb=new WordBreak();
		System.out.println(wb.wordBreak("leetcode", set));
	}
}

