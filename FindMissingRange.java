/*
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

*/

public class FindMissingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result= new ArrayList();
        if(nums.length<1) {
            result.add(generate(lower,upper));
            return result;
        }
        int pre= lower-1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]<lower) continue;//don't care if it is under the hell
            if(nums[i]>upper) break;//num is already high than the heaven
            if(nums[i]>pre+1){
                result.add(generate(pre+1,nums[i]-1));//detect a number gap
            }
            pre=nums[i];
        }
        if(pre<upper){//the last range
            result.add(generate(pre+1,upper));
        }
        return result;
    }
    public String generate(int num1,int num2){
        if(num1==num2) return String.valueOf(num1);
        else return String.valueOf(num1)+"->"+String.valueOf(num2);
    }
}