import java.util.*;
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
		reverse(nums);
		int [] temp = Arrays.copyOf(nums,nums.length);
		// int prev = 0, mid = 0, post = nums.length-1;
		// int med = nums.length % 2 == 0 ? nums.length/2-1 : nums.length/2;
		// int median = nums[med];
		// while(mid <= post){
// 			if(nums[mid] > median){
// 				swap(nums,map(mid,nums.length),map(prev,nums.length));
// 				mid ++;
// 				prev++;
// 			}
// 			else if(nums[mid] < median){
// 				swap(nums,map(mid,nums.length),map(post,nums.length));
// 				post--;
// 			}
// 			else mid++;
// 		}
	for(int i = 0; i < nums.length; i++){
		nums[map(i,nums.length)] = temp[i];
	}
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i]+"\t");
		}

    }
	private int map(int index, int n){
		return (2*index + 1) % (n | 1);
	}
	private void reverse(int [] nums){
		for(int i = 0; i < nums.length/2; i++){
			swap(nums,i, nums.length - 1 - i);
		}
	}
	private void swap(int [] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String args[]){
		WiggleSortII ws = new WiggleSortII();
		int [] nums = {0,1,2,3,4,5,6,7,8,9,10,11};
		ws.wiggleSort(nums);
	}
}