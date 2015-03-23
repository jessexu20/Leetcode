public class BucketSort{
	public void sort(int [] array){
		int arr[]=new int[100];
		for(int i=0;i<100;i++){
			arr[i]=0;
		}
		for(int age: array){
			arr[age-1]++;
		}
		int j=0;
		for(int i=0;i<100;i++){
			while(arr[i]>0){
				array[j]=i+1;
				arr[i]--;
				j++;
			}
		}
	}
	public static void main(String args[]){
		BucketSort bs= new BucketSort();
		int a[]=new int[100];
		for(int i=0;i<a.length;i++){
			a[i]=(int)(Math.random()*100+1);
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println();
		bs.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		
	}
	
	
	
}