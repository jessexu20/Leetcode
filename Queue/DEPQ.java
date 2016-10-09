import java.util.*;
class Frame{
	int time;
	int price;
	Frame(int t, int p){
		time = t;
		price = p;
	}
	public String toString(){
		return "time:" + time + " price:" + price;
	}
}
public class DEPQ{
	PriorityQueue<Frame> time_que = new PriorityQueue<>(10,new Comparator<Frame>(){
		public int compare(Frame a, Frame b){
			return b.time - a.time;
		}
	});
	PriorityQueue<Frame>  price_min_que = new PriorityQueue<>(10,new Comparator<Frame>(){
		public int compare(Frame a, Frame b){
			return a.price - b.price;
		}
	});
	PriorityQueue<Frame>  price_max_que = new PriorityQueue<>(10,new Comparator<Frame>(){
		public int compare(Frame a, Frame b){
			return b.price - a.price;
		}
	});
	HashMap<Integer, Frame> map = new HashMap<>();
	public void add(int time, int val){
		if(map.containsKey(time))
			return;
		Frame f = new Frame(time,val);
		time_que.offer(f);
		price_min_que.offer(f);
		price_max_que.offer(f);
		map.put(time,f);
		getStatus();
	}
	public void remove(int time, int val){
		if(map.containsKey(time))
			return;
		Frame f = map.get(time);
		f.time = Integer.MAX_VALUE;
		time_que.poll();
		f.price = Integer.MIN_VALUE;
		price_max_que.poll();
		f.price = Integer.MAX_VALUE;
		price_min_que.poll();
		map.remove(time);
		getStatus();
	}
	public void update(int time, int val){
		if(!map.containsKey(time))
			return;
		map.get(time).price = val;
		getStatus();
	}
	public void getStatus(){		
		System.out.print("min:" + price_min_que.peek().price);
		System.out.print(" max:" + price_max_que.peek().price);
		System.out.println(" recent:" + time_que.peek().price);
	}
	public static void main(String args[]){
		DEPQ depq = new DEPQ();
		depq.add(1,4);
		depq.add(4,7);
		depq.add(2,5);
		depq.update(4,2);
		System.out.println(depq.price_max_que);
		depq.add(3,3);
		System.out.println(depq.price_max_que);
		// Frame f = new Frame(1,2);
		// Frame f1 = new Frame(2,3);
		// Frame f3 = new Frame (-1,-1);
		// depq.time_que.offer(f);
		// depq.time_que.offer(f1);
		// depq.time_que.offer(f3);
		System.out.println(depq.time_que);
		
		
		
	}
}

