import java.util.*;
class Interval{
	int start;
	int end;
	List<String> val;
	Interval(int s, int e){
		start = s;
		end = e;
		val = new ArrayList<>();
	}
	public String toString(){
		return this.start + "\t" + this.end + "\t" + val;
	}
}
class Comp{
	int number;
	List<String> val;
	Comp(int n){
		number = n;
		val = new ArrayList<>();
	}
}
public class IntervalValue{
	public List<Interval> sortInterval(List<Interval> intervals){
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				if(i1.start == i2.start)
					return i1.end - i2.end;
				else
					return i1.start - i2.start;
			}
		});
		PriorityQueue<Comp> pq = new PriorityQueue<>(10, new Comparator<Comp>(){
			public int compare(Comp c1, Comp c2){
				return c1.number - c2.number;
			}
				
		});
		Set<String> set = new HashSet<>();
		List<Interval> result = new ArrayList<>();
		int st = intervals.get(0).start, ed = intervals.get(0).end;
		Comp c0 = new Comp(ed);
		c0.val.addAll(intervals.get(0).val);
		pq.offer(c0);
		set.addAll(c0.val);
		for(int i = 1; i < intervals.size(); i++){
			int cur_st = intervals.get(i).start;
			int cur_ed = intervals.get(i).end;
			if(cur_st >= pq.peek().number){
				Comp temp = pq.poll();
				Interval t = new Interval(st, temp.number);
				t.val.addAll(set);
				set.removeAll(temp.val);
				result.add(t);
				st = cur_st;
			}
			Comp c = new Comp(cur_ed);
			c.val.addAll(intervals.get(i).val);
			set.addAll(c.val);
			pq.offer(c);
		}
		while(!pq.isEmpty()){
			Comp temp = pq.poll();
			Interval t = new Interval(st, temp.number);
			t.val.addAll(set);
			set.removeAll(temp.val);
			result.add(t);
			st = temp.number;
		}
		return result;
	}
	
	public static void main(String [] args){
		IntervalValue iv = new IntervalValue();
		Interval i1 = new Interval(1,3);
		i1.val.add("a");
		Interval i2 = new Interval(2,4);
		i2.val.add("b");
		List<Interval> intervals = Arrays.asList(i1,i2);
		
		List<Interval> result = iv.sortInterval(intervals);
		System.out.println(result);
	}
}