import java.util.*;

class DLinkedNode {
	int val;
	int key;
	DLinkedNode prev;
	DLinkedNode next;

	DLinkedNode(int k, int x) {
		val = x;
		key = k;
	}
}

public class LRUCache {
	DLinkedNode head;
	DLinkedNode tail;
	HashMap<Integer, DLinkedNode> map;
	int size;

	public LRUCache(int capacity) {
		head = new DLinkedNode(-1, 1);// dummy head
		tail = new DLinkedNode(-1, -1);// dummy tail
		head.next = tail;
		tail.prev = head;
		size = capacity;
		map = new HashMap<Integer, DLinkedNode>();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DLinkedNode node = map.get(key);
			putToHead(node);
			return node.val;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			DLinkedNode node = map.get(key);
			node.val = value;
			putToHead(node);
		} else {
			DLinkedNode node = new DLinkedNode(key, value);
			if (map.size() >= size) {
				int k = tail.prev.key;
				removeLast();
				map.remove(k);
			}
			map.put(key, node);
			putToHead(node);
		}
	}

	private void putToHead(DLinkedNode node) {
		if (node.prev == head)
			return;
		if (node.prev != null && node.next != null) {
			DLinkedNode p = node.prev;
			DLinkedNode t = node.next;
			p.next = t;
			t.prev = p;
		}
		DLinkedNode temp = head.next;
		head.next = node;
		node.next = temp;
		node.prev = head;
		temp.prev = node;
	}

	private void removeLast() {
		DLinkedNode temp = tail.prev;
		if (temp == head)
			return;
		temp.prev.next = tail;
		tail.prev = temp.prev;
	}

	public static void main(String args[]) {
		LRUCache lru = new LRUCache(2);
		lru.set(2, 1);
		lru.set(1, 1);
		System.out.println(lru.get(2));
		lru.set(4, 1);
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
	}
}