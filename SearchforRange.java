public class SearchforRange {
	public int[] searchRange(int[] nums, int target) {
	        int start=0,end=nums.length-1;
	        int second=-1;
	        while(start<=end){
	            int mid = (start+end)/2;
	            if(nums[mid]<=target) start=mid+1;
	            else end=mid-1;
	            if(target==nums[mid]){
	                second=mid;
	            }
	        }
	        int first=-1;
			start=0;end=nums.length-1;
	        while(start<=end){
	            int mid = (start+end)/2;
	            if(nums[mid]>=target) end=mid-1;
	            else start=mid+1;
	            if(target==nums[mid]){
	                first=mid;
	            }
	        }
			return new int[]{first,second};
	}
	public static void main(String args[]){
		SearchforRange sr= new SearchforRange();
		int [] num={5, 7, 7, 8, 8, 10};
		System.out.println(sr.searchRange(num,8)[0]+"\t"+sr.searchRange(num,8)[1]);
	}
}