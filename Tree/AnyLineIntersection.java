package google;

import java.util.*;

class Line {
	Point a;
	Point b;

	Line(Point x, Point y) {
		a = x;
		b = y;
	}
}

public class AnyLineIntersection {
	public int count(Line[] lines) {
		Comparator<Point> cp = new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.x - p2.x;
			}
		};
		HashMap<Point, Line> map = new HashMap<>();
		HashMap<Line, HashMap<Line, Boolean>> checked = new HashMap<>();
		PriorityQueue<Point> pq = new PriorityQueue<>(10, cp);
		for (Line l : lines) {
			map.put(l.a, l);
			map.put(l.b, l);
			pq.offer(l.a);
			pq.offer(l.b);
		}
		TreeSet<Point> treeSet = new TreeSet<>(new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.y - p2.y;
			}
		});
		Set<Line> visited = new HashSet<>();
		int cnt = 0;
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			Point prev = treeSet.higher(cur);
			Point next = treeSet.lower(cur);
			if (!visited.contains(map.get(cur))) {
				treeSet.add(cur);
				visited.add(map.get(cur));
				if (prev != null)
					if (check(map.get(cur), map.get(prev), checked))
						cnt++;
				if (next != null)
					if (check(map.get(cur), map.get(next), checked))
						cnt++;
			} else {
				treeSet.remove(cur);
				if (prev != null)
					if (check(map.get(cur), map.get(prev), checked))
						cnt++;
				if (next != null)
					if (check(map.get(cur), map.get(next), checked))
						cnt++;
				if (prev != null && next != null
						&& check(map.get(prev), map.get(next), checked))
					cnt++;
			}
		}
		return cnt;
	}

	private boolean checkLine(Line l1, Line l2) {
		int d1 = (l1.b.x - l1.a.x) * (l2.a.y - l1.a.y) - (l1.b.y - l1.a.y)
				* (l2.a.x - l1.a.x);
		int d2 = (l1.b.x - l1.a.x) * (l2.b.y - l1.a.y) - (l1.b.y - l1.a.y)
				* (l2.b.x - l1.a.x);
		int d3 = (l2.b.x - l2.a.x) * (l1.a.y - l2.a.y) - (l2.b.y - l2.a.y)
				* (l1.a.x - l2.a.x);
		int d4 = (l2.b.x - l2.a.x) * (l1.b.y - l2.a.y) - (l2.b.y - l2.a.y)
				* (l1.b.x - l2.a.x);
		return (d1 * d2 < 0) && (d3 * d4 < 0);

	}

	public boolean check(Line l1, Line l2,
			HashMap<Line, HashMap<Line, Boolean>> checked) {
		if (l1 == null || l2 == null)
			return false;
		boolean flag = false;

		if (!checked.containsKey(l1)) {
			checked.put(l1, new HashMap<Line, Boolean>());
		}
		if (!checked.containsKey(l2)) {
			checked.put(l2, new HashMap<Line, Boolean>());
		}
		if (checked.get(l1).containsKey(l2) || checked.get(l2).containsKey(l1))
			return false;
		else {
			if (checkLine(l1, l2)) {
				checked.get(l1).put(l2, true);
				checked.get(l2).put(l1, true);
				flag = true;
			} else {
				checked.get(l1).put(l2, false);
				checked.get(l2).put(l1, false);
			}

			return flag;
		}
	}

	public static void main(String args[]) {
		Point p1 = new Point(1, 0);
		Point p2 = new Point(5, 0);
		Line l1 = new Line(p1, p2);
		p1 = new Point(2, -1);
		p2 = new Point(2, 4);
		Line l2 = new Line(p1, p2);
		p1 = new Point(3, 1);
		p2 = new Point(3, 3);
		Line l3 = new Line(p1, p2);
		p1 = new Point(1, 2);
		p2 = new Point(4, 2);
		Line l4 = new Line(p1, p2);
		Line[] lines = { l1, l2, l3, l4 };
		AnyLineIntersection li = new AnyLineIntersection();
		// System.out.println(li.checkLine(l3,l4));
		System.out.println(li.count(lines));

	}
}