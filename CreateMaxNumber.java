import java.util.*;
public class CreateMaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1.length > nums2.length) return maxNumber(nums2,nums1,k);
		List<Integer> max = new ArrayList<>();
		for(int i = Math.max(0,k-nums2.length); i <= Math.min(nums1.length, k); i++){//pick i from left, and k - i from right
			List<Integer> left = new ArrayList(pickNumber(nums1,i));
			List<Integer> right = new ArrayList(pickNumber(nums2,k-i));
			List<Integer> temp = new ArrayList<>(getNum(left,right)); //cur value
			max = greater(max,0,temp,0) ? max:temp;//detect the max number
		}
		int [] result = new int[k];
		for(int i = 0; i < k ;i++)
			result[i] = max.get(i);
		return result;
    }
	private List<Integer> getNum(List<Integer> left, List<Integer> right){//merge two list into one list(num)
		List<Integer> ans = new ArrayList<>();
		int len = left.size()+right.size();
		for(int i = 0, j = 0,r =0;r<len;r++){
			int x = greater(left,i,right,j) ? left.get(i++):right.get(j++);
			ans.add(x);
		}
		return ans;
	}
	private boolean greater(List<Integer> left,int i, List<Integer> right,int j){//detect if there is same number , e.g. 660 670 should pick the second first
		while(i < left.size() && j < right.size() && left.get(i) == right.get(j)){
			i++;
			j++;
		}
		return j == right.size() || (i < left.size() && left.get(i) > right.get(j));
	}
	private List<Integer> pickNumber(int [] arr, int k){//pick the largest number from two list
		List<Integer> result = new ArrayList<>();
		if(k==0 || arr.length < 1) return result;
		int max = Integer.MIN_VALUE;
		int index = -1;
		for(int i = 0; i < arr.length; i++){
			if(arr[i]>max){
				max = arr[i];
				index = i;
			}
		}
		if(arr.length-index <= k){
			int left = k - (arr.length-index);
			if(left > 0){
				List<Integer> leftNum = new ArrayList<>(pickNumber(Arrays.copyOfRange(arr,0,index),left));
				result.addAll(leftNum);
			}
			for(int i = index; i<arr.length; i++){
				result.add(arr[i]);
			}
		} 
		else{
			result.add(max);
			result.addAll(pickNumber(Arrays.copyOfRange(arr,index+1,arr.length),k-1));
		}		
		return result;
	}
	public static void main(String args[]){
		CreateMaxNumber cmn = new CreateMaxNumber();
		int [] x = new int [5];
		int [] nums1 = {6,7};
		int [] nums2 = {6,0,4};
		x = cmn.maxNumber(nums1,nums2,5);
		for(int i = 0; i < x.length; i++){
			System.out.print(x[i]);
		}
	}
}