package sort;

public class HeapSort{
    public static int n;

	public void heapSort(int[] nums) {
		n=nums.length-1;
		heapify(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
		for (int i = nums.length-1; i >0;i--) {
			swap(nums, 0, i);
			n--;
			maxheap(nums, 0);
//			System.out.println();
//			for (int j = 0; j < nums.length; j++) {
//				System.out.print(nums[j]+"\t");
//			}
		}
    }
    public int findKthLargest(int[] nums, int k) {
        n=k-1;
        int a []=new int [k];
        for(int i=0;i<k;i++){
            a[i]=nums[i];
        }
        heapify(a);
        for(int i=k-1;i>0;i--){
            swap(a,0,i);
            n=n-1;
            maxheap(a,0);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>a[k-1]){
                a[k-1]=nums[i];
                n=k-1;
                heapify(a);
                for(int j=k-1;j>0;j--){
                    swap(a,0,j);
                    n=n-1;
                    maxheap(a,0);
                }
            }
        }
        return a[k-1];
    }
    public static void heapify(int arr[]){
        for(int i=n/2;i>=0;i--)
            maxheap(arr,i);
    }
    public static void maxheap(int arr[],int i){
        int left=2*i+1;
        int right=2 * i+2;
        int max=i;
        if(left<=n && arr[left]<arr[max])
            max=left;
        if(right<=n && arr[right]<arr[max])
            max=right;
        if(max!=i){
            swap(arr,i,max);
            maxheap(arr,max);
        }
    }
    public static void swap(int arr[],int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
	public static void main(String args[]){
		HeapSort hs= new HeapSort();
		int a[]={3,2,10,5,7,6,0,8,9,1};
		hs.heapSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
		System.out.println(hs.findKthLargest(a,5));
	}

}