public class MissingNumber {
    public int missingNumber(int[] nums) {
        int length=nums.length;
		if(length<1)
			return 0;
		int actsum=0;
		boolean zero=false;
		for(int i=0;i<length;i++){
			actsum+=nums[i];
			if(nums[i]==0)
				zero=true;
		}
		if(!zero)
			return 0;
		int sum = (0+length)*(length+1)/2;
		
		if(sum==actsum){
			return length+1;
		}
		return sum-actsum;
    }
	public static void main(String args[]){
		MissingNumber ms = new MissingNumber();
		int []nums={0,1};
		System.out.println(ms.missingNumber(nums));
	}
	
}