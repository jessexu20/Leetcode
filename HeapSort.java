public class HeapSort{
	public static int n;
	public static int size;
	HeapSort(int s){
		size=s;
	}
	public static void sort(int arr[]){
		n=size-1;
		int a[]=new int [size];
		for(int i=0;i<size;i++)
			a[i]=arr[i];
		heapify(a);
		for(int i=size-1;i>0;i--){
			swap(a,0,i);
			n=n-1;
			maxheap(a,0);
		}
		for(int i=size;i<arr.length;i++){
			if(arr[i]>a[size-1]){
				a[size-1]=arr[i];
				n=size-1;
				heapify(a);
				for(int j=size-1;j>0;j--){
					swap(a,0,j);
					n=n-1;
					maxheap(a,0);
				}
			}			
		}
		for(int i=0;i<size;i++)
			System.out.print(a[i]+"\t");
	}
	public static void heapify(int arr[]){
		for(int i=n/2;i>=0;i--)
			maxheap(arr,i);
	}
	public static void maxheap(int arr[],int i){
		int left = 2*i+1;
		int right= 2*i+2;
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
	public static void swap(int arr[],int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String args[]){
		HeapSort hs= new HeapSort(5);
		int a[]={3,2,10,5,7,6,0,8,9,1};
		hs.sort(a);
		// for(int i=0;i<a.length;i++){
		// 	System.out.print(a[i]+"\t");
		// }
		
	}

}