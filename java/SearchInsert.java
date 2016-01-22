public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int index=-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(target<nums[mid]) end=mid-1;
            else if(target>nums[mid]) start= mid+1;
            else if(target==nums[mid]){
                index=mid;
                break;
            }
        }
        if(index==-1)
            index=start;
        return index;
    }
	public static void main(String args[]){
		SearchInsert si =new SearchInsert();
		int [] nums={1,3,5,6};
		System.out.println(5/3*3);
		System.out.println(si.searchInsert(nums,0));
	}
}