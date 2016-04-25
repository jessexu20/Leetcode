package google;

import java.util.*;

public class RandomizedHashtable {
	int [] array = new int [10];
	int length = 0;
	//key = value; value = index;
	HashMap<Integer, Integer> index = new HashMap<>();
	public void add(int val){
		//double size
		if(length == array.length-1){
			int [] tmp = new int[array.length*2];
			System.arraycopy(array, 0, tmp, 0, length);
			array = tmp;
		}
		array[length] = val;
		index.put(val, length);
		length++;
	}
	//swap the last element with the deleted element
	public boolean remove(int val){
		if (!index.containsKey(val)) {
			return false;
		}
		else {
			int pos = index.get(val);
			array[pos] = array[--length];
			index.put(array[pos], pos);
			index.remove(val);
			return true;
		}
	}
	public int getRandom(){
		Random random = new Random();
		int pos = random.nextInt(length);
		return array[pos];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedHashtable hashtable = new RandomizedHashtable();
		for(int i = 0;i < 4;i++)
			hashtable.add(i);
		System.out.println(hashtable.index);
		System.out.println(hashtable.remove(120));
		System.out.println(hashtable.remove(1));
		for(int i = 6;i <= 7;i++)
			hashtable.add(i);
		System.out.println(hashtable.index);
		for(int i = 0; i < 20; i++){
			System.out.println(hashtable.getRandom());
		}
	}

}
