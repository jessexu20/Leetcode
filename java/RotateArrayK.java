public class RotateArrayK{
	public void rotate(int [] nums, int k){
		int length = nums.length;
		k = k % length;
		for(int i = 0; i < length/2; i++){
			swap(nums,i,length-1-i);
		}
		int left = length - k;
		for(int i = 0; i < left/2; i++){
			swap(nums,i,left-1-i);
		}
		for(int i = 0; i < k/2; i++){
			swap(nums,left+i,length-1-i);
		}
	}
	private void swap(int [] nums, int x ,int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
	public static void main(String args[]){
		RotateArrayK ra = new RotateArrayK();
		int [] number = {1,2,3,4,5,6,7,8};
		ra.rotate(number,9);
		for(int i = 0; i < number.length;i++){
			System.out.println(number[i]);
		}
	}
}