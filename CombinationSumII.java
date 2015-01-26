import java.util.*;
public class CombinationSumII{
	public void findTarget(int []num,int index,int target,List<Integer> list, List<List<Integer>> res){
		if(target<0)
			return;
		else if (target==0){
			Collections.sort(list);
			if(!res.contains(list))
				res.add(list);
			return;
		}

		for(int i=index;i<num.length;i++){
			if(num[i]<=target){
				List<Integer> temp=new ArrayList<Integer>(list);
				temp.add(num[i]);
				findTarget(num,i+1,target-num[i],temp,res);
			}
			else break;
		}
	}
    public List<List<Integer>> combinationSum2(int[] num, int target) {
    	 List<List<Integer>> result=new  ArrayList<List<Integer>> ();
		 Arrays.sort(num);
		 findTarget(num,0,target,new  ArrayList<Integer>(),result);
		 return result;
    }
	public static void main(String args[]){
		CombinationSumII cs= new CombinationSumII();
		int []num={8,7,4,3};
		
		int target=11;
		System.out.println(cs.combinationSum2(num,target));
	}
}