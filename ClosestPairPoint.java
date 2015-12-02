import java.util.*;

class Point implements Comparable<Point> {
	int x;
	int y;

	Point(int a, int b) {
		x = a;
		y = b;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return this.x - o.x;
	}
}

public class ClosestPairPoint {
	public int dist(Point[] points) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		TreeSet<Point> treeset = new TreeSet<>(new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.y - p2.y;
			}
		});
		int short_dist = Integer.MAX_VALUE;
		for (Point p : points)
			pq.offer(p);
		Queue<Point> que = new LinkedList<>();
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			if (que.isEmpty()) {
				que.offer(cur);
				treeset.add(cur);
				continue;
			}
			while (!que.isEmpty() && cur.x - que.peek().x > short_dist) {
				Point del = que.poll();
				treeset.remove(del);
			}
			Set<Point> set;
			if (short_dist != Integer.MAX_VALUE) {
				Point upbound = new Point(cur.x, cur.y + short_dist);
				Point lowbound = new Point(cur.x, cur.y - short_dist);
				set = treeset.subSet(lowbound, upbound);
			} else
				set = treeset;
			for (Point p : set) {
				short_dist = Math.min(short_dist, cal(p, cur));
			}
			treeset.add(cur);
			que.offer(cur);
		}
		return short_dist;
	}

	private int cal(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);// Manhattan Distance
	}
	public double calTriSize(Point a, Point b, Point c){
		return ((double)(a.x - c.x) * (b.y - c.y) - (double)(a.y - c.y) * (b.x - c.x))/2;
	}
	public static void main(String args[]) {
		ClosestPairPoint cpp = new ClosestPairPoint();
		Point p1 = new Point(1, 0);
		Point p2 = new Point(2, -9);
		Point p3 = new Point(1, 2);
		Point p4 = new Point(8, 4);
		Point p5 = new Point(5, 3);
		Point p6 = new Point(2, 0);
		Point p7 = new Point(-2, 3);
		Point p8 = new Point(3, -2);
		Point p9 = new Point(1, 9);
		Point[] points = { p1, p2, p3, p4, p5, p6, p7, p8, p9 };
		System.out.println(cpp.calTriSize(p1,p2,p4));
		System.out.println(cpp.dist(points));
	}
}