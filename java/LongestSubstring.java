package leetcode;

import java.util.*;
public class LongestSubstring {
    // public int lengthOfLongestSubstring(String s) {
//     	HashMap hashMap=new HashMap();
//     	int count=0;
//     	int max=0;
//     	for (int i = 0; i < s.length(); i++) {
//     		for (int j = i; j < s.length(); j++) {
//     			if (hashMap.containsKey(s.charAt(j))==false) {
//     				hashMap.put(s.charAt(j), 1);
//     				count++;
// //    				System.out.print(s.charAt(j)+"\t");
// //    				System.out.println(count);
//     			}
//     			else {
//     				hashMap.clear();
//     				hashMap.put(s.charAt(j), 1);
//     				count=1;
//     			}
//     			if (count>max)  max=count;
// 			}
//     		hashMap.clear();
//     		count=0;
// 		}
// 		return max;
//     }
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
    public int lengthOfLongestSubstring(String s) {
        Set<Character>chars=new HashSet();
        int length=0;
        int max=0;
        int i=0,j=0;
        while(i<s.length()&&j<s.length()){
            if(chars.add(s.charAt(j++))){
                length=j-i;
                if(max<=length) max=length;
            }
            else{
                while(s.charAt(i)!=s.charAt(j-1)){
                    chars.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
        }
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
