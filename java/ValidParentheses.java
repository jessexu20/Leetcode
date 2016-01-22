import java.util.Stack;
public class ValidParentheses{
	public boolean isMatch(char a, char b){
		if(a=='(' && b==')')
			return true;
		if(a=='[' && b==']')
			return true;
		if(a=='{' && b=='}')
			return true;
		return false;
	}
	public boolean isValid(String str){
		if(str.length()%2!=0)
			return false;
		Stack<Character> myStack = new Stack();
		for(int i=0;i<str.length();i++){
			char temp=str.charAt(i);
			if(temp=='(' || temp=='[' || temp=='{')
				myStack.add(temp);
			else{
				if(myStack.isEmpty())
					return false;
				else{
					char t=myStack.pop();
					if(!isMatch(t,temp))
						return false;
				}
			}
		}
		if(myStack.isEmpty())
			return true;
		else return false;
	}
	public static void main(String args[]){
		ValidParentheses vp= new ValidParentheses();
		String str="{[()[]]()}";
		System.out.println(vp.isValid(str));
		     
	}
}