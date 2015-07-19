import java.util.Deque;
import java.util.LinkedList;
public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length==0)
			return new int [0];
        Deque <Integer> deque= new LinkedList<Integer>();	
		int [] res= new int [nums.length-k+1];
		for(int i= 0;i<nums.length;i++){
			while(!deque.isEmpty()&& deque.getLast()<nums[i])
				deque.removeLast();
			deque.add(nums[i]);
			if(i<k-1)
				continue;
			res[i-k+1]=deque.peek();
			if(i-k+1>=0 && res[i-k+1]==nums[i-k+1])
				deque.removeFirst();
		}
		return res;
    }
	public static void main(String args[]){
		SlidingWindow sw= new SlidingWindow();
		int [] nums = {};
		int [] result = sw.maxSlidingWindow(nums,1);
		for(int i=0; i < result.length;i++){
			System.out.println(result[i]);
		}
	}
}