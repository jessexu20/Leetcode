import java.util.*;
public class TwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()<1) return 0;
        int i = 0,j =0,max=0;//Two pointer
        HashMap<Character,Integer> map = new HashMap();
        int count =0;
        while(i<=j && j<s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){//map already has key, fast pointer move forward
                map.put(c,map.get(c)+1);
                j++;
            }
            else{//doesn't containe key
                if(count<2){//don't have two different character
                    map.put(c,1);
                    j++;
                    count++;
                }
                else{//
                    while(count>1 && i <=j){// slow pointer need to go to satisfy the criteria
                        char x = s.charAt(i++);
                        map.put(x,map.get(x)-1);//update the map until one of the key disappear
                        if(map.get(x)==0){
                            count--;
                            map.remove(x);
                        }
                    }
                }
            }
            max=Math.max(max,j-i);//update the length
        }
        return max;
    }
	public static void main(String args[]){
		TwoDistinct td= new TwoDistinct();
		System.out.println(td.lengthOfLongestSubstringTwoDistinct("eceba"));
	}
}