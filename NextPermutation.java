public class NextPermutation{
	public void reverse(int []num,int start,int end){
		int halfLen=(end-start)/2;
		for(int i=0;i<halfLen;i++){
			int temp=num[start+i];
			num[start+i]=num[end-1-i];
			num[end-1-i]=temp;
		}
	}
	public void swap(int [] num,int i,int j){
		int temp=num[i];
		num[i]=num[j];
		num[j]=temp;
	}
	public void nextPermutation(int[] num) {
		int index=-1;
		for(int i=0;i<num.length-1;i++){
			if(num[i]<num[i+1])	index=i;
		}
		// System.out.println(index);
		if(index==-1){
			reverse(num,0,num.length);
		}
		else if(index==num.length-2){
			swap(num,index,index+1);
		}
		else{
			int key=num[index];
			int j=-1;
			int i=0;
			for(i=index+1;i<num.length;i++){
				if(num[i-1]>key && num[i]<=key)
					j=i-1;
			}
			if(i==num.length && j==-1){
				if(num[num.length-1]>key)
					j=num.length-1;
			}
			swap(num,index,j);
			reverse(num,index+1,num.length);
		}
    }
	public static void main(String args[]){
		NextPermutation np= new NextPermutation();
		int [] nums={3,2,1};
		np.nextPermutation(nums);
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]);
	}
}