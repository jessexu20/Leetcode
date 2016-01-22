public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int x=0;
        for(int i =0; i<nums.length;i++){
            if(nums[i]==0) continue;
            nums[x]=nums[i];
            x++;
        }
        for(int i=x;i<nums.length;i++){
            nums[i]=0;
        }
    }
}