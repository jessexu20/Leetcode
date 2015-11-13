public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map= new HashMap();
        int [] result= new int[2];
        for(int i =0; i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i+1;
                return result;
            }
            else{
                map.put(nums[i],i+1);
            }
        }
        return result;
    }
}