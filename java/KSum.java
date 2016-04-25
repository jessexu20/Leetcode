package google;

import java.util.*;

public class KSum {
	public List<List<Integer>> getksum(int[] nums, int target, int k) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		if (k == 0)
			return result;
		else
			return helper(nums, target, k);
	}

	public List<List<Integer>> helper(int[] nums, int target, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (k == 1) {
			for (int i : nums) {
				if (i == target) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					result.add(list);
				}
			}
			return result;
		}
		if (k == 2) {
			return twosum(nums, target);
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				List<List<Integer>> temp = helper(
						Arrays.copyOfRange(nums, i + 1, nums.length), target
								- nums[i], k - 1);
				for (List<Integer> list : temp) {
					list.add(nums[i]);
					result.add(list);
				}
			}
			return result;
		}
	}

	public List<List<Integer>> twosum(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		List<List<Integer>> result = new ArrayList<>();
		while (start < end) {
			int sum = nums[start] + nums[end];
			if (sum == target) {
				List<Integer> list = new ArrayList<>();
				list.add(nums[start]);
				list.add(nums[end]);
				result.add(list);
				start++;
			}
			if (sum < target)
				start++;
			else
				end--;
		}
		return result;
	}

	public static void main(String args[]) {
		KSum ksum = new KSum();
		int[] nums = { 1, 1, 1,2, 2, 3, 4, 5, 6, 7, 8, 9 };
		// System.out.println(ksum.twosum(nums,7));
		System.out.println(ksum.getksum(nums, 7, 4));

	}
}