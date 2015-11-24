import java.util.*;

public class WordAbbr {
	public List<String> transfer(String string) {
		List<String> result = new ArrayList<String>();
		int length = string.length();
		helper(result, string, 0, length);
		result.add(string);
		return result;
	}

	public void helper(List<String> list, String string, int index, int length) {
		for (int i = index; i < length; i++) {
			String left = string.substring(0, i);
			String right = string.substring(i + 1);
			String t = left + "*" + right;
			list.add(handle(t));
			helper(list, t, i+1, t.length());
		}
	}
	public String handle(String str){
		int len = 0;
		StringBuilder sb = new StringBuilder();
		int start =0;
		while(start < str.length()){
			if(str.charAt(start)=='*'){
				len++;
				start++;
			}
			else{
				if(len>0){
					sb.append(len);
					len=0;
					sb.append(str.charAt(start++));
				}
				else sb.append(str.charAt(start++));
			}
		}
		if(len>0) sb.append(len);
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordAbbr wordAbbr = new WordAbbr();
		System.out.println(wordAbbr.transfer("abc"));
		System.out.println(wordAbbr.transfer("abcd"));
	}
}