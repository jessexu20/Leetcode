import java.util.*;
public class CountTriangle{
	public int count(int [][] matrix, int n){
		List<Set<Integer>> list = new ArrayList<>();
		for(int i = 0; i < n; i++){
			list.add(new HashSet<Integer>());
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j]==1){
					list.get(i).add(j);
					list.get(j).add(i);
				}
			}
		}
		int count = 0;
		for(int i = 0; i < n; i++){
			Set<Integer> temp = new HashSet<>(list.get(i));
			for(int j: temp){
				Set<Integer> intersect = new HashSet<>(list.get(j));
				intersect.retainAll(list.get(i));
				for(int k: intersect){
					count++;
					list.get(i).remove(k);
					list.get(j).remove(k);
				}
				list.get(i).remove(j);
			}
		}
		return count;
	}
	public static void main(String args[]){
		CountTriangle ct = new CountTriangle();
		int [][] matrix = {{0,1,1,0,0},{1,0,0,1,1},{1,0,0,1,0},{0,1,1,0,1},{0,1,0,1,0}};
		System.out.println(ct.count(matrix,matrix.length));
	}
}