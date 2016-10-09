import java.util.*;
class Query{
	String val;
	long time;
	Query(String s, long t){
		val = s;
		time = t;
	}
}
public class QuerySystem{
	HashMap<String, Queue<Long>> map;
	QuerySystem(){
		map = new HashMap<>();
	}
	public void add(Query q){
		long cur = q.time;
		if(!map.containsKey(q.val)){
			map.put(q.val, new LinkedList<Long>());
			map.get(q.val).add(q.time);
		}
		else{
			Queue<Long> temp = map.get(q.val);
			while(!temp.isEmpty()){
				if(temp.peek() < q.time - 3600){
					temp.poll();
				}
				else break;
			}
			temp.add(q.time);
		}
	}
	public List<String> getFreq(int number){
		List<String> res = new ArrayList<>();
		List<Map.Entry<String, Queue<Long> > > unsorted = new ArrayList<>();
		unsorted.addAll(map.entrySet());
		Collections.sort(unsorted,new Comparator< Map.Entry< String, Queue<Long> > > (){
			public int compare(Map.Entry<String, Queue<Long>> e1, Map.Entry<String, Queue<Long>> e2) {
				return e2.getValue().size() - e1.getValue().size();
			}
		} );
		for(Map.Entry<String, Queue<Long>> entry: unsorted){
			if(number <= 0)
				break;
			number -= entry.getValue().size();
			res.add(entry.getKey());
		}
		return res;
	}
	public static void main(String args[]){
		QuerySystem qs = new QuerySystem();
		String[] fruits = {"apple", "orange", "banana", "peach", "kiwi", "grape"};
		Random random = new Random();
		long [] time = new long[100];
		for(int i = 0; i < 100; i++){
			time[i] = random.nextInt(6000);
		}
		Arrays.sort(time);
		for(int i = 0; i < 100; i++){
			Query q = new Query(fruits[random.nextInt(fruits.length)],time[i]);
			qs.add(q);
		}
		for(String str: qs.map.keySet()){
			System.out.println(str+":" + qs.map.get(str).size());
		}
		System.out.println(qs.getFreq(30));	
	}
}