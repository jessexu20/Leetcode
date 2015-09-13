import java.util.*;
public class PalindromePartitioningII {
    public int minCut(String s) {
		List<Integer> res= new ArrayList<Integer> ();
		generatePartition(res,new ArrayList(),s,0);
		int min=Integer.MAX_VALUE;
		for(int i:res){
			if(i<min)
				min=i;
		}
		return min;
    }
	public void generatePartition(List<Integer>result, List<String>list,String str, int index){
		if(index==str.length()){
			result.add(list.size());
		}
		for(int i=index+1; i<=str.length();i++){
			String temp= str.substring(index,i);
			if(isPalindrome(temp)){
				List<String> tempList=new ArrayList(list);
				tempList.add(temp);
				generatePartition(result,tempList,str,i);
			}
		}
	}
	public boolean isPalindrome(String str){
		int length=str.length();
		int start=0;
		int end=length-1;
		while(start<=end){
			if(str.charAt(start)!=str.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	public static void main(String args[]){
		PalindromePartitioningII pp2=new PalindromePartitioningII();
		String str="";
		System.out.println(pp2.minCut(str));
	}
}