import java.util.ArrayList;
import java.util.List;

public class RotateArray{
		// public void rotate(int[] nums, int k) {
		// int length=nums.length;
		// k=k%length;
		// List<Integer> list=new ArrayList<>();
		// for(int i=length-k;i<length;i++){
		// 	list.add(nums[i]);
		// }
		// for(int i=length-k-1;i>=0;i--){
		// 	nums[i+k]=nums[i];
		// }
		// for(int i=0;i<list.size();i++){
		// 	nums[i]=list.get(i);
		// }
		//     }

	public void reverse(int [] nums,int begin,int end){
		if(begin<0){
			begin=0;
		}
		if(end>=nums.length)
			end=nums.length-1;
		int temp;
		for(int i=0;i<Math.floor((end-begin+1)/2);i++){
			temp=nums[begin+i];
			nums[begin+i]=nums[end-i];
			nums[end-i]=temp;
		}
	}
	public void rotate(int [] nums,int k){
		reverse(nums,0,nums.length-1);
		reverse(nums,0,nums.length-k-1);
		reverse(nums,k+1,nums.length-1);
	}
	public static void main(String args[]){
		RotateArray ra=new RotateArray();
		int [] nums={1,2,3,4,5,6,7};
		int k = 1;
		ra.rotate(nums,k);
		
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
	}
}