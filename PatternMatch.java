package google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternMatch {
	public boolean match(String pattern, Iterable<String> iter){
		StringBuilder sb = new StringBuilder();
		Iterator<String> iterator = iter.iterator();
		while(iterator.hasNext() && sb.indexOf(pattern)==-1)
			sb.append(iterator.next());
		if(sb.indexOf(pattern)==-1) return false;
		else return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatternMatch pm = new PatternMatch();
		List<String> list = new ArrayList<String>();
		list.add("ab");
		list.add("cd");
		System.out.println(pm.match("abc",list));
	}

}
