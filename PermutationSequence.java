package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		List<String>list=new ArrayList<String>();
		int len=n;
		int sum=1;
		for (int j = 1; j < len; j++) {
			sum=sum*j;
		}
		int offset=k/sum;
		getall(n, list, "",k,true);
		System.out.println(list);
		if (len>8) {
			return list.get(k-offset*sum-1);
		}
		else return list.get(k-1);
    }
	public void getall(int length,List<String>lStrings,String str,int k,boolean flag){
		if (str.length()==length){
//			System.out.println(str);
			lStrings.add(str);
			return;
		}
		for (int i = 1; i <= length; i++) {
			String string=null;
			int offset=0;
			int sum=1;
			int q=0;
			if (flag && length>8) {
				for (int j = 1; j < length; j++) {
					sum=sum*j;
				}
				offset=k/sum;
				q=offset*sum;
//				System.out.println(offset);
				string=Integer.toString(i+offset);
			}
			else string=Integer.toString(i);
			if (i+offset>length) {
				break;
			}
			if (length>8 && (k-q<=lStrings.size())) {
				break;
			}
			if(str.indexOf(string)<0){
				getall(length, lStrings, str+string,k,false);
			}	
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence permutation=new PermutationSequence();
		String string=permutation.getPermutation(9, 13531);
		System.out.println(string);
		
	}

}
