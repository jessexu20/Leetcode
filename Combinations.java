import java.util.*;

public class Combinations{
	public void traverse(int n,int k,int index,List<Integer> list, List<List<Integer>> result){
		if(k==0){
			result.add(list);
			return;
		}	
		for(int i=index+1;i<n;i++){
			List<Integer> temp=new ArrayList(list);
			temp.add(i);
			traverse(n,k-1,i,temp,result);
		}
	}
	public List<List<Integer>> combine(int n, int k) {
		List<Integer> list=new ArrayList();
		List<List<Integer>> reslist= new ArrayList();
		traverse(n+1,k,0,list,reslist);
		return reslist;
	}
	public static void main(String args[]){
		Combinations comb= new Combinations();
		System.out.println(comb.combine(5,2));
	}
}