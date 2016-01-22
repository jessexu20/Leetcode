import java.util.*;
public class SlidingWindowMinAbstract{
	public int findAbstract(int [] nums, int k){
		Deque<Integer> maxDeque = new ArrayDeque();
		Deque<Integer> minDeque = new ArrayDeque();
		int [] max = new int [nums.length-k+1];
		int [] min = new int [nums.length-k+1];
		int index  = 0;
		for(int i = 0;i<nums.length;i++){
			//MaxDeque
			while(!maxDeque.isEmpty() && i>maxDeque.peek()+k-1){
				maxDeque.poll();
			}
			while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[i]){
				maxDeque.pollLast();
			}
			maxDeque.offer(i);
			//minDeque
			while(!minDeque.isEmpty() && i>minDeque.peek()+k-1){
				minDeque.poll();
			}
			while(!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[i]){
				minDeque.pollLast();
			}
			minDeque.offer(i);
			if(i>=k-1){
				max[index] = nums[maxDeque.peek()];
				min[index++] = nums[minDeque.peek()];
			}
		}
		int minAbs = Integer.MAX_VALUE;
		for(int i = 0;i<max.length;i++){
			minAbs = Math.min(minAbs,Math.abs(max[i]-min[i]));
		}
		return minAbs;
	}
	public static void main(String args[]){
		SlidingWindowMinAbstract swma = new SlidingWindowMinAbstract();
		int [] nums = {1,3,-1,-3,5,3,6,7};
		System.out.println(swma.findAbstract(nums,3));
	}

}