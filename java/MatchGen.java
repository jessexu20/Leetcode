package google;

import java.util.Random;

public class MatchGen {
	public void matchSeq(int[] nums) {
		if (nums.length < 2) {
			System.out.println("Winner is " + String.valueOf(1+nums[0]));
			return;
		}
		int[] next = new int[(nums.length + 1) / 2];
		Random random = new Random();
		for (int i = 0; i < nums.length / 2; i++) {
			System.out.println("(" + String.valueOf(i + 1) + ","
					+ String.valueOf(nums.length - i) + ")");
			next[i] = random.nextInt(2) == 0 ? i : nums.length - 1 - i;
		}
		if (nums.length % 2 != 0)
			next[next.length - 1] = nums[nums.length - 1];
		matchSeq(next);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,2,3,4,5,6,7};
		MatchGen matchGen = new MatchGen();
		matchGen.matchSeq(nums);
		
	}

}
