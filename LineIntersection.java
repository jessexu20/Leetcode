import java.util.*;
class Point{
	int x;
	int y;
	Point(int a, int b){
		x = a;
		y = b;
	}
}
class Line{
	Point a;
	Point b;
	Line(Point x, Point y){
		a = x; 
		b = y;
	}
}
public class LineIntersection{
	public int count(Line [] lines){
		Comparator<Point> cp = new Comparator<Point>(){
			public int compare(Point p1, Point p2){
				return p1.x - p2.x;
			}
		};
		PriorityQueue<Point> h = new PriorityQueue<>(10,cp);
		PriorityQueue<Point> v = new PriorityQueue<>(10,cp);
		for(Line l : lines){
			if(l.a.x == l.b.x){
				v.offer(l.a);
				v.offer(l.b);
			}
			else{
				h.offer(l.a);
				h.offer(l.b);
			}
		}
		TreeSet<Integer> treeSet = new TreeSet<>();
		int cnt = 0;
		while(!h.isEmpty() && !v.isEmpty()){
			if(h.peek().x<=v.peek().x){
				Point cur = h.poll();
				if(!treeSet.add(cur.y))
					treeSet.remove(cur.y);
			}
			else{
				Point first = v.poll();
				Point second = v.poll();
				int low = Math.min(first.y, second.y);
				int high = Math.max(first.y, second.y);
				cnt += treeSet.subSet(low,high).size();
			}
		}
		return cnt;
	}
	public static void main(String args[]){
		Point p1 = new Point(1,0);
		Point p2 = new Point(5,0);
		Line l1 = new Line(p1,p2);
		p1= new Point(2,-1);
		p2 = new Point(2,4);
		Line l2 = new Line(p1,p2);
		p1 = new Point(3,1);
		p2 = new Point(3,3);
		Line l3 = new Line(p1,p2);
		p1 = new Point(1,2);
		p2 = new Point(4,2);
		Line l4 = new Line(p1,p2);
		Line[]lines = {l1,l2,l3,l4};
		LineIntersection li = new LineIntersection();
		System.out.println(li.count(lines));
		
	}
}