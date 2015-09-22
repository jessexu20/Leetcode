import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList();
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				int front = j+1;
				int back= nums.length-1;
				int temp=nums[i]+nums[j];
				while(front< back){
					int sum= nums[front]+nums[back];
					if(sum+temp<target) front++;
					else if(sum+temp>target) back--;
					else{
						List<Integer> list =new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[front]);
						list.add(nums[back]);
						res.add(list);
						while(front<back && nums[front]==list.get(2)) front++;
						while(front<back && nums[back]==list.get(3)) back--;
					}
				}
				while(j+1<nums.length && nums[j]==nums[j+1]) j++;
			}
			while(i+1<nums.length && nums[i]==nums[i+1]) i++;
		}
		return res;
    }
	public static void main(String args[]){
		FourSum fs= new FourSum();
		int nums[]={1,0,-1,0,-2,2};
		System.out.println(fs.fourSum(nums,0));
	}
}