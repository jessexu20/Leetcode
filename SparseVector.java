package google;

import java.util.*;

public class SparseVector {
	HashMap<Long, Integer> map;

	SparseVector() {
		map = new HashMap<>();
	}

	public void set(long idx, int val) {
		this.map.put(idx, val);
	}

	public int get(long idx) {
		if (map.containsKey(idx))
			return map.get(idx);
		else
			return -1;
	}

	public int dotProduct(SparseVector otherVec) {
		Set<Long> idx1 = new HashSet<Long>(map.keySet());
		Set<Long> idx2 = new HashSet<Long>(otherVec.map.keySet());
		idx1.retainAll(idx2);
		int cnt = 0;
		for (Long num : idx1)
			cnt += (this.map.get(num) * otherVec.map.get(num));
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparseVector sVector = new SparseVector();
		sVector.set(111, 1);
		sVector.set(222, 2);
		SparseVector bVector = new SparseVector();
		bVector.set(111, 3);
		bVector.set(333, 4);
		System.out.println(sVector.dotProduct(bVector));
	}

}
