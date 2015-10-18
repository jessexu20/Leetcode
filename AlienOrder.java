import java.util.*;

public class AlienOrder {
	HashMap<Character,List<Character>> suc =new HashMap<Character, List<Character>>();
	HashMap<Character, Integer> indegree= new HashMap<Character, Integer>();
	Set<Character> set= new HashSet<Character>();
	public String alienOrder(String[] words) {
		if(words.length<1) return "";
		for (String word: words) {
			for (int i = 0; i < word.length(); i++) {
				set.add(word.charAt(i));
			}
		}
		for(int i =0;i<words.length-1;i++){
			int j =0;
			int len1=words[i].length(),len2=words[i+1].length();
			while(j<Math.min(len1,len2) && words[i].charAt(j)==words[i+1].charAt(j))
				j++;
			if (j==Math.min(len1,len2)) continue;//till the end of the short one, the next one is same...
			//different letter
			char prev=words[i].charAt(j);
			char c = words[i+1].charAt(j);
			if(!suc.containsKey(prev)){
				List<Character> list= new ArrayList<Character>();
				list.add(c);
				suc.put(prev, list);
			} 
			else{
				if (suc.get(prev).contains(c)) {
					continue;
				}
				suc.get(prev).add(c);
			}
			if (indegree.containsKey(c)) indegree.put(c, indegree.get(c)+1);
			else indegree.put(c, 1);
		}
//		System.out.println(indegree);
//		System.out.println(suc);
		String result="";
		Queue<Character> queue=new LinkedList<Character>();
		for (Character c : set) {
			if (!indegree.containsKey(c)){
				queue.offer(c);
			}
		}
//		System.out.println(queue);
		while(!queue.isEmpty()){
			char c = queue.poll();
			result+=c;
			if (!set.remove(c)) {
				return "";
			}
			if (suc.containsKey(c)) {
				queue.addAll(suc.get(c));
			}
		}
		return set.isEmpty()?result:"";
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlienOrder ao= new AlienOrder();
		String [] strs= {"wrt","wrf","er","ett","rftt"};
		System.out.println(ao.alienOrder(strs));
	}

}
