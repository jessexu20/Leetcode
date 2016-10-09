import java.util.*;
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
		for(int i = 1; i <= Math.min(9,n); i++)
        	helper(result, i, n);
		return result;
    }
    public void helper(List<Integer> result, int cur, int n){
        if(cur > n)
            return;
        result.add(cur);
        for(int i = 0; i <= 9; i++){
            helper(result, cur * 10 + i, n);
        }
    }
	public static void main(String [] args){
		LexicographicalNumbers ln = new LexicographicalNumbers();
		System.out.println(ln.lexicalOrder(100));
	}
}