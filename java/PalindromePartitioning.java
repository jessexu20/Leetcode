import java.util.*;
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
		List<List<String>> res= new ArrayList();
		generatePartition(res,new ArrayList<String>(),s,0);
        return res;
    }
	public void generatePartition(List<List<String>>result, List<String>list,String str, int index){
		if(index==str.length()){
			result.add(list);
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
		PalindromePartitioning pp= new PalindromePartitioning();
		String str="aabaa";
		System.out.println(pp.partition(str));		
	}
}