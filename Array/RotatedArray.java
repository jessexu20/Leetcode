public class RotatedArray{
	public int findMin(int [] arr){
		int start = 0, end = arr.length - 1;
		while(start < end){
			int mid = start + (end - start )/2;
			if(arr[mid] < arr[end]){
				end = mid;
			}
			else start = mid + 1;
		}
		return arr[start];
	}
	public int findMinDup(int [] arr){
		int start = 0, end = arr.length - 1;
		while(start < end){
			int mid = start + (end - start )/2;
			if(arr[mid] < arr[end]){
				end = mid;
			}
			else if(arr[mid] > arr[end])
				start = mid + 1;
			else end--;
		}
		System.out.println(start+"\t"+end);
		return arr[start];
	}
	public int find(int [] arr, int target){
		int start = 0, end = arr.length - 1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(arr[mid] == target)
				return mid;
			if(arr[start] <= arr[mid]){
				if(arr[start] <= target && target < arr[mid])
					end = mid - 1;
				else  start = mid + 1;
			}
			else{
				if(arr[mid] < target && target <= arr[end])
					start = mid + 1;
				else  end = mid - 1;
			}
		}
		return -1;
	}
	public int findLarge(int [] arr, int target){
		int start = 0, end = arr.length - 1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(arr[mid] <= target)
				start = mid + 1;
			else end = mid - 1;
		}
		return start;
	}
	public int findSmall(int [] arr, int target){
		int start = 0, end = arr.length - 1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(arr[mid] >= target)
				end = mid - 1;
			else start = mid + 1;
		}
		return start;
	}
	public static void main(String [] args){
		RotatedArray ra = new RotatedArray();
		int [] arr = {0,1,1,1,3};
		System.out.println(ra.findMinDup(arr));
		System.out.println(ra.find(arr,1));
		System.out.println(ra.findSmall(arr,1));
		System.out.println(ra.findLarge(arr,1));
	}
}