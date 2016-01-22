import java.util.*;
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int cnt=0;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2;i++){
            int low=i+1,high=nums.length-1;
            while(low<high){
                if(nums[i]+nums[low]+nums[high]>target) high--;
                else{
                    cnt+=(high-low);
                    low++;
                    
                }
            }
        }
        return cnt;
    }
}