package google;

import java.util.*;

public class AvgLatency {
	HashMap<String, Queue<Integer>> methodQue;
	HashMap<String, Integer> cnt;
	int window;

	AvgLatency(List<String> methods, int window_size) {
		if (window_size <= 0)
			return;
		window = window_size;
		methodQue = new HashMap<>();
		cnt = new HashMap<>();
		for (String str : methods) {
			Queue<Integer> que = new LinkedList<>();
			methodQue.put(str, que);
			cnt.put(str, 0);
		}
	}

	double getAvgLatency(String method) {
		return (double) cnt.get(method) / window;
	}

	void addLatency(String method, int latency) {
		if (!methodQue.containsKey(method))
			return;
		Queue<Integer> cur = methodQue.get(method);
		while (cur.size() >= window) {
			int n = cur.poll();
			cnt.put(method, cnt.get(method) - n);
		}
		cur.offer(latency);
		cnt.put(method, cnt.get(method) + latency);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> methods= new ArrayList<String>();
		methods.add("GET");
		methods.add("POST");
		AvgLatency avgLatency = new AvgLatency(methods, 3);
		avgLatency.addLatency("GET", 10);
		avgLatency.addLatency("GET", 6);
		avgLatency.addLatency("GET", 6);
		avgLatency.addLatency("GET", 6);
		System.out.println(avgLatency.getAvgLatency("GET"));
	}

}
