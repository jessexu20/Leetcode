import java.util.*;
public class StarString{
	public void changeStar(String str){
		StringBuilder sb = new StringBuilder(str);
		List<String> list = new ArrayList();
		helper(sb,0);
		helper2(list,str,"",0);
		System.out.println(list);
	}
	//print the string
	public void helper(StringBuilder str, int index){
		for(int i = index;i<str.length();i++){
			if(str.charAt(i)=='*'){
				str.setCharAt(i,'j');
				helper(str,i);
				str.setCharAt(i,'k');
				helper(str,i);
				str.setCharAt(i,'*');
			}
		}
		if(str.indexOf("*")==-1)
			System.out.println(str);
	}
	//store the string
	public void helper2(List<String> result, String str,String temp, int index){
		if(temp.length()== str.length()){
			result.add(temp);
			return;
		}
		for(int i = index; i < str.length();i++){
			if(str.charAt(i)!='*'){
				temp += str.charAt(i);
			}
			else{
				helper2(result,str,temp+'j',i+1);
				helper2(result,str,temp+'k',i+1);
			}
		}
		if(temp.length()== str.length()){
			result.add(temp);
		}
	}
	public static void main(String args []){
		StarString ss = new StarString();
		String str = "2*a*b";
		ss.changeStar(str);
	}
}