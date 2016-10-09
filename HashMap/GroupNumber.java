import java.util.*;
public class GroupNumber{
	public boolean group(int [] arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for(int i: arr){
			map.put(i, map.containsKey(i)? map.get(i)+1:1);
			max = Math.max(i,max);
		}
		while(map.size() > 0){
			int length = 0, t = max;
			while(length < 5 && map.containsKey(t)){
				map.put(t, map.get(t) - 1);
				if(map.get(max) == 0)
					max--;
				if(map.get(t) == 0)
					map.remove(t);
				t--;
				length++;
			}
			if(length < 5) return false;
		}
		return true;
	}
	public static void main(String args[]){
		int [] arr = {1,3,3,2,4,5,4,6,7,5};
		GroupNumber gn = new GroupNumber();
		System.out.println(gn.group(arr));
	}
}