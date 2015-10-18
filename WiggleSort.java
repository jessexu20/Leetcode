public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for(int i =1 ; i < nums.length;i++){
            if(i %2 !=0 && nums[i]<nums[i-1])
                swap(nums,i,i-1);
            if(i%2 ==0 && nums[i]>nums[i-1]){
                swap(nums,i,i-1);
            }
        }
    }
    public void swap(int[] nums, int x,int y){
        int temp = nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
	public static void main(String args[]){
		WiggleSort ws= new WiggleSort();
		int []nums={7,6,3,4,5,2,1};
		ws.wiggleSort(nums);
		for(int i =0;i<nums.length;i++)System.out.print(nums[i]+"\t");
	}
}