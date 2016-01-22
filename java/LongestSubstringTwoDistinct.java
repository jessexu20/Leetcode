/*
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/
public class LongestSubstringTwoDistinct {
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
}