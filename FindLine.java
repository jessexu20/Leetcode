import java.util.*;
public class FindLine {
    public int findLine(String str, int offset) {
		if(offset>str.length()) return -1;
		List<Integer> list= new ArrayList<Integer>();
		int count = 1;
		for(int i = 1 ; i<offset;i++){
			if(str.charAt(i-1)=='\n'){
				count++;
				list.add(i);
			} 
		}
		System.out.println(list);
		return count;
    }
	public static void main(String args[]){
		FindLine fl= new FindLine();
		String str= "abc\nde\nefg\nh\n";
		System.out.println(fl.findLine(str,8));				
	}
}