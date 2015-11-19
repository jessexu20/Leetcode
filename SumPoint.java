import java.util.*;
public class SumPoint{
	public List<Integer> find(int [] nums){
		int sum = 0;
		List<Integer> list = new ArrayList();
		for(int i = 0; i < nums.length; i++) sum+=nums[i];
		int left = 0; int right = sum;
		for(int i = 0; i< nums.length; i++){
			left += nums[i];
			right -= nums[i];
			if(left == right)
				list.add(i);
		}
		return list;
	}
	public static void main(String args[]){
		SumPoint point = new SumPoint();
		int [] num = {1,3,-1,2,1,3,-5,4};
		System.out.println(point.find(num));
	}
}