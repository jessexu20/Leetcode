import java.util.*;
public class SubList{
	public List<Integer> findSubList(List<Integer> list, Set<Integer> set){
		int len = set.size();
		HashSet<Integer> temp = new HashSet<>(set);
		List<Integer> result = new ArrayList<>();
		if(list.size() < len) return result;
		int start = 0, end = list.size()-1;
		for(int i = 0; i < list.size(); i++){
			if(!temp.remove(list.get(i))){
				start = i+1;
			}
			if(temp.size() == 0){
				end = i;
				break;
			}
		}
		for(int i = start; i <= end; i++)
			result.add(list.get(i));
		return result;
	}
	public static void main(String args[]){
		SubList sublist = new SubList();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 20; i+=2)
			list.add(i);
		Set<Integer> set = new HashSet<>();
		set.add(6);
		set.add(8);
		set.add(10);
		set.add(11);
		System.out.println(sublist.findSubList(list,set));
	}
}