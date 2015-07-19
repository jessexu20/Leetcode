import java.util.*;
public class SumRange {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length<1){
        	return new ArrayList<String>();
        }
		List<String>list= new ArrayList<String>();
		if(nums.length<2){
			list.add(Integer.toString(nums[0]));
			return list;
		}
		int len=nums.length;
		int i =1;
		int start=nums[i-1];
		int end=start;
		while(i<len){
			if(nums[i]-nums[i-1]==1){
				end=nums[i];
				i++;
			}
			else{
				String str="";
				if (start<end){
					str+=Integer.toString(start)+"->"+Integer.toString(end);
				}
				else str+=Integer.toString(start);
				list.add(str);
				start=nums[i];
				i=i+1;
			}
		}
		if(start<end){
			String str=Integer.toString(start)+"->"+Integer.toString(end);
			list.add(str);
		}
		else{
			list.add(Integer.toString(start));
		}
		return list;
    }
	public static void main(String args[]){
		SumRange sr= new SumRange();
		int [] sums = {0,4,8};
		System.out.println(sr.summaryRanges(sums));
		
	}
}