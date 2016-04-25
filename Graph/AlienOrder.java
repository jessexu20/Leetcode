/*Alien Dictionary
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

*/

import java.util.*;

public class AlienOrder {
	public String alienOrder(String[] words) {
        HashMap<Character,Integer> inDegree = new HashMap();
        HashMap<Character,List<Character>> edges = new HashMap();
        //Init all the topo vertices
        for(int i = 0 ; i< words.length; i++){
            String temp = words[i];
            for(int j =0; j < temp.length();j++){
                if(!inDegree.containsKey(temp.charAt(j))){
                    inDegree.put(temp.charAt(j),0);
                    edges.put(temp.charAt(j),new ArrayList());
                }
            }
        }
        //Form topo logic
        for(int i = 0;i<words.length-1;i++){
            String str1 = words[i];
            String str2 = words[i+1];
            int j = 0;
            for(;j<str1.length() && j <str2.length() && str1.charAt(j)==str2.charAt(j);j++);
            if(j==Math.min(str1.length(),str2.length())) continue;//one of the string go to the end... nothing can be detected.
            //char at j is different in two string and has order.
            inDegree.put(str2.charAt(j),inDegree.get(str2.charAt(j))+1);//add b's in degree
            edges.get(str1.charAt(j)).add(str2.charAt(j));//add edge to the a->b
        }
        //topological sort
        Queue<Character> que = new LinkedList();
        for(Character c : inDegree.keySet()){
            if(inDegree.get(c)==0){
                que.offer(c);
            }
        }
        String result = "";
        while(!que.isEmpty()){
            char cur = que.poll();
            result += cur;
            List<Character> next = edges.get(cur);
            for(Character c : next){
                inDegree.put(c,inDegree.get(c)-1);
                if(inDegree.get(c)==0) que.offer(c);
            }
        }
        //Check if all the words has been sorted..
        for(Character c : inDegree.keySet()){
            if(inDegree.get(c)!=0){
                return "";
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlienOrder ao= new AlienOrder();
		String [] strs= {"wrt","wrf","er","ett","rftt"};
		System.out.println(ao.alienOrder(strs));
	}

}
