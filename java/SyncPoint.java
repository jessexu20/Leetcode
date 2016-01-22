package google;

import java.util.*;

public class SyncPoint {
	public int[] syncPoint(int[] a, int[] b) {
		for (int i = 1; i < a.length; i++) {
			a[i] += a[i - 1];
		}
		for (int i = 1; i < b.length; i++) {
			b[i] += b[i - 1];
		}
		int i = 0, j = 0, len = 0;
		int[] result = new int[a.length];
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				result[len++] = a[i];
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else
				j++;
		}
		return Arrays.copyOf(result, len);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SyncPoint sp = new SyncPoint();
		int[] nums1 = {1,5,8,9};
		int[] nums2 = {1,4,9,9};
		int[] result = sp.syncPoint(nums1, nums2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "\t");
		}
	}

}
