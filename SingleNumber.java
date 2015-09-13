import java.util.*;
public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int [] result=new int [2];
		int temp=0;
		for(int i=0;i<nums.length;i++){
			temp= temp ^ nums[i]; 
		}
		int mask=1;
		while((temp & mask) == 0 ){
			mask<<=1;
		}
		List<Integer>group1=new ArrayList<Integer>();
		List<Integer>group2=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			if((nums[i]& mask)!=0)
				group1.add(nums[i]);
			else group2.add(nums[i]);
		}
		for(int i=0;i<group1.size();i++){
			result[0]= result[0] ^ group1.get(i);
		}
		for(int i=0;i<group2.size();i++){
			result[1]= result[1] ^ group2.get(i);
		}
		return result;
    }
	public static void main(String args[]){
		SingleNumber sn= new SingleNumber();
		int [] num ={5,5,1,4,2,3,2,3,4,7};
		int [] result= sn.singleNumber(num);
		for(int i =0; i< result.length;i++){
			System.out.println(result[i]);
		}
	}
}