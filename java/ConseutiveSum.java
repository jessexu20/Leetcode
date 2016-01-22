import java.util.*;
public class ConseutiveSum{
	public List<List<Integer>> findSequence(int [] nums, int target){
		List<List<Integer>> result = new ArrayList();
		for(int i = 2; i <= nums.length;i++){//sequence length
			int sum = 0;
			int start = 0;
			for(int j = 0; j < nums.length; j++){
				if(sum==target){
					List<Integer> list = new ArrayList();
					for(int k = start; k<j;k++) list.add(nums[k]);
					result.add(list);
				}
				if(j<start+i){
					sum += nums[j];
				}
				else{
					sum -= nums[start++];
					sum += nums[j];
				}
				
			}
			if(sum==target){
				List<Integer> list = new ArrayList();
				for(int k = start; k<nums.length;k++) list.add(nums[k]);
				result.add(list);
			}
		}
		return result;
	}
	public List<List<Integer>> find(int [] nums,int target){
		List<List<Integer>> result = new ArrayList();
		HashMap<Integer,Integer> map = new HashMap();
		int [] sum = new int [nums.length];
		for(int i = 0;i<nums.length;i++){
			sum[i]+=nums[i];
			if(i>0) sum[i]+=sum[i-1];//sum[p]-sum[q] = target => p->q = target
			if(map.containsKey(sum[i]-target)){
				int start = map.get(sum[i]-target);
				List<Integer> list = new ArrayList();
				for(int k = start+1; k <= i; k++){
					list.add(nums[k]);
				}
				result.add(list);
			}
			else map.put(sum[i],i);
		}
		return result;
		
	}
	public static void main(String args[]){
		ConseutiveSum cs = new ConseutiveSum();
		int [] nums = {-3,1,-2,1,1,1,1,2};
		System.out.println(cs.findSequence(nums,5));
		System.out.println(cs.find(nums,5));
	}
}