package google;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class MultiThread {
	static Machine m = new Machine();
	public static void main(String[] args) {
		Thread prod1 = new Thread(new Producer(1, m));
		Thread prod2 = new Thread(new Producer(2, m));
		Thread cons1 = new Thread(new Consumer(1, m));
		Thread cons2 = new Thread(new Consumer(2, m));
		cons1.start();
		prod1.start();
	}
	static class Machine {
		LinkedList<Object> list = new LinkedList<Object>();
		int capacity = 3;
		public Machine() {
		}
		public synchronized Object getObj() throws InterruptedException {
			while (list.size() == 0) {
				wait();
			}
			Object tmp = list.peekFirst();
			list.removeFirst();
			notify();
			return tmp;
		}
		public synchronized void putObj(Object obj) throws InterruptedException {
			while (list.size() == capacity) {
				wait();
			}
			list.addLast(obj);
			notify();
		}
	}
	static class Producer implements Runnable {
		int id;
		Machine m;
		public Producer(int id, Machine m) {
			this.id = id;
			this.m = m;
		}
		@Override
		public void run() {
			try {
				m.putObj(new Object());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(id + ": putObj");
		}
	}
	static class Consumer implements Runnable {
		int id;
		Machine m;
		public Consumer(int id, Machine m) {
			this.id = id;
			this.m = m;
		}
		@Override
		public void run() {
			try {
				m.getObj();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(id + ": getObj");
		}
	}
}
