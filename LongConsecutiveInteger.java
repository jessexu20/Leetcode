import java.util.*;
public class LongConsecutiveInteger{
	public int findMaxLength(int [] nums){
		int max = 0;
		Arrays.sort(nums);
		HashMap<Integer, Integer> map = new HashMap();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i],map.get(nums[i])+1);
			}
			else map.put(nums[i],1);
		}
		for(int i = 0; i < nums.length;i++){
			int key = nums[i];
			if(!map.containsKey(key)) continue;
			int times = map.get(key);
			int n = key;
			int length = 1;
			while(map.containsKey(n-1) && map.get(n-1) >= times){
				int val = map.get(n-1)-1;
				if(val>0) map.put(n-1,val);
				else map.remove(n-1);
				length++;
				if(map.containsKey(n-1) && map.get(n-1)>=times) break;
				n--;
				
			} 
			n = key;
			while(map.containsKey(n+1) && map.get(n+1) >= times){
				int val = map.get(n+1)-1;
				if(val>0) map.put(n+1,val);
				else map.remove(n+1);
				length++;
				if(map.containsKey(n+1) && map.get(n+1)>=times) break;
				n++;
				
			} 
			int val = map.get(key)-1;
			if(val>0) map.put(key,val);
			else map.remove(key);
			max = Math.max(max,length);
		}
		return max;
	}
	public static void main(String args[]){
		LongConsecutiveInteger ls = new LongConsecutiveInteger();
		int [] nums = {1,2,3,3,2,1,4,6,4,7,0,-2,-2,-1,3,2,5,1,6};
		System.out.println(ls.findMaxLength(nums));
	}
	
	
	
}