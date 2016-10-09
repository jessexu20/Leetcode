public class Sort{
	public void quicksort(int [] arr){
		if(arr.length < 1)
			return;
		quicksortHelper(arr, 0, arr.length - 1);
		traverse(arr);
	}
	public void quicksortHelper(int [] arr, int low, int high){
		if(low >= high)
			return;
		int i = low, j = high, pivot = arr[high];
		while(i < j){
			if(arr[i++] > pivot){
				swap(arr, --i, --j);
			}
		}
		swap(arr, i, high);
		quicksortHelper(arr, low, i - 1);
		quicksortHelper(arr, i+1, high);
	}
	public void mergeSort(int [] arr){
		int [] helper = new int [arr.length];
		mergeSortHelper(arr, helper, 0, arr.length - 1);
		traverse(arr);
	}
	public void mergeSortHelper(int [] arr, int [] helper, int low, int high){
		if(low >= high)
			return;
		int mid = (low+high)/2;
		mergeSortHelper(arr,helper,low, mid);
		mergeSortHelper(arr,helper,mid+1, high);
		merge(arr,helper,low, mid, high);
	}
	public void merge(int [] arr, int [] helper, int low, int mid, int high){
		for(int i = low; i < high; i++)
			helper[i] = arr[i];
		int cur = low, left = low, right = mid;
		while(left < mid && right < high){
			if(helper[left] < helper[right]){
				arr[cur++] = helper[left++];
			}
			else arr[cur++] = helper[right++];
		}
		while(left < mid){
			arr[cur++] = arr[left++];
		}
		while(right < high)
			arr[cur++] = arr[right++];
	}
	
	public static void main(String args[]){
		int [] arr = {9,21,2,3,1,5,8};
		Sort s = new Sort();
		s.quicksort(arr);
		s.mergeSort(arr);
	}
	public void traverse(int [] arr){
		for(int i: arr){
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	public void swap(int [] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}