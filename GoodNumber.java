import java.util.*;
public class GoodNumber{
	public Set<Integer> goodNumber(int n){
		Set<Integer> result = new HashSet();
		List<Integer> cube = new ArrayList();
		for(int i = 0; i * i * i < n; i++){
			cube.add(i*i*i);
		}
		helper(result,cube,0,n,0);
		return result;
		
	}
	public void helper(Set<Integer> result, List<Integer> cube, int index, int n, int sum){
		if(index==cube.size()){
			if(!cube.contains(sum))
				result.add(sum);
			return;
		}
		for(int i = index; i < cube.size(); i++){
			if(cube.get(i)>n) return;
			helper(result,cube,i+1,n,sum);
			if(sum+cube.get(i) < n)
				helper(result,cube,i+1,n,sum+cube.get(i));
		}
	}
	public static void main(String args[]){
		GoodNumber gn = new GoodNumber();
		System.out.println(gn.goodNumber(100));
	}
}