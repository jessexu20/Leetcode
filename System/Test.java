public class Test{
	public static void heapify(int [] arr, int idx){
		int max = arr[idx];
		int left = (2*idx+1) < arr.length ? arr[2*idx+1] : Integer.MIN_VALUE;
		int right = (2*idx+2) < arr.length ? arr[2*idx+2] : Integer.MIN_VALUE;
		max = Math.max(max, Math.max(left, right));
		if(max == arr[idx])
			return;
		else if(max == left){
			swap(arr,idx,2*idx+1);
			heapify(arr,2*idx+1);
		}
		else{
			swap(arr,idx,2*idx+2);
			heapify(arr,2*idx+2);
		}
	}
	public static void swap(int []arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public static void main(String args[]){
		int [] arr = {1,5,3,4,7,9};
		for(int i=arr.length/2;i>=0;i--)
			heapify(arr,i);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}
	}
}