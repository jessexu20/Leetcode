import java.util.*;
public class WordBreakII {
	public boolean wordBreakI(String s, Set<String> dict) {
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
	
    public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res= new ArrayList<String>();
		if(wordBreakI(s,wordDict))
        	generateString(res,"",s,wordDict,0);
		return res;
    }
	public void generateString(List<String> list,String str,String s,Set<String> wordDict,int start){
		if(start==s.length()){
			list.add(str.substring(0,str.length()-1));
			return;
		}
		for(int i=start+1;i<=s.length();i++){
			String temp=s.substring(start,i);
			if(wordDict.contains(temp)){
				generateString(list,str+temp+" ",s,wordDict,i);
			}
		}
	}
	public static void main(String args[]){
		WordBreakII wb= new WordBreakII();
		Set <String> set= new HashSet();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		System.out.println(wb.wordBreak("catsanddog",set));
	}
	
}