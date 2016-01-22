import java.util.*;
public class LongestParentheses {
    public int longestValidParentheses(String s) {
        Stack <Integer> stack=new Stack();
		int length=s.length();
		if(length<2)
			return 0;	
		int curLen=0;
		int maxLen=0;
		for(int i=0;i<length;i++){
			char c= s.charAt(i);
			if(c=='('){
				stack.push(curLen);
				curLen=0;
			}
			else{
				if(stack.isEmpty())
					curLen=0;
				else{
					curLen=curLen+stack.pop()+2;
					if(curLen>maxLen) maxLen=curLen;
				}
			}					
		}
		return maxLen;
    }
	public static void main(String args[]){
		LongestParentheses lp=new LongestParentheses();
		String str=")()())()()(";
		System.out.println(lp.longestValidParentheses(str));
	}
}