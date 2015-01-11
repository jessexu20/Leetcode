package leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
    	HashMap hashMap=new HashMap();
    	int count=0;
    	int max=0;
    	for (int i = 0; i < s.length(); i++) {
    		for (int j = i; j < s.length(); j++) {
    			if (hashMap.containsKey(s.charAt(j))==false) {
    				hashMap.put(s.charAt(j), 1);
    				count++;
//    				System.out.print(s.charAt(j)+"\t");
//    				System.out.println(count);
    			}
    			else {
    				hashMap.clear();
    				hashMap.put(s.charAt(j), 1);
    				count=1;
    			}
    			if (count>max)  max=count;
			}
    		hashMap.clear();
    		count=0;
		}
		return max;
    }
    public int lengthDP(String s){
    	HashMap map=new HashMap();
    	int count=0;
    	int max= 0;
    	int start=0;
    	for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),i+1);
			}
			else {
				int dup=(int) map.get(s.charAt(i));
				for (int j = start; j <dup; j++) {
//					System.out.println(s.charAt(j));
					map.remove(s.charAt(j));
					
				}
//				System.out.println(map);
				map.put(s.charAt(i), i+1);
//				System.out.println(map);
				start=dup;
			}
			count=map.size();
			if (count>max) {
				max=count;
			}
//			System.out.println(map);
//			System.out.println("start"+"\t"+"end"+"\t"+"count"+"\t"+"max");
//			System.out.println(start+"\t"+i+"\t"+count+"\t"+max);
			
		}
//    	System.out.println(map);
		return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="whtaciohordtqkvwcsgspqo";
		LongestSubstring lSubstring=new LongestSubstring();
		System.out.println(lSubstring.lengthOfLongestSubstring(string));
		System.out.println(lSubstring.lengthDP(string));
	}

}
