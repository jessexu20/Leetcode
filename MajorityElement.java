import java.util.*;
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list =new ArrayList<Integer>();
		if (nums.length<1){
			return list;
		}
		if (nums.length<2){
			list.add(nums[0]);
			return list;
		}
		int x=-1,y=0;
		int xc=0,yc=0;
		for (int i=0;i<nums.length;i++){
			if (nums[i]==x) xc++;
			else if (nums[i]==y) yc++;
			else if (xc==0){
				x=nums[i];
				xc=1;
			}
			else if (yc==0){
				y=nums[i];
				yc=1;
			}
			else{
				xc--;
				yc--;
			}
		}
		xc=0;yc=0;
		for(int i:nums){
			if (i ==x)
				xc++;
			if (i ==y)
				yc++;
		}
		if (xc>nums.length/3)
			list.add(x);
		if (yc>nums.length/3 && y!=x)
			list.add(y);
		return list;
    }
	public static void main(String args[]){
		MajorityElement me = new MajorityElement();
		int [] nums ={1,1,1,3,3,2,2,2};
		System.out.println(me.majorityElement(nums));
	}
}