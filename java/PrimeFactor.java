import java.util.*;
public class PrimeFactor{
	HashMap<Integer, Integer> map = new HashMap();
	public List<Integer> getNumber(int [] nums){
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < nums.length;i++){
			if(map.containsKey(nums[i]))
				map.put(nums[i],map.get(nums[i])+1);
			else map.put(nums[i],1);
		}
		List<Integer> list = new ArrayList(map.keySet());
		for(int i = 1 ; i < nums.length; i++){
			helper(result,list,0,i,0,1);
		}
		return result;
	}
	private void helper(List<Integer> result, List<Integer> nums, int index, int size, int len, int product){
		if(len == size){
			result.add(product);
			return;
		}
		for(int i = index; i < nums.size(); i++){
			int number = map.get(nums.get(i));
			if(number>1){
				while( number > 1){
					helper(result,nums,i+1,size,len+number,product*(int)Math.pow(nums.get(i),number));
					number--;
				}
			}
			helper(result,nums,i+1,size,len+1,product*nums.get(i));
		}
	}
	public static void main(String args[]){
		PrimeFactor pf = new PrimeFactor();
		int [] nums = {2,2,3,5,7};
		System.out.println(pf.getNumber(nums));
	}
}