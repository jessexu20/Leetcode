import java.util.*;
public class FindSumSet{
	public List<Integer> find(int [] arr){
		List<Integer> result = new ArrayList<Integer>();
		int sum = 0;
		int s = 0;
		for(int i: arr) sum+=i;
		while(s <= sum/100){
			int temp = new int [2];
			
		}
		
		return result;
	}
	public int[] quickselect(int [] arr, int start, int end){
		int low = start, high = end, k = arr[start];
		int sum = 0;
		while(low < high){
			while(arr[high] >= k && low < high){
				sum+=arr[high];
				high--;
			} 
			if(low < high) arr[low] = arr[high];
			while(arr[low] <= k && low < high) low++;
			if(low < high) arr[high] = arr[low];
		}
		arr[low] = k;
		int [] result = new int[2];
		result[0] = low;
		result[1] = sum;
		return result;
	}
	public static void main(String args[]){
		FindSumSet fss = new FindSumSet();
		int [] nums = {12,8,33,0,5,10,44,21,13,14,51,16,7};
		fss.quickselect(nums,0,6);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i]+"\t");
		}
		
		// System.out.println(fss.find(nums));
	}
}