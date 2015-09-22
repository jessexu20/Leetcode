public class JumpGameII {
    public int jump(int[] nums) {
        int cur_max=0;
		int last=0;
		int step=0;
		for(int i = 0; i<nums.length-1;i++){
			cur_max=Math.max(i+nums[i],cur_max);
			if(i==last){
				step++;
				last=cur_max;
			}
		}
		return step;
    }
}