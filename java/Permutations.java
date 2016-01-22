import java.util.*;
public class Permutations{
    public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();//to avoid modify itself(concurrent modify exception)
			for (List<Integer> l : result) {
				for (int j = 0; j < l.size()+1; j++) {
					l.add(j, num[i]);
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
					l.remove(j);
				}
				System.out.println(current);
			}
			result = new ArrayList<List<Integer>>(current);
		}
		return result;
    }
	public static void main(String args[]){
		Permutations p=new Permutations();
		int [] num={1,2,3};
		System.out.println(p.permute(num));
	}
}