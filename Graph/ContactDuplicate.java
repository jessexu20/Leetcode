import java.util.*;
public class ContactDuplicate{
	public List<List<Integer>> mergeDup(HashMap<Integer, List<Character>> map){
		int user = map.size();
		HashMap<Character, List<Integer>> reverseMap = new HashMap<>();
		for(int key : map.keySet()){
			List<Character> list = map.get(key);
			for(char c: list){
				if(!reverseMap.containsKey(c))
					reverseMap.put(c, new ArrayList<Integer>());
				reverseMap.get(c).add(key);
			}
		}
		int [] unionset = new int [user];
		
		for(int i = 0; i < unionset.length; i++){
			unionset[i] = i;
		}
		
		List<List<Integer>> entry = new ArrayList<>(reverseMap.values());
		
		for(List<Integer> list: entry){
			if(list.size() < 2)
				continue;
			for(int i = 1; i < list.size();i++){
				union(unionset, list.get(0) - 1, list.get(i) - 1);
			}
		}
		HashMap<Integer, List<Integer>> userMap = new HashMap<>();
		for(int i = 0; i < unionset.length; i++){
			int j = find(unionset, i);
			if(!userMap.containsKey(j))
				userMap.put(j, new ArrayList<Integer>());
			userMap.get(j).add(i + 1);
		}
		return new ArrayList<>(userMap.values());
	}
	public int find(int [] arr, int x){
		if(arr[x]==x)
			return x;
		return find(arr, arr[x]);
	}
	public void union(int [] arr, int x, int y){
		int xroot = find(arr,x);
		int yroot = find(arr,y);
		if(xroot == yroot)
			return;
		int min = Math.min(xroot, yroot);
		int max = Math.max(xroot, yroot);
		arr[max] = min;
	}
	
	public static void main(String [] args){
		ContactDuplicate cd = new ContactDuplicate();
		HashMap<Integer, List<Character>> map = new HashMap<>();
		map.put(1, Arrays.asList('x','y','z'));
		map.put(2, Arrays.asList('x'));
		
		map.put(3, Arrays.asList('a','b'));
		map.put(4, Arrays.asList('y','z'));
		map.put(5, Arrays.asList('b'));
		map.put(6, Arrays.asList('m'));
		
		map.put(7, Arrays.asList('t','b'));
		System.out.println(cd.mergeDup(map));
	}
}