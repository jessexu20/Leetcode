public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<1) return 0;
        int [] pos = new int [nums.length+1];
        pos[0]=nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]<pos[0]) pos[0] = nums[i];
            else if(nums[i]>pos[len-1]) pos[len++]=nums[i];
            else pos[bsLarge(pos,nums[i],0,len)] = nums[i];
			// for(int j = 0;j<nums.length;j++){
			// 	System.out.print(pos[j]+"\t");
			// }
			// System.out.println();
        }
        return len;
    }
    public int bsLarge(int [] nums, int target,int start, int end){
        // int start = 0, end = nums.length-1;
        while(start<end){
            int mid = start + (end - start)/2;
            if(nums[mid]<target){
                start = mid + 1;
            }
            else{
                end = mid; 
            }
        }
        return end;
    }
	public static void main(String args[]){
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int [] nums = {10,9,2,5,3,4};
		int [] t= {2,5};
		// System.out.println(lis.bsLarge(t,3));
		System.out.println(lis.lengthOfLIS(nums));
	}
}