import java.util.*;
class Letter{
	char c;
	int times;
	Letter(char x, int t){
		c = x;
		times = t;
	}
}
public class OrderString{
	public String build(String str){
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap();
		for(int i= 0;i<str.length();i++){
			char c = str.charAt(i);
			if(!map.containsKey(c))
				map.put(c,1);
			else map.put(c,map.get(c)+1);
		}
		Queue<Letter> que = new PriorityQueue<Letter>(10,new Comparator<Letter>(){
			public int compare(Letter l1, Letter l2){
				return l2.times - l1.times;
			}
		});
		for(char c: map.keySet()){
			Letter letter = new Letter(c,map.get(c));
			que.offer(letter);
		}
		Letter temp = null;
		while(!que.isEmpty()){
			Letter cur = que.poll();
			sb.append(cur.c);
			cur.times = cur.times - 1;
			if(temp!=null && temp.times>0)
				que.offer(temp);
			temp = cur;
		}
		if(temp!=null && temp.times> 0){
			if(temp.times>1) return "";
			else sb.append(temp.c);
		}
		return sb.toString();
	}
	public static void main(String args[]){
		OrderString os = new OrderString();
		System.out.println(os.build("aaaaabbbccd"));//abacabacbad
	}
}