public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int [] pos = new int [nums.length+1];
        if(nums.length < 1) return 0;
        pos[0] = nums[0];
        int size = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < pos[0]) pos[0] = nums[i];//replace first item
            else if(nums[i] > pos[size-1]) pos[size++] = nums[i];//append in the end
            else{
                int index = bsLarge(pos, nums[i], size-1);//bs large replace next larger item
                pos[index] = nums[i];
            }
        }
        return size;
    }
    public int bsLarge(int [] arr,int target, int end){
        int start = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target) return mid;
            else if(target < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
	public static void main(String args[]){
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int [] nums = {10,9,2,5,3,4};
		int [] t= {2,5};
		// System.out.println(lis.bsLarge(t,3));
		System.out.println(lis.lengthOfLIS(nums));
	}
}