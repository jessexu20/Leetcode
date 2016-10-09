import java.util.*;
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long [] sum = new long[nums.length];
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            sum[i] = (i==0) ? nums[i] : nums[i] + sum[i-1];
        }
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L,1);
        for(int i = 0; i < sum.length; i++){
            long low = sum[i] - upper;
            long high = sum[i] - lower;
            for(Map.Entry<Long, Integer> entry: map.subMap(low,true, high,true).entrySet()){
                result += entry.getValue();
            }
            map.put(sum[i], map.containsKey(sum[i]) ? map.get(sum[i]) + 1: 1);
        }
        return result;
    }
	public static void main(String args[]){
		CountRangeSum crs = new CountRangeSum();
		int [] nums = {-2,2,3};
		System.out.println(crs.bsSmall(nums,0));
	}
}
