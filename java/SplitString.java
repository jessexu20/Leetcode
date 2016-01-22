import java.util.*;
public class SplitString{
	public List<String> splitString(String str){
		List<String> list = new ArrayList<String>();
		int j=0;
		boolean flag = false;
		for(int i = 0; i <str.length();i++){
			if(str.charAt(i)=='\"')
				flag = !flag;
			if(str.charAt(i)==' ' && !flag){
				list.add(str.substring(j,i));
				j = i+1;	
			}
		}
		list.add(str.substring(j,str.length()));
		return list;
		
	}
	public static void main(String args[]){
		SplitString ss = new SplitString();
		String s = "This is \"an example\" st\"r\"ing";
		System.out.println(ss.splitString(s));
		
	}
}