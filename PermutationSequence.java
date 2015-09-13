import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int num=n-1;
		k=k-1;
		String str="";
		List<Integer> numbers=new ArrayList<Integer>();
		for(int i =1;i<=n;i++){
			numbers.add(i);
		}
		while(str.length()<n){
			int t=factorial(num);
			int temp=k/t;
			str+=String.valueOf(numbers.get(temp));
			numbers.remove(temp);
			k%=t;
			num-=1;
		}
		return str;
    }
	public int factorial(int n){
		int res=1;
		for(int i=1;i<=n;i++){
			res*=i;
		}
		return res;
	}
	public static void main(String[] args) {
		PermutationSequence permutation=new PermutationSequence();
		String string=permutation.getPermutation(2,1);
		System.out.println(string);
	}

}
