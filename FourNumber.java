import java.util.*;
public class FourNumber{
	public boolean checkFour(int [] arr){
		int len = arr.length/4;
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < arr.length; i+=len){
			list.add(arr[i]);
		}
		for(int i = 0; i < list.size(); i++){
			int cur = list.get(i);
			int length = bsLarge(arr,cur) - bsSmall(arr,cur) + 1;
			if(length >= (float)arr.length / 4 ) return true;  
		}
		return false;
	}
	private int bsLarge(int [] arr, int target){
		int start = 0, end = arr.length - 1;
		while(start <= end){
			int mid = start + (end - start) / 2;
			if(target < arr[mid]) end = mid - 1;
			else start = mid + 1;
		}
		return start-1; 
	}
	private int bsSmall(int [] arr, int target){
		int start = 0, end = arr.length - 1;
		while(start <= end){
			int mid = start + (end - start) / 2;
			if(target <= arr[mid]) end = mid - 1;
			else start = mid + 1;
		}
		return end+1; 
	}
	public static void main(String args[]){
		FourNumber four = new FourNumber();
		int [] nums = {1,1,1,2,2,2,3,3,4,4,5,6};
		System.out.println(four.checkFour(nums));
		
		
	}
}