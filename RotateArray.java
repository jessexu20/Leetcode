import java.util.ArrayList;
import java.util.List;

public class RotateArray{
    public void rotate(int[] nums, int k) {
		int length=nums.length;
		k=k%length;
		List<Integer> list=new ArrayList<>();
		for(int i=length-k;i<length;i++){
			list.add(nums[i]);
		}
		// System.out.println(list);
		for(int i=length-k-1;i>=0;i--){
			nums[i+k]=nums[i];
		}
		for(int i=0;i<list.size();i++){
			nums[i]=list.get(i);
		}
    }
	public static void main(String args[]){
		RotateArray ra=new RotateArray();
		int [] nums={1,2,3,4,5,6,7};
		ra.rotate(nums,3);
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
	}
}