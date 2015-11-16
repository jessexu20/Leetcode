/*
Wiggle Sort My Submissions Question
Total Accepted: 3533 Total Submissions: 7667 Difficulty: Medium
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

*/
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for(int i =1 ; i < nums.length;i++){
            if(i %2 !=0 && nums[i]<nums[i-1])
                swap(nums,i,i-1);
            if(i%2 ==0 && nums[i]>nums[i-1]){
                swap(nums,i,i-1);
            }
        }
    }
    public void swap(int[] nums, int x,int y){
        int temp = nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
	public static void main(String args[]){
		WiggleSort ws= new WiggleSort();
		int []nums={7,6,3,4,5,2,1};
		ws.wiggleSort(nums);
		for(int i =0;i<nums.length;i++)System.out.print(nums[i]+"\t");
	}
}