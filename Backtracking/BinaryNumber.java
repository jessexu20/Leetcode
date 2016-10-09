import java.util.*;
//Given two number a and b, find all the binary representations with length a and has b number of 1's and output in decimal in sorted order
public class BinaryNumber{
	public List<String> binary(int a, int b){
		List<String> list = new ArrayList<>();
		if(a<b)
			return list;
		dfs(list,"", a,b);
		for(String str: list){
			System.out.print(Integer.valueOf(str,2)+"\t");
		}
		System.out.println();
		return list;
	}
	private void dfs(List<String> list, String temp, int a, int b){
		if(temp.length() == a){
			if(b == 0)
				list.add(temp);
			return;
		}
		dfs(list,temp+"0", a, b);
		dfs(list,temp+"1", a, b-1);
	}
	public static void main(String args[]){
		BinaryNumber bn = new BinaryNumber();
		System.out.println(bn.binary(5,3));
	}
	

}