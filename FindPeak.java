public class FindPeak {
    public int findPeakElement(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			if (start + 1 == end)
				return nums[start] > nums[end] ? start : end;
			int mid = (start + end) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) // larger than its neighbor!
				return mid;
			if (nums[mid] > nums[mid - 1] && nums[mid + 1] > nums[mid])// monotonically increase
				start = mid + 1;
			else // either mono decrease trap in a local minimal
				end = mid - 1;
		}
		return start;
    }
	public static void main(String args[]){
		FindPeak fp=new FindPeak();
		int [] num={1,2,1};
		System.out.println(fp.findPeakElement(num));
	}
}