import java.util.*;
public class WordLadder{
	public boolean diffOne(String a,String b){
		int count=0;
		for(int i=0;i<a.length();i++){
			if(a.charAt(i)!=b.charAt(i)) count++;
		}
		return count<=1 ? true: false;
	}
	public int step(String start, String end, Set<String> dict,){
		
	}
    public int ladderLength(String start, String end, Set<String> dict) {
        return 0;
    }
	public static void main(String args[]){
		WordLadder wl=new WordLadder();
		String start="hit";
		String end="cog";
		Set<String> hashset=new HashSet();
		hashset.add("hot");hashset.add("dot");hashset.add("dog");
		hashset.add("lot");hashset.add("log");
		System.out.println(wl.ladderLength(start,end,hashset));
	}
}