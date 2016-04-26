public class FindMinimuminRotated{
	//find the min in the rotated array
    public int findMin(int[] nums) {
        if(nums.length<1) return 0;
        int start = 0, end = nums.length-1;
        while(start < end){//no equal
            int mid = start +(end-start)/2;
            if(nums[mid]>nums[end]){
                start = mid+1;
            }
            else end = mid;//end could be the min..
        }
        return nums[start];
    }
	public static void main(String args[]){
		FindMinimuminRotated rmr=new FindMinimuminRotated();
		int []num={4,0,1 ,2,4,4,4,4};
		System.out.println(rmr.findMin(num));
	}
}