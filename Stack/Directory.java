import java.util.*;
public class Directory{
	public int pathLen(String input, String str){
		HashMap<String, String> map = new HashMap<>();//key: children, value:parent;
		System.out.println(input);
		Stack<String> stack = new Stack<>();
		stack.push("root");
		String []strings = input.split("\n");
		for(String s: strings){
			int cnt = 0;
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i)=='\t') cnt++;
				else break;
			}
			while(stack.size() > cnt)
				stack.pop();
			map.put(s.trim(),stack.peek());
			stack.push(s.trim());
		}
		StringBuilder sb = new StringBuilder(str);
		while(map.containsKey(str) && map.get(str)!="root"){
			sb= sb.insert(0,map.get(str)+"/");
			str = map.get(str);
		}
		sb.insert(0,"/");
		System.out.println(sb);
		return sb.length();
	}
	public static void main(String args[]){
		Directory d = new Directory();
		System.out.println(d.pathLen("\tdic1\n\t\tdic2\n\t\tdic3\n\t\t\tpic.png\n\t\t\tnote1.txt\n\t\t\tdic4\n\tdic5","pic.png"));
	}
}