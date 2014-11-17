package leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
//		System.out.println(dict.contains("lee"));
		boolean bool[]=new boolean [s.length()+1];
		bool[0]=true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (bool[j] && dict.contains(s.substring(j, i))) {
					bool[i]=true;
					break;
				}
			}
		}
//		for (int i = 0; i < bool.length; i++) {
//			System.out.print(bool[i]);
//			System.out.print('\t');
//		}
//		System.out.println();
		
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
