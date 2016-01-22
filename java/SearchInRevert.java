public class SearchInRevert {
    public int search(int[] nums, int target) {
		int start=0,end=nums.length-1;
		while(start<=end){
			int mid=(start+end)/2;
			if(nums[mid]==target) return mid;
			if(nums[start]<=nums[mid]){//in a sorted region
				if(nums[start]<=target && target < nums[mid]) 
					end=mid-1;
				else start=mid+1;
			}
			if(nums[mid]<= nums[end]){//in antoher sorted region
				if(nums[mid]<target && target <= nums[end])
					start=mid+1;
				else end=mid-1;
			}
		}
		return -1;
    }
	public static void main(String args[]){
		SearchInRevert sr= new SearchInRevert();
		int [] num={1};
		System.out.println(sr.search(num,1));
	}
}