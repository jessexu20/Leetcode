/*

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

*/



class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
public class MeetingRoom {
    public int minMeetingRooms(Interval[] intervals) {
       	Comparator<Interval> comparator=new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start==o2.start)
					return o1.end - o2.end;
				else return o1.start - o2.start;
			}
		}; 
		Arrays.sort(intervals,comparator);
		Queue<Integer> que= new PriorityQueue<Integer>();
		int count=0;
		for(int i =0; i <intervals.length;i++){
		    if(que.isEmpty()){
		        que.offer(intervals[i].end);
		        count=1;
		        continue;
		    } 
		    int e= que.peek();
		    if(intervals[i].start<e){
		        que.offer(intervals[i].end);
		        count++;
		    }
		    else{
		        que.poll();
		        int cur= intervals[i].end;
		        que.offer(cur);
		    }
		}
		return count;
		
    }
}