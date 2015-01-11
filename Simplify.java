import java.util.*;
import java.lang.String;
public class Simplify{
	public String simplifyPath(String path){
		String [] strings= path.split("/");
		String result="";
		Stack <String> mystack=new Stack();
		for(String str:strings){
			if(str.equals("..")){
				if(!mystack.isEmpty())
					mystack.pop();
			}
			else if(str.equals(".") || str.equals("...")||str.equals(""))
				continue;
			else
				mystack.push(str);
		}
		System.out.println(mystack);
		while(!mystack.isEmpty()){
			result="/"+mystack.pop()+result;
		}
		if(result.length()<1)
			return "/";
		return result;
	}
	public static void main(String args[]){
		String path="//";
		Simplify simple=new Simplify();
		System.out.println(simple.simplifyPath(path));
	}
}