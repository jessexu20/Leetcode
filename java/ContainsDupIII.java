import java.util.*;
public class ContainsDupIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
         if (k < 1 || t < 0) return false;
         HashMap<Long, Long> map = new HashMap<Long,Long>();
         for (int i = 0; i < nums.length; i++) {
             long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
             long bucket = remappedNum / ((long) t + 1);
             if (map.containsKey(bucket)
                     || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                         || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                             return true;
             if (map.entrySet().size() >= k) {
                 long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                 map.remove(lastBucket);
             }
             map.put(bucket, remappedNum);
			 // System.out.println(map);
         }
		 
         return false;
     }
	 public static void main(String args[]){
	 	ContainsDupIII cd= new ContainsDupIII();
		int [] nums={3,19,23,41,2,8,4,1,5};
		System.out.println(cd.containsNearbyAlmostDuplicate(nums,2,2));
	 }
}