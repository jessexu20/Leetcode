package google;

import java.util.*;

class Logger {
	void startReq(long req_id, long time) {
		Request req = new Request(req_id, time);
		map.put(req_id, req);
		que.offer(req);
	}

	void endReq(long req_id, long time) {
		if (!map.containsKey(req_id))
			return;
		map.get(req_id).endTime = time;
		if (!que.isEmpty() && que.peek().equals(map.get(req_id))) {
			while (!que.isEmpty() && que.peek().endTime != 0) {
				Request cur = que.poll();
				map.remove(cur.req_id);
				System.out.println(cur.req_id + "\t" + cur.startTime + "\t"
						+ cur.endTime);
			}

		}

	}

	HashMap<Long, Request> map = new HashMap<>();
	PriorityQueue<Request> que = new PriorityQueue<>();

}

class Request implements Comparable<Request> {
	long req_id;
	long startTime;
	long endTime;

	Request(long id, long st) {
		req_id = id;
		startTime = st;
	}

	public int compareTo(Request req) {
		return (int) (this.startTime - req.startTime);
	}
}

public class LogRequest {
	public static void main(String args[]){
		Logger logger = new Logger();
		logger.startReq(123, 1);
		logger.startReq(124, 10);
		logger.startReq(125, 5);
		logger.startReq(126, 11);
		logger.endReq(124, 12);
		logger.endReq(123, 7);
		logger.endReq(125, 15);
		
	}
}
