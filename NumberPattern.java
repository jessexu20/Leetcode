package google;

import java.util.Arrays;

public class NumberPattern {
	public int smallNumber(int[] nums, char[] order) {
		Arrays.sort(nums);
		// 2359 -> 2395 iid
		// 3259 dii
		// ddi
		// 3259 3529 5329
		int len = 0;
		for (int i = 0; i < order.length; i++) {
			if (order[i] == 'd')
				len++;
			if (order[i] == 'i' && len != 0) {
				reverse(nums, i-len, i);
				len = 0;
			}
		}
		if(len!=0)
			reverse(nums, order.length-len, order.length);
		int result = 0;
		for(int i = 0; i < nums.length; i++){
			result*=10;
			result +=nums[i];
			
		}
		return result;
	}

	private void reverse(int[] arr, int start, int end) {
		for (int i = 0; i <= (end - start) / 2; i++) {
			int temp = arr[start + i];
			arr[start + i] = arr[end - i];
			arr[end - i] = temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {3,5,9,2,4};
		char [] order = {'i','d','d','i'};
		NumberPattern np = new NumberPattern();
		System.out.println(np.smallNumber(nums, order));
	}

}
