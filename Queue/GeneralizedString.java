import java.util.*;
class Query implements Comparable<Query>{
	int cnt;
	Query(int c){
		cnt = c;
	}
	public int compareTo(Query q){
		return this.cnt - q.cnt;
	}
}
public class GeneralizedString{
	public List<String> generate(String str){
		List<String> res = new ArrayList<>();
		helper(res, "", str, 0, true);
		return res;
	}
	public void helper(List<String> result, String temp, String str, int index, boolean flag){
		if(index == str.length()){
			result.add(temp);
			return;
		}
		
		for(int i = index + 1; i <= str.length() && flag; i++){
			helper(result, temp + Integer.valueOf(i - index), str, i , false);
		}
	
		helper(result, temp + str.charAt(index),str, index + 1, true);
		
	}
	public static void main(String[] args){
		GeneralizedString gs = new GeneralizedString();
		System.out.println(gs.generate("abcd"));
		PriorityQueue<Query> pq = new PriorityQueue<>();
		Query q10 = new Query(10);
		pq.offer(new Query(1));
		pq.offer(q10);
		pq.offer(new Query(11));
		q10.cnt = 0;
		System.out.println(pq.poll().cnt);
		System.out.println(pq.poll().cnt);
		
	}
}
