package leetcode;
import java.util.*;
public class CombinationSumIII{
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n/k>9||n>45)
			return new ArrayList();
		int [] numsCount=new int [10];
		numsCount[0]=1;
		List<List<Integer>> result= new ArrayList();
		find(result,new ArrayList(),numsCount,k,n,0);
		return result;
    }
	public void find(List<List<Integer>> result,List<Integer> list,int []count, int k,int n,int index){
		if(k==0 && n==0){
			result.add(list);
			return;
		}
		else if(k==0 && n!=0){
			return;
		}
		for(int i=index;i<count.length;i++){
			if(count[i]==0 && n>=i){
				List<Integer> t= new ArrayList(list);
				t.add(i);
				int [] countTemp=count.clone();
				countTemp[i]=1;
 				find(result,t,countTemp,k-1,n-i,i+1);
			}
		}
	}
	public static void main(String args[]){
		CombinationSumIII cs= new CombinationSumIII();
		List<List<Integer>> result=cs.combinationSum3(3,7);
		if(result!=null){
			for(List<Integer> list:result){
				if(list!=null){
					for(int i : list){
						System.out.print(i+"\t");
					}
				}
				System.out.println();
			}
		}
	}
}