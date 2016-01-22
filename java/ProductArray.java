public class ProductArray {
    public int[] productExceptSelf(int[] nums) {
		int length = nums.length;
        int [] left= new int [length];
		int [] right= new int [length];
		int [] result=new int [length];
		left[0]=1;right[length-1]=1;
		for(int i=1;i<length;i++){
			left[i]=left[i-1]*nums[i-1];
		}
		for(int i=length-2;i>=0;i--){
			right[i]=right[i+1]*nums[i+1];
		}
		for(int i=0;i<length;i++){
			result[i]=left[i]*right[i];
		}
		return result;
    }
	public static void main(String args[]){
		ProductArray pa =new ProductArray();
		int [] nums={1,2,3,4};
		int [] result = pa.productExceptSelf(nums);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]);
			System.out.print("\t");
		}
	}
}