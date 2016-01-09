public class FindMissinginThree{
	public int find(int [] nums){
		int start = 1; int end = nums.length/3;
		while(start <= end){
			int mid = start + (end - start)/2;
			if( nums[mid*3-1] == mid) start = mid + 1;
			else end = mid-1;
		}
		return start;
	}
	public static void main(String args[]){
		FindMissinginThree fmt = new FindMissinginThree();
		int [] nums = {1,1,2,2,2,3,3,3,4,4,4};
		System.out.println(fmt.find(nums));
	}
	
}