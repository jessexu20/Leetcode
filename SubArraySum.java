import java.util.*;
public class SubArraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        
        int len = nums.length;
        
        ArrayList<Integer> ret = new ArrayList<Integer>();
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // We set the index -1 sum to be 0 to let us more convient to count.
        map.put(0, -1);
        
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            
            if (map.containsKey(sum)) {//detect from i to j that sum = origin + nums[i] ... +nums[j] has duplicate => nums[i]+...+nums[j] = 0
                // For example: 
                //        -3  1  2 -3 4
                // SUM: 0 -3 -2  0 -3 1
                // then we got the solution is : 0 - 2
                ret.add(map.get(sum) + 1);
                ret.add(i);
                return ret;
            }
            
            // Store the key:value of sum:index.
            map.put(sum, i);
        }
        
        return ret;
    }
	public static void main(String args[]){
		SubArraySum sas = new SubArraySum();
		int [] nums = {1, -3 ,1, 2, -4};
		System.out.println(sas.subarraySum(nums));
	}
}