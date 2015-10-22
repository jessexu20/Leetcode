import java.util.*;
public class FindString {
	String result = "";
	int max=0;
    public String findLongest(String str, Set<String> dict) {
		helper(str,str,dict,0);
		return result;
    }
	public void helper(String str,String temp, Set<String> dict, int index){
		if(dict.contains(temp) || temp==""){
			if(temp.length()>max){
				max=temp.length();
				result=temp;
			}
			return;
		}
		for(int i = index; i<temp.length();i++){
			String t=temp.substring(0,i)+temp.substring(i+1,temp.length());
			helper(str,t,dict,i);
			helper(str,temp,dict,i+1); 
		}
	}
	public static void main(String args[]){
		FindString fs= new FindString();
		Set<String> dict=new HashSet<String>();
		String [] d={"abc","abcddd","abcdeef","abcdef","ab"};
		dict.add("abc");dict.add("aabcdddbc");dict.add("ab");
		dict.add("abcdef");dict.add("abcdeef");
		System.out.println(fs.findLongest("abcdedasef",dict));
	}
}