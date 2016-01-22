import java.util.*;
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList();
        Set<String> set = new HashSet();
        Queue<String> que = new LinkedList();
        que.offer(s);
        set.add(s);
        while(!que.isEmpty()){
            String str = que.poll();
			if(result.size()>0 && result.get(0).length()>str.length()) break;
            if(isValid(str)) result.add(str);
            for(int i = 0;i<str.length();i++){
                char c = str.charAt(i);
                if(c== '(' || c==')'){
                    String temp = str.substring(0,i)+str.substring(i+1,str.length());
                    if(set.add(temp)){
                    	que.offer(temp);
                    } 
                }
            }
        }
        return result;
    }
    public boolean isValid(String str){
        int left = 0, right = 0;
        int i = 0;
        while(left>=right && i<str.length()){
            char c = str.charAt(i++);
            if(c == '(' ) left++;
            else if(c==')') right++;
        }
        if(left!=right) return false;
        else return true;
    }
	public static void main(String args[]){
		RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
		
		System.out.println(rip.removeInvalidParentheses("()())()"));
	}
}