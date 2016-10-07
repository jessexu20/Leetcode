import java.util.*;
public class BinaryIndexTree{
	int [] nums;
	int [] arr;
	public BinaryIndexTree(int [] array){
		nums = new int[array.length];
		arr = new int [1+array.length];
		for(int i = 1; i < arr.length; i++){
			update(i - 1, array[i - 1]);
		}
	}
	public int getNext(int i){
		return i + ( i & (-i));
	}
	public int getParent(int i){
		return i - (i & (-i));
	}
	public int sum(int i, int j){
		return sum(arr, j) - sum(arr, i - 1);
	}
	public int sum(int [] arr, int i){
		int index = i + 1;
		int sum = 0;
		while(index < arr.length && index > 0){
			sum += arr[index];
			index = getParent(index);
		}
		return sum;
	}
	public void update(int i, int val){
		int index = i + 1;
		int diff = val - nums[i];
		nums[i] = val;
		while(index < arr.length){
			arr[index] += diff;
			index = getNext(index);
		}
	}
	public static void main(String [] args){
		int [] arr = {3,2,-1,4,8,7,-9,8,10};
		BinaryIndexTree bit = new BinaryIndexTree(arr);
		System.out.println(bit.sum(0,5));
		
	}
}