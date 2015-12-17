public class SumK{
	public boolean sum(int [] nums, int k){
		int start = 0, end = 0;
		if(nums.length < 1) return false;
		int s = nums[start];
		while(end < nums.length){
  		  	if(s==k){
  		  		return true;
  		  	}
			else if(s < k){
				s += nums[end++];
			}
			else{
				if(start == end){
					s -= nums[start];
					s += nums[end++];
				}
				else{
					s -= nums[start++];
				}
			}
		}
		return s==k? true:false;
	}
	public static void main(String args[]){
		SumK sumk = new SumK();
		int [] nums ={1,2,3,1,2,1,4,9};
		System.out.println(sumk.sum(nums,6));
	}
}