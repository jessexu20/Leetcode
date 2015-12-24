import java.util.*;
public class CreateMaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1.length > nums2.length) return maxNumber(nums2,nums1,k);
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < Math.min(nums1.length, k); i++){
			List<Integer> left = new ArrayList(pickNumber(nums1,i));
			List<Integer> right = new ArrayList(pickNumber(nums2,k-i));
			max = Math.max(max, getNum(left,right));
		}
		int [] result = new int [k];
		int i = k-1;
		while(max > 0){
			result[i--] = (max%10);
			max /= 10;
		}
		return result;
    }
	private int getNum(List<Integer> left, List<Integer> right){
		int number = 0;
		int i = 0, j = 0;
		while(i < left.size() || j < right.size()){
			if(i == left.size()){
				number += right.get(j++);
			}
			else if(j == right.size()){
				number += left.get(i++);
			}
			else{
					number += ((left.get(i) > right.get(j)) ? left.get(i++):right.get(j++));
			}
			number *= 10;
		}
		return number/10;
	}
	public List<Integer> pickNumber(int [] arr, int k){
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
			return result;
		} 
		else{
			result.add(max);
			result.addAll(pickNumber(Arrays.copyOfRange(arr,index+1,arr.length),k-1));
			return result;
		}		
	}
	public static void main(String args[]){
		CreateMaxNumber cmn = new CreateMaxNumber();
		int [] x = new int [5];
		int [] nums1 = {3,4,6,5};
		int [] nums2 = {9,1,2,5,8,3};
		x = cmn.maxNumber(nums1,nums2,5);
		for(int i = 0; i < x.length; i++){
			System.out.print(x[i]);
		}
	}
}