import java.util.HashMap;
public class Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<1)
            return false;
        HashMap <Integer,Integer> map=new HashMap();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i]))
				return true;
			map.put(nums[i],1);
		}
		return false;
    }
	public static void main(String args[]){
		Duplicate d= new Duplicate();
		int []num={1,2,3,3,5,6,9};
		System.out.println(d.containsDuplicate(num));
	}
}