package google;

import java.util.*;

public class CoverRange {
	public int cover(List<Interval> list, int start, int end) {
		Collections.sort(list, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		int cur_max = Math.max(start,list.get(0).end);
		int cur = start;
		int cnt = 0;
		for (Interval interval : list) {
			if (interval.start > cur_max) {
				return -1;
			}
			cur_max = Math.max(cur_max, interval.end);
			if (interval.start >= cur) {
				cur = cur_max;
				cnt++;
			}
		}
		if (cur_max < end)
			return -1;
		else
			return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoverRange cr = new CoverRange();
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1, 2));
		list.add(new Interval(4, 5));
		list.add(new Interval(2, 4));
		list.add(new Interval(3, 5));
		list.add(new Interval(1, 3));
		list.add(new Interval(6, 7));
		System.out.println(cr.cover(list, 3, 6));
	}

}
