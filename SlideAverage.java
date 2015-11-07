import java.util.*;
public class SlideAverage{
	public List<Float> slide(int [] nums,int window){
		Queue <Integer> que = new LinkedList();
		List <Float> result =new ArrayList();
		float sum = 0;
		for(int i = 0 ;i<nums.length;i++){
			if(que.size()<window){
				que.offer(nums[i]);
				sum+=nums[i];
				
			}
			else{
				int t = que.poll();
				que.offer(nums[i]);
				sum+=(nums[i]-t);
			}
			result.add(sum/que.size());
		}
		System.out.println(result);
		return result;
	}
	public static void main(String args[]){
		SlideAverage sa = new SlideAverage();
		int []nums={1, 2, 3, 4, 5, 6, 7, 8};
		sa.slide(nums,3);
	}
}