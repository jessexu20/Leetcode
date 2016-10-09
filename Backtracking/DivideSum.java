import java.util.*;
public class DivideSum{
	int cnt = 0;
	public int count(int n){
		if(n*(n+1)/2 % 2 != 0)
			return 0;
		int target = n*(n+1)/4;
		dfs(target,1,n, new ArrayList<Integer>());
		
		
		return n%2 == 0 ? cnt/2:cnt;
	}
	private void dfs(int target,int start, int n, List<Integer> list){
		if(target < 0)
			return;
		if(target ==0){
			cnt++;
			System.out.println(list);
			return;
		}
		for(int i = start; i <= n; i++){
			list.add(i);
			dfs(target - i,i+1, n, list);
			list.remove(list.size()-1);
		}
	}
	public static void main(String args[]){
		DivideSum ds = new DivideSum();
		System.out.println(ds.count(8));
	}
}

