import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ContainsDupII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer, Integer>map=new HashMap<Integer, Integer>();
    	if (k<=0) {
			return false;
		}
        Queue<Integer> que=new LinkedList<Integer>();
        int i=0;
        while(i<nums.length&&que.size()<=k){
        	int t=nums[i];
        	if (map.containsKey(t)) {
				return true;
			}
        	que.add(nums[i]);
        	map.put(t, 1);
        	i++;
        }
        if (i==nums.length) {
			return false;
		}
        while(i<nums.length){
        	int temp=que.poll();
        	map.remove(temp);
        	int t= nums[i];
        	if (map.containsKey(t)) {
				return true;
			}
        	que.add(nums[i]);
        	map.put(t, 1);
        	i++;
        }
		return false;
    }
	public static void main(String args[]){
		ContainsDupII cd= new ContainsDupII();
		int [] nums= {1,0,1,1};
		int k = 1;
		System.out.println(cd.containsNearbyDuplicate(nums,k));
	}
}