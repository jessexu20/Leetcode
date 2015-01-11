package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
	public int removeDuplicates(int[] A) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		ArrayList<Integer> dupindex = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			if (hashMap.containsKey(A[i])) {
				int occurance = hashMap.get(A[i]);
				if (occurance < 2) {
					hashMap.put(A[i], occurance + 1);
				} else {
					dupindex.add(i);
				}
			} else {
				hashMap.put(A[i], 1);
			}
		}
		int i = 0, j = 0, k = 0;
		while (j < A.length) {
			if (k >= dupindex.size()) {
				break;
			}
			if (j != dupindex.get(k)) {
				A[i] = A[j];
				i++;
				j++;
			} else {
				j++;
				k++;
			}
		}
		while (j < A.length) {
			A[i] = A[j];
			i++;
			j++;
		}
		return A.length - dupindex.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 1, 1, 1, 2 };
		RemoveDuplicates remove = new RemoveDuplicates();
		System.out.println(remove.removeDuplicates(A));
	}

}
