package google;

import java.util.*;

public class MyHashtable {
	HashMap<String, Integer> table = new HashMap<>();
	HashMap<String, Integer> index = new HashMap<>();
	List<String> list= new ArrayList<>();      
	public void put(String key, Integer value){
		list.add(key);
		index.put(key,list.size()-1);
		table.put(key,value);
	}
	public int get(String key){
		return table.get(key);
	}
	public boolean remove(String key){
		if(table.containsKey(key)){
			table.remove(key);
			int i = index.get(key);
			list.remove(i);
			index.remove(key);
			return true;
		}
		else return false;
	}
	public String randomGetKey(){
		Random random = new Random();
		int r = random.nextInt(list.size());
		return list.get(r);
	}
	public int randomGetValue(){
		String k = randomGetKey();
		return table.get(k);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashtable hashtable = new MyHashtable();
		hashtable.put("abc",1);
		hashtable.put("ac",4);
		hashtable.put("ab",3);
		hashtable.put("abfc",2);
		System.out.println(hashtable.get("abc"));
		System.out.println(hashtable.randomGetKey());
		System.out.println(hashtable.randomGetValue());
		System.out.println(hashtable.remove("Abc"));
		System.out.println(hashtable.remove("abc"));
		System.out.println(hashtable.randomGetKey());
		System.out.println(hashtable.randomGetValue());
	}

}
