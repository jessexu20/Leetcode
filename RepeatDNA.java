import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
public class RepeatDNA{
	public int hashcode(String s){
		HashMap<Character,Integer> x=new HashMap();
		x.put('A',1);x.put('G',2);x.put('C',3);x.put('T',4);
		int count=0;
		for(int i=0;i<10;i++){
			count+=Math.pow(4,i)*x.get(s.charAt(i));
		}
		return count;
	}
	public List<String> findRepeatedDnaSequences(String s) {
		int length=s.length();
		if(length<=10){
			List<String>res=new ArrayList<String>();
			return res;
		}
		Set<String> set= new HashSet<>();
		// HashMap<Integer,Integer> map=new HashMap<>();
		boolean maps[]=new boolean[4194305];
		int start=0;
		while(start+10<=length){
			String s1=s.substring(start,start+10);
			if(maps[hashcode(s1)])
				set.add(s1);
			else{
				maps[hashcode(s1)]=true;
			}
			start++;
		}
        return new ArrayList<String>(set);
    }
	public static void main(String args[]){
		RepeatDNA rd= new RepeatDNA();
		String str="AAAAAAAAAAA";
		System.out.println(rd.findRepeatedDnaSequences(str));
	}
}